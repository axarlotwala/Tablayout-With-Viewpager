package com.test.aksha.tabfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.aksha.tabfragment.adapter.Viewpager_adapter;
import com.test.aksha.tabfragment.Fragment.GraidlayoutFragment;
import com.test.aksha.tabfragment.Fragment.RecyclerFragment;

public class MainActivity extends AppCompatActivity {

    TabLayout tabview;
    ViewPager pager;
    Viewpager_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabview = findViewById(R.id.tabview);
        pager = findViewById(R.id.pager);

        adapter = new Viewpager_adapter(getSupportFragmentManager());

        adapter.AddFragment(new RecyclerFragment(),"List View");

        adapter.AddFragment(new GraidlayoutFragment(),"Graid View");

        pager.setAdapter(adapter);
        tabview.setupWithViewPager(pager);



    }
}
