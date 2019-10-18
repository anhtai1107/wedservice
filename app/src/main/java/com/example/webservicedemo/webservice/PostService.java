package com.example.webservicedemo.webservice;

import com.example.webservicedemo.scheme.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("posts")
    Call<List<Post>> getPosts();
}
