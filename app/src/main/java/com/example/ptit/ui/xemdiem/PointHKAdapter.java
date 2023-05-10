package com.example.ptit.ui.xemdiem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptit.Database.PointDB;
import com.example.ptit.R;
import com.example.ptit.model.Point;

import java.util.List;

public class PointHKAdapter extends RecyclerView.Adapter<PointHKViewHolder> {
    private List<Point> points;
    private PointDB pointDB;
    int index = 0;

    public PointHKAdapter(List<Point> points) {
        this.points = points;
    }

    @Override
    public PointHKViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_point_item,parent, false);
        return new PointHKViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PointHKViewHolder holder, int position) {
        Point point =points.get(position);
        pointDB = new PointDB(holder.itemView.getContext());
        index = index + 1;
        holder.stt.setText(""+index);
        holder.subjectCode.setText(""+point.getSubjectCode());
        holder.subjectName.setText(""+point.getSubjectName());
        holder.credits.setText(""+point.getCredits());
        holder.ptCC.setText(""+point.getPtCC());
        holder.ptKT.setText(""+point.getPtKT());
        holder.ptTH.setText(""+point.getPtTH());
        holder.ptBT.setText(""+point.getPtBT());
        holder.ptThi.setText(""+point.getPtThi());
        holder.CC.setText(""+point.getCC());
        holder.KT.setText(""+point.getKT());
        holder.TH.setText(""+point.getTH());
        holder.BT.setText(""+point.getBT());
        holder.ThiL1.setText(""+point.getThiL1());
        holder.ThiL2.setText(""+point.getThiL2());
        holder.TK10.setText(""+point.getTK10());
        holder.TKChu.setText(""+point.getTKChu());
        holder.KQ.setText(""+point.getKQ());
    }

    @Override
    public int getItemCount() {
        return points.size();
    }
}
 class PointHKViewHolder extends RecyclerView.ViewHolder{
    TextView stt, subjectCode, subjectName, credits;
    TextView ptCC, ptKT, ptTH, ptBT, ptThi;
    TextView CC, KT, TH, BT, ThiL1, ThiL2;
    TextView TK10, TKChu, KQ;
    public PointHKViewHolder(View itemView) {
        super(itemView);
        stt = itemView.findViewById(R.id.stt);
        subjectCode = itemView.findViewById(R.id.subjectCode);
        subjectName = itemView.findViewById(R.id.subjectName);
        credits = itemView.findViewById(R.id.credits);
        ptCC = itemView.findViewById(R.id.ptCC);
        ptKT = itemView.findViewById(R.id.ptKT);
        ptTH = itemView.findViewById(R.id.ptTH);
        ptBT = itemView.findViewById(R.id.ptBT);
        ptThi = itemView.findViewById(R.id.ptThi);
        CC = itemView.findViewById(R.id.CC);
        KT = itemView.findViewById(R.id.KT);
        TH = itemView.findViewById(R.id.TH);
        BT = itemView.findViewById(R.id.BT);
        ThiL1 = itemView.findViewById(R.id.ThiL1);
        ThiL2 = itemView.findViewById(R.id.ThiL2);
        TK10 = itemView.findViewById(R.id.TK10);
        TKChu = itemView.findViewById(R.id.TKChu);
        KQ = itemView.findViewById(R.id.KQ);
    }
}