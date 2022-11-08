package com.example.gr_lesson_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtTheme;
    private EditText edtMessage;
    private Button btn_send;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.eTextGmail);
        edtTheme = findViewById(R.id.eTextTheme);
        edtMessage = findViewById(R.id.eTextMessage);
        btn_send = findViewById(R.id.button);

        btn_send.setOnClickListener(view -> {
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{edtEmail.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, edtTheme.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, edtMessage.getText().toString());
            startActivity(intent);
        });
    }
}