package com.example.kytc.Fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kytc.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //    Button firstFragmentBt, secondFragmentBt;
//    ViewPager2 viewPager2;
    TabLayout fragmentsTl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
//        firstFragmentBt = findViewById(R.id.fragment1Bt);
//        secondFragmentBt = findViewById(R.id.fragment2Bt);
//        Button thirdFragmentBt = findViewById(R.id.fragment3Bt);

//        viewPager2 = findViewById(R.id.fragments_container);
        fragmentsTl = findViewById(R.id.fragments_Tl);
//        fragmentsTl.addTab(fragmentsTl.newTab().setText("fragment 4"));
        fragmentsTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
//                    getSupportFragmentManager().beginTransaction().add(R.id.fragments_container, new FirstFragment()).addToBackStack("").commit();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    FirstFragment firstFragment = new FirstFragment();
                    Bundle b = new Bundle();
                    b.putString("fragmentName",tab.getText().toString());
                    firstFragment.setArguments(b);
                    fragmentTransaction.add(R.id.fragments_container, firstFragment).addToBackStack("").commit();
                } else if (tab.getPosition() == 1) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragments_container, new SecondFragment()).addToBackStack("").commit();
                } else if (tab.getPosition() == 2) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragments_container, new ThirdFragment()).addToBackStack("").commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        ArrayList<Fragment> fragments = new ArrayList<>();
//        fragments.add(new FirstFragment());
//        fragments.add(new SecondFragment());
//        fragments.add(new ThirdFragment());

//        ArrayList<String> tabs = new ArrayList<>();
//        tabs.add("Fragment 1");
//        tabs.add("Fragment 2");
//        tabs.add("Fragment 3");

//        PagerAdapter adapter = new PagerAdapter(this,fragments);
//
//        viewPager2.setAdapter(adapter);
//
//        new TabLayoutMediator(fragmentsTl, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(tabs.get(position));
//
//            }
//        }).attach();

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        FirstFragment firstFragment = new FirstFragment();
//        fragmentTransaction.add(R.id.fragments_container, firstFragment).commit();

//        getSupportFragmentManager().beginTransaction().add(R.id.fragments_container, new FirstFragment()).commit();

//        firstFragmentBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                FragmentManager fragmentManager = getSupportFragmentManager();
////                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                FirstFragment firstFragment = new FirstFragment();
////                fragmentTransaction.replace(R.id.fragments_container, firstFragment).addToBackStack("").commit();
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, new FirstFragment()).addToBackStack("").commit();
//
//            }
//        });
//        secondFragmentBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                SecondFragment secondFragment = new SecondFragment();
//                fragmentTransaction.replace(R.id.fragments_container, secondFragment).addToBackStack("").commit();
//            }
//        });
//        thirdFragmentBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                ThirdFragment thirdFragment = new ThirdFragment();
//                fragmentTransaction.replace(R.id.fragments_container, thirdFragment).addToBackStack("").commit();
//            }
//        });
    }
}