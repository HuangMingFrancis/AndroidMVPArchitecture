package com.sherlockshi.androidmvparchitecture.model.storage.json;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 利用fastjson对json数据的一些解析
 * Created by Francis on 2017-2-7.
 */
public class JsonUtil {
    /**
     * 对象转化为json fastjson 使用方式
     *
     * @return
     */
    public static String objectToJsonForFastJson(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return JSON.toJSONString(object);
        } catch (JSONException e) {
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * json转化为对象  fastjson 使用方式
     *
     * @return
     */
    public static <T> T jsonToObjectForFastJson(String jsonData, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        try {
            return JSON.parseObject(jsonData, clazz);
        } catch (Exception e) {
        }
        return null;
    }
    /**
     *json转化为List  fastjson 使用方式
     */
    public static <T> List<T> jsonToListForFastJson(String jsonData , Class<T> cls) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        List<T> arrayList = new ArrayList<>();
        try {
            arrayList =  JSON.parseArray(jsonData,cls);
        } catch (Exception e) {
        }
        return arrayList;

    }
    /**
     *json转化为Map  fastjson 使用方式
     */
    public static Map jsonToMapForFastJson(String jsonData){
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        Map map = null;
        try{
            map =  JSON.parseObject(jsonData,new TypeReference<Map>(){});
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
