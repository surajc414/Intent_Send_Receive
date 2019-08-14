package com.example.intent_send_receive;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button btn;
    EditText t1,t2,sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.num1);
        t2 = findViewById(R.id.num2);
        sum = findViewById(R.id.sum);

        btn = findViewById(R.id.find);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = String.valueOf(t1.getText());
                String n2 = String.valueOf(t2.getText());

                Intent intent = new Intent(getApplicationContext(),FindResult.class);
                intent.putExtra("V1",n1);
                intent.putExtra("V2",n2);
                startActivityForResult(intent,100);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == Activity.RESULT_OK)
        sum.setText("Sum of "+t1.getText()+" and "+t2.getText() +" is "+data.getStringExtra("res"));
    }
}


