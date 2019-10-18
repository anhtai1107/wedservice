package com.example.webservicedemo.webservice;

import com.example.webservicedemo.scheme.Person;
import com.example.webservicedemo.scheme.Request;
import com.example.webservicedemo.scheme.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonService {

//    @GET("v2/5da470983500005d004a7719")
//    Call<List<Person>> getPerson();

    @GET("/api/users")
    Call<Request> getPersonList(@Query("page") int page);
}
