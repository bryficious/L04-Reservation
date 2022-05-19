package sg.edu.rp.c346.id21012434.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnBook;
    Button btnReset;
    TextView tvDisplay1;
    TextView tvDisplay2;
    TextView tvDisplay3;
    TextView tvDisplay4;
    TextView tvDisplay5;
    TextView tvDisplay6;
    RadioButton Smoke;
    RadioButton NonSmoke;
    RadioGroup Option;
    EditText textName;
    EditText textNumber;
    EditText textSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        tvDisplay1=findViewById(R.id.DisplayDate);
        tvDisplay2=findViewById(R.id.DisplayTime);
        tvDisplay3=findViewById(R.id.Name);
        tvDisplay4=findViewById(R.id.number);
        tvDisplay5=findViewById(R.id.size);
        tvDisplay6=findViewById(R.id.option);
        btnBook=findViewById(R.id.buttonBook);
        btnReset=findViewById(R.id.buttonReset);
        textName=findViewById(R.id.editText);
        textNumber=findViewById(R.id.editText2);
        textSize=findViewById(R.id.editText3);
        Smoke=findViewById(R.id.radioButtonSmoke);
        NonSmoke=findViewById(R.id.radioButtonNosmoking);
        Option=findViewById(R.id.Option);


        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FName = textName.getText().toString();
                String PhoneNo = textNumber.getText().toString();
                String GSize = textSize.getText().toString();
                tvDisplay3.setText("Name: "+FName);
                tvDisplay4.setText("Phone Number: "+PhoneNo);
                tvDisplay5.setText("Group Size: "+GSize);
                int CurrentHour = tp.getCurrentHour();
                int CurrentMinute = tp.getCurrentMinute();
                String minuteString = "";
                String hourString = "";
                if (CurrentMinute < 10) {
                    minuteString = "0" + CurrentMinute;
                } else {
                    minuteString = "" + CurrentMinute;
                }
                if (CurrentHour < 10) {
                    hourString = "0" + CurrentHour;
                } else {
                    hourString = "" + CurrentHour;
                }
                String timeMessage =  hourString + ":" + minuteString;
                tvDisplay2.setText("Arrival Time: "+timeMessage);
                String DateMessage=+dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear();
                tvDisplay1.setText("Booked Date:"+DateMessage);
                int checkRadioId = Option.getCheckedRadioButtonId();
                String table="";
                if (checkRadioId== R.id.radioButtonSmoke){
                    table="Smoking Area";
                    tvDisplay6.setText("Table Choice: Smoking Area");

                }else if (checkRadioId==R.id.radioButtonNosmoking){
                    table="Non-Smoking Area";
                    tvDisplay6.setText("Table Choice: Non-Smoking Area");

                }
                Toast.makeText(MainActivity.this, String.format(" Name: %s \n Phone Number: %s \n Group Size: %s" +
                                "\n Arrival Time: %s \n Booked Date: %s \n Table Choice: %s "
                        ,FName,PhoneNo,GSize,timeMessage,DateMessage,table),
                        Toast.LENGTH_LONG).show();
            }

        });



    }
}