package com.refillmybottle.refilmybottle;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.refillmybottle.refilmybottle.ServicesHandler.RequestInterfaces;
import com.refillmybottle.refilmybottle.ServicesHandler.Utils;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.CAMERA;

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
    Spinner country;
    @BindView(R.id.City)
    Spinner City;
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
    @BindView(R.id.et_state)
    Spinner et_state;
    int mYear, mMonth, mDay;
    Context mContext;
    RequestInterfaces mRequestInterfaces;
    private Uri outputFileUri;
    private static int TAKE_PICTURE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        ButterKnife.bind(this);
        mContext = this;
        mRequestInterfaces = Utils.getApiServices();


    }

    @OnClick({R.id.facebook, R.id.TakeImage, R.id.UserAggreement, R.id.Continue, R.id.doB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.facebook:
                break;
            case R.id.TakeImage:
                TakePhoto();
                break;
            case R.id.UserAggreement:
                break;
            case R.id.Continue:
                //registerProcess();
                break;
            case R.id.doB :
                datePicker();
                break;
        }
    }

    private void TakePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        outputFileUri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, TAKE_PICTURE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PICTURE ) {
            if(resultCode==0 ){
                return;
            }
            // photo taken


            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), outputFileUri);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }//BitmapFactory.decodeFile(tmpFile.getAbsolutePath());
            Matrix matrix = new Matrix();

            // resize the bit map
            float scale=(float)profileP.getMeasuredWidth()/bitmap.getWidth();
            matrix.postScale(scale, scale);

            // recreate the new Bitmap\
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);

            bitmap.recycle();
            profileP.setImageBitmap(resizedBitmap);


        }
    }


    private void datePicker() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                doB.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
            }
        }, mYear,mMonth,mDay);
        datePickerDialog.show();

    }

    public void registerProses(){
        mRequestInterfaces.registerrequest(fName.getText().toString(), Lname.getText().toString(),Email.getText().toString(), EmailConfirm.getText().toString(), pass.getText().toString(),
                passConf.getText().toString(), doB.getText().toString(), country.getSelectedItem().toString(), et_state.getSelectedItem().toString(),
                City.getSelectedItem().toString(), street.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){

                    try {
                        JSONObject jsonResult = new JSONObject(response.body().string());
                        if(jsonResult.getString("msg")
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



}

