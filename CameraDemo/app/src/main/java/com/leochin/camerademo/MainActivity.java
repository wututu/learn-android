package com.leochin.camerademo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_CAPTURE_CODE = 1;
    private final static int REQUEST_CROP_CODE = 2;
    @Bind(R.id.camera) Button mCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.camera)
    public void camera(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(cameraIntent.resolveActivity(getPackageManager()) != null) {
            File imageFile = null;
            try {
                imageFile = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (imageFile != null) {
                /*
                加上改参数后，onActivityResult()的intent可能返回为null
                 */
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
                startActivityForResult(cameraIntent, REQUEST_CAPTURE_CODE);
            }
        }
    }

    private String mCurrentPhotoPath;
    private File createImageFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "IMG_" + timeStamp;
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    /**
     *
     * @param path 为图片存储的绝对路径
     */
    private void galleryAddPic(String path) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.fromFile(new File(path)));
        this.sendBroadcast(mediaScanIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAPTURE_CODE:
                    cropImage(Uri.fromFile(new File(mCurrentPhotoPath)), 600, 600, REQUEST_CROP_CODE);
                    break;
                case REQUEST_CROP_CODE:
                    galleryAddPic(mCurrentPhotoPath);
                    Intent intent = new Intent(this, CameraActivity.class);
                    intent.putExtra("path", mCurrentPhotoPath);
                    startActivity(intent);
                    break;
            }
        }
    }

    private void cropImage(Uri uri, int outputX,int outputY, int requestCode) {
        Intent intent = new Intent("com.android.camera.action.CROP"); //裁剪图片
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        /* 裁剪框的比例，1：1 */
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        /* 裁剪后输出图片的尺寸大小 */
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra("scaleUpIfNeeded", true);//黑边
        intent.putExtra("outputFormat", "JPEG");//图片格式
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("output", uri);
        intent.putExtra("return-data", false);
        startActivityForResult(intent, requestCode);
    }

}
