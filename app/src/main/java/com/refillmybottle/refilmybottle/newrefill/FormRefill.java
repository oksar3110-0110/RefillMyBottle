package com.refillmybottle.refilmybottle.newrefill;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.refillmybottle.refilmybottle.FragmentParent;
import com.refillmybottle.refilmybottle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormRefill extends Fragment {

    public static FormRefill newInstance() {
        FormRefill formRefill = new FormRefill();
        return formRefill;
    }
    public FormRefill(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_form_refill, container, false);
        ((FragmentParent) getActivity()).getSupportActionBar().setTitle("Fragment New Refill");
        ((FragmentParent) getActivity()).getSupportActionBar().setSubtitle("(activity_form_refill.xml)");
        ((FragmentParent)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
