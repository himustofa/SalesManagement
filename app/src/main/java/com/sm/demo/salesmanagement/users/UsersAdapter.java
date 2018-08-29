package com.sm.demo.salesmanagement.users;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<UsersModel> arrayList;
    UsersService service;

    public UsersAdapter(Activity context, ArrayList<UsersModel> arrayList, UsersService service) {
        this.context = context;
        this.arrayList = arrayList;
        this.service = service;
    }

    //====================================================| ViewHolder |====================================================
    //To scroll smoothly from big data
    public static class ViewHolder {
        TextView userFullName, userDesignation, userUsername, userPhoneNumber, userId;
        ImageView regPassport;
        Button deleteButton;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //====================================================| To view all data in ListView |====================================================
    @Override
    public View getView(int position, View viewRow, final ViewGroup parent) {
        ViewHolder holder;
        final UsersModel dataModel = arrayList.get(position);

        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.users_list_row, parent, false);

            holder.userId = (TextView) viewRow.findViewById(R.id.reg_id);
            holder.userFullName = (TextView) viewRow.findViewById(R.id.reg_full_name);
            holder.userDesignation = (TextView) viewRow.findViewById(R.id.reg_designation);
            holder.userUsername = (TextView) viewRow.findViewById(R.id.reg_username);
            holder.userPhoneNumber = (TextView) viewRow.findViewById(R.id.reg_phone_number);
            holder.regPassport = (ImageView) viewRow.findViewById(R.id.reg_passport);

            // store the holder with the view.
            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.userId.setText("" + arrayList.get(position).getUserId());
        holder.userFullName.setText(arrayList.get(position).getFullName());
        holder.userDesignation.setText(arrayList.get(position).getDesignation());
        holder.userUsername.setText(arrayList.get(position).getUsername());
        holder.userPhoneNumber.setText(arrayList.get(position).getPhoneNumber());
        try {
            holder.regPassport.setImageBitmap(loadImageToListView(position)); //Image load into ListView
        } catch (Exception e){
            e.getStackTrace();
        }

        //====================================================| Delete item from ListView by Single Clicking |====================================================
        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //AlertDialog window to delete data and image
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = service.deleteDataById(String.valueOf(arrayList.get(positionWindow).getUserId())); //delete row
                        if(data > 0){
                            try {
                                new File(arrayList.get(positionWindow).getPhotoPath(), arrayList.get(positionWindow).getPhotoName()).delete(); //delete image from directory
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                            arrayList = (ArrayList) service.getUsers(); //get all data
                            notifyDataSetChanged();
                            Toast.makeText(parent.getContext(), "Delete row successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
                //Toast.makeText(parent.getContext(), "view clicked: " + dataModel.getFullName(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        //====================================================| Edit item from ListView by Long Clicking |====================================================
        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editListItem(positionWindow, parent);
                //Toast.makeText(parent.getContext(), "view clicked: " + dataModel.getFullName(), Toast.LENGTH_SHORT).show();
            }
        });

        return  viewRow;
    }


    //====================================================| Edit data by Custom AlertDialog |====================================================
    //To display popup modal window by clicking edit button
    public void editListItem(final int positionPopup, ViewGroup parent) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parent.getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Edit User");
        //final View inflateForm = getLayoutInflater().inflate(R.layout.user_alert_dialog, null); // Get custom login form view.
        View inflateForm = LayoutInflater.from(context).inflate(R.layout.user_alert_dialog, (ViewGroup) context.findViewById(R.id.user_alert_dialog_id));

        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        final ImageView userPhoto = (ImageView) inflateForm.findViewById(R.id.reg_passport);
        userPhoto.setImageBitmap(loadImageToListView(positionPopup));
        final EditText fullName = (EditText) inflateForm.findViewById(R.id.reg_full_name);
        fullName.setText(arrayList.get(positionPopup).getFullName());
        final EditText designation = (EditText) inflateForm.findViewById(R.id.reg_designation);
        designation.setText(arrayList.get(positionPopup).getDesignation());
        final EditText email = (EditText) inflateForm.findViewById(R.id.reg_email);
        email.setText(arrayList.get(positionPopup).getEmail());
        final EditText phoneNumber = (EditText) inflateForm.findViewById(R.id.reg_phone_number);
        phoneNumber.setText(arrayList.get(positionPopup).getPhoneNumber());
        final EditText address = (EditText) inflateForm.findViewById(R.id.reg_address);
        address.setText(arrayList.get(positionPopup).getAddress());
        final EditText username = (EditText) inflateForm.findViewById(R.id.reg_username);
        username.setText(arrayList.get(positionPopup).getUsername());
        final EditText password = (EditText) inflateForm.findViewById(R.id.reg_password);
        password.setText(arrayList.get(positionPopup).getPassword());
        final EditText confirmPassword = (EditText) inflateForm.findViewById(R.id.reg_confirm_password);
        password.setText(arrayList.get(positionPopup).getPassword());

        final Button saveButton = (Button) inflateForm.findViewById(R.id.reg_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    UsersModel model = arrayList.get(positionPopup);
                    model.setFullName(fullName.getText().toString());
                    model.setDesignation(designation.getText().toString());
                    model.setEmail(email.getText().toString());
                    model.setPhoneNumber(phoneNumber.getText().toString());
                    model.setAddress(address.getText().toString());
                    model.setUsername(username.getText().toString());
                    model.setPassword(password.getText().toString());
                    //Need photo name & path
                    model.setPhotoPath(arrayList.get(positionPopup).getPhotoPath());
                    service.updateDataById(model, String.valueOf(arrayList.get(positionPopup).getUserId())); //update row
                    arrayList = (ArrayList) service.getUsers(); //get all data
                    notifyDataSetChanged();

                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //====================================================| Load image from gallery |====================================================
        //Load image from gallery
        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                context.startActivityForResult(galleryIntent, positionPopup);

                Uri selectImage = galleryIntent.getData();
                //String userPhotoName = "img_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".png";
                userPhoto.setImageURI(selectImage);
            }
        });
    }

    //====================================================| Image path and name load from array |====================================================
    //Load image from object array
    public Bitmap loadImageToListView(int position){
        Bitmap bitmap = null;
        try {
            File file = new File(arrayList.get(position).getPhotoPath(), arrayList.get(position).getPhotoName());
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
