package com.example.baobao.thigiuakicustomlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BaoBao on 4/15/2018.
 */

public class Adapter_SinhVien extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<SinhVien> arrayList;
    public Adapter_SinhVien(@NonNull Context context, int resource, @NonNull ArrayList<SinhVien> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource,null);


        TextView hoten = convertView.findViewById(R.id.txtHoTen);
        TextView sdt = convertView.findViewById(R.id.txtSdt);
        TextView diachi = convertView.findViewById(R.id.txtDiaChi);


        SinhVien sv = arrayList.get(position);
        hoten.setText(sv.getHoten());
        sdt.setText(sv.getSdt());
        diachi.setText(sv.getDiachi());

        return convertView;
    }
}
