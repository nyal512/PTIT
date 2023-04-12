package com.example.ptit.ui.xemdiem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.ptit.databinding.FragmentXemdiemBinding;

public class DiemFragment extends Fragment {

    private FragmentXemdiemBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentXemdiemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}