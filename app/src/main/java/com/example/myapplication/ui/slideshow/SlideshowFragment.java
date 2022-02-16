package com.example.myapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.TextWatcherAdapter;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;


public class SlideshowFragment extends Fragment {
    private Spinner spinner;
    private Spinner spinner2;
    private List<String> list;
    public TextView status;
    public  int fist =2;
    public int to=2;
    int u=0, v=0;
    public EditText value1;
    public TextView value2;
    public String convert (String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

//    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        View view = inflater.inflate(R.layout.chuyen_co_so, container, false);


        Button button;

        button = view.findViewById(R.id.doi);

        list = new ArrayList<>();
        list.add("Cm");
        list.add("Dm");
        list.add("M");
        list.add("Km");
        spinner = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        status= view.findViewById(R.id.status);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(getActivity().getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item,
                list);
//        ArrayAdapter spinnerAdapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                to = 0;
                if(i == 0){
                    v =0;
                    to = 2;
                } else if( i== 1){
                    v=1;
                    to = 8;
                }
                else if ( i == 2 ){
                    v=2;
                    to = 10;
                }
                else if (i == 3){
                    v=3;
                    to = 16;
                }
                try {
                    String a = convert(String.valueOf(value1.getText()), fist, to);
                    value2.setText(a);
                    status.setText("Trạng thái: Chuyển đổi thành công");
                } catch (Exception ex){
                    status.setText("Trạng thái: Đầu vào không hợp lệ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                fist = 0;
                if(i == 0){
                    u=0;
                    fist = 2;
                } else if( i== 1){
                    u=1;
                    fist = 8;
                }
                else if ( i == 2 ){
                    u=2;
                    fist = 10;
                }
                else if (i == 3){
                    u=3;
                    fist = 16;
                }
                try {
                    String a = convert(String.valueOf(value1.getText()), fist, to);
                    value2.setText(a);
                    status.setText("Trạng thái: Chuyển đổi thành công");
                } catch (Exception ex){
                    status.setText("Trạng thái: Đầu vào không hợp lệ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        value1 = view.findViewById(R.id.textView3);
        value2 = view.findViewById(R.id.textView4);

        value1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                 Log.v("TAG", "trckhi doi");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                 String a = convert(String.valueOf(value1.getText()), fist, to);
//                 value2.setText(a);

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String a = convert(String.valueOf(value1.getText()), fist, to);
                    value2.setText(a);
                    status.setText("Trạng thái: Chuyển đổi thành công");
                } catch (Exception ex){
                    status.setText("Trạng thái: Đầu vào không hợp lệ");
                }
            }

        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t = u;
                u = v;
                v = t;
                t = fist;
                fist =to;
                to = t;
                spinner.setSelection(u);
                spinner2.setSelection(v);
                try {
                    String a = convert(String.valueOf(value1.getText()), fist, to);
                    value2.setText(a);
                    status.setText("Trạng thái: Chuyển đổi thành công");
                } catch (Exception ex){
                    status.setText("Trạng thái: Đầu vào không hợp lệ");
                }
            }
        });











        return view ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}