package com.example.ptit.ui.xemdiem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptit.Database.PointDB;
import com.example.ptit.LoginActivity;
import com.example.ptit.databinding.FragmentHomeBinding;
import com.example.ptit.databinding.FragmentXemdiemBinding;
import com.example.ptit.model.Point;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DiemFragment extends Fragment {

    private FragmentXemdiemBinding binding;
    private RecyclerView list_point;
    private PointAdapter pointAdapter;
    PointDB pointDB;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentXemdiemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        list_point = binding.points;
        list_point.setLayoutManager(new LinearLayoutManager(getContext()));
        pointDB = new PointDB(getContext());
        List<List<Point>> pointList = new ArrayList<>();
        //lấy dữ liệu điểm theo học kỳ
        int cnt = pointDB.getMaxHocKy();
        for (int i=1;i<=cnt;i++){
            List<Point> points = pointDB.getPointBySemester(i);
            pointList.add(points);
        }
        System.out.println("Số học kỳ: "+pointList.size());
        for (List<Point> i:pointList){
            System.out.println("Point :"+i);
        }
        pointAdapter = new PointAdapter(pointList);
        list_point.setAdapter(pointAdapter);
        binding.btnSearch.setOnClickListener(v -> {
            if(!TextUtils.isEmpty(binding.HKKey.getText().toString())){
                List<List<Point>> pointLists = new ArrayList<>();
                List<Point> points = pointDB.getPointBySemester(Integer.parseInt(binding.HKKey.getText().toString()));
                pointLists.add(points);
                pointAdapter.setList(pointLists);
            }else{
                List<List<Point>> pointLists = new ArrayList<>();
                //lấy dữ liệu điểm theo học kỳ
                int cnt1 = pointDB.getMaxHocKy();
                for (int i=1;i<=cnt1;i++){
                    List<Point> points = pointDB.getPointBySemester(i);
                    pointLists.add(points);
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}