package com.refillmybottle.refilmybottle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

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

    int TAKE_PHOTO_CODE = 0;
    public static int count = 0;

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
//                takeShoot();
                break;
            case R.id.UserAggreement:
                break;
            case R.id.Continue:
                break;
        }
    }

   /* private void takeShoot() {
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/RefillMyBottle/";
        File newdir = new File(dir);
        newdir.mkdirs();
        count++;
        String file = dir+count+".jpg";
        File newfile = new File(file);
        try {
            newfile.createNewFile();
        }
        catch (IOException e)
        {
        }

        Uri outputFileUri = Uri.fromFile(newfile);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);

    }*/
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Log.d("CameraDemo", "Pic saved");
    }*/
}

