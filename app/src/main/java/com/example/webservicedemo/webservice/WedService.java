package com.example.webservicedemo.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WedService {

    private static WedService instance;

    private Retrofit retrofit;

    private PersonService personService;

    private EmployeeService employeeService;

    private WedService(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static WedService getInstance(){
        if(instance == null){
            instance = new WedService();
        }
        return instance;
    }

    public PersonService getPersonService(){
        if (personService==null){
            personService = retrofit.create(PersonService.class);
        }
        return personService;
    }

    public EmployeeService getEmployeeService(){
        if (employeeService==null){
            employeeService = retrofit.create(EmployeeService.class);
        }
        return employeeService;
    }
}
