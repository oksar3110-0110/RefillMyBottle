package com.refillmybottle.refilmybottle.newrefill;

import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.refillmybottle.refilmybottle.R;

public class fragment_new_intro extends Fragment {
    public static fragment_new_intro  newInstance(){
        fragment_new_intro fragment_new_intro = new fragment_new_intro();
        return fragment_new_intro;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_new_intro, container, false);
    }


}
