package cnam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xee.sdk.api.XeeApi;
import com.xee.sdk.api.model.Authorization;
import com.xee.sdk.api.model.User;
import com.xee.sdk.api.model.Vehicle;
import com.xee.sdk.core.auth.AuthenticationCallback;
import com.xee.sdk.core.auth.OAuth2Client;
import com.xee.sdk.core.auth.XeeAuth;
import com.xee.sdk.core.common.XeeEnv;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity  {

    private Button logIn;
    private XeeEnv xenv;
    private XeeAuth xeau;
    private XeeApi xapi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.logIn =  findViewById(R.id.sign_in_button);

        OAuth2Client oAuthClient = new OAuth2Client.Builder()
                .clientId("324b3e00-2ccf-477e-833e-b1c819c6577f")
                .clientSecret("b0aeab4367810e479a4166c1f6668ccffcb1b0a492d8eb92a28699516c2f3751")
                .scopes(Arrays.asList("vehicles.read"))
                .build();



        this.xenv = new XeeEnv(this, oAuthClient);
        this.xapi = new XeeApi(this.xenv, true);
        this.xeau = new XeeAuth(this.xenv, true);


    }

    public void logIn(View v)
    {
        xeau.connect(new AuthenticationCallback() {
            @Override
            public void onError(@NotNull Throwable throwable) {
                Log.i("RES-Errreur",throwable.getMessage());
            }
            @Override
            public void onSuccess() {
                Log.i("RES-Ok","Utilisateur connecté");
            }
        });
    }
}
