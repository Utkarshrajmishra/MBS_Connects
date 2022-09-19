package com.example.mbsconnects.navigation_fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.mbsconnects.R;
import com.example.mbsconnects.app_content.about_us;
import com.example.mbsconnects.assignment.assignment_activity;
import com.example.mbsconnects.courses.Bsc;
import com.example.mbsconnects.courses.bba;
import com.example.mbsconnects.courses.bca;
import com.example.mbsconnects.courses.bcom;
import com.example.mbsconnects.courses.mcom;
import com.example.mbsconnects.courses.msc;
import com.example.mbsconnects.scheme.scheme_activity;
import com.example.mbsconnects.online_class.join_class;
import com.example.mbsconnects.paper.previous_paper;
import com.example.mbsconnects.result.result_activity;


public class home_fragment extends Fragment {

    CardView about,join_class_btn,scheme,paper,result,task,bca,bba,bcom,mcom,msc,bsc;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment, container, false);

        about=view.findViewById(R.id.about_us);
        join_class_btn=view.findViewById(R.id.join_class);
        scheme=view.findViewById(R.id.scheme);
        paper=view.findViewById(R.id.paper_btn);
        result=view.findViewById(R.id.result_btn);
        task=view.findViewById(R.id.task);
        bca=view.findViewById(R.id.bca_btn);
        bba=view.findViewById(R.id.bba_btn);
        bcom=view.findViewById(R.id.bcom_btn);
        msc=view.findViewById(R.id.msc_btn);
        mcom=view.findViewById(R.id.mcom_btn);
        bsc=view.findViewById(R.id.bsc_btn);







        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), bca.class);
                startActivity(intent);
            }
        });

        bba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), bba.class);
                startActivity(intent);
            }
        });
        bcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), bcom.class);
                startActivity(intent);
            }
        });

        mcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),mcom.class);
                startActivity(intent);
            }
        });


        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Bsc.class);
                startActivity(intent);
            }
        });

        msc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), msc.class);
                startActivity(intent);
            }
        });


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), result_activity.class);
                startActivity(intent);
            }
        });

        join_class_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), join_class.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), about_us.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogtask();
            }
        });

        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogscheme();
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogPaper();
            }
        });

        return view;

    }

    private void showDialogtask() {
        final Dialog dialog=new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.assigment_sheet);

        LinearLayout home=dialog.findViewById(R.id.homework1);
        LinearLayout labwork=dialog.findViewById(R.id.labwork1);
        LinearLayout assignment=dialog.findViewById(R.id.assignment1);


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations= R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), assignment_activity.class);
                intent.putExtra("assignment_type","Home-Work");
                startActivity(intent);
            }
        });
        labwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),assignment_activity.class);
                intent.putExtra("assignment_type","Lab-Work");
                startActivity(intent);
            }
        });
        assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), assignment_activity.class);
                intent.putExtra("assignment_type","Assignment");
                startActivity(intent);
            }
        });




    }

    private void showDialogPaper() {

        final Dialog dialog=new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sheet_paper);

        LinearLayout sesssionl_paper=dialog.findViewById(R.id.sessional_paper);
        LinearLayout semester_paper=dialog.findViewById(R.id.semster_paperr);


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations= R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        semester_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), previous_paper.class);
                intent.putExtra("paper_type","Semesters-Paper");
                startActivity(intent);
            }
        });

        sesssionl_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), previous_paper.class);
                intent.putExtra("paper_type","Sessional-Papers");
                startActivity(intent);
            }
        });


    }

    private void showDialogscheme() {

        final Dialog dialog=new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sheet_assigment);

        LinearLayout sessional_tt=dialog.findViewById(R.id.sessional_tt);
        LinearLayout class_tt=dialog.findViewById(R.id.class_time_table);
        LinearLayout sems_tt=dialog.findViewById(R.id.semester_tt);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations= R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        sessional_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), scheme_activity.class);
                intent.putExtra("parent","Sessional-Time-Table");
                startActivity(intent);
            }
        });

        class_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), scheme_activity.class);
                intent.putExtra("parent","Class-Time-Table");
                startActivity(intent);
            }
        });

        sems_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), scheme_activity.class);
                intent.putExtra("parent","Semester-Time-Table");
                startActivity(intent);
            }
        });
    }


}






