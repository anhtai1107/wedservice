package com.example.webservicedemo.webservice;

import com.example.webservicedemo.scheme.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeService {

    @GET("api/v1/employees")
    Call<List<Employee>> getEmployees();


}
