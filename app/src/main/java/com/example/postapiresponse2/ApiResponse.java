package com.example.postapiresponse2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiResponse {
    @POST("checkMapping")
    Call<ResponseData> getResponse(@Body PassData passData);
}
