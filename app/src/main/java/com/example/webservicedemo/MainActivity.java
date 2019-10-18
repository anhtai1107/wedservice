package com.example.webservicedemo;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import com.example.webservicedemo.scheme.Person;
import com.example.webservicedemo.scheme.Request;
import com.example.webservicedemo.scheme.User;
import com.example.webservicedemo.webservice.PersonService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

//        EmployeeService employeeService = retrofit.create(EmployeeService.class);
//        employeeService.getEmployees().enqueue(new Callback<List<Employee>>() {
//            @Override
//            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
//                for (Employee employee : response.body()) {
//                    Log.d("DEBUG_WEBSERVICE", employee.getEmployee_name());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Employee>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
////
//        PersonService personService = retrofit.create(PersonService.class);
//        personService.getPerson().enqueue(new Callback<List<Person>>() {
//            @Override
//            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
//                for (Person person : response.body()){
//                    Log.d("DEBUG",person.getName());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Person>> call, Throwable t) {
//
//            }
//        });
        PersonService personService = retrofit.create(PersonService.class);
        personService.getPersonList(2).enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {
                for (User user : response.body().getData()) {

                    Log.d("DEBUG", String.valueOf(user.getEmail()));
                }


            }

            @Override
            public void onFailure(Call<Request> call, Throwable t) {

            }
        });
    }
}
