package com.example.imageload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.net.URL;

public class ImageLoadTask extends AsyncTask<Void,Void, Bitmap> {
    private String getUrl;
    private ImageView imageView;
    public ImageLoadTask(String url,ImageView imageView){
        this.getUrl = url;
        this.imageView = imageView;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(getUrl);
            Log.e("e",url+"");
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            Log.e("d",bitmap+"");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        imageView.invalidate();
    }

}
