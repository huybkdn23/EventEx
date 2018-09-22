package com.uievent.exercise.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_input;
    private TextView tv;
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_cong,btn_tru,btn_nhan,btn_chia,btn_c,btn_ac,btn_bang,btn_cham;
    private final String TAG    = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Langnghe();
    }
    private void Anhxa()
    {
        edt_input   = (EditText)findViewById(R.id.edt_input);
        tv          = (TextView)findViewById(R.id.tv);
        btn_0       = (Button)findViewById(R.id.btn_0);
        btn_1       = (Button)findViewById(R.id.btn_1);
        btn_2       = (Button)findViewById(R.id.btn_2);
        btn_3       = (Button)findViewById(R.id.btn_3);
        btn_4       = (Button)findViewById(R.id.btn_4);
        btn_5       = (Button)findViewById(R.id.btn_5);
        btn_6       = (Button)findViewById(R.id.btn_6);
        btn_7       = (Button)findViewById(R.id.btn_7);
        btn_8       = (Button)findViewById(R.id.btn_8);
        btn_9       = (Button)findViewById(R.id.btn_9);
        btn_cong    = (Button)findViewById(R.id.btn_cong);
        btn_tru     = (Button)findViewById(R.id.btn_tru);
        btn_nhan    = (Button)findViewById(R.id.btn_nhan);
        btn_chia    = (Button)findViewById(R.id.btn_chia);
        btn_c       = (Button)findViewById(R.id.btn_c);
        btn_ac      = (Button)findViewById(R.id.btn_ac);
        btn_bang    = (Button)findViewById(R.id.btn_bang);
        btn_cham    = (Button)findViewById(R.id.btn_cham);
    }

    private void Langnghe()
    {
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_cong.setOnClickListener(this);
        btn_tru.setOnClickListener(this);
        btn_nhan.setOnClickListener(this);
        btn_chia.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_bang.setOnClickListener(this);
        btn_cham.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_0:
                edt_input.append("0");
                break;
            case R.id.btn_1:
                edt_input.append("1");
                break;
            case R.id.btn_2:
                edt_input.append("2");
                break;
            case R.id.btn_3:
                edt_input.append("3");
                break;
            case R.id.btn_4:
                edt_input.append("4");
                break;
            case R.id.btn_5:
                edt_input.append("5");
                break;
            case R.id.btn_6:
                edt_input.append("6");
                break;
            case R.id.btn_7:
                edt_input.append("7");
                break;
            case R.id.btn_8:
                edt_input.append("8");
                break;
            case R.id.btn_9:
                edt_input.append("9");
                break;
            case R.id.btn_cong:
                edt_input.append("+");
                break;
            case R.id.btn_tru:
                edt_input.append("-");
                break;
            case R.id.btn_nhan:
                edt_input.append("x");
                break;
            case R.id.btn_chia:
                edt_input.append("/");
                break;
            case R.id.btn_c:
                BaseInputConnection textFieldInputConnection    = new BaseInputConnection(edt_input,true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_ac:
                edt_input.setText("");
                tv.setText("0");
                break;
            case R.id.btn_bang:
                DecimalFormat   decimalFormat   = new DecimalFormat("###.####");
                double result   = 0;
                saveOperation(edt_input.getText().toString());
                saveNumber(edt_input.getText().toString());
                //Thuật toán tính toán biểu thức.
                if (operation.size()>=number.size() || operation.size()<1 )
                {
                    tv.setText("Lỗi định dạng");
                }

                for(int i=0; i < (number.size() - 1); i++)
                {
                    switch (operation.get(i))
                    {
                        case "+":
                            if(i==0) result = number.get(i) + number.get(i+1);
                            else result += number.get(i+1);
                            break;
                        case "-":
                            if(i==0) result = number.get(i) - number.get(i+1);
                            else result += number.get(i+1);
                            break;
                        case "x":
                            if(i==0) result = number.get(i) * number.get(i+1);
                            else result += number.get(i+1);
                            break;
                        case "/":
                            if(i==0) result = number.get(i) / number.get(i+1);
                            else result += number.get(i+1);
                            break;
                        default:
                            break;
                    }
                    tv.setText(decimalFormat.format(result) + "");
                }
                break;
            case R.id.btn_cham:
                edt_input.append(".");
                break;
            default:
                break;

        }
    }
    //Mảng chứa các số
    public ArrayList<Double> number;
    //Mảng chứa phép tính
    public ArrayList<String> operation;

    //Lấy tất cả phép tính lưu vào mảng operation.
    public void saveOperation(String input)
    {
        operation   = new ArrayList<>();
        number      = new ArrayList<>();
        char[] cArray   = input.toCharArray();
        for(int i=0; i<cArray.length; i++)
        {
            switch (cArray[i])
            {
                case '+':
                    operation.add(cArray[i]+"");
                    break;
                case '-':
                    operation.add(cArray[i]+"");
                    break;
                case 'x':
                    operation.add(cArray[i]+"");
                    break;
                case '/':
                    operation.add(cArray[i]+"");
                    break;
                default:
                        break;
            }
        }
    }

    //Lưu tất cả số vào mảng number.
    public void saveNumber(String input)
    {
        number  = new ArrayList<>();
        Pattern regex   = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(input);
        while (matcher.find())
        {
            number.add(Double.valueOf(matcher.group(1)));
        }
    }

}
