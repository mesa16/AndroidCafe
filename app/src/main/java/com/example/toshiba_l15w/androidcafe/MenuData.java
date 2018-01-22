package com.example.toshiba_l15w.androidcafe;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by TOSHIBA-L15W on 1/21/2018.
 */

public class MenuData {
    private static String jsondata = "";

    public void setJsonData(String json){
        jsondata = json;
        Log.i("DATA",jsondata);

    }
    public static ArrayList<Menu> getListMenu() {

        String response = null;
        Menu menu = null;
        FetchMenuData conn = (FetchMenuData) new FetchMenuData();
        conn.execute();
        try {
            jsondata = conn.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        ArrayList<Menu> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsondata);
            Gson gson = new Gson();
            int i = 0;


            while (i < jsonArray.length()) {
                list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Menu.class));
                i++;
            }
        } catch (JSONException e) {

            e.printStackTrace();

        }
        return list;
    }
}