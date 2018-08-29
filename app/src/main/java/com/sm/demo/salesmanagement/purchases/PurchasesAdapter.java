package com.sm.demo.salesmanagement.purchases;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.products.ProductsModel;
import com.sm.demo.salesmanagement.products.ProductsService;
import com.sm.demo.salesmanagement.suppliers.SuppliersModel;
import com.sm.demo.salesmanagement.suppliers.SuppliersService;

import java.util.ArrayList;

public class PurchasesAdapter extends BaseAdapter {

    private Spinner ed1, ed2;
    private TextView e1d, e2d;
    private EditText ed3, ed4, ed5, ed6, ed7, ed8, ed9;
    private DatePicker picker;

    private Activity context;
    ArrayList<PurchasesModel> purchasesModelArrayList;
    PurchasesService purchasesService;

    //Product
    ArrayList<ProductsModel> productsModelArrayList;
    ProductsService productsService;

    //Supplier
    ArrayList<SuppliersModel> suppliersModelArrayList;
    SuppliersService suppliersService;

    public PurchasesAdapter(Activity context, ArrayList<PurchasesModel> arrayList, PurchasesService service, ArrayList<ProductsModel> proArrayList, ProductsService proService, ArrayList<SuppliersModel> suArrayList, SuppliersService suService) {
        this.context = context;
        this.purchasesModelArrayList = arrayList;
        this.purchasesService = service;

        this.productsModelArrayList = proArrayList;
        this.productsService = proService;

        this.suppliersModelArrayList = suArrayList;
        this.suppliersService = suService;

        Log.d("Purchase adapter", String.valueOf(purchasesModelArrayList.size()));
        Log.d("Product adapter", String.valueOf(productsModelArrayList.size()));
    }

    public static class ViewHolder{
        TextView prodName, suppName, purDate, purProQty, purAmount, purPayment, purBalance, purId;
    }

