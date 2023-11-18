package com.example.mvcNota;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mvcNota.controller.NotaController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    ListView ListView;
    NotaController MnotaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = findViewById(R.id.listView);
        MnotaController = new NotaController(getApplicationContext());
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new OnClickListener() {
            @Override


            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(i);
            }
        });

        ListView.setOnItemClickListener(New AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick (AdapterView < ? > parent, View view ,int position, long id ){

                exibirNota(position);
            }
        }
        );
    }
    private void exibirNota(int position ) {

    MnotaController.getAllNote().get(position).getId();
      Intent i = new Intent(getApplicationContext(),ExibirActivity.class);
      i.putExtra("id",MnotaController.getAllNote().get(position).getId());

      startActivity(i);
    }
        protected void onStart () {
            super.onStart();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    MnotaController.getAllTitlesNotes());
            ListView.setAdapter(adapter);

        }
    }
}