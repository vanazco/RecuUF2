package com.example.vast.recuuf2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPostActivity  extends AppCompatActivity {
    public EditText new_title;
    public EditText new_context;
    public Button btn_public;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_post_item);

        new_title = findViewById(R.id.new_titulo);
        new_context = findViewById(R.id.new_context);
        btn_public = findViewById(R.id.btn_publicar);

        btn_public.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPostActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
