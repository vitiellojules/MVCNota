package com.example.mvcNota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvcNota.controller.NotaController;
import com.example.mvcNota.model.Nota;

public class CadastrarActivity extends AppCompatActivity {

    EditText edTitulo,edTxt;
    Nota Mnote;
    NotaController mNotaController;
    Button bntCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        Mnote = new Nota(edTitulo.getText().toString(),edTxt.getText().toString());
        bntCadastrar = findViewById(R.id.bntExcluir);

        mNotaController = new NotaController(getApplicationContext()) ;
        bntCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casdatraNota();
            }


        });
    }
    public void updateDataNota(){

        Mnote.setTitulo(edTitulo.getText().toString());
        Mnote.setTxt(edTxt.getText().toString());



    }




    private void casdatraNota() {

        Mnote.setTitulo(edTitulo.getText().toString());
        Mnote.setTxt(edTxt.getText().toString());
        mNotaController.cadastrarNota(Mnote);
       finish();
    }
}