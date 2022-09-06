package com.example.clarochile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    TextView tvUsuarioNombre;
    MaterialButton logoutBoton, btnConsultaFacturas, btnMisPuntos, btnPromociones, btnTipoDocto, btnQuejas, btnConsultaSaldo, btnEnvioCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvUsuarioNombre = findViewById(R.id.tvUsuarioNombre);
        logoutBoton = findViewById(R.id.logoutBoton);
        btnConsultaFacturas = findViewById(R.id.btnConsultaFacturas);
        btnMisPuntos = findViewById(R.id.btnMisPuntos);
        btnPromociones = findViewById(R.id.btnPromociones);
        btnTipoDocto = findViewById(R.id.btnTipoDocto);
        btnQuejas = findViewById(R.id.btnQuejas);
        btnConsultaSaldo = findViewById(R.id.btnConsultaSaldo);
        btnEnvioCorreo = findViewById(R.id.btnEnvioCorreo);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            tvUsuarioNombre.setText(user.getEmail());
        }

        logoutBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        btnConsultaFacturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(UserActivity.this, Servicios.class);
                startActivity(intent);*/
                //finish();
            }
        });

        btnPromociones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, Principal.class);
                startActivity(intent);
                //finish();
            }
        });

        btnTipoDocto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(UserActivity.this, ObtenerTipoDoc.class);
                //startActivity(intent);
                //finish();
            }
        });

        btnConsultaSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(UserActivity.this, ConsultSaldo.class);
                //startActivity(intent);
                //finish();
            }
        });

        btnQuejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(UserActivity.this, Quejas.class);
                //startActivity(intent);
                //finish();
            }
        });

        btnEnvioCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(UserActivity.this, EnvioCorreo.class);
                //startActivity(intent);
                //finish();
            }
        });

        btnMisPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, DatosCliente.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}