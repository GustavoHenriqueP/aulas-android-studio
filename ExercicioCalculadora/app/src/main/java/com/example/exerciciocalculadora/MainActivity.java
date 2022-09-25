package com.example.exerciciocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, dot, plus, minus, times, divided;
    private TextView expression, result;
    int aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        dot.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        times.setOnClickListener(this);
        divided.setOnClickListener(this);
    }

    private void initializeComponents()
    {
        num0 = findViewById(R.id.btn0);
        num1 = findViewById(R.id.btn1);
        num2 = findViewById(R.id.btn2);
        num3 = findViewById(R.id.btn3);
        num4 = findViewById(R.id.btn4);
        num5 = findViewById(R.id.btn5);
        num6 = findViewById(R.id.btn6);
        num7 = findViewById(R.id.btn7);
        num8 = findViewById(R.id.btn8);
        num9 = findViewById(R.id.btn9);
        dot = findViewById(R.id.btnDot);
        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        times = findViewById(R.id.btnTimes);
        divided = findViewById(R.id.btnDivided);
        expression = findViewById(R.id.txtExpression);
        result = findViewById(R.id.txtResult);
    }

    public void addExpression(String str, boolean erase_data, View v)
    {
        if (erase_data && (result.getText().toString().isEmpty() || result.getText().toString().equals(" ")))
        {
            result.setText(" ");
            expression.append(str);
        }
        else if (!expression.getText().toString().endsWith("+ ") &&
                 !expression.getText().toString().endsWith("- ") &&
                 !expression.getText().toString().endsWith("x ") &&
                 !expression.getText().toString().endsWith("/ "))
        {
            if (result.getText().equals("") && !erase_data)
            {
                expression.setText(" ");
            }
            else if (!erase_data && aux <= 1)
            {
                expression.append(" "+str+" ");
                result.setText("");
            }
            else if(!erase_data && aux > 1)
            {
                showResult(v);
                expression.setText(result.getText()+" ");
                expression.append(str+" ");
                aux = 1;
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn0:
                addExpression("0", true, v);
                break;
            case R.id.btn1:
                addExpression("1", true, v);
                break;
            case R.id.btn2:
                addExpression("2", true, v);
                break;
            case R.id.btn3:
                addExpression("3", true, v);
                break;
            case R.id.btn4:
                addExpression("4", true, v);
                break;
            case R.id.btn5:
                addExpression("5", true, v);
                break;
            case R.id.btn6:
                addExpression("6", true, v);
                break;
            case R.id.btn7:
                addExpression("7", true, v);
                break;
            case R.id.btn8:
                addExpression("8", true, v);
                break;
            case R.id.btn9:
                addExpression("9", true, v);
                break;
            case R.id.btnDot:
                addExpression(".", true, v);
                break;
            case R.id.btnPlus:
                aux++;
                addExpression("+", false, v);
                break;
            case R.id.btnMinus:
                aux++;
                addExpression("-", false, v);
                break;
            case R.id.btnTimes:
                aux++;
                addExpression("x", false, v);
                break;
            case R.id.btnDivided:
                aux++;
                addExpression("/", false, v);
                break;
        }
    }

    public void eraseFields(View v)
    {
        expression.setText("");
        result.setText("");
        aux = 0;
    }

    public void backspace(View v)
    {
        TextView txt_expression = findViewById(R.id.txtExpression);
        String str = txt_expression.getText().toString();

        if (!str.isEmpty())
        {
            int var0 = str.length()-1;
            String txtExpression = str.substring(0, var0);
            expression.setText(txtExpression);
        }
        result.setText("");
    }

    public void showResult(View v)
    {
        try {
            int n = 0;
            double n1 = 0;
            double n2 = 0;
            double auxResult = 0;
            char digit, operation = 0;
            String text = "";
            String initialExpression = expression.getText().toString();

            if (initialExpression.contains("+") ||
                initialExpression.contains("-") ||
                initialExpression.contains("x") ||
                initialExpression.contains("/"))
            {
                for(int i=0; i<initialExpression.length(); i++)
                {
                    if (initialExpression.charAt(i) != '+' &&
                        initialExpression.charAt(i) != '-' &&
                        initialExpression.charAt(i) != 'x' &&
                        initialExpression.charAt(i) != '/')
                    {
                        digit = initialExpression.charAt(i);
                        if (!String.valueOf(digit).equals(" "))
                        {
                            text = text+digit;
                            n2 = Double.parseDouble(text);
                        }
                    }
                    else if ((initialExpression.charAt(i) == '+' ||
                            initialExpression.charAt(i) == '-' ||
                            initialExpression.charAt(i) == 'x' ||
                            initialExpression.charAt(i) == '/') &&
                            n < 1)
                    {
                        operation = initialExpression.charAt(i);
                        n1 = Double.parseDouble(text);
                        text = "";
                        n++;
                    }
                }

                if (!text.equals(""))
                {
                    switch (operation)
                    {
                        case '+':
                            auxResult = n1 + n2;
                            break;
                        case '-':
                            auxResult = n1 - n2;
                            break;
                        case 'x':
                            auxResult = n1 * n2;
                            break;
                        case '/':
                            auxResult = n1 / n2;
                            break;
                    }

                    aux = 0;
                    result.setText(String.valueOf(auxResult));
                    expression.setText(result.getText());
                }
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Algo deu errado. Por favor, tente novamente", Toast.LENGTH_SHORT).show();
        }
    }
}