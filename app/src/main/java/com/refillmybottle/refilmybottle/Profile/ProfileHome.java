package com.refillmybottle.refilmybottle.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.refillmybottle.refilmybottle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileHome extends Fragment {
    @BindView(R.id.profile_foto)
    CircleImageView profileFoto;
    @BindView(R.id.profile_name)
    TextView profileName;
    @BindView(R.id.city_profile)
    TextView cityProfile;
    @BindView(R.id.change_profile_name)
    CircleImageView changeProfileName;
    @BindView(R.id.intro_bio_profile)
    TextView introbioProfile;
    @BindView(R.id.account_settings)
    TextView accountSettings;
    @BindView(R.id.statistic)
    TextView statistic;
    @BindView(R.id.points_profile)
    TextView pointsProfile;
    @BindView(R.id.share_with_friend)
    TextView shareWithFriend;
    @BindView(R.id.about_us)
    TextView aboutUs;
    @BindView(R.id.terms_of_service)
    TextView termsOfService;
    Unbinder unbinder;

    public static ProfileHome newInstance() {
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
        View view = inflater.inflate(R.layout.activity_profile_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.account_settings, R.id.statistic, R.id.points_profile, R.id.share_with_friend, R.id.about_us, R.id.terms_of_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.account_settings:
                startActivity(new Intent(getActivity().getApplication(), AccountSetting.class));
                break;
            case R.id.statistic:
                break;
            case R.id.points_profile:
                break;
            case R.id.share_with_friend:
                break;
            case R.id.about_us:
                break;
            case R.id.terms_of_service:
                break;
        }
    }
}
