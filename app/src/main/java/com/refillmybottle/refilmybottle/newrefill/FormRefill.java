package com.refillmybottle.refilmybottle.newrefill;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.refillmybottle.refilmybottle.R;

import java.lang.reflect.Type;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FormRefill extends Fragment {

    @BindView(R.id.back_arrow)
    ImageView backArrow;
    @BindView(R.id.input_Image)
    EditText inputImage;
    @BindView(R.id.suggested_station)
    Spinner suggestedStation;
    @BindView(R.id.type_refill_station)
    Spinner typeRefillStation;
    @BindView(R.id.submit_type)
    Button submitType;
    Unbinder unbinder;

    public static FormRefill newInstance() {
        FormRefill formRefill = new FormRefill();
        return formRefill;
    }

    public FormRefill() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_form_refill, container, false);
        final String[] type;
        final String[] relation;


        type = getResources().getStringArray(R.array.type_fountain);
        relation = getResources().getStringArray(R.array.relation_station);

        ArrayAdapter<String> Types = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, type);
        ArrayAdapter<String> Relation = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, relation);

        suggestedStation.setAdapter(Relation);
        typeRefillStation.setAdapter(Types);
        suggestedStation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        typeRefillStation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        unbinder = ButterKnife.bind(this, view);
        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.back_arrow, R.id.input_Image, R.id.submit_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_arrow:
                break;
            case R.id.input_Image:
                break;
            case R.id.submit_type:
                break;
        }
    }
}
