package com.refillmybottle.refilmybottle;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.refillmybottle.refilmybottle.response.ItemCity;
import com.refillmybottle.refilmybottle.response.ItemCountry;
import com.refillmybottle.refilmybottle.response.ItemState;
import com.refillmybottle.refilmybottle.response.ResponseCity;
import com.refillmybottle.refilmybottle.response.ResponseCountry;
import com.refillmybottle.refilmybottle.response.response_state;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public String images;
    SessionManager sessionManager;
    View dialogView;

    AlertDialog.Builder dialog;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        ButterKnife.bind(this);
        mContext = this;
        mRequestInterfaces = Utils.getApiServices();
        sessionManager = new SessionManager(this);
        initCountry();


        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                initState();
                statePut();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void initCountry() {
        mRequestInterfaces.getCountry("nama").enqueue(new Callback<ResponseCountry>() {
            @Override
            public void onResponse(Call<ResponseCountry> call, Response<ResponseCountry> response) {
                if (response.isSuccessful()) {
                    List<ItemCountry> responseCountries = response.body().getData();
                    List<String> listCountry = new ArrayList<String>();
                    for (int i = 0; i < responseCountries.size(); i++) {
                        listCountry.add(responseCountries.get(i).getCountry());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_spinner_item, listCountry);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    country.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ResponseCountry> call, Throwable t) {

            }
        });

    }

    private void initState() {
        mRequestInterfaces.getState(country.getSelectedItem().toString()).enqueue(new Callback<response_state>() {
            @Override
            public void onResponse(Call<response_state> call, Response<response_state> response) {
                List<ItemState> itemStates = response.body().getData();
                List<String> listState = new ArrayList<String>();
                for (int i = 0; i < itemStates.size(); i++) {
                    listState.add(itemStates.get(i).getState());
                    /*initCity();*/
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_spinner_item, listState);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                et_state.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<response_state> call, Throwable t) {

            }
        });

    }

    private void statePut() {
        et_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void initCity() {
        if (et_state.getSelectedItem().toString() != null) {
            mRequestInterfaces.getCity(et_state.getSelectedItem().toString()).enqueue(new Callback<ResponseCity>() {
                @Override
                public void onResponse(Call<ResponseCity> call, Response<ResponseCity> response) {
                    List<ItemCity> itemCities = response.body().getData();
                    List<String> listCity = new ArrayList<String>();
                    for (int i = 0; i < itemCities.size(); i++) {
                        listCity.add(itemCities.get(i).getCity());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_spinner_item, listCity);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    et_state.setAdapter(adapter);
                    putCity();
                }

                @Override
                public void onFailure(Call<ResponseCity> call, Throwable t) {

                }
            });
        }

    }

    private void putCity() {
        City.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
                doRegist();
                break;
            case R.id.doB:
                datePicker();
                break;
        }
    }

    private void TakePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        outputFileUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, TAKE_PICTURE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PICTURE) {
            if (resultCode == 0) {
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
            float scale = (float) profileP.getMeasuredWidth() / bitmap.getWidth();
            matrix.postScale(scale, scale);

            // recreate the new Bitmap\
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);

            profileP.setImageBitmap(resizedBitmap);

            images = encodeFromString(bitmap);
            sessionManager.saveSessionStr(sessionManager.SESSION_UPLOAD_IMAGE_REG, images);

        }
    }

    public static String encodeFromString(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 40, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();

        return Base64.encodeToString(b, Base64.DEFAULT);
    }


    private void datePicker() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                doB.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    private void doRegist() {
        images = sessionManager.getSessionUploadImageReg().toString();
        mRequestInterfaces.registerrequest(fName.getText().toString(), Lname.getText().toString(), Email.getText().toString()
                , EmailConfirm.getText().toString(), pass.getText().toString(), passConf.getText().toString(), doB.getText().toString(), country.getSelectedItem().toString(),
                et_state.getSelectedItem().toString(),City.getSelectedItem().toString(), street.getText().toString(), images).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonResult = new JSONObject(response.body().string());
                        if (jsonResult.getString("status").equals(200)) {
                            /*String msg = jsonResult.getString("msg").toString();
                            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();*/
                            DialogForm();

                        } else {
                            String error_msg = jsonResult.getString("msg");
                            Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void DialogForm() {
        dialog = new AlertDialog.Builder(CreateAcc.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_dialog, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);

        dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CreateAcc.this, Login.class));
        finish();
    }
}

