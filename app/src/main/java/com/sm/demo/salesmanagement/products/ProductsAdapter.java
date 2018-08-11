package com.sm.demo.salesmanagement.products;

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

public class ProductsAdapter extends ArrayAdapter<ProductsModel> {

    private Context context;
    ArrayList<ProductsModel> products;

    public ProductsAdapter(@NonNull Context context, ArrayList<ProductsModel> products) {
        super(context, R.layout.products_list_row , products);
        this.context = context;
        this.products = products;
    }

    public static class ViewHolder{
        TextView productName, productCode, productQuantity, productPrice, productExpireDate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ProductsModel model = products.get(position);
        ProductsAdapter.ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ProductsAdapter.ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.products_list_row, parent,false);
            viewHolder.productName = convertView.findViewById(R.id.product_name);
            viewHolder.productCode = convertView.findViewById(R.id.product_code);
            viewHolder.productQuantity = convertView.findViewById(R.id.product_quantity);
            viewHolder.productPrice = convertView.findViewById(R.id.product_price);
            viewHolder.productExpireDate = convertView.findViewById(R.id.product_expire_date);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ProductsAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.productName = convertView.findViewById(R.id.product_name);
        viewHolder.productName.setText(model.getProductName());
        viewHolder.productCode = convertView.findViewById(R.id.product_code);
        viewHolder.productCode.setText(model.getProductCode());
        viewHolder.productQuantity = convertView.findViewById(R.id.product_quantity);
        viewHolder.productQuantity.setText(String.valueOf(model.getProductQuantity()));
        viewHolder.productPrice = convertView.findViewById(R.id.product_price);
        viewHolder.productPrice.setText(String.valueOf(model.getProductPrice()));
        viewHolder.productExpireDate = convertView.findViewById(R.id.product_expire_date);
        viewHolder.productExpireDate.setText(model.getProductExpireDate());

        return convertView;
    }

}
