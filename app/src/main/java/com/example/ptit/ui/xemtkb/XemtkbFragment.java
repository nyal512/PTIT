package com.example.ptit.ui.xemtkb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.ptit.databinding.FragmentXemtkbBinding;


public class XemtkbFragment extends Fragment {

    private FragmentXemtkbBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        XemtkbViewModel dashboardViewModel =
                new ViewModelProvider(this).get(XemtkbViewModel.class);

        binding = FragmentXemtkbBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}