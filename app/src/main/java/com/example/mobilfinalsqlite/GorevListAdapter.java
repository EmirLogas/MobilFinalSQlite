package com.example.mobilfinalsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GorevListAdapter extends ArrayAdapter<Gorev> {

    private static final String TAG = "PersonListAdapter";
    private Context mContext;
    int mResource;

    public GorevListAdapter(Context context, int resource, ArrayList<Gorev> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String gorev = getItem(position).getGorev();
        int onemDerecesi = getItem(position).getOnemDerecesi();
        int hatirlat = getItem(position).getHatirlat();

        Gorev gorev1 = new Gorev(gorev, onemDerecesi, hatirlat);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvgorev = convertView.findViewById(R.id.textView2);
        TextView tvonemDerecesi = convertView.findViewById(R.id.textView6);
        TextView tvhatirlat = convertView.findViewById(R.id.textView7);

        tvgorev.setText(gorev);
        tvonemDerecesi.setText("Önem Derecesi : " + onemDerecesi);
        tvhatirlat.setText("Hatırlatma : " + hatirlat);

        return convertView;
    }
}
