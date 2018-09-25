package com.example.leoruan.lab_4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start_button;
    static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = findViewById(R.id.button);
        start_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent i = new Intent(this, ActivityTwo.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data.hasExtra("WORD")){
            String word_to_search = data.getExtras().getString("WORD");
            Uri search_result = Uri.parse("https://www.merriam-webster.com/dictionary/" + word_to_search);
            Intent result_display = new Intent(Intent.ACTION_VIEW, search_result);
            startActivity(result_display);
        }
    }

}
