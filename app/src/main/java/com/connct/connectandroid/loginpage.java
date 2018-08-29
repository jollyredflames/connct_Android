package com.connct.connectandroid;

import android.content.Intent;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginpage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Method Invoked on initial startup or after start once app proceess has been killed
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        //Checks if user is already logged in
        mAuth = FirebaseAuth.getInstance();
        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        //android.app.ActionBar myBar = getActionBar();
        //myBar.hide();

    }

    public void onStart() {
        //invoked everytime app is navigated too
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            updateUI(currentUser);
        }
    }

    public void tryLogin(View login_button) {

        //Take input from username text field
        EditText login_field = findViewById(R.id.login_field);
        //Take input from password text field
        EditText password_field = findViewById(R.id.password_field);

        String email = login_field.getText().toString();
        String password = password_field.getText().toString();

        if (email.length() == 0) {
            Toast.makeText(loginpage.this, "Email Address field cannot be empty!",
                    Toast.LENGTH_SHORT).show();
            vib.vibrate(100);
            Animation shake = AnimationUtils.loadAnimation(loginpage.this, R.anim.shake);
            login_field.startAnimation(shake);
        }
        else if (password.length() == 0) {
            Toast.makeText(loginpage.this, "Password field cannot be empty!",
                    Toast.LENGTH_SHORT).show();
            vib.vibrate(100);
            Animation shake = AnimationUtils.loadAnimation(loginpage.this, R.anim.shake);
            password_field.startAnimation(shake);
        }
        else if (!email.contains("@") || !email.contains(".")){
            Toast.makeText(loginpage.this, "Sorry! Login using Usernames is not supported yet. Please enter your email address instead.",
                    Toast.LENGTH_LONG).show();
            vib.vibrate(100);
            Animation shake = AnimationUtils.loadAnimation(loginpage.this, R.anim.shake);
            login_field.startAnimation(shake);
        }
        else{
            firebaseLogin(email, password);
        }
    }

    private void firebaseLogin(String email, String password){

        //Go to Firebase database and try authenticating with username and password
        //or with FirebaseUser Instance if user has previously logged in

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("EmailSignIn", "SignIN: SUCCESSFUL!");
                            Toast.makeText(loginpage.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("EmailSignInFailure", task.getException());
                            Toast.makeText(loginpage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void pullSignUp(View signup_button){
        //Navigate to sign up page when clicked
        Intent pullsignup = new Intent(this, signuppage.class);
        startActivity(pullsignup);
        //setContentView(R.layout.signuppage);
    }

    public void updateUI(FirebaseUser uname){
        //TODO: Add Code to transition to "Logged In" Screen.
        //Method invoked with null if login unsuccessful, else with FirebaseUser instance
        if (uname == null){
            Animation shake = AnimationUtils.loadAnimation(loginpage.this, R.anim.shake);
            findViewById(R.id.login_field).startAnimation(shake);
            findViewById(R.id.password_field).startAnimation(shake);
            vib.vibrate(150);
            //findViewById(R.id.password_field).setText("");
        } else {
            Intent goToMain = new Intent(this, landingpage.class);
            startActivity(goToMain);
        }
    }
}
