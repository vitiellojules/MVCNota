package com.example.mvcNota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvcNota.controller.NotaController;
import com.example.mvcNota.model.Nota;

public class ExibirActivity extends AppCompatActivity {
    NotaController mNotaController;
    Nota mNota;
    EditText edTitulo,edTxt;
    Button bntSalvar,bntExclluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityexibir);

        mNotaController = new NotaController(getApplicationContext());
        mNotaController.getNota( getIntent().getExtras().getInt("id"));


        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        bntSalvar = findViewById(R.id.bntSalvar);

        bntExclluir=findViewById(R.id.bntExcluir);
        bntExclluir.setOnClickListener(New View.OnClickListener(){

            @Override


                    public void onClick (View v ){
                excluirNota();

            }
        }


        );
        bntSalvar.setOnClickListener(New View.OnClickListener(){



            @Override

           public void onClick (View v ){

                salvar();
            }
        });

    }

    private void excluirNota() {

        mNotaController.deleteNota(mNota);
    }

    private void salvar() {

        mNota.setTitulo(edTitulo.getText().toString());
        mNota.setTxt(edTitulo.getText().toString());
        mNotaController.updateNota(mNota);
    }

    protected void onStart(){

        super.onStart();
        edTitulo.setText(mNota.getTitulo());
        edTxt.setText(mNota.getTxt());


    }
}