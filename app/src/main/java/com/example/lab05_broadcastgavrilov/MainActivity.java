package com.example.lab05_broadcastgavrilov;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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

    public void openSecondActivity_Click(View v)
    {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("TextMain", ed.getText().toString());
        i.putExtra("Flag1", ch1.isChecked());
        i.putExtra("Flag2", ch2.isChecked());

        startActivityForResult(i, 123);
    }

    public void closeActivity_Click(View v)
    {
        AlertDialog.Builder db = new AlertDialog.Builder(this);
        db.setTitle("Exit");
        db.setMessage("Are you sure you want to get out?");
        db.setCancelable(true);
        db.setIcon(R.drawable.icon);
        db.setPositiveButton("YES", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                //Выход из приложения
                finish();
            }
        });

        db.setNegativeButton("NO", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                //Возврат в приложение приложения
                return;
            }
        });
    }

    public void onDialog_Click(View v)
    {
        LayoutInflater inf = getLayoutInflater();
        View vi = inf.inflate(R.layout.activity_second2, null, false);

        Dialog db = new Dialog(this);
        db.setTitle(R.string.Title_Dialog);
        db.setContentView(vi);
        db.setCancelable(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 123)
        {
            if(resultCode == RESULT_OK && data != null)
            {
                String s = data.getStringExtra("TextSecond");
                boolean flag1 = data.getBooleanExtra("Flag1",false);
                boolean flag2 = data.getBooleanExtra("Flag2",false);

                ed.setText(s);
                ch1.setChecked(flag1);
                ch2.setChecked(flag2);

                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}