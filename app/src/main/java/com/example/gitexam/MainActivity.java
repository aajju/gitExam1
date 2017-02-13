package com.example.gitexam;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// TestFragment.CallbackListener 구현했음
public class MainActivity extends AppCompatActivity implements TestFragment.CallbackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onButtonClicked(String value) {
        System.out.println("프래그먼트로부터 전달받은 문자열 값 : " + value);
    }
}
