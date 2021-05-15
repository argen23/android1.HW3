package com.example.android1hw3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SecondFragment extends Fragment {

    private Button button2;
    private String string;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        string = getArguments().getString("key");
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button2 = view.findViewById(R.id.btn_two);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ThirdFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key2",string);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_frame,fragment)
                        .addToBackStack(null).commit();
            }
        });
    }
}