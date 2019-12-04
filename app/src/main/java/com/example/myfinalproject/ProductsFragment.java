package com.example.myfinalproject;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;;import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductsFragment extends Fragment {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private String URL = "https://api.myjson.com/bins/1210r8";
    int id;
    String title;
    String description;
    double rating;
    double price;
    int image;

    private RequestQueue mRequestQueue;

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mRequestQueue = Volley.newRequestQueue(getContext());
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_products, container, false);

        final RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        //initializing the productlist
        productList = new ArrayList<>();


        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {




                            for(int i = 0; i<response.length();i++) {
                                JSONObject productobj;

//                                Log.d("Here we go...." , "weeeee");

                                productobj = response.getJSONObject(i);

                                id = productobj.getInt("width");
                                title = productobj.getString("title");
                                price = productobj.getDouble("price");
                                rating = productobj.getDouble("rating");
                                description = productobj.getString("description");
                                image = R.drawable.ic_store_black_24dp;



//                                Log.d("Product List: ", productList.toString());

                                productList.add(new Product(id, title, description, rating, price, R.drawable.ic_add_shopping_cart_black_24dp));
                            }
                            //creating recyclerview adapter




                            CustomAdapter adapter = new CustomAdapter(getContext(), productList);

                            //setting adapter to recyclerview
                            rv.setAdapter(adapter);
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
        });

        mRequestQueue.add(req);











        //adding some items to our list
//        productList.add(
//                new Product(
//                        400,
//                        "Brown Eggs",
//                        "Raw Organic",
//                        4.3,
//                        60000,
//                        R.drawable.cio_ic_paypal_monogram));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        4.3,
//                        60000,
//                        R.drawable.ic_account_box_white_24dp));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.ic_account_box_white_24dp));











        return rootView;
    }

}