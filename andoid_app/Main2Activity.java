package com.example.aman.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        Bundle bundle=getIntent().getExtras();
        String msg=bundle.getString("aman");
        TextView txt=(TextView)findViewById(R.id.textView2);
        txt.setText(msg);

    }
}