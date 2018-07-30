package com.refillmybottle.refilmybottle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.refillmybottle.refilmybottle.Maps.MapsFragmentActivity;
import com.refillmybottle.refilmybottle.Profile.ProfileHome;
import com.refillmybottle.refilmybottle.newrefill.fragment_new_intro;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FragmentParent extends AppCompatActivity {
    @BindView(R.id.mapsBut)
    RelativeLayout mapsBut;
    @BindView(R.id.newBut)
    RelativeLayout newBut;
    @BindView(R.id.eventBut)
    RelativeLayout eventBut;
    @BindView(R.id.ShopBut)
    RelativeLayout ShopBut;
    @BindView(R.id.profile_But)
    RelativeLayout profileBut;

    public static final int BACK_PERIIOD = 2000;
    private long LAST_PERIOD_BACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_parent);
        ButterKnife.bind(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, MapsFragmentActivity.newInstace());
        transaction.commit();

    }


    @OnClick({R.id.mapsBut, R.id.newBut, R.id.eventBut, R.id.ShopBut, R.id.profile_But})
    public void onViewClicked(View view) {
        Fragment selectedFragment = null;
        switch (view.getId()) {
            case R.id.mapsBut:
                selectedFragment = MapsFragmentActivity.newInstace();
                break;
            case R.id.newBut:
                selectedFragment = fragment_new_intro.newInstance();
                break;
            case R.id.eventBut:
                break;
            case R.id.ShopBut:
                break;
            case R.id.profile_But:
                selectedFragment = ProfileHome.newInstance();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,selectedFragment);
        transaction.commit();

}

}

