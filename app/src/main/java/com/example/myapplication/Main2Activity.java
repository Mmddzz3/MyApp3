package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    TextView mTextViewResult;
    Button back, quote;
    private static final String TAG = "Main2Activity";
    private  OkHttpClient okHttpClient;
    private Request request;
    private String url = "https://favqs.com/api/qotd";
    private TextView mResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button back1 = (Button)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView  mTextViewResult1 = (TextView)findViewById(R.id.text_view_reult);
        Button quote1 = (Button)findViewById(R.id.quote);
        quote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            okHttpClient = new OkHttpClient();
            request = new Request.Builder().url(url).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.i(TAG, e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String myResponse = response.body().string();
                    //Log.i(TAG,response.body().string());
                    mTextViewResult1.setText(myResponse);
                }
            });

            }
        });





    }



}
