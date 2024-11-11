package com.example.appresgistro;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nombres, apellidos, nota1, nota2, nota3;
    TextView mostrartexto;
    Button guardar, mostrar;
    ArrayList listaEstudiantes;
    Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombres = findViewById(R.id.edtnombres);
        apellidos = findViewById(R.id.edtapellidos);
        nota1 = findViewById(R.id.edtnota1);
        nota2 = findViewById(R.id.edtnota2);
        nota3 = findViewById(R.id.edtnota3);
        guardar = findViewById(R.id.btnguardar);
        mostrar = findViewById(R.id.btnmostrar);
        mostrartexto = findViewById(R.id.txtdatos);
        listaEstudiantes = new ArrayList();


    }
    public void Guardar(View v){
        String nombre = nombres.getText().toString();
        String apellido = apellidos.getText().toString();
        float nota_1 = Float.parseFloat(nota1.getText().toString());
        float nota_2 = Float.parseFloat(nota2.getText().toString());
        float nota_3 = Float.parseFloat(nota3.getText().toString());

        estudiante = new Estudiante(nombre,apellido,nota_1,nota_2,nota_3);

        listaEstudiantes.add(estudiante);


    }
    public void Mostrar(View v) {
        String datos = "";
        for (int i = 0; i < listaEstudiantes.size() ; i++){
           Estudiante estudiante1 = (Estudiante) listaEstudiantes.get(i);
           float promedio = (estudiante1.nota1+estudiante1.nota2+estudiante1.nota3)/3;

           String text = estudiante1.nombres+" "+estudiante1.apellidos+" su promedio es: "+promedio;

            datos += text +"\n";
        }
        mostrartexto.setText(datos);
    }

}
