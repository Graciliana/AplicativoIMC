package com.example.app_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {
    String nome, indiceImc;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura,tvImc, tvIndice;
    DecimalFormat df = new DecimalFormat(("0.00"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString( "nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");
        indiceImc = bundle.getString("indiceImc");

        tvNome = findViewById(R.id.tvNome);
        tvAltura = findViewById(R.id.tvAltura);
        tvPeso = findViewById(R.id.tvPeso);
        tvImc = findViewById(R.id.tvImc);
        tvIndice = findViewById(R.id.tvIndice);

    }

    @Override
    protected void onStart() {
        super.onStart();
        tvNome.setText(nome);
        tvAltura.setText(altura.toString());
        tvPeso.setText(peso.toString());
        tvImc.setText(df.format( calcularIMC(peso, altura)));
        Double imc = (double) peso/(altura*altura);
        tvIndice.setText(indiceImc);
        if (imc < 18.5){
            tvImc.setText(df.format(imc));
            tvIndice.setText("Abaixo do Peso");
        }else if (imc >= 18.5 && imc <= 24.99){
            tvImc.setText(df.format(imc));
            tvIndice.setText( " Peso ideal(Parabéns)");
        }else if(imc >= 25.0 && imc <= 29.99){
            tvImc.setText(df.format(imc));
            tvIndice.setText(df.format(imc) + " Levemente acima do Peso ");
        } else if(imc >= 30.0 && imc <= 34.99){
            tvIndice.setText(df.format(imc) + " Obesidade grau I ");
        }else if(imc >= 35.0 && imc <= 39.99){
            tvIndice.setText(df.format(imc) + " Obesidade grau II(Severa) ");
        }else if(imc > 40){
            tvIndice.setText(df.format(imc) + " Obesidade grau III(Mórbida) ");
        }
    }

    public Double calcularIMC (Double peso, Double altura){
        Double imc = (double) peso/(altura*altura);

        return imc;
    }

}