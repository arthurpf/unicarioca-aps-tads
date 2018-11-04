package com.example.aps.listacompras;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragmentTab extends Fragment {

    private EditText etName;
    private EditText etQty;
    private EditText etValue;
    private DatabaseHelper databaseHelper;
    private ArrayList<String> arrayList;
    private TextView tvnames;

    public HomeFragmentTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
        tvnames = (TextView) view.findViewById(R.id.products_list);
        tvnames.setText("");

        arrayList = databaseHelper.getProducstsList();
        for (int i = 0; i < arrayList.size(); i++){
            tvnames.setText(tvnames.getText().toString()+" "+arrayList.get(i) + "\n");
        }
    }


}
