package com.example.lab05_broadcastgavrilov;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    CheckBox ch1, ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.editText_Main);
        ch1 = findViewById(R.id.checkBox_Flag1);
        ch2 = findViewById(R.id.checkBox_Flag2);
    }

    public void OpenSecondActivity_Click(View v)
    {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("TextMain", ed.getText().toString());
        i.putExtra("Flag1", ch1.isChecked());
        i.putExtra("Flag2", ch2.isChecked());

        startActivityForResult(i, 123);
    }

    public void CloseActivity_Click(View v)
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 123)
        {
            if(data != null)
            {

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}