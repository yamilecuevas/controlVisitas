package com.rhsoft.controlvisitas;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etEmpresa, etProposito, etDni;
    private Button btnRegistrar;
    private RecyclerView recyclerVisitas;
    private VisitaAdapter visitaAdapter;
    private List<visita> listaVisitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre);
        etEmpresa = findViewById(R.id.etEmpresa);
        etProposito = findViewById(R.id.etProposito);
        etDni = findViewById(R.id.etDni);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        recyclerVisitas = findViewById(R.id.recyclerVisitas);

        // Configurar lista y adapter
        listaVisitas = new ArrayList<>();
        visitaAdapter = new VisitaAdapter(listaVisitas);
        recyclerVisitas.setLayoutManager(new LinearLayoutManager(this));
        recyclerVisitas.setAdapter(visitaAdapter);

        // Acción del botón
        btnRegistrar.setOnClickListener(v -> registrarVisita());
    }

    private void registrarVisita() {
        String nombre = etNombre.getText().toString().trim();
        String empresa = etEmpresa.getText().toString().trim();
        String proposito = etProposito.getText().toString().trim();
        String dni = etDni.getText().toString().trim();

        // Validaciones
        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(empresa) ||
                TextUtils.isEmpty(proposito) || TextUtils.isEmpty(dni)) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (dni.length() != 8) {
            Toast.makeText(this, "El DNI debe tener 8 dígitos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear objeto visita y agregarlo a la lista
        visita nuevaVisita = new visita(nombre, empresa, proposito, dni);
        listaVisitas.add(nuevaVisita);
        visitaAdapter.notifyItemInserted(listaVisitas.size() - 1);

        // Limpiar campos
        etNombre.setText("");
        etEmpresa.setText("");
        etProposito.setText("");
        etDni.setText("");

        Toast.makeText(this, "Visita registrada", Toast.LENGTH_SHORT).show();
    }
}
