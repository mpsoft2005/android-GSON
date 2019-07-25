package com.ben.android_gson;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends Activity {

    private Gson GSON = new Gson();

    private TextView json_text;
    private TextView id_text;
    private TextView name_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        json_text = (TextView)findViewById(R.id.json_text);
        id_text = (TextView)findViewById(R.id.id_text);
        name_text = (TextView)findViewById(R.id.name_text);

        testGSON();
    }

    void testGSON() {
        String json = "{\"id\":12,\"name\":\"ben\"}";
        Student student = GSON.fromJson(json, Student.class);

        json_text.setText("json: " + json);
        id_text.setText("id: " + student.getId());
        name_text.setText("name: " + student.getName());
    }
}
