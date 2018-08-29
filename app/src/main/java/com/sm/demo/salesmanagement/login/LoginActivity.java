package com.sm.demo.salesmanagement.login;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.HomeActivity;
import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.users.UsersActivity;
import com.sm.demo.salesmanagement.users.UsersModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private Button button;
    private EditText userName, passWord;
    private ImageView imageView;
    private TextView textView;
    private LoginService loginService;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginService = new LoginService(LoginActivity.this);

        this.textView = (TextView)findViewById(R.id.for_registration);
        this.imageView = (ImageView) this.findViewById(R.id.login_photo);
        this.userName = (EditText) this.findViewById(R.id.login_username);
        this.passWord = (EditText) this.findViewById(R.id.login_password);
        this.button = (Button) this.findViewById(R.id.login_button);


        //===============================================| Create SharedPreferences & Check it |===========================================
        preferences = getSharedPreferences("loginInfo", Context.MODE_PRIVATE); //Create login.xml file in private data folder in your mobile apps
        //Logging time access
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn",false); //Retrieve value by key="isLoggedIn" from login.xml file. False coz if do not get find any value.
        if(isLoggedIn){

            goToHome();
        //===================================================================================================================================

        } else {

            //Do not get true value login.xml file then login using database
            passWord.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) { }
                @Override
                public void afterTextChanged(Editable s) {
                    UsersModel data = loginService.loginByUserPass(userName.getText().toString(), passWord.getText().toString());
                    if (data != null) {
                        try {
                            Log.d(TAG, data.getPhotoPath()+"/"+data.getPhotoName());
                            Log.d(TAG, new File(getFilesDir() + "/UsersPhoto/").getAbsolutePath());
                            imageView.setImageBitmap(BitmapFactory.decodeFile(data.getPhotoPath()+"/"+data.getPhotoName() ));
                            /*if(data.getUsername().equals("admin")){
                                imageView.setImageResource(getResources().getIdentifier("admin", "drawable", "com.sm.demo.salesmanagement"));
                            }*/
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                //===============================================| Writes SharedPreferences |===========================================
                                SharedPreferences.Editor editor = preferences.edit(); //Write
                                editor.putBoolean("isLoggedIn", true); //key = isLoggedIn and value="true"
                                editor.putString("userName", userName.getText().toString());
                                editor.putString("userPass", passWord.getText().toString());
                                editor.apply();
                                editor.commit();
                                //======================================================================================================================

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            });


        }

        //====================================================| To Registration/User |====================================================
        //Need to registration in text-view then display progress bar
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressBar = ProgressDialog.show(LoginActivity.this, "Registration", "Please wait to create a new account");
                progressBar.setCancelable(true);
                Intent i = new Intent(getApplicationContext(), UsersActivity.class);
                startActivity(i);
            }
        });

        saveAdminImageToInternalStorage();

    }

    //====================================================| For Activity Starting and Closing |====================================================
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    //============================================================| SharedPreferences
    private void goToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    //Editor to edit value in xml file at the logging time
    /*public void login(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_LOGGED_IN,true); //key = isLoggedIn and value="true"
        editor.apply();
        //editor. remove();//Remove value using key
        ///editor.clear(); //Remove from login.xml file
        editor.commit();

        boolean isLoggedIn = sharedPreferences.getBoolean(IS_LOGGED_IN,false);
        Toast.makeText(this, "is xml file created? "+isLoggedIn, Toast.LENGTH_SHORT).show();
        login();
    }*/



    //=================================================| Save admin image to internal storage
    protected String saveAdminImageToInternalStorage(){
        File directory = new File(getFilesDir() + "/UsersPhoto/");
        directory.mkdir();
        File file = new File(directory, "img_admin.png");
        try {
            OutputStream output = new FileOutputStream(file);
            Bitmap b = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.admin);
            b.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
    }

}
