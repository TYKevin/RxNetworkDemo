package com.example.rxjava.movie.network.service;

import com.example.rxjava.network.entity.HttpResult;
import com.example.rxjava.movie.entity.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface MovieService {

    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
