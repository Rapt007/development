package com.example.aman.form;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt1;
    EditText txt2;
    EditText txt3;
    EditText txt4;
    TextView txt;
    String name1;
    String DOB1;
    String EmailID1;
    String q="";
    int age1;
    ArrayList<Student> list = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addToArray(View v) {
        txt1 = (EditText) findViewById(R.id.editText);
        name1 = txt1.getText().toString();
        txt2 = (EditText) findViewById(R.id.editText4);
        age1 = Integer.parseInt(txt2.getText().toString());
        txt3 = (EditText) findViewById(R.id.editText5);
        DOB1 = txt3.getText().toString();
        txt4 = (EditText) findViewById(R.id.editText6);
        EmailID1 = txt4.getText().toString();

//        TextView newt=(TextView)findViewById(R.id.textView6);
//        String message="ArrayLIST: " + "\n" +"name " + s1.Name + " \n" + "DOB! " +s1.DOB +"\n"+"EMAILID: " +s1.EmailID;
//        newt.setText(message);
        if (age1 > 18 && name1.length() > 3) {
            AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
            alertdialog.setMessage("Do u want to save it or not");
            alertdialog.setPositiveButton("save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "you saved it", Toast.LENGTH_LONG).show();
                    Student s1 = new Student(name1, age1, DOB1, EmailID1);
                    list.add(s1);
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");

                }
            });
            alertdialog.setNegativeButton("discarded", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Discarded", Toast.LENGTH_LONG).show();
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");


                }
            });
            AlertDialog alertDial = alertdialog.create();
            alertDial.show();
        } else {
            Toast.makeText(MainActivity.this, "error in authentication", Toast.LENGTH_LONG).show();
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
        }


    }




    public void newPage(View v) {
//        txt1 = (EditText) findViewById(R.id.editText);
//        name1 = txt1.getText().toString();
//        txt2 = (EditText) findViewById(R.id.editText4);
//        int age1=Integer.parseInt(txt2.getText().toString());
//        txt3 = (EditText) findViewById(R.id.editText5);
//        DOB1 = txt3.getText().toString();
//        txt4 = (EditText) findViewById(R.id.editText6);
//        EmailID1 = txt4.getText().toString();

        Intent i = new Intent(this, Main2Activity.class);
        for(Student s:list) {
            q += "hey my name is :" + s.Name + "\n" + "my age is :" + s.age + "\n" + "my DOB1 is: " + s.DOB+ "\n" + "my EmailId is:" + s.EmailID + "\n";
            q+="\n";
        }
        i.putExtra("aman", q);
        startActivity(i);



    }
}