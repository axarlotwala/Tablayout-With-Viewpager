package com.test.aksha.tabfragment.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.aksha.tabfragment.adapter.RecyclerList_adapter;
import com.test.aksha.tabfragment.Model.Category_model;
import com.test.aksha.tabfragment.R;
import com.test.aksha.tabfragment.Retrofit.ApiClient;
import com.test.aksha.tabfragment.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {
    RecyclerView site_name;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the list_recyclerlayout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recycler, container, false);
        site_name = view.findViewById(R.id.site_name);

        Setup();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        site_name.setLayoutManager(manager);
        return view;
    }

    private void Setup() {

        ApiClient client = RetrofitClient.getClient().create(ApiClient.class);

        Call<Category_model> call = client.getCategoryName("123");

        call.enqueue(new Callback<Category_model>() {
            @Override
            public void onResponse(Call<Category_model> call, Response<Category_model> response) {

                RecyclerList_adapter adapter = new RecyclerList_adapter(response.body().category,getActivity());
                site_name.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Category_model> call, Throwable t) {

            }
        });

    }


}
