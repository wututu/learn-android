package com.leochin.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wenhao on 8/19/15.
 */
public class CameraActivity extends AppCompatActivity {

    private String path;
    @Bind(R.id.image)
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);

        getIntentData();
        setImage();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            path = intent.getStringExtra("path");
        }
    }

    private void setImage() {
        if (!TextUtils.isEmpty(path)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; //samsung 需要添加该选项，才能显示
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            if (bitmap != null) {
                mImage.setImageBitmap(bitmap);
            }
        }
    }
}
