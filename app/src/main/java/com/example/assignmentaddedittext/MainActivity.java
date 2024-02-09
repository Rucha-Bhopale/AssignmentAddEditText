package com.example.assignmentaddedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private Button btnAddition, btnSubtraction, btnEqual;
    private EditText editText;
    private LinearLayout linearLayout;
    private int edtTextCount = 0;
    private int total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
        btnAddition = findViewById(R.id.btnAddition);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnEqual = findViewById(R.id.btnEqual);
        linearLayout = findViewById(R.id.linearLayout);



        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = new EditText(MainActivity.this);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                ++edtTextCount;
                //editText.setHint(""+(++edtTextCount));
                editText.setLayoutParams(layoutParams);
                linearLayout.addView(editText);

            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTextCount>0){
                    linearLayout.removeViewAt(edtTextCount-1);
                    edtTextCount--;
                }

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                for (int i = 0; i<linearLayout.getChildCount(); i++){
                    View child = linearLayout.getChildAt(i);
                    if (child instanceof EditText){
                        EditText editText1 = (EditText) child;
                        String valueStr= editText1.getText().toString();
                        if (!valueStr.isEmpty()){
                            int enteredValue = Integer.parseInt(valueStr);
                            total += enteredValue;
                        }
                    }

                    }
                txtResult.setText("Total: " + total);
                }



        });
    }
}