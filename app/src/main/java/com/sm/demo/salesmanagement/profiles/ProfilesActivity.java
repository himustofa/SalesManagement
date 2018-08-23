package com.sm.demo.salesmanagement.profiles;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.database.SQLiteDatabaseHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProfilesActivity extends AppCompatActivity {

    ImageView companyLogo;
    Button loadButton, saveButton;
    EditText companyName, companyEmail, companyPhoneNumber, companyAddress;

    ProfilesService service;
    SQLiteDatabaseHelper database;

    private static final int RESULT_LOAD_IMAGE = 1;
    OutputStream output;
    String imagePath;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        companyLogo = (ImageView) findViewById(R.id.company_logo);
        loadButton = (Button) findViewById(R.id.company_logo_upload_button);
        saveButton = (Button) findViewById(R.id.company_save_button);
        companyName = (EditText) findViewById(R.id.company_name);
        companyEmail = (EditText) findViewById(R.id.company_email);
        companyPhoneNumber = (EditText) findViewById(R.id.company_phone_number);
        companyAddress = (EditText) findViewById(R.id.company_address);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

        //Load image from gallery
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });
    }

    private void addData() {
        if(!companyName.getText().toString().trim().isEmpty() && !companyEmail.getText().toString().trim().isEmpty() && !companyPhoneNumber.getText().toString().trim().isEmpty()){
            ProfilesModel model = new ProfilesModel(companyName.getText().toString(),companyEmail.getText().toString(),companyPhoneNumber.getText().toString(),companyAddress.getText().toString(),imageName,new File(getFilesDir() + "/CompanyLogo/").getAbsolutePath());
            long data = service.addData(model);
            //Log.e("Insert2 : ", String.valueOf(model));
            if (data > 0){
                //Logo save
                Bitmap bitmap = ((BitmapDrawable)companyLogo.getDrawable()).getBitmap();
                imagePath = saveToInternalStorage(bitmap);
                if(imagePath != null){
                    Toast.makeText(getApplicationContext(), "Logo saved successfully", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Please insert values in name, email & number", Toast.LENGTH_SHORT).show();
        }
    }

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


}
