package com.example.calculadoraimcv2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAltura;
    private EditText editTextPeso;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String alturaStr = editTextAltura.getText().toString();
        String pesoStr = editTextPeso.getText().toString();

        if (!alturaStr.isEmpty() && !pesoStr.isEmpty()) {
            double altura = Double.parseDouble(alturaStr);
            double peso = Double.parseDouble(pesoStr);

            double imc = peso / (altura * altura);
            String classificacao = classificarIMC(imc);

            Intent intent = new Intent(MainActivity.this, ResultadoPage.class);
            intent.putExtra("imc", imc);
            intent.putExtra("classificacao", classificacao);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Por favor, insira altura e peso", Toast.LENGTH_SHORT).show();
        }
    }

    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Baixo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Excesso de peso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade";
        } else {
            return "Obesidade extrema";
        }
    }
}
