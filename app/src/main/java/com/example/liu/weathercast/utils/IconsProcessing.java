package com.example.liu.weathercast.utils;

import android.content.Context;
import android.util.Log;

import com.example.liu.weathercast.R;

import java.util.Map;

//判断天气，并返回图标
public class IconsProcessing {
    private Context context;
    int [] icons={0,0};
    private  Map<String,Integer> map;
    public IconsProcessing(Context context){
        this.context=context;
        SaveObject saveObject=new SaveObject();
        map= (Map<String,Integer>)saveObject.getObejectData(context,"icons");
    }
    public int[] judgeWeather(String weather){

        int i=0;
        Log.d("判断","运行"+weather.contains("风"));
        if(weather.contains("晴")){
            if(icons[0]!=0){
                icons[1]=map.get("晴");
            }else{
                icons[0]=map.get("晴");
            }

            weather.replace("晴","");
            this.judgeWeather(weather);
        }else if(weather.contains("雨")){
           i= map.get("雨");
           if(icons[0]!=0){
               icons[1]=map.get("雨");
           }else{
               icons[0]=map.get("雨");
           }
           weather.replace("雨","");
           this.judgeWeather(weather);
        }else if(weather.contains("雾")){
            if(icons[0]!=0){
                icons[1]= map.get("雾");
            }else{
                icons[0]= map.get("雾");
            }
            weather.replace("雾","");
            this.judgeWeather(weather);
        }else if(weather.contains("风")){

           i= map.get("风");
           if(icons[0]!=0){
               icons[1]=map.get("风");
           }else{
               icons[0]=map.get("风");
           }
           weather.replace("风","");
           this.judgeWeather(weather);

        }else if(weather.contains("雷")){

          if(icons[0]!=0){
              icons[1]=map.get("雷");
          }else{
              icons[0]=map.get("雷");
          }
          weather.replace("雷","");
          this.judgeWeather(weather);
        }else if(weather.contains("云")){
            i=map.get("云");
            if(icons[0]!=0){
                icons[1]=map.get("云");
            }else{
                icons[0]=map.get("云");
            }
            weather.replace("云","");
            this.judgeWeather(weather);
        }else if(weather.contains("雪")){
            if(icons[0]!=0){
                icons[0]=map.get("雪");
            }else{
                icons[1]=map.get("雪");
            }
          this.judgeWeather(weather);
        }else {
            if(icons[0]!=0){
                icons[1]= R.mipmap.unknown;
            }else{
                icons[0]=R.mipmap.unknown;
            }

        }

        return icons;
    }
}

