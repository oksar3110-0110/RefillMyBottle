package com.refillmybottle.refilmybottle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAcc extends AppCompatActivity {

    @BindView(R.id.facebook)
    Button facebook;
    @BindView(R.id.fName)
    EditText fName;
    @BindView(R.id.Lname)
    EditText Lname;
    @BindView(R.id.Email)
    EditText Email;
    @BindView(R.id.EmailConfirm)
    EditText EmailConfirm;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.passConf)
    EditText passConf;
    @BindView(R.id.doB)
    EditText doB;
    @BindView(R.id.country)
    EditText country;
    @BindView(R.id.City)
    EditText City;
    @BindView(R.id.street)
    EditText street;
    @BindView(R.id.profileP)
    ImageView profileP;
    @BindView(R.id.TakeImage)
    ImageButton TakeImage;
    @BindView(R.id.UserAggreement)
    TextView UserAggreement;
    @BindView(R.id.Continue)
    Button Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.facebook, R.id.TakeImage, R.id.UserAggreement, R.id.Continue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.facebook:
                break;
            case R.id.TakeImage:
                break;
            case R.id.UserAggreement:
                break;
            case R.id.Continue:
                break;
        }
    }

}
