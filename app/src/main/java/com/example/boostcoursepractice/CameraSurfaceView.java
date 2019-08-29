package com.example.boostcoursepractice;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder holder ;
    Camera camera = null ;

    public CameraSurfaceView(Context context) {
        super(context);

        init(context);
    }

    public CameraSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context)
    {
        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
         camera = Camera.open();

         try{
             camera.setPreviewDisplay(holder);
         }catch (Exception e){
             e.printStackTrace() ;
         }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        camera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        camera.stopPreview();
        camera.release();
        camera=null;
    }

    public boolean capture(Camera.PictureCallback callback)
    {
        if(camera != null)
        {
            camera.takePicture(null, null, callback);
            return true ;
        }else{
            return false;
        }
    }
}
