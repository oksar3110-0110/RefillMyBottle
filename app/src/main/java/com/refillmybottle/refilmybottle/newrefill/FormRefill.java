package com.refillmybottle.refilmybottle.newrefill;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.refillmybottle.refilmybottle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormRefill extends AppCompatActivity {

    @BindView(R.id.back_arrow)
    ImageView backArrow;
    @BindView(R.id.input_Image)
    EditText inputImage;
    @BindView(R.id.suggested_station)
    EditText suggestedStation;
    @BindView(R.id.type_refill_station)
    EditText typeRefillStation;
    @BindView(R.id.submit_type)
    Button submitType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_refill);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_arrow, R.id.input_Image, R.id.submit_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_arrow:
                break;
            case R.id.input_Image:
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                break;
            case R.id.submit_type:
                break;
        }
    }
}
