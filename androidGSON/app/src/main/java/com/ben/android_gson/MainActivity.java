package com.ben.android_gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ben.android_gson.model.QueryAutoCompleteResult;
import com.ben.android_gson.model.Student;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    private final String TAG = "TestGSON";
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

        test_GSON();
        test_JSON_to_QueryAutoCompleteResult();
    }

    void test_GSON() {
        String json = "{\"id\":12,\"name\":\"ben\"}";
        Student student = GSON.fromJson(json, Student.class);

        json_text.setText("json: " + json);
        id_text.setText("id: " + student.getId());
        name_text.setText("name: " + student.getName());
    }

    void test_JSON_to_QueryAutoCompleteResult() {

        String json = readTextFile(R.raw.query_auto_complete);
        Log.d(TAG, "query_auto_complete json: " + json);

        QueryAutoCompleteResult result = GSON.fromJson(json, QueryAutoCompleteResult.class);
        Log.d(TAG, "predictions count: " + result.predictions.length);

        for (int i = 0; i < result.predictions.length; i++) {
            QueryAutoCompleteResult.Prediction prediction = result.predictions[i];
            Log.i(TAG, String.format("%d %s", i, prediction.description));
        }

    }

    public String readTextFile(int raw_data_id) {
        InputStream inputStream = getResources().openRawResource(raw_data_id);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
