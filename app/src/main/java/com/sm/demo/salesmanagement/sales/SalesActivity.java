package com.sm.demo.salesmanagement.sales;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class SalesActivity extends AppCompatActivity {

    private EditText E1, E2, E3, E4, E5, E6, E7, E8, E9, saleSearchView;
    private ListView salesListView;
    private Spinner S1, S2;
    private TextView T1, T2;
    private DatePicker picker;


    private SalesModel salModel;
    private SalesService salService;
    private SalesAdapter salAdapter;
    private ArrayList<SalesModel> salArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        this.salService = new SalesService(this); //Important: To get from service

        //===============================================| FloatingActionButton Add Button |=========================================
        FloatingActionButton fab = findViewById(R.id.add_sale_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();
            }
        });

        //===============================================| Getting All Data in ListView |=========================================
        salesListView = (ListView) findViewById(R.id.sales_list_view_id);
        try {
            salArrayList = (ArrayList) salService.getAllData(); //Get all data from database and set in list view
            salAdapter = new SalesAdapter(SalesActivity.this, salArrayList, salService);
            salesListView.setAdapter(salAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //===============================================| SearchView |=========================================
        //Search Bar
        /*saleSearchView = (SearchView) findViewById(R.id.sale_search);
        saleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //customAdapter.getItem()
                return false;
            }
        });*/

        //===============================================| Custom adapter search |=========================================
        saleSearchView = (EditText) findViewById(R.id.sale_search);
        saleSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int textlength = cs.length();
                ArrayList<SalesModel> tempArrayList = new ArrayList<SalesModel>();
                for(SalesModel c: salArrayList){
                    if (textlength <= c.getProductName().length()) {
                        if (c.getProductName().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                salAdapter = new SalesAdapter(SalesActivity.this, tempArrayList, salService);
                salesListView.setAdapter(salAdapter);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sales_option_menu, menu);
        return true;
    }

    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_sale_option_menu:
                customAlertDialog(); //Add method
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Back press disabled
    @Override
    public void onBackPressed() {}

    //====================================================| Custom AlertDialog |====================================================
    //Add data into database using alert dialog
    protected void customAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SalesActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Add Sale");
        final View inflateForm = getLayoutInflater().inflate(R.layout.sales_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        this.S1 = (Spinner) inflateForm.findViewById(R.id.sl_product_name);
        this.T1 = (TextView) inflateForm.findViewById(R.id.s1_product_id);
        this.E1 = (EditText) inflateForm.findViewById(R.id.sl_product_quantity);
        this.E2 = (EditText) inflateForm.findViewById(R.id.sl_purchase_product_quantity);
        this.S2 = (Spinner) inflateForm.findViewById(R.id.sl_customer_name);
        this.T2 = (TextView) inflateForm.findViewById(R.id.sl_customer_id);
        this.E3 = (EditText) inflateForm.findViewById(R.id.sl_sales_date);
        this.E4 = (EditText) inflateForm.findViewById(R.id.sl_sales_discount);
        this.E5 = (EditText) inflateForm.findViewById(R.id.sl_sales_vat);
        this.E6 = (EditText) inflateForm.findViewById(R.id.sl_sales_amount);
        this.E7 = (EditText) inflateForm.findViewById(R.id.sl_sales_payment);
        this.E8 = (EditText) inflateForm.findViewById(R.id.sl_sales_balance);
        this.E9 = (EditText) inflateForm.findViewById(R.id.sl_sales_description);

        //DatePicker dialog for sales date
        E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saleDate();
            }
        });

        //Calculation
        /*E6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        Button saveButton = (Button) inflateForm.findViewById(R.id.sale_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    addData(S1,
                            T1,
                            E1,
                            E2,
                            S2,
                            T2,
                            E3,
                            E4,
                            E5,
                            E6,
                            E7,
                            E8,
                            E9); //Adding data into database

                    //Displaying data from database and sets listView
                    if(salAdapter==null) {
                        salAdapter = new SalesAdapter(SalesActivity.this, salArrayList, salService);
                        salesListView.setAdapter(salAdapter);
                    }
                    salAdapter.salesModelArrayList = (ArrayList) salService.getAllData();
                    ((BaseAdapter)salesListView.getAdapter()).notifyDataSetChanged(); //Refresh listView

                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    //DatePicker
    private void saleDate() {
        picker = new DatePicker(this);
        int curYear = picker.getYear();
        int curMonth = picker.getMonth()+1;
        int curDayOfMonth = picker.getDayOfMonth();
        DatePickerDialog pickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                E3.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, curYear, curMonth, curDayOfMonth);
        pickerDialog.show();
    }


    //====================================================| Select, Insert, Update, Delete |====================================================
    //Adding data into database
    private void addData(
            Spinner s1,
            TextView t1,
            EditText e1,
            EditText e2,
            Spinner s2,
            TextView t2,
            EditText e3,
            EditText e4,
            EditText e5,
            EditText e6,
            EditText e7,
            EditText e8,
            EditText e9) {
        try {

            //Need exception handle because without value do not parse
            String salS1 = s1.getSelectedItem().toString();
            String salT1 = t1.getText().toString();
            int salE1 = Integer.parseInt(e1.getText().toString());
            int salE2 = Integer.parseInt(e2.getText().toString());
            String salS2 = s2.getSelectedItem().toString();
            String salT2 = t2.getText().toString();
            String salE3 = e3.getText().toString();
            double salE4 = Double.parseDouble(e4.getText().toString());
            double salE5 = Double.parseDouble(e5.getText().toString());
            double salE6 = Double.parseDouble(e6.getText().toString());
            double salE7 = Double.parseDouble(e7.getText().toString());
            double salE8 = Double.parseDouble(e8.getText().toString());
            String salE9 = e9.getText().toString();

            SalesModel model = new SalesModel(
                    salS1,
                    salT1,
                    salE1,
                    salE2,
                    salS2,
                    salT2,
                    salE3,
                    salE4,
                    salE5,
                    salE6,
                    salE7,
                    salE8,
                    salE9);

            if(!e1.getText().toString().trim().isEmpty() && !e3.toString().trim().isEmpty() && !e6.getText().toString().trim().isEmpty()){

                long data = SalesActivity.this.salService.addAdd(model);
                Log.d("Add Data ====== : ", String.valueOf(data));

                if (data > 0){
                    Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Do not saved unsuccessfully", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),"Please insert the values into the red color fields.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {

        }
    }

    //====================================================| For Database Starting and Closing |====================================================
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    //====================================================== No Need

    /*private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePickerModel view, int selectedYear, int selectedMonth, int selectedDay) {
            day = selectedDay;
            month = selectedMonth;
            year = selectedYear;
            datePickerButton.setText(selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear);
        }
    };*/

    /*@SuppressLint("ValidFragment")
    public class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }*/


    //Date picker dialog
    /*private String datePickerDialog() {

        picker = new DatePicker(this);
        int curYear = picker.getYear();
        int curMonth = picker.getMonth()+1;
        int curDayOfMonth = picker.getDayOfMonth();

        DatePickerDialog pickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                StringBuilder builder = new StringBuilder();
                builder.append(dayOfMonth+" / ");
                builder.append((month+1)+" / ");
                builder.append(year+" / ");
                Log.d("Datepicker", String.valueOf(builder));
            }
        }, curYear, curMonth, curDayOfMonth);
        pickerDialog.show();



        return String.valueOf("");
    }*/





}
