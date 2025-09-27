package com.example.pvgcoet.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.pvgcoet.databinding.FragmentDashboardBinding;
import com.example.pvgcoet.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private ProgressBar mainProgressBar;
    private FragmentHomeBinding binding;
    private CardView attendance;
    private View dashboardView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        // Inflate the fragment_home layout using View Binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainProgressBar = binding.progressBar;
        attendance = binding.attendanceCard;

        Handler handler = new Handler();
        handler.post(new Runnable() {
            int overall = 70;
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

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateDashboardFragment();
            }
        });
    }

    private void inflateDashboardFragment() {
        // Inflate the fragment_dashboard layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        FragmentDashboardBinding dashboardBinding = FragmentDashboardBinding.inflate(inflater, binding.getRoot(), false);
        dashboardView = dashboardBinding.getRoot();

        // Add the inflated dashboard layout to the root of fragment_home
        ConstraintLayout homeLayout = (ConstraintLayout) binding.getRoot();

        // Check if a previous dashboardView exists and remove it
        if (dashboardView.getParent() != null) {
            ((ViewGroup) dashboardView.getParent()).removeView(dashboardView);
        }

        homeLayout.addView(dashboardView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
