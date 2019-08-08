package com.example.boostcoursepractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SubFragment extends Fragment {

    MainActivity activity ;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(context, "attach 실행됨", Toast.LENGTH_LONG).show();

        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "onDetach 실행됨", Toast.LENGTH_LONG).show();

        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), "onCreateView 실행됨", Toast.LENGTH_LONG).show();

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_sub, container, false) ;
        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.chageFragement(0);
            }
        });
        return rootView;
    }
}
