package com.example.calculadoraimcv2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
 public class ResultadoPage extends AppCompatActivity {

    private TextView textViewResultado;
    private ImageView imageViewClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewResultado = findViewById(R.id.textViewResultado);
        imageViewClassificacao = findViewById(R.id.imageViewClassificacao);

        Intent intent = getIntent();
        double imc = intent.getDoubleExtra("imc", 0);
        String classificacao = intent.getStringExtra("classificacao");

        String resultado = String.format("IMC: %.2f\nClassificação: %s", imc, classificacao);
        textViewResultado.setText(resultado);

        atualizarImagem(imc);
    }

    private void atualizarImagem(double imc) {
        if (imc < 18.5) {
            imageViewClassificacao.setImageResource(R.drawable.baixo_peso);
        } else if (imc >= 18.5 && imc < 24.9) {
            imageViewClassificacao.setImageResource(R.drawable.peso_normal);
        } else if (imc >= 25 && imc < 29.9) {
            imageViewClassificacao.setImageResource(R.drawable.excesso_de_peso);
        } else if (imc >= 30 && imc < 34.9) {
            imageViewClassificacao.setImageResource(R.drawable.obesidade);
        } else {
            imageViewClassificacao.setImageResource(R.drawable.obesidade_extrema);
        }
    }
}
