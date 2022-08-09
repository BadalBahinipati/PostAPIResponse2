package com.example.postapiresponse2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import javax.xml.transform.ErrorListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText et_username,et_deviceSlNo;
    private MaterialTextView tv_apiResponse;
    private MaterialButton btn_submit;
    private static String bankName = "others";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.user_Name);
        et_deviceSlNo = findViewById(R.id.device_Serial_No);
        tv_apiResponse = findViewById(R.id.responseView);
        btn_submit = findViewById(R.id.submitButton);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApiResponse();
            }
        });
    }


    private void getApiResponse() {
        String username = et_username.getText().toString(),
                deviceSerialNo = et_deviceSlNo.getText().toString();

        ApiResponse apiResponse = RetrofitClass.getRetrofit().create(ApiResponse.class);

        PassData passdata = new PassData(username, deviceSerialNo, bankName);

        Call<ResponseData> getCall = apiResponse.getResponse(passdata);


        getCall.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful() && response.body() != null)
                    tv_apiResponse.setText("Status : " + response.body().getStatusCode() +
                            "\nDescription : " + response.body().getDescription() +
                            "\nMessage : " + response.body().getResponseMsg());

                else {
                    ErrorResponseData error = ErrorHandle.errorParse(response);
                    tv_apiResponse.setText("Status : " + error.getErrorStatusCode() +
                            "\nError Message : " + error.getErrorMsg());
                }
            }
            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                tv_apiResponse.setText(t.getMessage());
            }
        });
    }
}