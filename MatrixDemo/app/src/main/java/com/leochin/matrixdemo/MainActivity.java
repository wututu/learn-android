package com.leochin.matrixdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    private TransformMatrixView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new TransformMatrixView(this);
        view.setScaleType(ImageView.ScaleType.MATRIX);
        view.setOnTouchListener(this);
        setContentView(view);
    }

    private void println(Matrix matrix) {
        // 下面的代码是为了查看matrix中的元素
        float[] values = new float[9];
        matrix.getValues(values);

        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += values[3 * i + j] + "\t";
            }
            Log.e("wenhao", temp);
        }
    }

    private void translate(Matrix matrix) {
        // 1. 平移
        matrix.postTranslate(view.getImageBitmap().getWidth(), view.getImageBitmap().getHeight());
        // 在x方向平移view.getImageBitmap().getWidth()，在y轴方向view.getImageBitmap().getHeight()
        view.setImageMatrix(matrix);
    }

    private void rotate(Matrix matrix) {
        // 2. 旋转(围绕图像的中心点)
        matrix.setRotate(45f, view.getImageBitmap().getWidth() / 2f, view.getImageBitmap().getHeight() / 2f);

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth() * 1.5f, 0f);
        view.setImageMatrix(matrix);
    }

    private void rotate2(Matrix matrix) {
        // 3. 旋转(围绕坐标原点) + 平移(效果同2)
        matrix.setRotate(45f);
        matrix.preTranslate(-1f * view.getImageBitmap().getWidth() / 2f, -1f * view.getImageBitmap().getHeight() / 2f);
        matrix.postTranslate((float) view.getImageBitmap().getWidth() / 2f, (float) view.getImageBitmap().getHeight() / 2f);

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate((float) view.getImageBitmap().getWidth() * 1.5f, 0f);
        view.setImageMatrix(matrix);
    }

    private void scale(Matrix matrix) {
        // 4. 缩放
        matrix.setScale(2f, 2f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao scale", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth(), view.getImageBitmap().getHeight());
        view.setImageMatrix(matrix);
    }

    private void skew(Matrix matrix) {
        // 5. 错切 - 水平
        matrix.setSkew(0.5f, 0f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao skew ", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth(), 0f);
        view.setImageMatrix(matrix);
    }

    private void skew2(Matrix matrix) {
        // 6. 错切 - 垂直
        matrix.setSkew(0f, 0.5f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao skew2 ", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(0f, view.getImageBitmap().getHeight());
        view.setImageMatrix(matrix);
    }

    private void skew3(Matrix matrix) {
        //          7. 错切 - 水平 + 垂直
        matrix.setSkew(0.5f, 0.5f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao skew3 ", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(0f, view.getImageBitmap().getHeight());
        view.setImageMatrix(matrix);
    }

    private void horizontal(Matrix matrix) {
        // 8. 对称 (水平对称)
        float matrix_values[] = {1f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrix_values);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao horizontal ", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(0f, view.getImageBitmap().getHeight() * 2f);
        view.setImageMatrix(matrix);
    }

    private void vertical(Matrix matrix) {
        // 9. 对称 - 垂直
        float matrix_values[] = {-1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrix_values);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao vertial ", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth() * 2f, 0f);
        view.setImageMatrix(matrix);
    }

    private void hv(Matrix matrix) {
        // 10. 对称(对称轴为直线y = x)
        float matrix_values[] = {0f, -1f, 0f, -1f, 0f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrix_values);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e("wenhao hr", temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getHeight() + view.getImageBitmap().getWidth(),
                view.getImageBitmap().getHeight() + view.getImageBitmap().getWidth());
        view.setImageMatrix(matrix);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Matrix matrix = new Matrix();
            // 输出图像的宽度和高度(162 x 251)
            Log.e("wenhao", "image size: width x height = " + view.getImageBitmap().getWidth() + " x " + view.getImageBitmap().getHeight());

//            translate(matrix);
//            rotate(matrix);
//            rotate2(matrix);
//            scale(matrix);
//            skew3(matrix);
//            horizontal(matrix);
            vertical(matrix);
//            hv(matrix);

            println(matrix);
            view.invalidate();
        }
        return true;
    }

    class TransformMatrixView extends ImageView {
        private Bitmap bitmap;
        private Matrix matrix;

        public TransformMatrixView(Context context) {
            super(context);
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            matrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // 画出原图像
            canvas.drawBitmap(bitmap, 0, 0, null);
            // 画出变换后的图像
            canvas.drawBitmap(bitmap, matrix, null);
            super.onDraw(canvas);
        }

        @Override
        public void setImageMatrix(Matrix matrix) {
            this.matrix.set(matrix);
            super.setImageMatrix(matrix);
        }

        public Bitmap getImageBitmap() {
            return bitmap;
        }
    }

}
