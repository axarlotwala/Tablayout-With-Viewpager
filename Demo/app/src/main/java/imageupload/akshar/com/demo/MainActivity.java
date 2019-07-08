package imageupload.akshar.com.demo;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager viewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tab);
        viewpager = findViewById(R.id.viewpager);

        Pageadapter pageadapter = new Pageadapter(getSupportFragmentManager());
        pageadapter.AddFragment(new OneFragment(),"One");
        pageadapter.AddFragment(new TwoFragment(),"second");
        pageadapter.AddFragment(new ThreeFragment(),"Three");

        viewpager.setAdapter(pageadapter);
        tab.setupWithViewPager(viewpager);


    }
}
