package com.example.gaurav.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GoogleSignIn extends AppCompatActivity {

    Button googleSignIN;
    GoogleApiClient googleApiClient;
    public FirebaseAuth fireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_sign_in);
        fireBaseAuth = FirebaseAuth.getInstance();

        googleSignIN = (Button) findViewById(R.id.button2);

        GoogleSignInOptions gso =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */,
                        new GoogleApiClient.OnConnectionFailedListener() {
                            @Override
                            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                                Toast.makeText(GoogleSignIn.this, "Connection failed", Toast.LENGTH_SHORT).show();
                            }
                        } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        googleSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent, 4232);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4232) {
            GoogleSignInResult result =
                    Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            handleSignInResult(result);


        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess())
        {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            GoogleSignInAccount account = result.getSignInAccount();
            sendToFirebase(account);
        }
        else{
            Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendToFirebase(GoogleSignInAccount account) {
        AuthCredential authCredentials =
                GoogleAuthProvider.getCredential(account.getIdToken(),null);
                fireBaseAuth.signInWithCredential(authCredentials)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(GoogleSignIn.this,DataBaseActivity.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(GoogleSignIn.this, "Success FireBase", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(GoogleSignIn.this, "Failur FireBase", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
    }
}
