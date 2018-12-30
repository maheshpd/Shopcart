package com.example.maheshprasad.shopcart;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context context;


    private VolleySingleton(Context context) {
        context = context;
     mRequestQueue = getmRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getmRequestQueue() {

        if (mRequestQueue==null) {
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return mRequestQueue;
    }

    public<T> void addToRequestque(Request<T> request)
    {
        mRequestQueue.add(request);
    }

}
