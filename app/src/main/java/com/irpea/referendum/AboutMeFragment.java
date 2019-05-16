package com.irpea.referendum;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutMeFragment extends Fragment {
    private TextView mName;
    private TextView mMail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_me, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mName = view.findViewById(R.id.name_string);
        mName.setText("Autor: Igor Čulić");
        mMail = view.findViewById(R.id.mail_string);
        mMail.setText("E-mail: irpea@live.com");
    }
}
