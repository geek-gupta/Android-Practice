package com.company.gaurav.mockserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.company.gaurav.mockserver.model.Teacher;
import com.company.gaurav.mockserver.services.RestClient;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private final static String TAG  = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonGetTeacher)
    public void getTeacher(View view) {

        Call<Teacher> teacherCall = RestClient.getClient().getTeacherById("2");
        teacherCall.enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> response) {
                Teacher teacher = response.body();
                Log.d(TAG, teacher.toString());
            }

            @Override
            public void onFailure(Call<Teacher> call, Throwable t) {
                Log.d(TAG, "Failure " + t.getMessage());
            }
        });


    }
}