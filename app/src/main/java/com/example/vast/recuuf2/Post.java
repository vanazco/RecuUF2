package com.example.vast.recuuf2;

import android.widget.ImageView;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Post {
    public String title;
    public String context;
    public String id;
    public String img;

    public Post(){}

    public Post(String id,String title_string, String context_string,String img) {
        this.title = title_string;
        this.context = context_string;
        this.id = id;
        this.img = img;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("title", title);
        result.put("context", context);
        result.put("img", img);
        return result;
    }
}
