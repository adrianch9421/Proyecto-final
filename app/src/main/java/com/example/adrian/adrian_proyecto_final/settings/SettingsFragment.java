package com.example.adrian.adrian_proyecto_final.settings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.adrian_proyecto_final.R;

/**
 * A simple {@link Fragment} subclass.
 */

public  class SettingsFragment extends PreferenceFragment {

    public SettingsFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.shared_preferences);
    }
}