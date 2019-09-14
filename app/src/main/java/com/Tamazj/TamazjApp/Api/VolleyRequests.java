package com.Tamazj.TamazjApp.Api;

import android.app.Activity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.Map;
import java.util.Observable;


/**
 * Created by hp on 12/09/2017.
 */

public class VolleyRequests<T> extends Observable {
  Activity activity;
  public interface IReceiveData<T> {
    void onDataReceived(T posts);

  }

  IReceiveData iReceiveData;


  public VolleyRequests setIReceiveData(IReceiveData iReceiveData) {
    this.iReceiveData = iReceiveData;
    return this;
  }


  public VolleyRequests setiReceiveData(IReceiveData iReceiveData) {
    this.iReceiveData = iReceiveData;
    return this;
  }









}