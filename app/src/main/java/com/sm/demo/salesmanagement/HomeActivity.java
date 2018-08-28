package com.sm.demo.salesmanagement;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.sm.demo.salesmanagement.login.LoginActivity;
import com.sm.demo.salesmanagement.users.UsersActivity;
import com.sm.demo.salesmanagement.customers.CustomersActivity;
import com.sm.demo.salesmanagement.products.ProductsActivity;
import com.sm.demo.salesmanagement.profiles.ProfilesActivity;
import com.sm.demo.salesmanagement.purchases.PurchasesActivity;
import com.sm.demo.salesmanagement.sales.SalesActivity;
import com.sm.demo.salesmanagement.suppliers.SuppliersActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    PieChart pieChart;
    BarChart barChart;

    //For checking SharedPreferences
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //ActionBar actionbar = getActionBar();
        //actionbar.setTitle("My Title");
        //actionbar.setSubtitle("sub-title");
        //getActionBar().setDisplayShowTitleEnabled(false);
        //actionbar.hide();

        //====================================================| To Display Navigation Bar Icon and Back |====================================================
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_id);
        toggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_id);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);

        //====================================================| Social Media Icon Hyperlink |====================================================
        //Hyperlink
        TextView fb =(TextView)findViewById(R.id.facebook_link);
        fb.setClickable(true);
        fb.setMovementMethod(LinkMovementMethod.getInstance());
        fb.setText(Html.fromHtml("<a href='http://www.facebook.com/hikamal'>f</a>"));

        TextView twitter =(TextView)findViewById(R.id.twitter_link);
        twitter.setClickable(true);
        twitter.setMovementMethod(LinkMovementMethod.getInstance());
        String t = "<a href='http://www.twitter.com/himustofa'>t</a>";
        twitter.setText(Html.fromHtml(t));

        TextView yt =(TextView)findViewById(R.id.youtube_link);
        yt.setClickable(true);
        yt.setMovementMethod(LinkMovementMethod.getInstance());
        String y = "<a href='http://www.youtube.com'>y</a>";
        yt.setText(Html.fromHtml(y));

        //====================================================| PieChart & BarChart |====================================================
        //PicChart and BarChart
        pieChart();
        barChart();

        //===============================================| Getting SharedPreferences |===========================================
        //for checking have any sharedPreferences
        preferences = getSharedPreferences("loginInfo", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
        String name = preferences.getString("userName", "Data not found");
        Toast.makeText(this, "SharedPreferences is "+isLoggedIn +" for "+name, Toast.LENGTH_SHORT).show();
        //========================================================================================================================


    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Back press disabled
    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //====================================================| Navigation |====================================================
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId()==R.id.sales_id){
            Intent intent = new Intent(HomeActivity.this, SalesActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.customers_id){
            Intent intent = new Intent(HomeActivity.this, CustomersActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.purchases_id){
            Intent intent = new Intent(HomeActivity.this, PurchasesActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.products_id){
            Intent intent = new Intent(HomeActivity.this, ProductsActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.suppliers_id){
            Intent intent = new Intent(HomeActivity.this, SuppliersActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.profiles_id){
            Intent intent = new Intent(HomeActivity.this, ProfilesActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.users_id){
            Intent intent = new Intent(HomeActivity.this, UsersActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.about_id){
            aboutMe();
        }
        if(menuItem.getItemId()==R.id.log_out){

            //===============================================| Remove SharedPreferences |===========================================
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear(); //Remove from login.xml file
            editor.commit();
            //======================================================================================================================

            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        return false;
    }

    //====================================================| About |====================================================
    public void aboutMe(){
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle("About")
                .setMessage("Sales Management 2018 \nVersion 1.0 \n" + HomeActivity.this.getString(R.string.developed_by))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT);
                    }
                }).show();
    }

    //=====================================================| Pie Chart
    public void pieChart() {
        pieChart = (PieChart) findViewById(R.id.pie_chart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.99f);
        pieChart.setDrawHoleEnabled(true); //false that shows filled up pie
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f); //31 or 91

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(30f, "Dhaka"));
        entries.add(new PieEntry(20f, "Chittagong"));
        entries.add(new PieEntry(2f, "Sylhet"));
        entries.add(new PieEntry(8, "Madaripur"));
        entries.add(new PieEntry(40, "Rajshahi"));

        Description d = new Description();
        //d.setText("This is the simple pie charts");
        d.setTextSize(15);
        pieChart.setDescription(d);

        pieChart.animateY(1000, Easing.EasingOption.EaseInCubic);

        PieDataSet dataSet = new PieDataSet(entries, "Districts");
        dataSet.setSliceSpace(3f); //pie divided space
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }

    //=====================================================| Bar Chart
    public void barChart() {
        barChart = (BarChart) findViewById(R.id.bar_chart); //Vertical chart
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);

        ArrayList<BarEntry> barList = new ArrayList<>();
        barList.add(new BarEntry(1, 40f));
        barList.add(new BarEntry(2, 44f));
        barList.add(new BarEntry(3, 30f));
        barList.add(new BarEntry(4, 10f));

        ArrayList<BarEntry> barList2 = new ArrayList<>();
        barList2.add(new BarEntry(1, 45f));
        barList2.add(new BarEntry(2, 50f));
        barList2.add(new BarEntry(3, 35f));
        barList2.add(new BarEntry(4, 15f));

        BarDataSet barDataSet = new BarDataSet(barList, "Data Set1");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet1 = new BarDataSet(barList2, "Data Set2");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        //-----------------------------------For group bar
        /*BarData bData = new BarData(barDataSet, barDataSet1);

        float groupSpace = 0.1f;
        float barSpace = 0.02f;
        float barWidth = 0.43f;

        barChart.setData(bData);
        bData.setBarWidth(barWidth);
        barChart.groupBars(1, groupSpace, barSpace);*/
        //--------------------------------------------------


        //------------------------------For single bar
        BarData bData = new BarData(barDataSet);
        bData.setBarWidth(0.9f);
        barChart.setData(bData);
        //---------------------------------------------

        //Display X-axis name
        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        XAxis ax = barChart.getXAxis();
        ax.setValueFormatter(new HomeActivity.MyXAxisValueFormatter(months));
        //ax.setPosition(XAxis.XAxisPosition.BOTH_SIDED); //For group bar
        ax.setGranularity(1);
        ax.setCenterAxisLabels(true);
        //ax.setAxisMaximum(1);
    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter {

        private String[] mValues;
		
        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }
}
