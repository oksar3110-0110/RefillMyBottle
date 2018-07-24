package com.refillmybottle.refilmybottle.newrefill;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.refillmybottle.refilmybottle.FragmentParent;
import com.refillmybottle.refilmybottle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class fragment_new_intro extends Fragment {
    RelativeLayout New;
    Fragment fragment;

    public fragment_new_intro(){

    }

    public static fragment_new_intro newInstance() {
        fragment_new_intro fragment_new_intro = new fragment_new_intro();
        return fragment_new_intro;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormRefill formRefill = new FormRefill();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, formRefill)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });*/

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_new_intro, container, false);
        return view;
    }





}
