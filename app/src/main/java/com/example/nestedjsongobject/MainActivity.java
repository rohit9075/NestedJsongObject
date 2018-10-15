package com.example.nestedjsongobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        apiService.getTopRatedMovies().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()) {
                      Toast.makeText(MainActivity.this, "OUTPUT : "+response.body().getContacts(), Toast.LENGTH_LONG).show();
                                      Log.d("MainActivity", "posts loaded from API");
                      List<Contact> contactList =  response.body().getContacts();
                      for(int i = 0; i<contactList.size(); i++)
                    {
                        int statusCode  = response.code();
                        String id = contactList.get(i).getId();
                        String name = contactList.get(i).getName();
                        String email = contactList.get(i).getEmail();
                        String address = contactList.get(i).getAddress();
                        String gender = contactList.get(i).getGender();
                        Phone phone = contactList.get(i).getPhone();
                        String mobile = phone.getMobile();
                        String home = phone.getHome();
                        String office = phone.getOffice();
                        Toast.makeText(MainActivity.this, "OUTPUT : "+statusCode +", "+ id +", "+ name +", "+ email +", "+ address +", "+ gender +", "+ mobile +", "+ home +", "+ office, Toast.LENGTH_LONG).show();
                    }
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code                }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });


    }
}
