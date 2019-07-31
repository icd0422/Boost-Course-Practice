package com.example.boostcoursepractice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    ImageView img;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view, this, true);

        textView = findViewById(R.id.tv);
        textView2 = findViewById(R.id.tv2) ;
        img = findViewById(R.id.img) ;
    }

    public void setName(String name)
    {
        textView.setText(name);
    }

    public void setMobile(String mobile)
    {
        textView2.setText(mobile);
    }

    public void setImg(int resID)
    {
        img.setImageResource(resID);
    }
}
