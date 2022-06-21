package com.example.kytc.Retrofit;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts")
    public Call<List<Post>> getAllPosts();

    @GET("posts/{id}")
    public Call<Post> getPostById(@Path("id") int id);

    @GET("posts")
    public Call<List<Post>> getPostByUserId(@Query("userId") int userId);

    @GET("photos/{tt}")
    public Call<Photo> getPhotoById(@Path("tt") int id);

    @GET("users/{id}")
    public Call<User> getUserById(@Path("id") int id);

    @POST("posts")
    public Call<Post> setPost(@Body HashMap<Object, Object> map);

}
