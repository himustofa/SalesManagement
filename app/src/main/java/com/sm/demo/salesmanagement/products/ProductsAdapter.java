package com.sm.demo.salesmanagement.products;

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

public class ProductsAdapter extends BaseAdapter {

    private Activity context;
    ArrayList<ProductsModel> productsModelArrayList;
    ProductsService productsService;

    public ProductsAdapter(Activity context, ArrayList<ProductsModel> arrayList, ProductsService service) {
        this.context = context;
        this.productsModelArrayList = arrayList;
        this.productsService = service;
    }

    public static class ViewHolder {
        TextView proName, proCode, proQty, proPrice, proExpDate, proId;
    }

    @Override
    public int getCount() {
        return productsModelArrayList.size();
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
        final ProductsModel dataModel = productsModelArrayList.get(position);
        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.products_list_row, parent, false);
            holder.proName = (TextView) viewRow.findViewById(R.id.product_name_list_row);
            holder.proCode = (TextView) viewRow.findViewById(R.id.product_code_list_row);
            holder.proQty = (TextView) viewRow.findViewById(R.id.product_quantity_list_row);
            holder.proPrice = (TextView) viewRow.findViewById(R.id.product_price_list_row);
            holder.proExpDate = (TextView) viewRow.findViewById(R.id.product_expire_date_list_row);
            holder.proId = (TextView) viewRow.findViewById(R.id.product_id_list_row);
            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.proName.setText(productsModelArrayList.get(position).getProductName());
        holder.proCode.setText(productsModelArrayList.get(position).getProductCode());
        holder.proQty.setText(String.valueOf(productsModelArrayList.get(position).getProductQuantity()));
        holder.proPrice.setText(String.valueOf(productsModelArrayList.get(position).getProductPrice()));
        holder.proExpDate.setText(productsModelArrayList.get(position).getProductExpireDate());
        holder.proId.setText("" + productsModelArrayList.get(position).getProductId());

        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = productsService.deleteDataById(String.valueOf(productsModelArrayList.get(positionWindow).getProductId())); //delete row
                        if(data > 0){
                            productsModelArrayList = (ArrayList) productsService.getAllProducts(); //get all data
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
                Toast.makeText(parent.getContext(), "view clicked: " + dataModel.getProductName(), Toast.LENGTH_SHORT).show();
                editListItem(positionWindow, parent);
            }
        });

        return viewRow;
    }



    public void editListItem(final int positionPopup, ViewGroup parent) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(parent.getContext());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Edit Product");
        View layout = LayoutInflater.from(context).inflate(R.layout.product_alert_dialog, (ViewGroup) context.findViewById(R.id.product_alert_dialog_id));
        builder.setView(layout); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        final EditText ed1 = (EditText) layout.findViewById(R.id.product_name);
        ed1.setText(productsModelArrayList.get(positionPopup).getProductName());
        final EditText ed2 = (EditText) layout.findViewById(R.id.product_code);
        ed2.setText(productsModelArrayList.get(positionPopup).getProductCode());
        final EditText ed3 = (EditText) layout.findViewById(R.id.product_quantity);
        ed3.setText(String.valueOf(productsModelArrayList.get(positionPopup).getProductQuantity()));
        final EditText ed4 = (EditText) layout.findViewById(R.id.product_price);
        ed4.setText(String.valueOf(productsModelArrayList.get(positionPopup).getProductPrice()));
        final EditText ed5 = (EditText) layout.findViewById(R.id.product_expire_date);
        ed5.setText(productsModelArrayList.get(positionPopup).getProductExpireDate());
        final EditText ed6 = (EditText) layout.findViewById(R.id.product_description);
        ed6.setText(productsModelArrayList.get(positionPopup).getProductDescription());


        final Button saveButton = (Button) layout.findViewById(R.id.product_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    ProductsModel model = productsModelArrayList.get(positionPopup);
                    model.setProductName(ed1.getText().toString());
                    model.setProductCode(ed2.getText().toString());
                    model.setProductQuantity(Integer.parseInt(ed3.getText().toString()));
                    model.setProductPrice(Double.parseDouble(ed4.getText().toString()));
                    model.setProductExpireDate(ed5.getText().toString());
                    model.setProductDescription(ed6.getText().toString());

                    productsService.updateDataById(model, String.valueOf(productsModelArrayList.get(positionPopup).getProductId())); //update row
                    productsModelArrayList = (ArrayList) productsService.getAllProducts(); //get all data

                    notifyDataSetChanged();
                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