    @Override
    public int getCount() {
        return purchasesModelArrayList.size();
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
        final PurchasesModel dataModel = purchasesModelArrayList.get(position);
        if (viewRow == null) {
            holder = new ViewHolder();
            viewRow = LayoutInflater.from(context).inflate(R.layout.purchases_list_row, parent, false);
            holder.prodName = (TextView) viewRow.findViewById(R.id.product_name_pur);
            holder.suppName = (TextView) viewRow.findViewById(R.id.supplier_name_pur);
            holder.purDate = (TextView) viewRow.findViewById(R.id.purchase_date_pur);
            holder.purProQty = (TextView) viewRow.findViewById(R.id.purchase_product_quantity_pur);
            holder.purAmount = (TextView) viewRow.findViewById(R.id.purchase_amount_pur);
            holder.purPayment = (TextView) viewRow.findViewById(R.id.purchase_payment_pur);
            holder.purBalance = (TextView) viewRow.findViewById(R.id.purchase_balance_pur);
            holder.purId = (TextView) viewRow.findViewById(R.id.purchase_id_pur);
            viewRow.setTag(holder);
        } else {
            holder = (ViewHolder) viewRow.getTag();
        }

        holder.prodName.setText(purchasesModelArrayList.get(position).getProductName());
        holder.suppName.setText(purchasesModelArrayList.get(position).getSupplierName()); //supId
        holder.purDate.setText(purchasesModelArrayList.get(position).getPurchaseDate());
        holder.purProQty.setText(String.valueOf(purchasesModelArrayList.get(position).getPurchaseProductQuantity()));
        holder.purAmount.setText(String.valueOf(purchasesModelArrayList.get(position).getPurchaseAmount()));
        holder.purPayment.setText(String.valueOf(purchasesModelArrayList.get(position).getPurchasePayment()));
        holder.purBalance.setText(String.valueOf(purchasesModelArrayList.get(position).getPurchaseBalance()));
        holder.purId.setText("" + purchasesModelArrayList.get(position).getPurchaseId());

        final int positionWindow = position;
        viewRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(parent.getContext()).setTitle("Are your sure?").setMessage("Do you want to delete it?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long data = purchasesService.deletePurchaseById(String.valueOf(purchasesModelArrayList.get(positionWindow).getPurchaseId())); //delete row
                        if(data > 0){
                            purchasesModelArrayList = (ArrayList) purchasesService.getPurchases(); //get all data
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
        builder.setTitle("Edit Purchase");
        View layout = LayoutInflater.from(context).inflate(R.layout.purchase_alert_dialog, (ViewGroup) context.findViewById(R.id.purchase_alert_dialog_id));
        builder.setView(layout); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final android.app.AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        //------------------------------------------------------| Spinner |------------------------------------------------------
        this.ed1 = (Spinner) layout.findViewById(R.id.product_name);
        ArrayAdapter<String> pro = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        for(ProductsModel obj : productsModelArrayList){
            pro.add(obj.getProductName());
        }
        ed1.setAdapter(pro);
        this.e1d = (TextView) layout.findViewById(R.id.product_id);
        ed1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                e1d.setText(productsModelArrayList.get(position).getProductId());
                ed5.setText(String.valueOf(productsModelArrayList.get(position).getProductPrice()));
                Log.d("Product: ", String.valueOf(productsModelArrayList.get(position).getProductCode()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        //---------------------------------
        this.ed2 = (Spinner) layout.findViewById(R.id.supplier_name);
        ArrayAdapter<String> sup = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        for(SuppliersModel obj : suppliersModelArrayList){
            sup.add(obj.getSupplierName());
        }
        ed2.setAdapter(sup);
        this.e2d = (TextView) layout.findViewById(R.id.supplier_id);
        ed2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                e2d.setText(suppliersModelArrayList.get(position).getSupplierId());
                Log.d("Supplier: ", String.valueOf(suppliersModelArrayList.get(position).getSupplierName()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        //------------------------------------------------------| End Spinner |------------------------------------------------------
        this.ed3 = (EditText) layout.findViewById(R.id.purchase_date);
        ed3.setText(purchasesModelArrayList.get(positionPopup).getPurchaseDate());
        ed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseDate();
            }
        });
        //----------------------------------
        this.ed4 = (EditText) layout.findViewById(R.id.purchase_product_quantity);
        ed4.setText(String.valueOf(purchasesModelArrayList.get(positionPopup).getPurchaseProductQuantity()));
        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ed6.setText(String.valueOf(Double.parseDouble(ed4.getText().toString())*Double.parseDouble(ed5.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //-----------------------------------
        this.ed5 = (EditText) layout.findViewById(R.id.purchase_product_price);
        ed5.setText(String.valueOf(purchasesModelArrayList.get(positionPopup).getPurchaseProductPrice()));
        this.ed6 = (EditText) layout.findViewById(R.id.purchase_amount);
        ed6.setText(String.valueOf(purchasesModelArrayList.get(positionPopup).getPurchaseAmount()));
        //----------------------------------
        this.ed7 = (EditText) layout.findViewById(R.id.purchase_payment);
        ed7.setText(String.valueOf(purchasesModelArrayList.get(positionPopup).getPurchasePayment()));
        ed7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ed8.setText(String.valueOf(Double.parseDouble(ed6.getText().toString()) - Double.parseDouble(ed7.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //----------------------------------
        this.ed8 = (EditText) layout.findViewById(R.id.purchase_balance);
        ed8.setText(String.valueOf(purchasesModelArrayList.get(positionPopup).getPurchaseBalance()));
        this.ed9 = (EditText) layout.findViewById(R.id.purchase_description);
        ed9.setText(purchasesModelArrayList.get(positionPopup).getPurchaseDescription());
        //---------------------------------------------------------------------------------------------------------------------------

        final Button saveButton = (Button) layout.findViewById(R.id.purchase_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    PurchasesModel model = purchasesModelArrayList.get(positionPopup);
                    model.setProductName(ed1.getSelectedItem().toString());
                    model.setProductId(e1d.getText().toString());
                    model.setSupplierName(ed2.getSelectedItem().toString());
                    model.setSupplierId(e2d.getText().toString());
                    model.setPurchaseDate(ed3.getText().toString());
                    model.setPurchaseProductQuantity(Integer.parseInt(ed4.getText().toString()));
                    model.setPurchaseProductPrice(Double.parseDouble(ed5.getText().toString()));
                    model.setPurchaseAmount(Double.parseDouble(ed6.getText().toString()));
                    model.setPurchasePayment(Double.parseDouble(ed7.getText().toString()));
                    model.setPurchaseBalance(Double.parseDouble(ed8.getText().toString()));
                    model.setPurchaseDescription(ed9.getText().toString());

                    purchasesService.updatePurchaseById(model, String.valueOf(purchasesModelArrayList.get(positionPopup).getPurchaseId())); //update row
                    purchasesModelArrayList = (ArrayList) purchasesService.getPurchases(); //get all data

                    notifyDataSetChanged();
                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    //DatePicker
    private void purchaseDate() {
        picker = new DatePicker(context);
        int curYear = picker.getYear();
        int curMonth = picker.getMonth()+1;
        int curDayOfMonth = picker.getDayOfMonth();
        DatePickerDialog pickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ed3.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, curYear, curMonth, curDayOfMonth);
        pickerDialog.show();
    }

}