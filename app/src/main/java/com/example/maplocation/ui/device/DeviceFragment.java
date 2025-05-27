package com.example.maplocation.ui.device;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.maplocation.databinding.FragmentDeviceBinding;

public class DeviceFragment extends Fragment {
    private FragmentDeviceBinding binding;
    private DeviceViewModel deviceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        deviceViewModel = new ViewModelProvider(this).get(DeviceViewModel.class);

        binding = FragmentDeviceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDevice;
        deviceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}