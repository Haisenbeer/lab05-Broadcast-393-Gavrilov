package com.example.lab05_broadcastgavrilov;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity {

    EditText ed;
    Switch sw1;
    Switch sw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        ed = findViewById(R.id.editText_Second);
        sw1 = findViewById(R.id.switch_Flag1);
        sw2 = findViewById(R.id.switch_Flag2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 123)
        {
            if(data != null)
            {
                String s = data.getStringExtra("TextMain");
                ed.setText(s);

                boolean flag1 = data.getBooleanExtra("Flag1",false);
                boolean flag2 = data.getBooleanExtra("Flag2",false);

                sw1.setChecked(flag1);
                sw2.setChecked(flag2);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}