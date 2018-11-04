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
import android.widget.Toast;


public class FormProductFragmentTab extends Fragment {

    private EditText etName;
    private EditText etQty;
    private EditText etValue;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.form_product_fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnStore = getView().findViewById(R.id.btnstore);
        // elementos do form de cadastros
        etName = view.findViewById(R.id.name);
        etQty = view.findViewById(R.id.quantity);
        etValue = view.findViewById(R.id.value);
        databaseHelper = new DatabaseHelper(getActivity());

        // button de submit do cadastro do produto
        btnStore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //registra no BD
                Product product = new Product(etName.getText().toString(),
                        Integer.parseInt(etQty.getText().toString()),
                        Float.parseFloat(etValue.getText().toString()));
                if (databaseHelper.addProduct(product) != -1) {
                    //reseta os campos
                    etName.setText("");
                    etQty.setText("");
                    etValue.setText("");

                    //msg de sucesso
                    Toast.makeText(getActivity(), "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    //msg de erro
                    Toast.makeText(getActivity(), "Erro - Não foi possível cadastrar, Tente novamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
