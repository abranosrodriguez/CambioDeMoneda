package com.example.cambiodemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton rdBtnPAE, rdbtnEAP;
    private Button btnCambiar;
    private RadioGroup btnRadioGroup;
    private EditText editTxtValor;
    private String strEditTxtValor;
    private TextView txtViewCambioRealizado;

    private double valorPesetasUnEuro = 1538.82;
    private double valorPesetas = 0.00065;
    private double valorCalculado,valorEditText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdBtnPAE = findViewById(R.id.rdbtnPAE);
        rdbtnEAP = findViewById(R.id.rdbtnEAP);
        editTxtValor = findViewById(R.id.editTxtValor);
        btnCambiar = findViewById(R.id.btnCambiar);
        txtViewCambioRealizado = findViewById(R.id.txtViewCambioRealizado);
        btnRadioGroup = findViewById(R.id.rdbBtnGroup);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strEditTxtValor = editTxtValor.getText().toString();
                if (strEditTxtValor.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Introduce algun valor", Toast.LENGTH_SHORT).show();
                } else if (strEditTxtValor.isEmpty() == false && btnRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "Selecciona un tipo de intercambio", Toast.LENGTH_SHORT).show();
                }else{
                    valorEditText = Double.parseDouble(strEditTxtValor);
                    if (rdBtnPAE.isChecked()) {
                        //1538,82pesetas el precio de 1€
                        valorCalculado = valorPesetas * valorEditText ;
                        txtViewCambioRealizado.setText(valorEditText +" pesetas son " + valorCalculado + " euros");
                    } else if (rdbtnEAP.isChecked()) {
                        valorCalculado = valorEditText * valorPesetasUnEuro;
                        txtViewCambioRealizado.setText(valorEditText +" euros son " + valorCalculado + " pesetas");
                    }

                }


            }
        });

    }
}