package com.sm.demo.salesmanagement.sales;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class SalesAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<SalesModel> salesArrayList;
    SalesService salesService;

    public SalesAdapter(Activity context, ArrayList<SalesModel> arrayList, SalesService service) {
        this.context = context;
        this.salesArrayList = arrayList;
        this.salesService = service;
    }

    public static class ViewHolder {
        TextView SL1, SL2, SL3, SL4, SL5;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View viewRow, final ViewGroup parent) {
        ViewHolder holder;
        final SalesModel dataModel = salesArrayList.get(position);

        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.sales_list_row, parent, false);

            holder.SL1 = (TextView) viewRow.findViewById(R.id.sale_list_1);
            holder.SL2 = (TextView) viewRow.findViewById(R.id.sale_list_2);
            holder.SL3 = (TextView) viewRow.findViewById(R.id.sale_list_3);
            holder.SL4 = (TextView) viewRow.findViewById(R.id.sale_list_4);
            holder.SL5 = (TextView) viewRow.findViewById(R.id.sale_list_5);

            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.SL1.setText(salesArrayList.get(position).getProductName());
        holder.SL2.setText(salesArrayList.get(position).getPurchaseProductQuantity());
        holder.SL3.setText(salesArrayList.get(position).getSalesDate());
        holder.SL4.setText(String.valueOf(salesArrayList.get(position).getSalesAmount()));
        holder.SL5.setText(salesArrayList.get(position).getSalesId());

        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //editListItem(positionWindow, parent);
                return false;
            }
        });

        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = salesService.deleteDataById(String.valueOf(salesArrayList.get(positionWindow).getSalesId()));
                        if(data > 0){
                            salesArrayList = (ArrayList) salesService.getAllData();
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
            }
        });

        return  viewRow;
    }


    public void editListItem(final int positionPopup, ViewGroup parent) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parent.getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Edit Sales Alert Dialog");
        View layout = LayoutInflater.from(context).inflate(R.layout.sales_alert_dialog, (ViewGroup) context.findViewById(R.id.sale_alert_dialog_id));
        builder.setView(layout);
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show();

        //final Spinner a = (Spinner) layout.findViewById(R.id.sl_product_name);
        //a.setText(salesArrayList.get(positionPopup).getProductName());
        final EditText b = (EditText) layout.findViewById(R.id.sl_product_quantity);
        b.setText(salesArrayList.get(positionPopup).getProductQuantity());
        //final EditText c = (EditText) layout.findViewById(R.id.sl_purchase_product_quantity); //calculation from purchase table
        //c.setText(salesArrayList.get(positionPopup).getPurchaseProductQuantity());
        //final Spinner d = (EditText) layout.findViewById(R.id.sl_customer_name);
        //d.setText(salesArrayList.get(positionPopup).getCustomerName());
        final EditText e = (EditText) layout.findViewById(R.id.sl_sales_date);
        e.setText(salesArrayList.get(positionPopup).getSalesDate());
        //final EditText f = (EditText) layout.findViewById(R.id.sl_sales_discount);
        //f.setText((int) salesArrayList.get(positionPopup).getSalesDiscount());
        //final EditText g = (EditText) layout.findViewById(R.id.sl_sales_vat);
        //g.setText((int) salesArrayList.get(positionPopup).getSalesVat());
        //final EditText h = (EditText) layout.findViewById(R.id.sl_sales_amount);
        //h.setText(salesArrayList.get(positionPopup).getSalesAmount());
        //final EditText i = (EditText) layout.findViewById(R.id.sl_sales_payment);
        //i.setText(salesArrayList.get(positionPopup).getSalesPayment());
        //final EditText j = (EditText) layout.findViewById(R.id.sl_sales_balance);
        //j.setText(salesArrayList.get(positionPopup).getSalesBalance());
        final EditText k = (EditText) layout.findViewById(R.id.sl_sales_description);
        k.setText(salesArrayList.get(positionPopup).getSalesDescription());

        final Button saveButton = (Button) layout.findViewById(R.id.sale_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    SalesModel model = salesArrayList.get(positionPopup);
                    /*model.setSupplierName(a.getText().toString());
                    model.setSupplierCompanyName(b.getText().toString());
                    model.setSupplierPhoneNumber(c.getText().toString());
                    model.setSupplierEmail(d.getText().toString());
                    model.setSupplierAddress(e.getText().toString());
                    model.setSupplierBankName(f.getText().toString());
                    model.setSupplierBankAccount(g.getText().toString());
                    model.setSupplierEmail(h.getText().toString());
                    model.setSupplierWebsite(i.getText().toString());*/

                    salesService.updateDataById(model, String.valueOf(salesArrayList.get(positionPopup).getSalesId()));
                    salesArrayList = (ArrayList) salesService.getAllData();

                    notifyDataSetChanged();
                    dialog.cancel();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
