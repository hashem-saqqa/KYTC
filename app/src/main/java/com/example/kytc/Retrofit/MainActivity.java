package com.example.kytc.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kytc.R;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView postIdTv, userIdTv, titleTv, bodyTv, lastTv;
    ImageView photoIv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        postIdTv = findViewById(R.id.postId);
//        userIdTv = findViewById(R.id.userId);
//        titleTv = findViewById(R.id.titleTv);
//        bodyTv = findViewById(R.id.bodyTv);
//        lastTv = findViewById(R.id.lastTv);

        photoIv = findViewById(R.id.photoIv);

//        lastTv.setMovementMethod(new ScrollingMovementMethod());


        String url = "https://jsonplaceholder.typicode.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "my post");
        map.put("body", "this is my first post");
        map.put("userId", 1);

        Call<Post> call = apiInterface.setPost(map);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                Log.d("setPostTest", "onResponse: " + response.body().getId());
                Log.d("setPostTest", "onResponse: " + response.body().getUserId());
                Log.d("setPostTest", "onResponse: " + response.body().getTitle());
                Log.d("setPostTest", "onResponse: " + response.body().getBody());

                Log.d("setPostTest", "onResponse: " + response.code());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


//        Call<User> call = apiInterface.getUserById(1);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                Log.d("userData", "user id: "+user.getId());
//                Log.d("userData", "user name: "+user.getUsername());
//                Log.d("userData", "user Email: "+user.getEmail());
//                Log.d("userData", "user Phone: "+user.getPhone());
//                Log.d("userData", "user City: "+user.getAddress().getCity());
//                Log.d("userData", "user Street: "+user.getAddress().getStreet());
//                Log.d("userData", "user Latitude: "+user.getAddress().getGeo().getLat());
//                Log.d("userData", "user Longitude: "+user.getAddress().getGeo().getLng());
//                Log.d("userData", "user company Name: "+user.getCompany().getName());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });

//        Call<Photo> call = apiInterface.getPhotoById(2);
//        call.enqueue(new Callback<Photo>() {
//            @Override
//            public void onResponse(Call<Photo> call, Response<Photo> response) {
//                postIdTv.setText(response.body().getTitle());
//                Picasso.get().load(response.body().getThumbnailUrl()).into(photoIv);
//            }
//
//            @Override
//            public void onFailure(Call<Photo> call, Throwable t) {
//
//            }
//        });

//        Call<Post> call = apiInterface.getPostById(2);
//
//        Call<List<Post>> call2 = apiInterface.getPostByUserId(1);
//
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                Log.d("checkk", "onResponse: im here");
//                Post p = response.body();
////                String title = p.getTitle();
//                postIdTv.setText(String.valueOf(response.body().getId()));
//                userIdTv.setText(String.valueOf(response.body().getUserId()));
//                titleTv.setText(response.body().getTitle());
//                bodyTv.setText(response.body().getBody());
////                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
////                Log.d("theTitle", "onResponse: " + title);
//                Log.d("internetTest", "onResponse: the first call");
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//            }
//        });
//        Log.d("internetTest", "onResponse: before the response");
//
//        call2.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                ArrayList<Post> posts = (ArrayList<Post>) response.body();
//                for (Post u :posts) {
//                    String text = "";
//                    text += "post Id: "+u.getId()+"\n";
//                    text += "user Id: "+u.getUserId()+"\n";
//                    text += "title: "+u.getTitle()+"\n";
//                    text += "body: "+u.getBody()+"\n\n";
//                    lastTv.append(text);
//                    Log.d("internetTest", "onResponse: internet is working");
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//
//            }
//        });


    }
}