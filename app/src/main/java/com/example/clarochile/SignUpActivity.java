package com.example.clarochile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    TextView nuevoUsuario, bienvenidoLabel, continuarLabel;
    ImageView signUpImageView;
    TextInputLayout usuarioSignUpTextField, contrasenaTextField;
    MaterialButton iniciarSesion;
    TextInputEditText emailEditText, passwordEditText, confirmPasswordEditText, nombreEditText;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpImageView = findViewById(R.id.signUpImageView);
        bienvenidoLabel = findViewById(R.id.bienvenidaLabel);
        continuarLabel = findViewById(R.id.continuarLabel);
        usuarioSignUpTextField = findViewById(R.id.usuarioSignUpTextField);
        contrasenaTextField = findViewById(R.id.contrasenaTextField);
        iniciarSesion = findViewById(R.id.iniciarSesion);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        nombreEditText = findViewById(R.id.nombreEditText);

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionBack();
            }
        });

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        mAuth = FirebaseAuth.getInstance();
    }


    public void validate(){

        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

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

        if(!confirmPassword.equals(password)){
            confirmPasswordEditText.setError("Las contraseñas deben ser iguales");
            return;
        } else {
            confirmPasswordEditText.setError(null);
            registrar(email, password);
        }
    }


    public void registrar(String email, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Intent intent = new Intent(SignUpActivity.this, UserActivity.class);
                            Intent intent = new Intent(SignUpActivity.this, Generico.class);
                            //Intent intent = new Intent(SignUpActivity.this, MainMenu.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Fallo la acción de registrarte!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    @Override
    public void onBackPressed(){
        transitionBack();
    }


    public void transitionBack(){
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

        /*Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View, String>(signUpImageView, "logoImageTrans");
        pairs[1] = new Pair<View, String>(bienvenidoLabel, "textTrans");
        pairs[2] = new Pair<View, String>(continuarLabel, "iniciaSesionTextTrans");
        pairs[3] = new Pair<View, String>(usuarioSignUpTextField, "emailInputTextTrans");
        pairs[4] = new Pair<View, String>(contrasenaTextField, "passwordInputTextTrans");
        pairs[5] = new Pair<View, String>(iniciarSesion, "buttonSignInTrans");
        pairs[6] = new Pair<View, String>(nuevoUsuario, "newUserTrans");

        //ANIMACION QUE NO HA FUNCIONADO

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }*/
    }
}