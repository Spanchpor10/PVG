package com.example.pvgcoet.ui.dashboard;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pvgcoet.databinding.FragmentDashboardBinding;
import com.example.pvgcoet.databinding.FragmentHomeBinding;
import com.example.pvgcoet.ui.home.HomeViewModel;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ProgressBar mainProgressBar;
    private ProgressBar progressBar_sub1;
    private ProgressBar progressBar_sub2;
    private ProgressBar progressBar_sub3;
    private ProgressBar progressBar_sub4;
    private ProgressBar progressBar_sub5;
    private ProgressBar progressBar_sub6;
    private TextView subject1;
    private TextView subject2;
    private TextView subject3;
    private TextView subject4;
    private TextView subject5;
    private TextView subject6;

    private TextView sub1_number;
    private TextView sub2_number;
    private TextView sub3_number;
    private TextView sub4_number;
    private TextView sub5_number;
    private TextView sub6_number;
    private TextView overall_number;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mainProgressBar = binding.mainprogressbar;
        progressBar_sub1=binding.progressSub1;
        progressBar_sub2=binding.progressSub2;
        progressBar_sub3=binding.progressSub3;
        progressBar_sub4=binding.progressSub4;
        progressBar_sub5=binding.progressSub5;
        progressBar_sub6=binding.progressSub6;


        subject1=binding.subject1;
        subject2=binding.subject2;
        subject3=binding.subject3;
        subject4=binding.subject4;
        subject5=binding.subject5;
        subject6=binding.subject6;

        subject1.setText("TOC");
        subject2.setText("SPOS");
        subject3.setText("IOT");
        subject4.setText("HCI");
        subject5.setText("CNS");
        subject6.setText("DBMS");

        sub1_number=binding.sub1Number;
        sub2_number=binding.sub2Number;
        sub3_number=binding.sub3Number;
        sub4_number=binding.sub4Number;
        sub5_number=binding.sub5Number;
        sub6_number=binding.sub6Number;
        overall_number=binding.overallnumber;

        int sub1=(87*100)/100;
        int sub2=(45*100)/100;
        int sub3=(32*100)/100;
        int sub4=(21*100)/100;
        int sub5=(90*100)/100;
        int sub6=(45*100)/100;
        int overall=(sub1+sub2+sub3+sub4+sub5+sub6)/6;

        float sub1Avg=(sub1*100)/56;
        sub1_number.setText(sub1+"%");
        sub2_number.setText(sub2+"%");
        sub3_number.setText(sub3+"%");
        sub4_number.setText(sub4+"%");
        sub5_number.setText(sub5+"%");
        sub6_number.setText(sub6+"%");
        overall_number.setText(overall+"%");


        final Handler handler = new Handler(Looper.myLooper());
        handler.post(new Runnable() {



            int progress = 0;
            @Override
            public void run() {
                if (progress < overall) {
                    progress++;
                    mainProgressBar.setProgress(progress);
                    handler.postDelayed(this, 30);
                }

            }
        });




        handler.post(new Runnable() {
            int progress = 0;


            @Override
            public void run() {
                progressBar_sub1.setProgress(progress);
                if (progress < sub1) {
                    progress++;
                    handler.postDelayed(this, 30); // Delay in milliseconds
                }
            }
        });




        handler.post(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                progressBar_sub2.setProgress(progress);
                if (progress < sub2) {
                    progress++;
                    handler.postDelayed(this, 30); // Delay in milliseconds
                }
            }
        });



        handler.post(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                progressBar_sub3.setProgress(progress);
                if (progress < sub3) {
                    progress++;
                    handler.postDelayed(this, 30); // Delay in milliseconds
                }
            }
        });


        handler.post(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                progressBar_sub4.setProgress(progress);
                if (progress < sub4) {
                    progress++;
                    handler.postDelayed(this, 30); // Delay in milliseconds
                }
            }
        });


        handler.post(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                progressBar_sub5.setProgress(progress);
                if (progress < sub5) {
                    progress++;
                    handler.postDelayed(this, 30); // Delay in milliseconds
                }
            }
        });


        handler.post(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                progressBar_sub6.setProgress(progress);
                if (progress < sub6) {
                    progress++;
                    handler.postDelayed(this, 30); // Delay in milliseconds
                }
            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}