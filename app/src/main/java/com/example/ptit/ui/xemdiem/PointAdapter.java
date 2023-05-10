package com.example.ptit.ui.xemdiem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptit.R;
import com.example.ptit.model.Point;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointViewHolder> {
    private List<List<Point>> pointLists;
    private PointHKAdapter pointHKAdapter;
    private List<List<Point>> list = new ArrayList<>();

    public PointAdapter(List<List<Point>> pointLists) {
        this.pointLists = pointLists;
    }

    @Override
    public PointViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.point_hk,parent, false);
        return new PointViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PointViewHolder holder, int position) {
        List<Point> points = pointLists.get(position);
        list.add(points);
        pointHKAdapter = new PointHKAdapter(points);
        holder.point_list.setAdapter(pointHKAdapter);
        holder.numHK.setText("Học kỳ "+ points.get(1).getHocKy());
        holder.tbHK.setText("Điểm trung bình học kỳ hệ 4:     " + tbHK(points));
        holder.GPA.setText("Điểm trung bình tích lũy (hệ 4): "+GPA(list));
    }

    private String GPA(List<List<Point>> list) {
        int sumCredits = 0;
        Float sumPoints = 0.0F;
        for(List<Point> points:list){
            for (Point point : points) {
                int credit = point.getCredits();
                if(credit > 1){
                    sumCredits += credit;

                    Float pointValue = 0.0F;
                    switch (point.getTKChu()) {
                        case "A+":
                            pointValue = 4.0F;
                            break;
                        case "A":
                            pointValue = 3.7F;
                            break;
                        case "B+":
                            pointValue = 3.5F;
                            break;
                        case "B":
                            pointValue = 3.0F;
                            break;
                        case "C+":
                            pointValue = 2.5F;
                            break;
                        case "C":
                            pointValue = 2.0F;
                            break;
                        case "D":
                            pointValue = 1.0F;
                            break;
                        case "F":
                            pointValue = 0.0F;
                            break;
                    }
                    sumPoints += pointValue * credit;
                }
            }
        }
        String GPA = String.format("%.2f", sumPoints/sumCredits);
        return GPA;
    }

    private String tbHK(List<Point> points) {
        int sumCredits = 0;
        Float sumPoints = 0.0F;
        for (Point point : points) {
            int credit = point.getCredits();
            if(credit > 1){
                sumCredits += credit;

                Float pointValue = 0.0F;
                switch (point.getTKChu()) {
                    case "A+":
                        pointValue = 4.0F;
                        break;
                    case "A":
                        pointValue = 3.7F;
                        break;
                    case "B+":
                        pointValue = 3.5F;
                        break;
                    case "B":
                        pointValue = 3.0F;
                        break;
                    case "C+":
                        pointValue = 2.5F;
                        break;
                    case "C":
                        pointValue = 2.0F;
                        break;
                    case "D":
                        pointValue = 1.0F;
                        break;
                    case "F":
                        pointValue = 0.0F;
                        break;
                }

                sumPoints += pointValue * credit;
            }
        }
        String pointTB = String.format("%.2f", sumPoints/sumCredits);
        return pointTB;
    }
    public void setList(List<List<Point>> list_point){
        pointLists = list_point;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return pointLists.size();
    }
}
class PointViewHolder extends RecyclerView.ViewHolder{
    RecyclerView point_list;
    TextView numHK,tbHK, GPA;
    public PointViewHolder(View itemView) {
        super(itemView);
        numHK = itemView.findViewById(R.id.numHK);
        point_list = itemView.findViewById(R.id.point_list);
        point_list.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        tbHK = itemView.findViewById(R.id.tbHK);
        GPA = itemView.findViewById(R.id.GPA);
    }
}
