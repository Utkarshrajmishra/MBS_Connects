package com.example.mbsconnects.loginandsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.HelperClass.UserData;
import com.example.mbsconnects.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_activity extends AppCompatActivity {

    String item="";
    String [] items={"BCA","BBA","MSc","BSc","MCOM", "BCOM", "Other-Parent/Teacher"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    private FirebaseAuth firebaseAuth;
    private TextInputLayout name,email,password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name=findViewById(R.id.full_name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.create_account_progressbar);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt_department_event);
        adapterItems = new ArrayAdapter<String>(this,R.layout.drop_down,items);
        autoCompleteTxt.setAdapter(adapterItems);
        firebaseAuth=FirebaseAuth.getInstance();

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();

            }
        });
    }

    public void signup_next(View view) {
        if(!validationName() | !validationEmail() | !validationPassword())
        {
            return;
        }
        else if(item.equals(""))
        {
            Toast.makeText(this, "Please Select the course", Toast.LENGTH_SHORT).show();
        }
        else
        {
            signup();
        }
    }



    private void signup() {
        progressBar.setVisibility(View.VISIBLE);
        String user_email = email.getEditText().getText().toString().trim();
        String user_pass =password.getEditText().getText().toString().trim();
        String user_name = name.getEditText().getText().toString().trim();


        firebaseAuth.createUserWithEmailAndPassword(user_email,user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Signup_activity.this, "Profile Created Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Signup_activity.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        saveuserinfo(user_email,user_pass,user_name,item);
        progressBar.setVisibility(View.GONE);
        Intent intent=new Intent(this,login_activity.class);
        startActivity(intent);
    }

    private void saveuserinfo(String user_email, String user_pass, String user_name, String item) {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("users_student");
        UserData userData=new UserData(user_name,user_email,user_pass,item);
        String k=user_email.replace(".","@");
        reference.child(k).setValue(userData);


    }


    public void login_button(View view) {
        Intent intent=new Intent(this,login_activity.class);
        startActivity(intent);
    }


    public boolean validationName() {
        String stu = name.getEditText().getText().toString().trim();
        if (stu.isEmpty()) {
            name.setError("Input the name");
            return false;
        } else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }



    public boolean validationEmail() {
        String stu = email.getEditText().getText().toString().trim();

        if (stu.isEmpty()) {
            email.setError("Input the email");
            return false;
        }

        else
        {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }


    public boolean validationPassword() {
        String stu =password.getEditText().getText().toString().trim();

        if (stu.isEmpty()) {
            password.setError("Input the password");
            return false;
        }
        else if(stu.contains(" "))
        {
            password.setError("Whitespaces are not allowed");
            return false;
        }
        else if(stu.length()<8)
        {
            password.setError("Password should contain atleast 8 characters");
            return false;
        }
        else
        {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }



    private boolean connected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificonn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileconn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wificonn != null && wificonn.isConnected()) || (mobileconn != null && mobileconn.isConnected())) {
            return true;
        } else {
            Toast.makeText(this, "Please connect to internet", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}