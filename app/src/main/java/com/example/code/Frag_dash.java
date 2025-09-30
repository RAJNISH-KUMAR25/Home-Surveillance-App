package com.example.code;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_dash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_dash extends Fragment {
WebView webview;
TextView off,close,lawn1;
RelativeLayout home,garage,lawn;
Button btn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_dash() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_dash.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_dash newInstance(String param1, String param2) {
        Frag_dash fragment = new Frag_dash();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frag_dash, container, false);
        webview=view.findViewById(R.id.webview);
        home=view.findViewById(R.id.home);
        garage=view.findViewById(R.id.garage123);
        lawn=view.findViewById(R.id.lawn1);
        close=view.findViewById(R.id.close);
        off=view.findViewById(R.id.off);
        lawn1=view.findViewById(R.id.open);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("192.168.1.114:5000");
                close.setText("Open");
                off.setText("Off");
                lawn1.setText("close");
            }
        });
        garage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://192.168.1.120:5000/video_feed");
                off.setText("On");
                close.setText("Close");
                lawn1.setText("close");
            }
        });
        lawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webview.loadUrl("http://192.168.1.113:8080/video_feed");
                off.setText("Off");
                close.setText("Close");
                lawn1.setText("Open");
            }
        });


        return view;
    }
}