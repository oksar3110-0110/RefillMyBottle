package com.refillmybottle.refilmybottle;

import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapsFragmentActivity extends Fragment {

    public static MapsFragmentActivity newInstace(){
        MapsFragmentActivity mapsFragmentActivity = new MapsFragmentActivity();
        return mapsFragmentActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_maps_fragment, container, false);
    }
}
