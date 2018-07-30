package com.refillmybottle.refilmybottle.newrefill;

import android.content.Context;
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
import android.widget.Toast;

import com.refillmybottle.refilmybottle.R;
import com.refillmybottle.refilmybottle.ServicesHandler.RequestInterfaces;
import com.refillmybottle.refilmybottle.ServicesHandler.Utils;
import com.refillmybottle.refilmybottle.response.ItemRelation;
import com.refillmybottle.refilmybottle.response.ItemTypes;
import com.refillmybottle.refilmybottle.response.RelationResponse;
import com.refillmybottle.refilmybottle.response.TypesResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    Context mContext;
    RequestInterfaces mBaseApi;

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
        unbinder = ButterKnife.bind(this, view);
        mBaseApi = Utils.getApiServices();
        mContext = getActivity();
        initSpinnerRelation();
        initSpinnerTypes();

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

        return view;
    }

    private void initSpinnerRelation() {
    mBaseApi.getRelationData().enqueue(new Callback<RelationResponse>() {
        @Override
        public void onResponse(Call<RelationResponse> call, Response<RelationResponse> response) {
            if(response.isSuccessful()){
                List<ItemRelation> itemRespons = response.body().getData();
                List<String> listSpinRel = new ArrayList<String>();
                for (int i = 0; i < itemRespons.size(); i++){
                    listSpinRel.add(itemRespons.get(i).getNama());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listSpinRel);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                suggestedStation.setAdapter(adapter);
            } else {
                Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<RelationResponse> call, Throwable t) {

        }
    });

    }

    private void initSpinnerTypes(){
        mBaseApi.getTypesData().enqueue(new Callback<TypesResponse>() {
            @Override
            public void onResponse(Call<TypesResponse> call, Response<TypesResponse> response) {
               if(response.isSuccessful()) {
                   List<ItemTypes> typesResponse = response.body().getData();
                   List<String> listSpinTypes = new ArrayList<String>();
                   for (int i = 0; i < typesResponse.size(); i++) {
                       listSpinTypes.add(typesResponse.get(i).getNama());
                   }
                   ArrayAdapter<String> aadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listSpinTypes);
                   aadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   typeRefillStation.setAdapter(aadapter);
                }
               }

            @Override
            public void onFailure(Call<TypesResponse> call, Throwable t) {

            }
        });
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

    @OnClick({R.id.input_Image, R.id.submit_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.input_Image:

                break;
            case R.id.submit_type:
                break;
        }
    }
}
