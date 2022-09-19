package com.example.mbsconnects.result;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mbsconnects.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class result_activity extends AppCompatActivity {

    TextInputLayout roll_number;
    ProgressBar result_progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        roll_number=findViewById(R.id.roll_number);
        result_progressBar=findViewById(R.id.result_progress_bar);
    }


    private boolean connected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificonn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileconn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wificonn != null && wificonn.isConnected()) || (mobileconn != null && mobileconn.isConnected())) {
            return true;
        }
        else {

            return false;

        }
    }



    public boolean validation()
    {
        String stu=roll_number.getEditText().getText().toString().trim();

        if(stu.isEmpty())
        {
            roll_number.setError("Input the roll number");
            return false;
        }
        roll_number.setErrorEnabled(false);
        return true;
    }

    public void get_result(View view) {
        if(!connected())
        {
            Toast.makeText(this, "Please connect to internet", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!validation()) {
            return;
        }
        result_progressBar.setVisibility(View.VISIBLE);
        String stu=roll_number.getEditText().getText().toString().trim();
        Query data= FirebaseDatabase.getInstance().getReference("result").orderByChild("pdfTitle").equalTo(stu);

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    roll_number.setError(null);
                    roll_number.setErrorEnabled(false);


                    String pdfUrl=snapshot.child(stu).child("pdfUrl").getValue(String.class);

                    Intent intent= new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(pdfUrl));
                      startActivity(intent);

                        }
                else
                {

                    Toast.makeText(result_activity.this, "Result not found", Toast.LENGTH_SHORT).show();
                }
                result_progressBar.setVisibility(View.GONE);
                }




            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                result_progressBar.setVisibility(View.GONE);
                Toast.makeText(result_activity.this, "Error! "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}