package com.rhsoft.controlvisitas;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etEmpresa, etProposito, etDni;
    Button btnRegistrar;
    RecyclerView recyclerVisitas;
    VisitaAdapter visitaAdapter;
    List<visita> listaVisitas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectar campos con el XML
        etNombre = findViewById(R.id.etNombre);
        etEmpresa = findViewById(R.id.etEmpresa);
        etProposito = findViewById(R.id.etProposito);
        etDni = findViewById(R.id.etDni);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        // Configurar RecyclerView
        recyclerVisitas = findViewById(R.id.recyclerVisitas);
        recyclerVisitas.setLayoutManager(new LinearLayoutManager(this));
        visitaAdapter = new VisitaAdapter(listaVisitas);
        recyclerVisitas.setAdapter(visitaAdapter);

        // Validaciones y agregar visita
        btnRegistrar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String empresa = etEmpresa.getText().toString().trim();
            String proposito = etProposito.getText().toString().trim();
            String dni = etDni.getText().toString().trim();

            if (!nombre.matches("^[a-zA-Z\\s]+$")) {
                etNombre.setError("El nombre solo debe contener letras y espacios");
                return;
            }
            if (empresa.isEmpty()) {
                etEmpresa.setError("La empresa no puede estar vacía");
                return;
            }
            if (proposito.matches("^[0-9]+$")) {
                etProposito.setError("El propósito debe describir algo, no solo números");
                return;
            }
            if (!dni.matches("^\\d{8}$")) {
                etDni.setError("El DNI debe tener exactamente 8 dígitos");
                return;
            }

            // Agregar visita a la lista
            listaVisitas.add(new visita(nombre, empresa, proposito, dni));
            visitaAdapter.notifyDataSetChanged();

            Toast.makeText(this, "Visita registrada correctamente", Toast.LENGTH_SHORT).show();
        });
    }
}
