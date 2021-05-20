package com.example.projectpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularCombustivel (View view){
        TextInputEditText editAlcool = findViewById(R.id.editAlcool);
        TextInputEditText editGasolina = findViewById(R.id.editGasolina);
        TextView textResultado = findViewById(R.id.textResultado);

        String useGasolina = getString(R.string.useGasolina);
        String useAlcool = getString(R.string.useAlcool);
        String preencha = getString(R.string.preencha);

        String valorAlcool = editAlcool.getText().toString();
        String valorGasolina = editGasolina.getText().toString();

        Boolean camposValidados = conferirCampos(valorGasolina,valorAlcool);

        if (camposValidados){
            Double precoAlcool = Double.parseDouble(valorAlcool);
            Double precoGasolina = Double.parseDouble(valorGasolina);

            Double resultadoCampos = precoAlcool/precoGasolina;

            if (resultadoCampos >= 0.7){
                textResultado.setText(useGasolina);
            }else{
                textResultado.setText(useAlcool);
            }
        }else{
            textResultado.setText(preencha);
        }
    }

    public Boolean conferirCampos (String alcool, String gasolina){
        Boolean camposValidados = true;

        if (alcool == null || alcool.equals("")){
            camposValidados = false;
        }else if (gasolina == null || gasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}