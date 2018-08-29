package com.sm.demo.salesmanagement.users;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class UsersActivity extends AppCompatActivity {

    protected static final String TAG = "UsersActivity";
    protected static final int RESULT_LOAD_IMAGE = 1;
    private OutputStream output;
    private String imagePath;
    private String userPhotoName;

    protected UsersService usersService;
    protected UsersAdapter customAdapter;

    ArrayList<UsersModel> arrayList;
    private ImageView userPhoto;
    private EditText fullName, designation, email, phoneNumber, address, username, password, confirmPassword, search;
    private TextView userId;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        this.usersService = new UsersService(this);

        //===============================================| FloatingActionButton Add Button |=========================================
        FloatingActionButton fab = findViewById(R.id.add_user_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();  //Add method
            }
        });

        //===============================================| Getting All Data in ListView |=========================================
        //Get all data from database and set in list view
        listView = (ListView) findViewById(R.id.users_list_view_id);
        arrayList = (ArrayList) usersService.getUsers();
        customAdapter = new UsersAdapter(UsersActivity.this, arrayList, usersService);
        listView.setAdapter(customAdapter);

        //===============================================| Custom adapter search |=========================================
        search = (EditText) findViewById(R.id.user_search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int textlength = cs.length();
                ArrayList<UsersModel> tempArrayList = new ArrayList<UsersModel>();
                for(UsersModel c: arrayList){
                    if (textlength <= c.getUsername().length()) {
                        if (c.getUsername().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                customAdapter = new UsersAdapter(UsersActivity.this, tempArrayList, usersService);
                listView.setAdapter(customAdapter);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.users_option_menu, menu);
        return true;
    }

    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_user_option_menu:
                customAlertDialog(); //Add method
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Back press disabled
    @Override
    public void onBackPressed() {}

    //====================================================| Custom AlertDialog |====================================================

    //Add data into database using alert dialog
    protected void customAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UsersActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Add User");
        final View inflateForm = getLayoutInflater().inflate(R.layout.user_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        this.userPhoto = (ImageView) inflateForm.findViewById(R.id.reg_passport);
        this.fullName = (EditText) inflateForm.findViewById(R.id.reg_full_name);
        this.designation = (EditText) inflateForm.findViewById(R.id.reg_designation);
        this.email = (EditText) inflateForm.findViewById(R.id.reg_email);
        this.phoneNumber = (EditText) inflateForm.findViewById(R.id.reg_phone_number);
        this.address = (EditText) inflateForm.findViewById(R.id.reg_address);
        this.username = (EditText) inflateForm.findViewById(R.id.reg_username);
        this.password = (EditText) inflateForm.findViewById(R.id.reg_password);
        this.confirmPassword = (EditText) inflateForm.findViewById(R.id.reg_confirm_password);
        final Button saveButton = (Button) inflateForm.findViewById(R.id.reg_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    addData(userPhoto, fullName, designation, email, phoneNumber, address, username, password, confirmPassword); //Adding data into database

                    //Displaying data from database and sets listView
                    if(customAdapter==null) {
                        customAdapter = customAdapter = new UsersAdapter(UsersActivity.this, arrayList, usersService);
                        listView.setAdapter(customAdapter);
                    }
                    customAdapter.arrayList = (ArrayList) usersService.getUsers();
                    ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged(); //Refresh listView

                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //1. Load image from gallery
        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });

    }

    //====================================================| Select, Insert, Update, Delete |====================================================

    //Adding data into database
    protected void addData(ImageView userPhoto, EditText fullName, EditText designation, EditText email, EditText phoneNumber, EditText address, EditText username, EditText password, EditText confirmPassword) {
        if(!fullName.getText().toString().trim().isEmpty() && !designation.getText().toString().trim().isEmpty() && !phoneNumber.getText().toString().trim().isEmpty() && !username.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty()){

            UsersModel model = new UsersModel(
                    fullName.getText().toString(),
                    designation.getText().toString(),
                    email.getText().toString(),
                    phoneNumber.getText().toString(),
                    address.getText().toString(),
                    username.getText().toString(),
                    password.getText().toString(),
                    userPhotoName,
                    new File(getFilesDir() + "/UsersPhoto/").getAbsolutePath());

            long data = UsersActivity.this.usersService.addUser(model);
            Log.d("Add Data ====== : ", String.valueOf(data));
            if (data > 0){
                //Logo save
                Bitmap bitmap = ((BitmapDrawable)userPhoto.getDrawable()).getBitmap();
                imagePath = saveToInternalStorage(bitmap); //3.
                if(imagePath != null){
                    Toast.makeText(getApplicationContext(), "Logo saved successfully", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Do not saved unsuccessfully", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Please insert values in name, email & number", Toast.LENGTH_LONG).show();
        }
    }

    //Getting all data from database
    protected void getAllData() {
        final ArrayList<UsersModel> arrayList = this.usersService.getUsers();
        for(UsersModel obj : arrayList){
            Log.d("Logo ====== : ", String.valueOf(obj.getPhotoName()));
            Log.d("Path ====== : ", String.valueOf(obj.getPhotoPath()));
        }
    }

    //====================================================| For Image |====================================================

    //2. Image set in ImageView using onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectImage = data.getData();
            userPhotoName = "img_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".png";
            userPhoto.setImageURI(selectImage);
        }
    }

    //3. Save image internal storage
    protected String saveToInternalStorage(Bitmap bitmapImage){
        File directory = new File(getFilesDir() + "/UsersPhoto/");
        directory.mkdir(); //Create imageDir
        File file = new File(directory,userPhotoName);
        try {
            output = new FileOutputStream(file);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, output); // Compress into png format image from 0% - 100%
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
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
}
