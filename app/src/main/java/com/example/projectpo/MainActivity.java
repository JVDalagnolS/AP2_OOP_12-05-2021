package com.example.projectpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool;
    private TextInputEditText editGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularCombustivel (View view){
        String valorAlcool = editAlcool.getText().toString();
        String valorGasolina = editGasolina.getText().toString();

        Boolean camposValidados = conferirCampos(valorGasolina,valorAlcool);

        if (camposValidados){
            Double precoAlcool = Double.parseDouble(valorAlcool);
            Double precoGasolina = Double.parseDouble(valorGasolina);

            Double resultadoCampos = precoAlcool/precoGasolina;

            if (resultadoCampos >= 0.7){
                textResultado.setText("Recomendamos utilizar gasolina.");
            }else{
                textResultado.setText("Recomendamos utilizar álcool.");
            }
        }else{
            textResultado.setText("É nescessário preencher todos os campos antes de calcular!");
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