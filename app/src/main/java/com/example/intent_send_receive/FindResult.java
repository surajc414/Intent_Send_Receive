package com.example.intent_send_receive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindResult extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_result);

        btn = findViewById(R.id.find);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();

                Integer n1 = Integer.parseInt(intent.getStringExtra("V1"));
                Integer n2 = Integer.parseInt(intent.getStringExtra("V2"));
                Integer res = n1+n2;

                Intent i = new Intent();
                i.putExtra("res",String.valueOf(res));
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
    }
}
