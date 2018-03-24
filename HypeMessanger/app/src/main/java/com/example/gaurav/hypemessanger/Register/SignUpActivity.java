package com.example.gaurav.hypemessanger.Register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gaurav.hypemessanger.CommonUtils.Utilites;
import com.example.gaurav.hypemessanger.MainUI.MainActivity;
import com.example.gaurav.hypemessanger.MainUI.UserListActivity;
import com.example.gaurav.hypemessanger.R;
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
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase db;
    //GoogleApiClient googleApiClient;
    EditText userNameText, phoneNumberText, emailText, passwordText;
    Button register;
    public FirebaseAuth firebaseAuth;
    //ImageView googleSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();
        //googleSignIn = (ImageView) findViewById(R.id.googleSignIn);
        userNameText = (EditText) findViewById(R.id.userNameText);
        phoneNumberText = (EditText) findViewById(R.id.phoneText);
        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        register = (Button) findViewById(R.id.registerButton);
        register.setOnClickListener(this);

//        GoogleSignInOptions gso =
//                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                        .requestEmail()
//                        .requestIdToken(getString(R.string.default_web_client_id))
//                        .build();
//
//        googleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this /* FragmentActivity */,
//                        new GoogleApiClient.OnConnectionFailedListener() {
//                            @Override
//                            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//                                Toast.makeText(SignUpActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
//                            }
//                        } /* OnConnectionFailedListener */)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();
//
//        googleSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
//                startActivityForResult(signInIntent, 4232);
//            }
//        });
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 4232) {
//            GoogleSignInResult result =
//                    Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//
//            handleSignInResult(result);
//
//
//        }
//    }

//    private void handleSignInResult(GoogleSignInResult result) {
//        if(result.isSuccess())
//        {
//            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//            GoogleSignInAccount account = result.getSignInAccount();
//            sendToFirebase(account);
//        }
//        else{
//            Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show();
//        }
//    }
//    private void sendToFirebase(GoogleSignInAccount account) {
//        AuthCredential authCredentials =
//                GoogleAuthProvider.getCredential(account.getIdToken(),null);
//        firebaseAuth.signInWithCredential(authCredentials)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Intent intent = new Intent(SignUpActivity.this,GroupAddActivity.class);
//                            startActivity(intent);
//                            finish();
//                            Toast.makeText(SignUpActivity.this, "Success FireBase", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(SignUpActivity.this, "Failur FireBase", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }

    boolean validateInput() {

        boolean result = true;
        String username = userNameText.getText().toString();
        String password = passwordText.getText().toString();
        String phone = phoneNumberText.getText().toString();
        String email = emailText.getText().toString();
        if (username.trim().length() == 0) {
            userNameText.setError("Please enter userName");
            result = false;
        }
        if (password.trim().length() == 0) {
            passwordText.setError("Please enter password");
            result = false;
        }
        if (phone.trim().length() == 0) {
            phoneNumberText.setError("Please enter phone");
            result = false;
        }else if(phone.trim().length() != 10){
            phoneNumberText.setError("Enter valid Phone number");
            result = false;
        }else if(phone.trim().contains("+91")){
            if(phone.trim().length() != 12){
                phoneNumberText.setError("Enter valid phone number");
                result = false;
            }
        }
        if (email.trim().length() == 0) {
            emailText.setError("Please enter email");
            result = false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                if (validateInput())
                    attemptRegister();
                break;
        }
    }

    void registerUser(final String email, final String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String token = FirebaseInstanceId.getInstance().getToken();
                        if (task.isSuccessful() && token!=null) {
                            //showProgress(false);
                            Utilites.sendIdTokenToServer(FirebaseDatabase.getInstance(),token
                                    , userNameText.getText().toString()
                                    , emailText.getText().toString(),
                                    phoneNumberText.getText().toString(),"test"+System.currentTimeMillis());
                            Intent intent = new Intent(SignUpActivity.this,UserListActivity.class);
                            startActivity(intent);
                            //Utilites.startHome(SignUpActivity.this);
                            Toast.makeText(SignUpActivity.this, "user Regsitered", Toast.LENGTH_SHORT).show();
                            //loginSuccessful();
                        } else {
                            //showProgress(false);
                            Toast.makeText(SignUpActivity.this, "Unable to Register ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


    private void attemptRegister() {

        // Reset errors.
        emailText.setError(null);
        passwordText.setError(null);
        phoneNumberText.setError(null);
        userNameText.setError(null);

        // Store values at the time of the login attempt.
        String username = userNameText.getText().toString();
        String password = passwordText.getText().toString();
        String phone = phoneNumberText.getText().toString();
        String email = emailText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordText.setError("Enter Password");
            focusView = passwordText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Enter Email");
            focusView = emailText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailText.setError("Enter Valid Email");
            focusView = emailText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
//            mAuthTask = new UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);

            registerUser(email, password);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
