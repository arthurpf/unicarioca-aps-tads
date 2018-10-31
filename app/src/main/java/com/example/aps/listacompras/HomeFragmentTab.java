package com.example.aps.listacompras;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragmentTab extends Fragment {

    private Button btnSubmit;
    private DatabaseHelper databaseHelper;
    private EditText name;
    private EditText quantity;
    private EditText value;

    public HomeFragmentTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        databaseHelper = new DatabaseHelper(getActivity());
        name = (EditText) findViewById("name");

        // evento ao clicar no botao de submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment_tab, container, false);
    }


}
