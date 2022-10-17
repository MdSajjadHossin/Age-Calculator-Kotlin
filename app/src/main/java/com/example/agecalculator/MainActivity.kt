package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.dobBtn);
        button.setOnClickListener{view->
            printAge(view)
        }
    }

    private fun printAge(view: View){
        var myClander = Calendar.getInstance();
        var year = myClander.get(Calendar.YEAR);
        var  month = myClander.get(Calendar.MONTH);
        var day = myClander.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, year, month, day ->
            val selectedDate = "$day/${month+1}/$year";
            var dobText = findViewById<TextView>(R.id.dobText);
            dobText.text= selectedDate;


            var dob = Calendar.getInstance();
            dob.set(year, month, day);

            var cYear = myClander.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            if(myClander.get(Calendar.DAY_OF_YEAR) > dob.get(Calendar.YEAR)){
                cYear--;
            }
            var cMonth = myClander.get(Calendar.MONTH) - dob.get(Calendar.MONTH);
            var cDay = myClander.get(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH);
            if(dob.get(Calendar.DAY_OF_MONTH) > myClander.get(Calendar.DAY_OF_MONTH)){
                cDay = dob.get(Calendar.DAY_OF_MONTH) - myClander.get(Calendar.DAY_OF_MONTH);
            }

            var ageDob = findViewById<TextView>(R.id.ageDob);
            ageDob.text = "You are $cYear years $cMonth months and $cDay days old";

                                                                 },
            year,
            month,
            day).show();
    }
}