package com.test.aksha.tabfragment.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.test.aksha.tabfragment.adapter.GraidviewAdapter;
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
public class GraidlayoutFragment extends Fragment {

    GridView graid;


    public GraidlayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the list_recyclerlayout for this fragment
        View view = inflater.inflate(R.layout.fragment_graidlayout, container, false);
        graid = view.findViewById(R.id.graid);
        setGraid();
        return view;
    }

    private void setGraid() {

        ApiClient client = RetrofitClient.getClient().create(ApiClient.class);

        Call<Category_model> call = client.getCategoryName("123");

        call.enqueue(new Callback<Category_model>() {
            @Override
            public void onResponse(Call<Category_model> call, Response<Category_model> response) {

                GraidviewAdapter adapter = new GraidviewAdapter(getActivity(),response.body().category);
                graid.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Category_model> call, Throwable t) {

            }
        });
    }

}
