package com.sm.demo.salesmanagement.customers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class CustomersAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<CustomersModel> customersModelArrayList;
    CustomersService customersService;

    public CustomersAdapter(Activity context, ArrayList<CustomersModel> arrayList, CustomersService service) {
        this.context = context;
        this.customersModelArrayList = arrayList;
        this.customersService = service;
    }

    public static class ViewHolder {
        TextView custName, custPhone, custEmail, custDiscount, custId;
    }

    @Override
    public int getCount() {
        return customersModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View viewRow, final ViewGroup parent) {
        ViewHolder holder;
        final CustomersModel dataModel = customersModelArrayList.get(position);
        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.customers_list_row, parent, false);
            holder.custName = (TextView) viewRow.findViewById(R.id.customer_name_cust);
            holder.custPhone = (TextView) viewRow.findViewById(R.id.customer_phone_number_cust);
            holder.custEmail = (TextView) viewRow.findViewById(R.id.customer_email_cust);
            holder.custDiscount = (TextView) viewRow.findViewById(R.id.customer_discount_cust);
            holder.custId = (TextView) viewRow.findViewById(R.id.customer_id_cust);
            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.custName.setText(customersModelArrayList.get(position).getCustomerName());
        holder.custPhone.setText(customersModelArrayList.get(position).getCustomerPhoneNumber());
        holder.custEmail.setText(String.valueOf(customersModelArrayList.get(position).getCustomerEmail()));
        holder.custDiscount.setText(String.valueOf(customersModelArrayList.get(position).getCustomerDiscount()));
        holder.custId.setText("" + customersModelArrayList.get(position).getCustomerId());

        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = customersService.deleteCustomerById(String.valueOf(customersModelArrayList.get(positionWindow).getCustomerId())); //delete row
                        if(data > 0){
                            customersModelArrayList = (ArrayList) customersService.getAllCustomers(); //get all data
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
                return false;
            }
        });

        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), "view clicked: " + dataModel.getCustomerName(), Toast.LENGTH_SHORT).show();
                editListItem(positionWindow, parent);
            }
        });

        return viewRow;
    }

    public void editListItem(final int positionPopup, ViewGroup parent) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parent.getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Edit Customer");
        View layout = LayoutInflater.from(context).inflate(R.layout.customer_alert_dialog, (ViewGroup) context.findViewById(R.id.customer_alert_dialog_id));
        builder.setView(layout); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        final EditText ed1 = (EditText) layout.findViewById(R.id.customer_name);
        ed1.setText(customersModelArrayList.get(positionPopup).getCustomerName());
        final EditText ed2 = (EditText) layout.findViewById(R.id.customer_phone_number);
        ed2.setText(customersModelArrayList.get(positionPopup).getCustomerPhoneNumber());
        final EditText ed3 = (EditText) layout.findViewById(R.id.customer_email);
        ed3.setText(String.valueOf(customersModelArrayList.get(positionPopup).getCustomerEmail()));
        final EditText ed4 = (EditText) layout.findViewById(R.id.customer_contact_person);
        ed4.setText(String.valueOf(customersModelArrayList.get(positionPopup).getCustomerContactPerson()));
        final EditText ed5 = (EditText) layout.findViewById(R.id.customer_discount);
        ed5.setText(String.valueOf(customersModelArrayList.get(positionPopup).getCustomerDiscount()));
        final EditText ed6 = (EditText) layout.findViewById(R.id.customer_address);
        ed6.setText(customersModelArrayList.get(positionPopup).getCustomerAddress());
        final EditText ed7 = (EditText) layout.findViewById(R.id.customer_description);
        ed7.setText(customersModelArrayList.get(positionPopup).getCustomerDescription());


        final Button saveButton = (Button) layout.findViewById(R.id.customer_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    CustomersModel model = customersModelArrayList.get(positionPopup);
                    model.setCustomerName(ed1.getText().toString());
                    model.setCustomerPhoneNumber(ed2.getText().toString());
                    model.setCustomerEmail(ed3.getText().toString());
                    model.setCustomerContactPerson(ed4.getText().toString());
                    model.setCustomerDiscount(Double.parseDouble(ed5.getText().toString()));
                    model.setCustomerAddress(ed6.getText().toString());

                    customersService.updateCustomerById(model, String.valueOf(customersModelArrayList.get(positionPopup).getCustomerId())); //update row
                    customersModelArrayList = (ArrayList) customersService.getAllCustomers(); //get all data

                    notifyDataSetChanged();
                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
