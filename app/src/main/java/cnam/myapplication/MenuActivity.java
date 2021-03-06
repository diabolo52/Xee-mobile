package cnam.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xee.sdk.api.model.Vehicle;
import com.xee.sdk.core.auth.DisconnectCallback;

import java.util.List;
import java.util.Observable;
import java.util.function.Consumer;

import cnam.myapplication.Classes.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /**
     * Lance l'activité Profil
     * @param v
     */
    public void getProfil(View v)
    {
        startActivity(new Intent(MenuActivity.this, ProfilActivity.class));
    }

    /**
     * Lance l'activité véhicule
     * @param v
     */
    public void getVehicles(View v)
    {
        startActivity(new Intent(MenuActivity.this, VehicleActivity.class));
    }

    /**
     * Lance l'activité Localisation
     * @param v
     */
    public void getLocation(View v)
    {
        startActivity(new Intent(MenuActivity.this, LocationActivity.class));
    }

    /**
     * Lance l'activité Statistiques
     * @param v
     */
    public void getStat(View v)
    {
        startActivity(new Intent(MenuActivity.this, StatActivity.class));
    }

    /**
     * Déconnecte l'utilisateur
     * @param v
     */
    public void logOut(View v) {
        ApiService.getInstance().getXeau().disconnect(new DisconnectCallback() {
            @Override
            public void onCompleted() {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });
    }

}
