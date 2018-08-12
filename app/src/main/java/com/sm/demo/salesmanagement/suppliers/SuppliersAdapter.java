package com.sm.demo.salesmanagement.suppliers;

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

public class SuppliersAdapter extends ArrayAdapter<SuppliersModel> {

    private Context context;
    ArrayList<SuppliersModel> suppliers;

    public SuppliersAdapter(@NonNull Context context, ArrayList<SuppliersModel> suppliers) {
        super(context, R.layout.suppliers_list_row , suppliers);
        this.context = context;
        this.suppliers = suppliers;
    }

    public static class ViewHolder{
        TextView supplierName, supplierCompanyName, supplierPhoneNumber, supplierEmail, supplierAddress;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SuppliersModel model = suppliers.get(position);
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.suppliers_list_row, parent,false);
            viewHolder.supplierName = convertView.findViewById(R.id.suppliers_name);
            viewHolder.supplierCompanyName = convertView.findViewById(R.id.suppliers_company_name);
            viewHolder.supplierPhoneNumber = convertView.findViewById(R.id.supplier_phone_number);
            viewHolder.supplierEmail = convertView.findViewById(R.id.supplier_email);
            viewHolder.supplierAddress = convertView.findViewById(R.id.supplier_address);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.supplierName = convertView.findViewById(R.id.suppliers_name);
        viewHolder.supplierName.setText(model.getSupplierName());
        viewHolder.supplierCompanyName = convertView.findViewById(R.id.suppliers_company_name);
        viewHolder.supplierCompanyName.setText(model.getSupplierCompanyName());
        viewHolder.supplierPhoneNumber = convertView.findViewById(R.id.supplier_phone_number);
        viewHolder.supplierPhoneNumber.setText(model.getSupplierPhoneNumber());
        viewHolder.supplierEmail = convertView.findViewById(R.id.supplier_email);
        viewHolder.supplierEmail.setText(model.getSupplierEmail());
        viewHolder.supplierAddress = convertView.findViewById(R.id.supplier_address);
        viewHolder.supplierAddress.setText(model.getSupplierAddress());

        return convertView;
    }

}
