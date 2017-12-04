package com.rpm.demo.designpattern.observer;

/**
 * Created by renpiming on 2017/12/4.
 */
public class Test {
    public static void main(String[] args) {
        //创建主题
         WeatherService service = WeatherService.instance;
        //WeatherService service =new WeatherService();
        //添加观察者
        service.addClient(new ClientAndroidServer());
        service.addClient(new ClientIphoneServer());
        //更新主题
        service.updateWeather(new WeatherInfo(System.currentTimeMillis(), "多云"));
        service.updateWeather(new WeatherInfo(System.currentTimeMillis()+1000*60*60*24, "多云转晴"));
        service.updateWeather(new WeatherInfo(System.currentTimeMillis()+1000*60*60*24*2, "晴"));
    }
}
