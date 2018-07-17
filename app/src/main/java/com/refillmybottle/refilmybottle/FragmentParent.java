package com.refillmybottle.refilmybottle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.refillmybottle.refilmybottle.Profile.ProfileHome;
import com.refillmybottle.refilmybottle.newrefill.fragment_new_intro;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FragmentParent extends AppCompatActivity {


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.maps)
    ImageView maps;
    @BindView(R.id.New)
    ImageView New;
    @BindView(R.id.Event)
    ImageView Event;
    @BindView(R.id.Shop)
    ImageView Shop;
    @BindView(R.id.Profile)
    ImageView Profile;
    @BindView(R.id.bottom_navigation)
    LinearLayout bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_parent);
        ButterKnife.bind(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment_new_intro.newInstance());
        transaction.commit();
    }

    @OnClick({R.id.maps, R.id.New, R.id.Event, R.id.Shop, R.id.Profile})
    public void onViewClicked(View view) {
        Fragment selectedFragment = null;
        switch (view.getId()) {
            case R.id.maps:
                selectedFragment = MapsFragmentActivity.newInstace();
                break;
            case R.id.New:
                selectedFragment = fragment_new_intro.newInstance();
                break;
            case R.id.Event:
                break;
            case R.id.Shop:
                break;
            case R.id.Profile:
                selectedFragment = ProfileHome.newInstance();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();
    }

}
