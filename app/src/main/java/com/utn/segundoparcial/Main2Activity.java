package com.utn.segundoparcial;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main2Activity extends AppCompatActivity {

    private TareaAsincrona tarea;
    private LocationManager locManager;
    private Location loc = null;
    private final int REQUEST_PERMISO = 1;
    GoogleApiClient apiClient;

    TextView tvLugar1;
    TextView tvLugar2;
    TextView tvHora1;
    TextView tvHora2;
    TextView tvDetalle;
    Button btnLlegada;
    Button btnSalida;
    CardView cvSalida;
    ImageView imLogo;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvLugar1 = findViewById(R.id.tvLugar1);
        tvLugar2 = findViewById(R.id.tvLugar2);
        tvHora1 = findViewById(R.id.tvHoraLlegada);
        tvHora2 = findViewById(R.id.tvSalida);
        btnLlegada = findViewById(R.id.btnLlegada);
        tvDetalle = findViewById(R.id.tvDetalle2);
        btnSalida = findViewById(R.id.btnSalida);
        cvSalida = findViewById(R.id.cvSalida);
        imLogo = findViewById(R.id.ivLogo);

        cvSalida.setVisibility(View.GONE);

        /*if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISO);
            ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISO);
        }*/

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String URL = bundle.getString("URL");

        Glide.with(this).load(URL).apply(new RequestOptions().placeholder(R.drawable.logo_basis).dontAnimate()).into(imLogo);

        btnLlegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarea = new TareaAsincrona();
                tarea.execute();
                cvSalida.setVisibility(View.VISIBLE);
                btnLlegada.setVisibility((View.GONE));
            }
        });

        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tarea = new TareaAsincrona();
                //tarea.execute();
                btnSalida.setVisibility(View.INVISIBLE);

            }
        });

    }

    protected class TareaAsincrona extends AsyncTask<Void, Integer, Boolean> {

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected Boolean doInBackground(Void... params) {

            locManager = (LocationManager) Main2Activity.this.getSystemService(Context.LOCATION_SERVICE);
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISO);
                //ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISO);
            }

            loc = locManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if(loc != null)
            {
                tvLugar1.setText(String.valueOf(loc.getLatitude()) + ", " + String.valueOf(loc.getLongitude()));
                tvLugar2.setText(loc.getLatitude() + ", " + loc.getLongitude());
            }
            else
            {
                tvLugar1.setText("Ubicación desconocida");
                tvLugar2.setText("Ubicación desconocida");
            }

            return true;
        }
    }
}
