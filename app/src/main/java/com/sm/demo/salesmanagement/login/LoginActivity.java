package com.sm.demo.salesmanagement.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public static final String APP_TAG = "MVC_APP_TAG";
    private ListView listView;
    private Button button;
    private EditText userName, passWord;
    private MyService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.service = new MyService(this);

        this.userName = (EditText) this.findViewById(R.id.user_name);
        this.passWord = (EditText) this.findViewById(R.id.pass_word);
        this.button = (Button) this.findViewById(R.id.save_button);
        this.listView = (ListView) this.findViewById(R.id.list_view_id);

        this.button.setOnClickListener(this.addEvent);
        this.getAllData();
    }

    //Getting all data from database
    private void getAllData() {
        final List<String> list = this.service.getTasks();
        Log.d(LoginActivity.APP_TAG, String.format("%d found list ", list.size()));
        this.listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.toArray(new String[]{})));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Deleting data by item click
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                Log.d(LoginActivity.APP_TAG, String.format("task id: %d and position: %d", id, position));
                final TextView v = (TextView) view;
                LoginActivity.this.service.deleteTask(v.getText().toString());
                LoginActivity.this.getAllData();
            }
        });
    }

    //Adding data into database
    private final View.OnClickListener addEvent = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            MyModel model = new MyModel(LoginActivity.this.userName.getText().toString(), LoginActivity.this.passWord.getText().toString());
            long data = LoginActivity.this.service.addTask(model);
            if(data > 0){
                Toast.makeText(LoginActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                LoginActivity.this.getAllData();
            } else {
                Toast.makeText(LoginActivity.this, "Do not saved unsuccessfully", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
