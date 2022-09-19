package com.example.mbsconnects.loginandsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mbsconnects.MainActivity;
import com.example.mbsconnects.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class login_activity extends AppCompatActivity {

    private TextInputLayout login_email, login_password;
    FirebaseAuth firebaseAuth;
    private ProgressBar login_progressBar;
    private Button forgot_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_progressBar = findViewById(R.id.login_progressbar);
        forgot_btn = findViewById(R.id.forgot_password);
        login_progressBar.getIndeterminateDrawable()
                .setColorFilter(ContextCompat.getColor(this, R.color.button_color), PorterDuff.Mode.SRC_IN );

        firebaseAuth = FirebaseAuth.getInstance();


    }


    public void login(View view) {
        if (!validationEmail() | !validationPassword()) {
            return;
        }
        login_progressBar.setVisibility(View.VISIBLE);
        String login_user_password = login_password.getEditText().getText().toString().trim();
        String login_user_email = login_email.getEditText().getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(login_user_email, login_user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(login_activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login_activity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(login_activity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        login_progressBar.setVisibility(View.GONE);

    }

    public void create_account(View view) {
        Intent intent = new Intent(this, Signup_activity.class);
        startActivity(intent);
    }


    public boolean validationEmail() {
        String stu = login_email.getEditText().getText().toString().trim();
        if (stu.isEmpty()) {
            login_email.setError("Input the email");
            return false;
        } else {
            login_email.setError(null);
            login_email.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validationPassword() {
        String stu = login_password.getEditText().getText().toString().trim();
        if (stu.isEmpty()) {
            login_password.setError("Input the password");
            return false;
        } else {
            login_password.setError(null);
            login_password.setErrorEnabled(false);
            return true;
        }
    }

    public void forgetpassword(View view) {

        EditText resetMail = new EditText(view.getContext());
        EditText resetmail = new EditText(view.getContext());

        AlertDialog.Builder resetPassword = new AlertDialog.Builder(view.getContext());
        resetPassword.setTitle("Reset Password");
        resetPassword.setMessage("Enter your email to receive reset link");
        resetPassword.setView(resetmail);

        resetPassword.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String mail = resetmail.getText().toString();


                firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(login_activity.this, "Reset link sent on your mail", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login_activity.this, "Error!!" + e.getMessage(), Toast.LENGTH_SHORT);
                    }
                });

            }
        });

        resetPassword.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        resetPassword.create().show();

    }
}



