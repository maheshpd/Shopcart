package com.example.maheshprasad.shopcart.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.maheshprasad.shopcart.Activity.WomenWear;
import com.example.maheshprasad.shopcart.R;
import com.example.maheshprasad.shopcart.VolleySingleton;
import com.example.maheshprasad.shopcart.common.Common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    private ViewPager mSliderViewPager;
    private LinearLayout mDotsLayout;

    RelativeLayout womenImage,menImage,kidImage;
    Context context;

    String banner_url = "http://192.168.64.2/Shopcart/getBanner.php";

    JsonArrayRequest banner_request;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();

        getBanner();
        
        womenImage=view.findViewById(R.id.women);
        menImage=view.findViewById(R.id.men);
        kidImage=view.findViewById(R.id.kid);


        womenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,WomenWear.class));
            }
        });

        return view;


    }

    private void getBanner() {
        banner_request = new JsonArrayRequest(banner_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i <response.length() ; i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String imageLink = jsonObject.getString("inageLink");
                        String name = jsonObject.getString("name");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance(context).addToRequestque(banner_request);
    }

}
