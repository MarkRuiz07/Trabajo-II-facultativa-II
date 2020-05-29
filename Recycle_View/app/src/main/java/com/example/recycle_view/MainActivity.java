package com.example.recycle_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Adapter myAdapter;
    Boolean created = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter=new Adapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
        created = true;

    }

    private ArrayList<Model> getMyList(){


        if(!created) {

            Repository.ClearAll();

            Model m = new Model();

            m.setTitle("FacultativaII");
            m.setDescription("Descripción de FacultativaII");
            m.setImg(R.drawable.app);
            m.setNmbProfesor("Saira María");
            m.setDia("Jueves");
            m.setHora("2:30 pm");
            m.setFechaEntrega("Viernes 29 de Mayo");
            Repository.Add(m);

            m = new Model();
            m.setTitle("Investigación");
            m.setDescription("Descripción de la Investigación");
            m.setImg(R.drawable.files);
            Repository.Add(m);

            m = new Model();
            m.setTitle("Planificación");
            m.setDescription("Descripción de la Planifiación");
            m.setImg(R.drawable.pc);
            Repository.Add(m);
        }

        return Repository.List();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.salir: {
                this.finish(); // cierra la app
                break;
            }
            case R.id.agregar: { // mostrar el layout en forma de dialogo
                Intent intent = new Intent();
                final Dialog dlg = new Dialog(this);
                dlg.setContentView(R.layout.dialog_add_layout);
                dlg.setTitle("Añadir asignatura...");
                dlg.setCancelable(false);

                Button btAddNew = (Button)dlg.findViewById(R.id.btnRegistrar); //Boton que me permite añadir los valores al arreglo
                Button btCancel = (Button)dlg.findViewById(R.id.btncancelar);

                btAddNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { //añadir elementos onClick al boton. Aqui se obtienen los datos y se guardan en el arreglo usando la clase Repository

                        EditText editText_asig = (EditText)dlg.findViewById(R.id.editText_Asig);
                        EditText editText_desc = (EditText)dlg.findViewById(R.id.editText_Desc);
                        EditText editText_prof = (EditText)dlg.findViewById(R.id.editText_prof);
                        EditText editText_dia = (EditText)dlg.findViewById(R.id.editText_dia);
                        EditText editText_hora = (EditText)dlg.findViewById(R.id.editText_hora);
                        EditText editText_proxTrab = (EditText)dlg.findViewById(R.id.editText_ProxTrab);

                        Model model = new Model();
                        model.setTitle(editText_asig.getText().toString());
                        model.setDescription(editText_desc.getText().toString());
                        model.setImg(R.drawable.files);
                        model.setDia(editText_dia.getText().toString());
                        model.setFechaEntrega(editText_proxTrab.getText().toString());
                        model.setHora(editText_hora.getText().toString());
                        model.setNmbProfesor(editText_prof.getText().toString());

                        editText_asig.setText(""); //dejar en blanco los cuadros de texto
                        editText_desc.setText("");
                        editText_prof.setText("");
                        editText_dia.setText("");
                        editText_hora.setText("");
                        editText_proxTrab.setText("");

                        Repository.Add(model);

                        //Se crea una nueva instancia del Adapter con el dato que se acaba de ingresar
                        myAdapter=new Adapter(v.getContext(), getMyList());
                        //Se asigna el adapter con los datos actualizados al RecyclerView para que los muestre
                        mRecyclerView.setAdapter(myAdapter);

                        dlg.cancel();
                    }
                });

                btCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });

                dlg.show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
