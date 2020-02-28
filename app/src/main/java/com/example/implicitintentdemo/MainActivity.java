package com.example.implicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private EditText email;
    private EditText subject;
    private EditText content;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        subject =findViewById(R.id.subject);
        content = findViewById(R.id.e_content);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+email.getText().toString() ));
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,content.getText().toString());

                if (intent.resolveActivity(getPackageManager())!= null)
                {startActivity(intent);}

            }
        });
    }
}
