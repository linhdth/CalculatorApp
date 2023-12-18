package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAddition;
    Button btnSubtraction;
    Button btnDivision;
    Button btnMultiply;
    Button btnRoot;
    Button btnPercentage;
    Button btnPythagorasValue;
    Button btnCircleArea;
    Button btnVolume;
    Button btnCalculateArea;

    Button btnClear;
    Button btnCalculateRoot;

    TextView tvResult;
    EditText edtValue1;
    EditText edtValue2;

    TextView tvMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tvResult);
        edtValue1=findViewById(R.id.edtValue1);
        edtValue2=findViewById(R.id.edtValue2);
        tvMessage=findViewById(R.id.tvMessage);

     /////////initialize all buttons///////////////////

        btnAddition=findViewById(R.id.btnAddition);
        btnSubtraction=findViewById(R.id.btnSubtraction);
        btnMultiply=findViewById(R.id.btnMultiplication);
        btnDivision=findViewById(R.id.btnDivision);
        btnRoot=findViewById(R.id.btnRoot);
        btnPercentage=findViewById(R.id.btnPercentage);
        btnPythagorasValue=findViewById(R.id.btnPythagorasValue);
        btnCircleArea=findViewById(R.id.btnCircleArea);
        btnVolume=findViewById(R.id.btnCylinderVolume);
        btnCalculateArea=findViewById(R.id.btnCalculateArea);
        btnCalculateRoot=findViewById(R.id.btnCalculateRoot);
        btnClear=findViewById(R.id.btnClear);


        String message = "Please Enter only 1 value in 1st field";
        SpannableString spannableMessage = new SpannableString(message);


        btnClear.setOnClickListener(v -> {
            tvResult.setText("0");
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            edtValue1.setText("");
            edtValue2.setText("");
            tvMessage.setText(R.string.tvMessage);

        });

        //////Calculating Sum//////////
        btnAddition.setOnClickListener(v -> {
            calculate("+");
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);
        });

        //////Calculating Subtract//////////
        btnSubtraction.setOnClickListener(v -> {
            calculate("-");
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);
        });

        //////Calculating Division//////////
        btnDivision.setOnClickListener(v -> {
            calculate("/");
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);

        });

        //////Calculating Multiplication//////////
        btnMultiply.setOnClickListener(v -> {
            calculate("*");
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);

        });
        //////Calculating Percentage//////////
        btnPercentage.setOnClickListener(v -> {
            percentage();
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);

        });


        btnRoot.setOnClickListener(v -> {
            btnCalculateRoot.setVisibility(View.VISIBLE);
            spannableMessage.setSpan(new ForegroundColorSpan(Color.RED), 0, message.length(), 0);
            btnCalculateArea.setVisibility(View.GONE);
            tvMessage.setText(spannableMessage);


        });

        //////Calculating SqrRoot//////////
        btnCalculateRoot.setOnClickListener(v -> {
            root();
            edtValue2.setText("");
            tvMessage.setText(R.string.tvMessage);

        });

        btnCircleArea.setOnClickListener(v -> {
            spannableMessage.setSpan(new ForegroundColorSpan(Color.RED), 0, message.length(), 0);
            btnCalculateArea.setVisibility(View.VISIBLE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(spannableMessage);
        });

        //////Calculating Circle Area//////////
        btnCalculateArea.setOnClickListener(v -> {
            circleArea();
            edtValue2.setText("");
            tvMessage.setText(R.string.tvMessage);
        });

        //////Calculating Cylinder Volume//////////
        btnVolume.setOnClickListener(v -> {
            cylinderVolume();
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);

        });

        //////Calculating Pythagoras Value//////////
        btnPythagorasValue.setOnClickListener(v -> {
            PythagorasValue();
            btnCalculateArea.setVisibility(View.GONE);
            btnCalculateRoot.setVisibility(View.GONE);
            tvMessage.setText(R.string.tvMessage);

        });


    }

  // I took away the old code and will replace it with the new one
  private void percentage() {
      String part=edtValue1.getText().toString();/////getting edittext1 value in string
      String whole=edtValue2.getText().toString();/////getting edittext2 value in string
      if (part.isEmpty() || whole.isEmpty()){
          ///////If any edit text have missing value//////////
          Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
          return;
      }
      try {
          /////converting the edit texts values into double for further calculations/////////////
          double p = Double.parseDouble(part);
          double w = Double.parseDouble(whole);

          double percentage=(p/w)*100;/////Formula to calculate percentage

          tvResult.setText(percentage + "%");//////Setting respective result in tvResult textView

      }
      catch (NumberFormatException e){
          tvResult.setText("Invalid Input");///////Any Exception


      }
  }

    private void root() {
        String v=edtValue1.getText().toString();/////getting edittext1 value in string
        if (v.isEmpty()){
            ///////If edit text have missing value//////////
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            /////converting the edit texts values into double for further calculations/////////////
            double number=Double.parseDouble(v);/////converting the edit texts values into double for further calculation
            double sqRoot=Math.sqrt(number);////Formula to calculate squareRoot

            tvResult.setText(String.valueOf(sqRoot));/////Setting respective result in tvResult textView


        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");

        }
    }

    private void circleArea() {
        String radius=edtValue1.getText().toString();//////getting radius in string
        if (radius.isEmpty()){
            ////if field is empty///
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double r=Double.parseDouble(radius);////converting string into double
            double getArea=Math.PI * Math.pow(r,2);/////formula to calculate area

            tvResult.setText(String.valueOf(getArea));////set result to tvResult

        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");
        }
    }

    private void cylinderVolume() {
        String radius=edtValue1.getText().toString();///////getting radius in string
        String height=edtValue2.getText().toString();///////getting height in string

        if (radius.isEmpty() ||  height.isEmpty()){
            ////any filed is empty
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {

            double r=Double.parseDouble(radius);////converting radius into double
            double h=Double.parseDouble(height);////converting height into double

            double volume=Math.PI * Math.pow(r,2) * h; ////formula to calculate volume

            tvResult.setText(String.valueOf(volume)); ////set result into tvResult

        }catch (NumberFormatException e){

            tvResult.setText("Invalid Input");

        }
    }

    private void PythagorasValue() {
        String value1=edtValue1.getText().toString();//////getting value 1
        String value2=edtValue2.getText().toString();//////getting value 2

        if (value1.isEmpty() ||  value2.isEmpty()){
            //////if any field is missing
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {

            ///converting into double
            double a=Double.parseDouble(value1);///converting into double
            double b=Double.parseDouble(value2);

            double c=Math.sqrt(aa + bb); ////formula to calculate pathagorus Value

            tvResult.setText(String.valueOf(c));/////set Result to tvResult

        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");
        }
    }


    ////// Method to calculate sum,subtract,division and multiplication////////////
    @SuppressLint("SetTextI18n")
    private void calculate(String operators){

        String v1=edtValue1.getText().toString();
        String v2=edtValue2.getText().toString();
        if (v1.isEmpty() || v2.isEmpty()){
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double value1=Double.parseDouble(v1);
            double value2=Double.parseDouble(v2);
            double result=0.0;

            switch (operators){
                case "+":
                    result=value1+value2;
                    break;
                case "-":
                    result=value1-value2;
                    break;
                case "/":
                    if (value2 !=0){
                        result=value1/value2;
                    }
                    else {
                        tvResult.setText("Cannot divided by zero");
                        return;
                    }
                    break;
                case "*":
                    result=value1*value2;
                    break;

            }

            tvResult.setText(String.valueOf(result));
        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");
        }

    }
    ///////////////Calculate Percentage////////////////
    private void percentage(){
        String part=edtValue1.getText().toString();/////getting edittext1 value in string
        String whole=edtValue2.getText().toString();/////getting edittext2 value in string
        if (part.isEmpty() || whole.isEmpty()){
            ///////If any edit text have missing value//////////
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            /////converting the edit texts values into double for further calculations/////////////
            double p = Double.parseDouble(part);
            double w = Double.parseDouble(whole);

            double percentage=(p/w)*100;/////Formula to calculate percentage

            tvResult.setText(percentage + "%");//////Setting respective result in tvResult textView

        }
        catch (NumberFormatException e){
            tvResult.setText("Invalid Input");///////Any Exception


        }
    }
    ///////////////Calculate Square Root////////////////
    private void root(){
        String v=edtValue1.getText().toString();/////getting edittext1 value in string
        if (v.isEmpty()){
            ///////If edit text have missing value//////////
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            /////converting the edit texts values into double for further calculations/////////////
            double number=Double.parseDouble(v);/////converting the edit texts values into double for further calculation
            double sqRoot=Math.sqrt(number);////Formula to calculate squareRoot

            tvResult.setText(String.valueOf(sqRoot));/////Setting respective result in tvResult textView


        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");

        }
    }


    ///////////////Calculate Circle Area////////////////
    private void circleArea(){
        String radius=edtValue1.getText().toString();//////getting radius in string
        if (radius.isEmpty()){
            ////if field is empty///
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double r=Double.parseDouble(radius);////converting string into double
            double getArea=Math.PI * Math.pow(r,2);/////formula to calculate area

            tvResult.setText(String.valueOf(getArea));////set result to tvResult

        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");
        }
    }

    ///////////////Calculate Cylinder Volume////////////////
    private void cylinderVolume(){

        String radius=edtValue1.getText().toString();///////getting radius in string
        String height=edtValue2.getText().toString();///////getting height in string

        if (radius.isEmpty() ||  height.isEmpty()){
            ////any filed is empty
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {

            double r=Double.parseDouble(radius);////converting radius into double
            double h=Double.parseDouble(height);////converting height into double

            double volume=Math.PI * Math.pow(r,2) * h; ////formula to calculate volume

            tvResult.setText(String.valueOf(volume)); ////set result into tvResult

        }catch (NumberFormatException e){

            tvResult.setText("Invalid Input");

        }

    }


    ///////////////Calculate  PythagorasValue////////////////
    private void PythagorasValue(){
        String value1=edtValue1.getText().toString();//////getting value 1
        String value2=edtValue2.getText().toString();//////getting value 2

        if (value1.isEmpty() ||  value2.isEmpty()){
            //////if any field is missing
            Toast.makeText(MainActivity.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            return;
        }
        try {

            ///converting into double
            double a=Double.parseDouble(value1);///converting into double
            double b=Double.parseDouble(value2);

            double c=Math.sqrt(a*a + b*b); ////formula to calculate pathagorus Value

            tvResult.setText(String.valueOf(c));/////set Result to tvResult

        }catch (NumberFormatException e){
            tvResult.setText("Invalid Input");
        }

    }


}