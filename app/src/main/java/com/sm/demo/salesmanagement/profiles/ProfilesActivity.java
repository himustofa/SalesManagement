package com.sm.demo.salesmanagement.profiles;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ProfilesActivity extends AppCompatActivity {

    private ImageView companyLogo;
    private Button saveButton;
    private EditText companyName, companyEmail, companyPhoneNumber, companyAddress;

    private ProfilesService service;

    private static final int RESULT_LOAD_IMAGE = 1;
    private OutputStream output;
    private String imagePath;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        this.service = new ProfilesService(this);

        this.companyLogo = (ImageView) findViewById(R.id.company_logo);
        this.saveButton = (Button) findViewById(R.id.company_save_button);
        this.companyName = (EditText) findViewById(R.id.company_name);
        this.companyEmail = (EditText) findViewById(R.id.company_email);
        this.companyPhoneNumber = (EditText) findViewById(R.id.company_phone_number);
        this.companyAddress = (EditText) findViewById(R.id.company_address);

        this.saveButton.setOnClickListener(this.addEvent);

        //====================================================| To Image Gallery Load |====================================================
        //Load image from gallery
        companyLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });

    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profiles_option_menu, menu);
        return true;
    }
    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.display_profiles_id:
                customAlertDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Back press disabled
    @Override
    public void onBackPressed() {}

    //====================================================| Display Data using AlertDialog |====================================================

    //Add data into database using popup window or modal
    public void customAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfilesActivity.this).setTitle("All Companies");

        final ArrayList<String> list = new ArrayList<String>();
        ArrayList<ProfilesModel> arrayList;
        try {
            arrayList = this.service.getAllData(); //Getting data from database
            for(ProfilesModel obj : arrayList){
                list.add(String.valueOf(obj.getCompanyId())+ " - " + String.valueOf(obj.getCompanyName())+ " - " + String.valueOf(obj.getCompanyLogoName()));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        final CharSequence[] items = list.toArray(new CharSequence[list.size()]);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, final int i) {
                new AlertDialog.Builder(ProfilesActivity.this).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String arr[] = String.valueOf(items[i]).split(" - ");
                        long data = ProfilesActivity.this.service.deleteDataById(arr[0]); //Deleting data from database
                        if (data > 0){
                            new File(new File(getFilesDir() + "/CompanyLogo/").getAbsolutePath(), arr[2]).delete(); //delete image from directory
                            Toast.makeText(getApplicationContext(),  "Deleted successfully"+String.valueOf(items[i]), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
        builder.show();
    }

    //====================================================| Select, Insert, Update, Delete |====================================================

    //Adding data into database
    private final View.OnClickListener addEvent = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            if(!companyName.getText().toString().trim().isEmpty() && !companyEmail.getText().toString().trim().isEmpty() && !companyPhoneNumber.getText().toString().trim().isEmpty()){
                ProfilesModel model = new ProfilesModel(companyName.getText().toString(),companyEmail.getText().toString(),companyPhoneNumber.getText().toString(),companyAddress.getText().toString(),imageName,new File(getFilesDir() + "/CompanyLogo/").getAbsolutePath());
                long data = ProfilesActivity.this.service.addData(model);
                if (data > 0){
                    //Logo save
                    Bitmap bitmap = ((BitmapDrawable)companyLogo.getDrawable()).getBitmap();
                    imagePath = saveToInternalStorage(bitmap);
                    if(imagePath != null){
                        Toast.makeText(getApplicationContext(), "Logo saved successfully", Toast.LENGTH_SHORT).show();
                    }
                    clearFields();
                    Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Do not saved unsuccessfully", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),"Please insert values in name, email & number", Toast.LENGTH_LONG).show();
            }
        }
    };

    //Getting all data from database
    private void getAllData() {
        final ArrayList<ProfilesModel> arrayList = this.service.getAllData();
        for(ProfilesModel obj : arrayList){
            Log.d("Logo ====== : ", String.valueOf(obj.getCompanyLogoName()));
            Log.d("Path ====== : ", String.valueOf(obj.getCompanyLogoPath()));
        }
    }

    //====================================================| For Image |====================================================

    //Image set in ImageView using onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectImage = data.getData();
            imageName = "img_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".png";
            companyLogo.setImageURI(selectImage);
        }
    }

    //Save image internal storage
    public String saveToInternalStorage(Bitmap bitmapImage){
        File directory = new File(getFilesDir() + "/CompanyLogo/");
        directory.mkdir(); //Create imageDir
        File file = new File(directory,imageName);
        Log.d("Save file dir ====== : ", file.getAbsolutePath());
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

    public void clearFields() {
        companyName.getText().clear();
        companyEmail.getText().clear();
        companyPhoneNumber.getText().clear();
        companyAddress.getText().clear();
        companyLogo.setImageResource(0);
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
