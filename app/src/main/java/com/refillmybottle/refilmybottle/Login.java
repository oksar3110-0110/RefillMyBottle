package com.refillmybottle.refilmybottle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.refillmybottle.refilmybottle.ServicesHandler.RequestInterfaces;
import com.refillmybottle.refilmybottle.ServicesHandler.Utils;
import com.refillmybottle.refilmybottle.newrefill.FormRefill;
import com.refillmybottle.refilmybottle.newrefill.fragment_new_intro;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class Login extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.forgot)
    TextView forgot;
    @BindView(R.id.sigIn)
    Button sigIn;
    @BindView(R.id.signUp)
    TextView signUp;
    Context mContext;
    RequestInterfaces mRequestInterfaces;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext = this;
        mRequestInterfaces = Utils.getApiServices();

        sessionManager = new SessionManager(this);

        if (sessionManager.getSessionStatus()){
            startActivity(new Intent(Login.this, FragmentParent.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        }

    }

    @OnClick({R.id.forgot, R.id.sigIn, R.id.signUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgot:
                break;
            case R.id.sigIn:
                login();
               /*startActivity(new Intent(Login.this, FragmentParent.class));
               finish();*/
                break;
            case R.id.signUp:
                startActivity(new Intent(Login.this, CreateAcc.class));
                finish();
                break;
        }
    }

    private void login() {
        mRequestInterfaces.loginRequest(username.getText().toString(), password.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonResult = new JSONObject(response.body().string());
                        if (jsonResult.getString("status").equals("200")){
                            sessionManager.saveSessionBoolean(sessionManager.SESSION_STATUS, true);
                            String email = jsonResult.getJSONObject("user").getString("email");
                            sessionManager.saveSessionStr(sessionManager.SESSION_EMAIL, email);
                            String photo = jsonResult.getJSONObject("user").getString("photo");
                            sessionManager.saveSessionStr(sessionManager.SESSION_PHOTO, photo);
                            String Fname = jsonResult.getJSONObject("user").getString("namadpn");
                            sessionManager.saveSessionStr(sessionManager.SESSION_NMDP, Fname);
                            String Lname = jsonResult.getJSONObject("user").getString("namablk");
                            sessionManager.saveSessionStr(sessionManager.SESSION_NMBK, Lname);
                            String DoB = jsonResult.getJSONObject("user").getString("tgl");
                            sessionManager.saveSessionStr(sessionManager.SESSION_DOB, DoB);
                            String country = jsonResult.getJSONObject("user").getString("negara");
                            sessionManager.saveSessionStr(sessionManager.SESSION_COUNTRY, country);
                            String state = jsonResult.getJSONObject("user").getString("prov");
                            sessionManager.saveSessionStr(sessionManager.SESSION_REGION, state);
                            String city = jsonResult.getJSONObject("user").getString("kota");
                            sessionManager.saveSessionStr(sessionManager.SESSION_CITY, city);
                            String street = jsonResult.getJSONObject("user").getString("jln");
                            sessionManager.saveSessionStr(sessionManager.SESSION_STREET, street);
                            String poin = jsonResult.getJSONObject("user").getString("poin");
                            String msg = jsonResult.getString("msg").toString();
                            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, FragmentParent.class));
                            finish();

                        } else {
                            String error_msg = jsonResult.getString("msg");
                            Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e){
                        e.printStackTrace();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



}
