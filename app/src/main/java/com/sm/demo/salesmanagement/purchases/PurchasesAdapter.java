package com.sm.demo.salesmanagement.purchases;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class PurchasesAdapter extends ArrayAdapter<PurchasesModel> {

    private Context context;
    ArrayList<PurchasesModel> purchases;

    public PurchasesAdapter(@NonNull Context context, ArrayList<PurchasesModel> purchases) {
        super(context, R.layout.purchases_list_row , purchases);
        this.context = context;
        this.purchases = purchases;
    }

    public static class ViewHolder{
        TextView productName, supplierName, purchaseDate, purchaseProductQuantity, purchaseAmount, purchasePayment, purchaseBalance;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PurchasesModel model = purchases.get(position);
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.purchases_list_row, parent,false);
            viewHolder.productName = convertView.findViewById(R.id.product_name);
            viewHolder.supplierName = convertView.findViewById(R.id.supplier_name);
            viewHolder.purchaseDate = convertView.findViewById(R.id.purchase_date);
            viewHolder.purchaseProductQuantity = convertView.findViewById(R.id.purchase_product_quantity);
            viewHolder.purchaseAmount = convertView.findViewById(R.id.purchase_amount);
            viewHolder.purchasePayment = convertView.findViewById(R.id.purchase_payment);
            viewHolder.purchaseBalance = convertView.findViewById(R.id.purchase_balance);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.productName = convertView.findViewById(R.id.product_name);
        viewHolder.productName.setText(model.getProductName());
        viewHolder.supplierName = convertView.findViewById(R.id.supplier_name);
        viewHolder.supplierName.setText(model.getSupplierName());
        viewHolder.purchaseDate = convertView.findViewById(R.id.purchase_date);
        viewHolder.purchaseDate.setText(model.getPurchaseDate());
        viewHolder.purchaseProductQuantity = convertView.findViewById(R.id.purchase_product_quantity);
        viewHolder.purchaseProductQuantity.setText(String.valueOf(model.getPurchaseProductQuantity()));
        viewHolder.purchaseAmount = convertView.findViewById(R.id.purchase_amount);
        viewHolder.purchaseAmount.setText(String.valueOf(model.getPurchaseAmount()));
        viewHolder.purchasePayment = convertView.findViewById(R.id.purchase_payment);
        viewHolder.purchasePayment.setText(String.valueOf(model.getPurchasePayment()));
        viewHolder.purchaseBalance = convertView.findViewById(R.id.purchase_balance);
        viewHolder.purchaseBalance.setText(String.valueOf(model.getPurchaseBalance()));

        return convertView;
    }
}
