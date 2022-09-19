package com.example.mbsconnects;

import static com.example.mbsconnects.HelperClass.constants.TOPIC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mbsconnects.bell_notification.notification_inbuilt;
import com.example.mbsconnects.loginandsignup.login_activity;
import com.example.mbsconnects.navigation_fragments.book_fragment;
import com.example.mbsconnects.navigation_fragments.home_fragment;
import com.example.mbsconnects.navigation_fragments.homework_fragment;
import com.example.mbsconnects.navigation_fragments.notice_fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ImageView menu;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ChipNavigationBar chipNavigationBar;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        chipNavigationBar=findViewById(R.id.bottom_nav_menu);
        firebaseAuth=FirebaseAuth.getInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_fragment()).commit();
        bottomMenu();



        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.naviagtion_view);
        menu=findViewById(R.id.navigation_icon);

        navigationDrawer();
    }



    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener (new ChipNavigationBar.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected ( int i){
            Fragment fragment = null;
            switch (i) {
                case R.id.home:
                    fragment = new home_fragment();
                    break;
                case R.id.notice:
                    fragment = new notice_fragment();
                    break;
                case R.id.homework:
                    fragment = new homework_fragment();
                    break;
                case R.id.book:
                    fragment = new book_fragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
        }
        });
    }



    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else

                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        if(item.getItemId()==R.id.drawer_home)
        {
            fragment= new home_fragment();
        }
        if(item.getItemId()==R.id.update)
        {

        }
        if(item.getItemId()==R.id.pass)
        {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

            EditText resetmail = new EditText(getApplicationContext());

            AlertDialog.Builder resetPassword = new AlertDialog.Builder(this);
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
                            Toast.makeText(getApplicationContext(), "Reset link sent on your mail", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!" + e.getMessage(), Toast.LENGTH_SHORT);
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
        if(item.getItemId()==R.id.logout)
        {


            AlertDialog.Builder logoutbox = new AlertDialog.Builder(this);
            logoutbox.setTitle("Logout");
            logoutbox.setMessage("Are you confirm you want to logout?");
            logoutbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    firebaseAuth.signOut();
                    Intent intent=new Intent(MainActivity.this, login_activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    finish();
                    Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            logoutbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            logoutbox.create().show();





        }
        if(item.getItemId()==R.id.location_marker)
        {
            Uri uri= Uri.parse("geo:0, 0?q=MARWAR BUSINESS SCHOOL GORAKHPUR");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);

        }
        if(item.getItemId()==R.id.delete_acc)
        {

            AlertDialog.Builder logoutbox = new AlertDialog.Builder(this);
            logoutbox.setTitle("Delete Account");
            logoutbox.setMessage("Are you sure you want to delete your account?");
            logoutbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Account deleted", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(MainActivity.this, login_activity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                                        finish();
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
            });
            logoutbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            logoutbox.create().show();

        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }

    private void change_password() {



    }

    private void location() {
    }

    private void logout_user() {
    }

    public void bell_notification(View view) {
          Intent intent=new Intent(this, notification_inbuilt.class);
          startActivity(intent);

    }
}