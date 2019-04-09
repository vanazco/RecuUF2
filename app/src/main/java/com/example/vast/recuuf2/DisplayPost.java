package com.example.vast.recuuf2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayPost extends AppCompatActivity {

    public TextView display_title;
    public TextView display_context;
    public Button exit;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_post);

        exit = findViewById(R.id.btn_display_exit);
        display_title = findViewById(R.id.display_title);
        display_context = findViewById(R.id.display_context);

        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");

        mRef = FirebaseDatabase.getInstance().getReference().child("Posts").child(id);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String title = post.title;
                String context = post.context;
                display_title.setText(title);
                display_context.setText(context);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DisplayPost.this, "No se ha cargado correctamente!", Toast.LENGTH_SHORT).show();
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
