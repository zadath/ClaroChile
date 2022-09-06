package com.example.clarochile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextView nuevoUsuario, olvidasContra;
    TextInputEditText emailEditText, passwordEditText;
    MaterialButton inicioSesion;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nuevoUsuario = findViewById(R.id.nuevoUsuario);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        inicioSesion = findViewById(R.id.inicioSesion);
        mAuth = FirebaseAuth.getInstance();
        olvidasContra = findViewById(R.id.olvidasContra);

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

                /* Pair[] pairs = new Pair[7];
                 pairs[0] = new Pair<View, String>(signUpImageView, "logoImageTrans");
                pairs[1] = new Pair<View, String>(bienvenidoLabel, "textTrans");
                pairs[2] = new Pair<View, String>(continuarLabel, "iniciaSesionTextTrans");
                pairs[3] = new Pair<View, String>(usuarioSignUpTextField, "emailInputTextTrans");
                pairs[4] = new Pair<View, String>(contrasenaTextField, "passwordInputTextTrans");
                pairs[5] = new Pair<View, String>(iniciarSesion, "buttonSignInTrans");
                pairs[6] = new Pair<View, String>(nuevoUsuario, "newUserTrans");

                //ANIMACION QUE NO HA FUNCIONADO

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }*/
            }
        });


        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });


        olvidasContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void validate(){

        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Correo inválido!");
            return;
        } else {
            emailEditText.setError(null);;
        }

        if(password.isEmpty() || password.length() < 8){
            passwordEditText.setError("Se necesitan 8 carácteres");
            return;
        } else if(!Pattern.compile("[0-9]").matcher(password).find()){
            passwordEditText.setError("Escribe al menos un número");
            return;
        } else {
            passwordEditText.setError(null);;
        }

        iniciarSesion(email, password);
    }

    public void iniciarSesion(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(LoginActivity.this, Generico.class);
                            //Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                            //Intent intent = new Intent(LoginActivity.this, MainMenu.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Credenciales equivocadas, intenta nuevamente", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}