package com.example.vast.recuuf2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class NewPostActivity  extends AppCompatActivity {
    public Button btn_public,btn_img;
    public EditText new_title,new_context;
    public String title_string, context_string;
    public DatabaseReference mRef;
    public String id;
    public ImageView preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_post_item);

        mRef = FirebaseDatabase.getInstance().getReference();

        btn_public = findViewById(R.id.btn_publicar);
        new_title = findViewById(R.id.new_titulo);
        new_context = findViewById(R.id.new_context);
        btn_img = findViewById(R.id.btn_image);

        btn_public.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_string = new_title.getText().toString();
                context_string = new_context.getText().toString();
                id = UUID.randomUUID().toString();
                Post post = new Post(id,title_string,context_string);
                mRef.child("Posts").child(id).setValue(post);
                finish();
            }
        });
    }
}
