package com.sm.demo.salesmanagement.customers;

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

public class CustomersAdapter extends ArrayAdapter<CustomersModel> {

    private Context context;
    ArrayList<CustomersModel> customers;

    public CustomersAdapter(@NonNull Context context, ArrayList<CustomersModel> customers) {
        super(context, R.layout.customers_list_row , customers);
        this.context = context;
        this.customers = customers;
    }

    public static class ViewHolder{
        TextView customerName, customerPhoneNumber, customerEmail, customerDiscount;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CustomersModel model = customers.get(position);
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.customers_list_row, parent,false);
            viewHolder.customerName = convertView.findViewById(R.id.customer_name);
            viewHolder.customerPhoneNumber = convertView.findViewById(R.id.customer_phone_number);
            viewHolder.customerEmail = convertView.findViewById(R.id.customer_email);
            viewHolder.customerDiscount = convertView.findViewById(R.id.customer_discount);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.customerName = convertView.findViewById(R.id.customer_name);
        viewHolder.customerName.setText(model.getCustomerName());
        viewHolder.customerPhoneNumber = convertView.findViewById(R.id.customer_phone_number);
        viewHolder.customerPhoneNumber.setText(model.getCustomerPhoneNumber());
        viewHolder.customerEmail = convertView.findViewById(R.id.customer_email);
        viewHolder.customerEmail.setText(model.getCustomerEmail());
        viewHolder.customerDiscount = convertView.findViewById(R.id.customer_discount);
        viewHolder.customerDiscount.setText(String.valueOf(model.getCustomerDiscount()));

        return convertView;
    }
}
