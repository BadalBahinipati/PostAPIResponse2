package com.example.postapiresponse2;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorHandle {
    public static ErrorResponseData errorParse(Response<?> response){
        Converter<ResponseBody,ErrorResponseData> converter = RetrofitClass.getRetrofit().responseBodyConverter(ErrorResponseData.class,new Annotation[0]);
        ErrorResponseData errorResponseData = new ErrorResponseData();

        try{
            assert response.errorBody() != null;
            errorResponseData = converter.convert(response.errorBody());
        }catch (Exception e){
            new ErrorResponseData();
        }
        return errorResponseData;
    }
}
