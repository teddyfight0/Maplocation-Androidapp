package com.example.maplocation.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

// Import CameraUpdateFactory
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.example.maplocation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MapView mapView;
    private TencentMap tencentMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 初始化 ViewModel
        HomeViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        binding.textHome.setText(homeViewModel.getText().getValue()); // 直接设置初始值
        homeViewModel.getText().observe(getViewLifecycleOwner(), binding.textHome::setText);

        // 初始化 MapView
        mapView = binding.mapView;
        tencentMap = mapView.getMap();

        // 设置地图中心点（以北京为例）
        LatLng center = new LatLng(39.9042, 116.4074); // 北京坐标
        // Use moveCamera to set center and zoom
        tencentMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 12)); // 设置缩放级别

        // 添加一个标记点
        MarkerOptions markerOptions = new MarkerOptions()
                .position(center)
                .title("北京")
                .snippet("欢迎使用腾讯地图！");
        Marker marker = tencentMap.addMarker(markerOptions);
        marker.showInfoWindow();

        // 打印日志确认 SDK 初始化
        Log.d("TencentMap", "Tencent Map SDK initialized successfully in HomeFragment");


        return root;
    }

    // MapView 生命周期管理
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
        binding = null;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 将 Fragment 的 outState Bundle 传递给 MapView
    }
}