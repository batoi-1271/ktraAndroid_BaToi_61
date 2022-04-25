package com.example.batoi_61;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class batoi_Adapter extends ArrayAdapter<batoi_vanTai> {
    private Context context;
    private int resource;
    private List<batoi_vanTai> vatTaiList;

    public batoi_Adapter(Context context, int resource, List<batoi_vanTai> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.vatTaiList = objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item_list_vt,parent,false);
            viewHodel = new ViewHodel();
            viewHodel.tvId = (TextView) convertView.findViewById(R.id.tvId);
            viewHodel.tvBKS = (TextView) convertView.findViewById(R.id.tvBKS);
            viewHodel.tvTenCX = (TextView) convertView.findViewById(R.id.tvtenCX);
            viewHodel.tvHangxe = (TextView) convertView.findViewById(R.id.tvHangxe);
            viewHodel.tvTrongtai = (TextView) convertView.findViewById(R.id.tvTrongtai);
            viewHodel.tvHTKD = (TextView) convertView.findViewById(R.id.tvHTKD);

            convertView.setTag(viewHodel);
        }
        else
            viewHodel = (ViewHodel) convertView.getTag();
        batoi_vanTai vatai = vatTaiList.get(position);
        viewHodel.tvId.setText(String.valueOf(vatai.getId()));
        viewHodel.tvBKS.setText("BKS: "+ vatai.getBks());
        viewHodel.tvTenCX.setText("Ten chu xe: "+ vatai.getTenchuxe());
        viewHodel.tvHangxe.setText("Hang xe: "+ vatai.getHangxe());
        viewHodel.tvTrongtai.setText("Trong tai: "+ vatai.getTrongtai());
        viewHodel.tvHTKD.setText("HTKD: "+ vatai.getHtkinhdoanh());


        return convertView;
    }
    class ViewHodel{
        private TextView tvId, tvBKS, tvTenCX, tvHangxe, tvTrongtai, tvHTKD;
    }
}
