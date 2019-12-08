package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et,et2, phn, fn, ln, addr;
    Button btn;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);
        et = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        fn = findViewById(R.id.editText3);
        ln = findViewById(R.id.editText4);
        phn = findViewById(R.id.editText5);
        addr = findViewById(R.id.editText6);


        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the ID", Toast.LENGTH_LONG).show();
                } else {
                    int id = Integer.parseInt(et.getText().toString());
                    // Toast.makeText(MainActivity.this, "ID"+ id, Toast.LENGTH_LONG).show();

                    Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                    myIntent.putExtra("ID",id);
                    startActivity(myIntent);
                }
            }

            });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int id = Integer.parseInt(et2.getText().toString());
                    String fname=(fn.getText().toString());
                    String lname=(ln.getText().toString());
                    int phone = Integer.parseInt(phn.getText().toString());
                    String Address=(addr.getText().toString());



                    // Toast.makeText(MainActivity.this, "ID"+ id, Toast.LENGTH_LONG).show();

                    Intent myIntent = new Intent(MainActivity.this, Main3Activity.class);
                    myIntent.putExtra("ID",id);
                    myIntent.putExtra("fname",fname);
                    myIntent.putExtra("lname",lname);
                    myIntent.putExtra("phone",phone);
                    myIntent.putExtra("Address",Address);
                    startActivity(myIntent);
                }


        });


    }


}