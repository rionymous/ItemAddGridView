package com.androidrion.itemaddgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String GetItem;
    List<String> daftar_item;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridViewAdd);
        Button button = findViewById(R.id.buttonAdd);
        final EditText editText = findViewById(R.id.textAdd);

        String[] values = new String[]{
                "Facebook", "Instagram", "Twitter"
        };

        daftar_item = new ArrayList<>(Arrays.asList(values));
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, daftar_item);
        gridView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GetItem = editText.getText().toString();
                daftar_item.add(daftar_item.size(), GetItem);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item Berhasil di Tambahkan", Toast.LENGTH_LONG).show();
            }
        });

    }
}

