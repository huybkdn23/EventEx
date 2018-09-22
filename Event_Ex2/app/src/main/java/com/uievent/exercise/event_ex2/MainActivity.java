package com.uievent.exercise.event_ex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText soa,sob;
    TextView sum;
    Button btn_sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText soa  = (EditText)findViewById(R.id.soa);
        final EditText sob  = (EditText)findViewById(R.id.sob);
        final TextView sum    = (TextView)findViewById(R.id.sum);
        Button btn_sum = (Button)findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum.setText(Integer.parseInt(soa.getText()+"") + Integer.parseInt(sob.getText()+"")+"");
            }
        });
    }
    public void tinh_tong(View view) {
        EditText soa  = (EditText)findViewById(R.id.soa);
        EditText sob  = (EditText)findViewById(R.id.sob);
        TextView sum    = (TextView)findViewById(R.id.sum);
        Button btn_sum = (Button)findViewById(R.id.btn_sum);
        sum.setText(Integer.parseInt(soa.getText()+"") + Integer.parseInt(sob.getText()+"")+"");
    }

}
