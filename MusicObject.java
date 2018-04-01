package com.example.eboard.myapplication;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import static android.graphics.Bitmap.CompressFormat.PNG;

public class MusicObject
{
    public int value;
    public char type;

    public MusicObject(int v, char t)
    {
        value = v;
        type = t;
    }

    public Bitmap convertToBitmap(Context c, int i, int x, int y, int width, int height)
    {
        Drawable image = null;
        if(type == 'n') {
            image = ContextCompat.getDrawable(c, R.drawable.note);
            //image.setAlpha(60);
        }
        else
            image = ContextCompat.getDrawable(c, R.drawable.staff);


        Bitmap result_bitmap = drawableToBitmap(image, x + i*40, y + value, width, height);
        //boolean isOK = saveBitmapToFile("Resource_test03.png", result_bitmap, PNG, 100);

        return result_bitmap;
    }


    public Bitmap drawableToBitmap(Drawable drawable, int x_pos, int y_pos, int w, int h)
    {
        Bitmap bitmap = null;
        System.out.println("W funkcji");
        if (drawable instanceof BitmapDrawable)
        {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null)
            {
                //return bitmapDrawable.getBitmap();
            }
        }
        //System.out.println("Za pierwszym ifem");
        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0)
        {
            System.out.println("If-Else = if");
            bitmap = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else
        {
            System.out.println("If-Else = else");
            System.out.println("Intrinsic width = " + drawable.getIntrinsicWidth());
            System.out.println("Intrinsic heigth = " + drawable.getIntrinsicHeight());
            //bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            bitmap = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        //drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.setBounds(x_pos, y_pos, x_pos + w, y_pos + h);
        drawable.draw(canvas);

        return bitmap;
    }


}
