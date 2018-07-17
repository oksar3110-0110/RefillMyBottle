package com.refillmybottle.refilmybottle.Profile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.refillmybottle.refilmybottle.R;

import java.util.zip.Inflater;

public class ProfileHome extends Fragment {
    public static ProfileHome  newInstance(){
        ProfileHome profileHome = new ProfileHome();
        return profileHome;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_profile_home, container, false);
    }
}
