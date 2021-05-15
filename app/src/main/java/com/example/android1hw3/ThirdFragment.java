package com.example.android1hw3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThirdFragment extends Fragment {
    private Button button3;
    private String string;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        string = getArguments().getString("key2");
        return inflater.inflate(R.layout.fragment_third, container, false);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button3 = view.findViewById(R.id.btn_three);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FourthFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key3",string);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_frame,fragment)
                        .addToBackStack(null).commit();
            }
        });
    }
}
