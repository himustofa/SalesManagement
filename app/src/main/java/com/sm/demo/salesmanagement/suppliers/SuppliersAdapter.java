package com.sm.demo.salesmanagement.suppliers;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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

public class SuppliersAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<SuppliersModel> suppliersArrayList;
    SuppliersService suppliersService;

    public SuppliersAdapter(Activity context, ArrayList<SuppliersModel> arrayList, SuppliersService service) {
        this.context = context;
        this.suppliersArrayList = arrayList;
        this.suppliersService = service;
    }

    //To scroll smoothly from big data
    public static class ViewHolder {
        TextView EL1, EL2, EL3, EL4, EL5, EL6;
    }

    @Override
    public int getCount() {
        return suppliersArrayList.size();
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
        final SuppliersModel dataModel = suppliersArrayList.get(position);

        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.suppliers_list_row, parent, false);

            holder.EL1 = (TextView) viewRow.findViewById(R.id.suppliers_list_1);
            holder.EL2 = (TextView) viewRow.findViewById(R.id.suppliers_list_2);
            holder.EL3 = (TextView) viewRow.findViewById(R.id.suppliers_list_3);
            holder.EL4 = (TextView) viewRow.findViewById(R.id.suppliers_list_4);
            holder.EL5 = (TextView) viewRow.findViewById(R.id.suppliers_list_5);
            holder.EL6 = (TextView) viewRow.findViewById(R.id.suppliers_list_6);

            // store the holder with the view.
            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.EL1.setText(suppliersArrayList.get(position).getSupplierName());
        holder.EL2.setText(suppliersArrayList.get(position).getSupplierCompanyName());
        holder.EL3.setText(suppliersArrayList.get(position).getSupplierPhoneNumber());
        holder.EL4.setText(suppliersArrayList.get(position).getSupplierEmail());
        holder.EL5.setText(suppliersArrayList.get(position).getSupplierAddress());
        holder.EL6.setText("" + suppliersArrayList.get(position).getSupplierId());

        //Long click to edit
        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //AlertDialog window to delete data and image
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = suppliersService.deleteDataById(String.valueOf(suppliersArrayList.get(positionWindow).getSupplierId())); //delete row
                        if(data > 0){
                            suppliersArrayList = (ArrayList) suppliersService.getAllData(); //get all data
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
                //Toast.makeText(parent.getContext(), "view clicked: " + dataModel.getSupplierName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //Single click to delete
        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(parent.getContext(), "view clicked: " + dataModel.getSupplierName(), Toast.LENGTH_SHORT).show();
                editListItem(positionWindow, dataModel, parent);
            }
        });

        return  viewRow;
    }


    //To display popup modal window by clicking edit button
    public void editListItem(final int positionPopup, SuppliersModel model, ViewGroup parent) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parent.getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Edit Supplier");
        View layout = LayoutInflater.from(context).inflate(R.layout.supplier_alert_dialog, (ViewGroup) context.findViewById(R.id.supplier_alert_dialog_id));

        builder.setView(layout); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        final EditText a = (EditText) layout.findViewById(R.id.suppliers_alert_1);
        a.setText(suppliersArrayList.get(positionPopup).getSupplierName());
        final EditText b = (EditText) layout.findViewById(R.id.suppliers_alert_2);
        b.setText(suppliersArrayList.get(positionPopup).getSupplierCompanyName());
        final EditText c = (EditText) layout.findViewById(R.id.suppliers_alert_3);
        c.setText(suppliersArrayList.get(positionPopup).getSupplierContactPerson());
        final EditText d = (EditText) layout.findViewById(R.id.suppliers_alert_4);
        d.setText(suppliersArrayList.get(positionPopup).getSupplierPhoneNumber());
        final EditText e = (EditText) layout.findViewById(R.id.suppliers_alert_5);
        e.setText(suppliersArrayList.get(positionPopup).getSupplierAddress());
        final EditText f = (EditText) layout.findViewById(R.id.suppliers_alert_6);
        f.setText(suppliersArrayList.get(positionPopup).getSupplierBankName());
        final EditText g = (EditText) layout.findViewById(R.id.suppliers_alert_7);
        g.setText(suppliersArrayList.get(positionPopup).getSupplierBankAccount());
        final EditText h = (EditText) layout.findViewById(R.id.suppliers_alert_8);
        h.setText(suppliersArrayList.get(positionPopup).getSupplierEmail());
        final EditText i = (EditText) layout.findViewById(R.id.suppliers_alert_9);
        i.setText(suppliersArrayList.get(positionPopup).getSupplierWebsite());

        final Button saveButton = (Button) layout.findViewById(R.id.supplier_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    SuppliersModel model = suppliersArrayList.get(positionPopup);
                    model.setSupplierName(a.getText().toString());
                    model.setSupplierCompanyName(b.getText().toString());
                    model.setSupplierPhoneNumber(c.getText().toString());
                    model.setSupplierEmail(d.getText().toString());
                    model.setSupplierAddress(e.getText().toString());
                    model.setSupplierBankName(f.getText().toString());
                    model.setSupplierBankAccount(g.getText().toString());
                    model.setSupplierEmail(h.getText().toString());
                    model.setSupplierWebsite(i.getText().toString());

                    suppliersService.updateDataById(model, String.valueOf(suppliersArrayList.get(positionPopup).getSupplierId())); //update row
                    suppliersArrayList = (ArrayList) suppliersService.getAllData(); //get all data

                    notifyDataSetChanged();
                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
