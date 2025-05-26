package com.example.maplocation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.example.maplocation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MapView mapView;
    private TencentMap mTencentMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 初始化地图
        mapView = binding.mapView;  // 使用与layout中一致的ID
        if (mapView != null) {
            // 不需要调用onCreate，MapView会自动处理生命周期
            mTencentMap = mapView.getMap();

            // 设置地图中心点
            if (mTencentMap != null) {
                LatLng latLng = new LatLng(39.984059, 116.307621);
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(latLng);
                mTencentMap.moveCamera(cameraUpdate);
            }
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mapView != null) {
            mapView.onDestroy();
        }
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mapView != null) {
            mapView.onPause();
        }
    }
}