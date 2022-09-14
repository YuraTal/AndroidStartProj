package ru.synergy.androidstartproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ComeBeckActivity extends AppCompatActivity {

    EditText textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_beck);

        textView  = (EditText) findViewById(R.id.backtv);
        button = (Button) findViewById(R.id.sendback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("tv",textView.getText().toString());
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}