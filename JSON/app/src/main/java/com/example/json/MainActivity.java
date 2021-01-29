package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button im_button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        im_button = findViewById(R.id.im_button);

        im_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendRequest();
            }
        });
        if (AppHelper.requestQueue==null){
            AppHelper.requestQueue  =Volley.newRequestQueue(getApplicationContext());
        }
    }

    public void println(String data){
        textView.append(data+'\n');
    }
    private void sendRequest() {
        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseJson(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("volley error",error.getMessage());
                    }
                }
        );
        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);
    }

    private void responseJson(String response) {
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response,MovieList.class);
        if (movieList!=null){
            String type = movieList.boxOfficeResult.boxofficeType;
            String Range = movieList.boxOfficeResult.showRange;
            ArrayList<Movie> list = movieList.boxOfficeResult.dailyBoxOfficeList;
            Toast.makeText(getApplicationContext(),type+ " / "+Range,Toast.LENGTH_SHORT).show();
            for (int i=0; i<list.size(); i++){
                println(i+1+"번째");
                println(list.get(i).audiChange);
                println(list.get(i).audiAcc);
                println(list.get(i).audiCnt);
                println(list.get(i).audiInten);
                println(list.get(i).movieCd);
                println(list.get(i).movieNm);
                println(list.get(i).rank);


            }
        }

    }
}
