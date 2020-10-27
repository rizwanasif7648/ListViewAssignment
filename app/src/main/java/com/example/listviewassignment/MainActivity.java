package com.example.listviewassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<String> arrayData = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SaveText(View view)
    {
        ListView listView = findViewById(R.id.listView);

        EditText text = (EditText)findViewById(R.id.editText);
        String value = text.getText().toString();
        if(value == null || value.trim().equals(""))
        {
            Toast t1 = Toast.makeText(getApplicationContext(), "Kindly Input some Text",
                    Toast.LENGTH_LONG);
            t1.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                    0, 0);
            t1.show();

        }
        else {

            arrayData.add(value);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, arrayData);

            listView.setAdapter(arrayAdapter);
            ((EditText) findViewById(R.id.editText)).setText("");
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Toast toast = Toast.makeText(getApplicationContext(), "You clicked: " + arrayData.get(i),
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            });

        }
    }
}