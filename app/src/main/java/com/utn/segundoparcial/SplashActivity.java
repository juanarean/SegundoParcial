package com.utn.segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final int tiempoCarga = 2000;
    private static final int animacion = 1500;

    private ObjectAnimator animatorAlpha;
    private ObjectAnimator animatorRotator;
    private ObjectAnimator animatorAlphaMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.ivLogo);
        TextView marca = findViewById(R.id.tvMarca);

        AnimatorSet animatorSet = new AnimatorSet();

        animatorAlpha = ObjectAnimator.ofFloat(logo, View.ALPHA, 0.0f, 1.0f);
        animatorRotator = ObjectAnimator.ofFloat(logo, "rotation", 0f, 360f);
        animatorAlpha.setDuration(animacion);
        animatorRotator.setDuration(animacion);
        AnimatorSet animatorSetLogo = new AnimatorSet();
        animatorSetLogo.playTogether(animatorAlpha, animatorRotator);
        animatorSetLogo.start();

        animatorAlphaMarca = ObjectAnimator.ofFloat(marca, View.ALPHA, 0.0f, 1.0f);
        animatorAlphaMarca.setDuration(animacion);
        AnimatorSet animatorSetMarca = new AnimatorSet();
        animatorSetMarca.play(animatorAlphaMarca);
        animatorSetMarca.start();

        final Intent intent = new Intent(SplashActivity.this,LoginActivity.class);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(intent);
            }
        }, tiempoCarga);

    }
}
