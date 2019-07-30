package com.example.boostcoursepractice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class BitmapButton extends AppCompatButton {

    public BitmapButton(Context context) {
        super(context);

        init(context) ;
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context) ;
    }

    private void init(Context context)
    {
        setBackgroundResource(R.drawable.ic_kakao);

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction() ;

        switch (action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.ic_facebook);
                break ;

            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.ic_kakao);
                break;

        }

        invalidate();

        return true ;
    }
}
