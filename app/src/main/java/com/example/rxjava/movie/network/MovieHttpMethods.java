package com.example.rxjava.movie.network;

import com.example.rxjava.network.http.HttpMethods;
import com.example.rxjava.movie.entity.Subject;
import com.example.rxjava.movie.network.service.MovieService;

import java.util.List;

import rx.Observable;
import rx.Subscriber;


public class MovieHttpMethods extends HttpMethods {
    private MovieService movieService;

    private MovieHttpMethods() {
        movieService = retrofit.create(MovieService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final MovieHttpMethods INSTANCE = new MovieHttpMethods();
    }

    //获取单例
    public static MovieHttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     * @param subscriber  由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovie(Subscriber<List<Subject>> subscriber, int start, int count){

        Observable observable = movieService.getTopMovie(start, count)
                .map(new HttpResultFunc<List<Subject>>());

        toSubscribe(observable, subscriber);
    }
}
