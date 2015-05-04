package lab.sodino.viewstubdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private LinearLayout mButtonLayout;
    private Button mShowButton;
    private Button mHideButton;
    private ViewStub mViewStub;

    private Button mSubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonLayout = (LinearLayout) findViewById(R.id.button_layout);
        mShowButton = (Button) findViewById(R.id.show_button);
        mHideButton = (Button) findViewById(R.id.hide_button);

        mViewStub = (ViewStub) findViewById(R.id.viewStub);
//        View vInflate = mViewStub.inflate();
        mViewStub.setOnInflateListener(new OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                Log.d(TAG, "viewStub onInflate done");
                mSubButton = (Button) inflated.findViewById(R.id.sub_button);
                mSubButton.setOnClickListener(MainActivity.this);
            }
        });

        mShowButton.setOnClickListener(this);
        mHideButton.setOnClickListener(this);
    }

    private void onShowButtonClick() {

        mViewStub.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams layParams = (LayoutParams) mButtonLayout.getLayoutParams();
        layParams.addRule(RelativeLayout.BELOW, R.id.subViewStubLayout);
        mButtonLayout.setLayoutParams(layParams);
    }

    private void onHideButtonClick() {
        mViewStub.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.show_button:
                onShowButtonClick();
                break;
            case R.id.hide_button:
                onHideButtonClick();
                break;
            case R.id.sub_button:
                Toast.makeText(this, "HAHA!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
