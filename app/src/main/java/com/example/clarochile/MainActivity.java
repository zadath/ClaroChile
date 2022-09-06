package com.example.clarochile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    //SharedPreferences preferences;
    //SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SharedPreferences
        //preferences = this.getSharedPreferences("sesiones", Context.MODE_PRIVATE);
        //editor = preferences.edit();


        //Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView tvBeneficios = findViewById(R.id.tvBeneficios);
        TextView tvClub = findViewById(R.id.tvClub);
        ImageView ivLogo = findViewById(R.id.ivMiClaro);
        final ImageView logoC = findViewById(R.id.idLogos);
        final TextView texBienv = findViewById(R.id.logobienvenida);

        tvBeneficios.setAnimation(animacion2);
        tvClub.setAnimation(animacion2);
        ivLogo.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    //Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    Intent intent = new Intent(MainActivity.this, Generico.class);
                    //Intent intent = new Intent(MainActivity.this, MainMenu.class);
                    //Intent intent = new Intent(MainActivity.this, ResumenVenta.class);
                    //SharedPreferences
                    //editor.putString("usuario", String.valueOf(user));
                    //editor.apply();
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    //ANIMACION QUE NO HA FUNCIONADO
                /*Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logoC, "logoTrans");
                pairs[1] = new Pair<View, String>(texBienv, "bienvenidaTrans");

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }*/

                }
            }
        }, 3000);
    }
}