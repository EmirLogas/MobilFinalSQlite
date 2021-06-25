package com.example.mobilfinalsqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        String resim = getItem(position).getResim();
        String gorev = getItem(position).getGorev();
        int onemDerecesi = getItem(position).getOnemDerecesi();
        int hatirlat = getItem(position).getHatirlat();

        Gorev gorev1 = new Gorev(resim, gorev, onemDerecesi, hatirlat);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView tvimage = convertView.findViewById(R.id.imageView2);
        TextView tvgorev = convertView.findViewById(R.id.textView2);
        TextView tvonemDerecesi = convertView.findViewById(R.id.textView6);
        TextView tvhatirlat = convertView.findViewById(R.id.textView7);


        byte[] aes_pic = Base64.decode(resim, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(aes_pic, 0, aes_pic.length);
        tvimage.setImageBitmap(bmp);

        tvgorev.setText(gorev);
        tvonemDerecesi.setText("Önem Derecesi : " + onemDerecesi);
        if (hatirlat == 0) {
            tvhatirlat.setText("Hatırlatma : " + "Kapalı");
        } else if (hatirlat == 1) {
            tvhatirlat.setText("Hatırlatma : " + "Açık");
        }


        return convertView;
    }
}
