package com.example.vast.recuuf2;

import android.widget.ImageView;

public class Post {
    public String title;
    public String context;
    public String id;

    public Post(){}

    public Post(String id,String title_string, String context_string) {
        this.title = title_string;
        this.context = context_string;
        this.id = id;
    }
}
