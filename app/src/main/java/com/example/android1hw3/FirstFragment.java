package com.example.android1hw3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFragment extends Fragment {

    private Button button1;
    private EditText editText1;
    private String string;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button1 =view.findViewById(R.id.btn_one);
        editText1 =  view.findViewById(R.id.et_one);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SecondFragment();
                Bundle bundle = new Bundle();
                string = editText1.getText().toString();
                bundle.putString("key",string);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_frame,fragment)
                        .addToBackStack(null).commit();
            }
        });
    }
}
