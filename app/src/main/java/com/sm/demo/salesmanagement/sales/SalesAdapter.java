package com.sm.demo.salesmanagement.sales;

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

public class SalesAdapter extends ArrayAdapter<SalesModel> {

    private Context context;
    ArrayList<SalesModel> sales;

    public SalesAdapter(@NonNull Context context, ArrayList<SalesModel> sales) {
        super(context, R.layout.sales_list_row , sales);
        this.context = context;
        this.sales = sales;
    }

    public static class ViewHolder{
        TextView productName, purchaseProductQuantity, salesDate, customerName, salesDiscount, salesAmount;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SalesModel model = sales.get(position);
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.sales_list_row,parent,false);
            viewHolder.productName = convertView.findViewById(R.id.product_name);
            viewHolder.purchaseProductQuantity = convertView.findViewById(R.id.purchase_product_quantity);
            viewHolder.salesDate = convertView.findViewById(R.id.sales_date);
            viewHolder.customerName = convertView.findViewById(R.id.customer_name);
            viewHolder.salesDiscount = convertView.findViewById(R.id.sales_discount);
            viewHolder.salesAmount = convertView.findViewById(R.id.sales_amount);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.productName = convertView.findViewById(R.id.product_name);
        viewHolder.productName.setText(model.getProductName());
        viewHolder.purchaseProductQuantity = convertView.findViewById(R.id.purchase_product_quantity);
        viewHolder.purchaseProductQuantity.setText(String.valueOf(model.getPurchaseProductQuantity()));
        viewHolder.salesDate = convertView.findViewById(R.id.sales_date);
        viewHolder.salesDate.setText(model.getSalesDate());
        viewHolder.customerName = convertView.findViewById(R.id.customer_name);
        viewHolder.customerName.setText(model.getCustomerName());
        viewHolder.salesDiscount = convertView.findViewById(R.id.sales_discount);
        viewHolder.salesDiscount.setText(String.valueOf(model.getSalesDiscount()));
        viewHolder.salesAmount = convertView.findViewById(R.id.sales_amount);
        viewHolder.salesAmount.setText(String.valueOf(model.getSalesAmount()));

        return convertView;
    }
}
