package com.refillmybottle.refilmybottle.newrefill;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.refillmybottle.refilmybottle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class fragment_new_intro extends Fragment {
    RelativeLayout New;
    Fragment fragment;
    @BindView(R.id.newRefill)
    RelativeLayout newRefill;
    Unbinder unbinder;

    public fragment_new_intro() {

    }

    public static fragment_new_intro newInstance() {
        fragment_new_intro fragment_new_intro = new fragment_new_intro();
        return fragment_new_intro;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_new_intro, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.newRefill)
    public void onViewClicked() {
        FormRefill formRefill = FormRefill.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, formRefill);
        fragmentTransaction.commit();
    }
}
