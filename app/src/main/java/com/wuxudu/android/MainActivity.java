package com.wuxudu.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.wuxudu.android.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements PlanFragment.OnListFragmentInteractionListener {

    private ViewPager viewPager;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_plan:
                    viewPager.setCurrentItem(0,false);
                    return true;
                case R.id.navigation_explore:
                    viewPager.setCurrentItem(1,false);
                    return true;
                case R.id.navigation_me:
                    viewPager.setCurrentItem(2,false);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewPager = findViewById(R.id.viewpager);
        this.navigation = findViewById(R.id.navigation);
        this.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        this.initViewPager();
    }

    private void initViewPager() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(PlanFragment.newInstance(1));
        adapter.addFragment(PlanFragment.newInstance(2));
        adapter.addFragment(PlanFragment.newInstance(3));
        this.viewPager.setAdapter(adapter);
        this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                navigation.getMenu().getItem(position).setChecked(true);
            }
        });
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}

