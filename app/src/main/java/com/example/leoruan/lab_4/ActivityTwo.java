package com.example.leoruan.lab_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTwo extends Activity implements View.OnClickListener{

    private EditText word_input;
    private Button start_searching;
    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        word_input = findViewById(R.id.editText);
        start_searching = findViewById(R.id.button2);
        start_searching.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        word = word_input.getText().toString();

        Toast.makeText(this, word, Toast.LENGTH_LONG).show();

        Intent i = new Intent();

        i.putExtra("WORD", word);
        setResult(RESULT_OK, i);
        finish();
    }
}
