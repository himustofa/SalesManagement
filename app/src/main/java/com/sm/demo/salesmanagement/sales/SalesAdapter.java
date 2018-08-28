package com.sm.demo.salesmanagement.sales;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class SalesAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<SalesModel> salesModelArrayList;
    SalesService salesService;

    public SalesAdapter(Activity context, ArrayList<SalesModel> arrayList, SalesService service) {
        this.context = context;
        this.salesModelArrayList = arrayList;
        this.salesService = service;
    }

    public static class ViewHolder {
        TextView productName, productQuantity, salesDate, salesAmount, salesId;
    }

    @Override
    public int getCount() {
        return salesModelArrayList.size();
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
        final SalesModel dataModel = salesModelArrayList.get(position);

        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.sales_list_row, parent, false);

            holder.productName = (TextView) viewRow.findViewById(R.id.sale_list_1);
            holder.productQuantity = (TextView) viewRow.findViewById(R.id.sale_list_2);
            holder.salesDate = (TextView) viewRow.findViewById(R.id.sale_list_3);
            holder.salesAmount = (TextView) viewRow.findViewById(R.id.sale_list_4);
            holder.salesId = (TextView) viewRow.findViewById(R.id.sale_list_5);

            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.productName.setText(salesModelArrayList.get(position).getProductName());
        holder.productQuantity.setText(String.valueOf(salesModelArrayList.get(position).getPurchaseProductQuantity()));
        holder.salesDate.setText(salesModelArrayList.get(position).getSalesDate());
        holder.salesAmount.setText(String.valueOf(salesModelArrayList.get(position).getSalesAmount()));
        holder.salesId.setText(salesModelArrayList.get(position).getSalesId());

        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = salesService.deleteDataById(String.valueOf(salesModelArrayList.get(positionWindow).getSalesId()));
                        if(data > 0){
                            salesModelArrayList = (ArrayList) salesService.getAllData();
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
                editListItem(positionWindow, parent);
            }
        });

        return  viewRow;
    }


    public void editListItem(final int positionPopup, ViewGroup parent) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parent.getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Edit Sales");
        View layout = LayoutInflater.from(context).inflate(R.layout.sales_alert_dialog, (ViewGroup) context.findViewById(R.id.sale_alert_dialog_id));
        builder.setView(layout);
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show();

        final Spinner sl1 = (Spinner) layout.findViewById(R.id.sl_product_name);
        Log.d("Sales Adapter", String.valueOf(salesModelArrayList.get(positionPopup).getProductName()));
        //sl1.setSelection(Integer.parseInt(salesModelArrayList.get(positionPopup).getProductName()));
        final TextView sl1d = (TextView) layout.findViewById(R.id.s1_product_id);
        sl1d.setText(salesModelArrayList.get(positionPopup).getProductId());

        final EditText sl2 = (EditText) layout.findViewById(R.id.sl_product_quantity);
        sl2.setText(String.valueOf(salesModelArrayList.get(positionPopup).getProductQuantity()));
        final EditText sl3 = (EditText) layout.findViewById(R.id.sl_purchase_product_quantity); //calculation from purchase table
        sl3.setText(String.valueOf(salesModelArrayList.get(positionPopup).getPurchaseProductQuantity()));

        final Spinner sl4 = (Spinner) layout.findViewById(R.id.sl_customer_name);
        //sl4.setSelection(Integer.parseInt(salesModelArrayList.get(positionPopup).getCustomerName()));
        final TextView sl2d = (TextView) layout.findViewById(R.id.sl_customer_id);
        sl2d.setText(salesModelArrayList.get(positionPopup).getCustomerId());

        final EditText sl5 = (EditText) layout.findViewById(R.id.sl_sales_date);
        sl5.setText(salesModelArrayList.get(positionPopup).getSalesDate());
        final EditText sl6 = (EditText) layout.findViewById(R.id.sl_sales_discount);
        sl6.setText(String.valueOf(salesModelArrayList.get(positionPopup).getSalesDiscount()));
        final EditText sl7 = (EditText) layout.findViewById(R.id.sl_sales_vat);
        sl7.setText(String.valueOf(salesModelArrayList.get(positionPopup).getSalesVat()));
        final EditText sl8 = (EditText) layout.findViewById(R.id.sl_sales_amount);
        sl8.setText(String.valueOf(salesModelArrayList.get(positionPopup).getSalesAmount()));
        final EditText sl9 = (EditText) layout.findViewById(R.id.sl_sales_payment);
        sl9.setText(String.valueOf(salesModelArrayList.get(positionPopup).getSalesPayment()));
        final EditText sl10 = (EditText) layout.findViewById(R.id.sl_sales_balance);
        sl10.setText(String.valueOf(salesModelArrayList.get(positionPopup).getSalesBalance()));
        final EditText sl11 = (EditText) layout.findViewById(R.id.sl_sales_description);
        sl11.setText(salesModelArrayList.get(positionPopup).getSalesDescription());

        final Button saveButton = (Button) layout.findViewById(R.id.sale_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    SalesModel model = salesModelArrayList.get(positionPopup);
                    model.setProductName(sl1.getSelectedItem().toString());
                    model.setProductId(sl1d.getText().toString());
                    model.setProductQuantity(Integer.parseInt(sl2.getText().toString()));
                    model.setPurchaseProductQuantity(Integer.parseInt(sl3.getText().toString()));
                    model.setCustomerName(sl4.getSelectedItem().toString());
                    model.setCustomerId(sl2d.getText().toString());
                    model.setSalesDate(sl5.getText().toString());
                    model.setSalesDiscount(Double.parseDouble(sl6.getText().toString()));
                    model.setSalesVat(Double.parseDouble(sl7.getText().toString()));
                    model.setSalesAmount(Double.parseDouble(sl8.getText().toString()));
                    model.setSalesPayment(Double.parseDouble(sl9.getText().toString()));
                    model.setSalesBalance(Double.parseDouble(sl10.getText().toString()));
                    model.setSalesDescription(sl11.getText().toString());

                    salesService.updateDataById(model, String.valueOf(salesModelArrayList.get(positionPopup).getSalesId()));
                    salesModelArrayList = (ArrayList) salesService.getAllData();

                    notifyDataSetChanged();
                    dialog.cancel();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
