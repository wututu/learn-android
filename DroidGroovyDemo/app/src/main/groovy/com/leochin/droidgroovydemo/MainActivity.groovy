package com.leochin.droidgroovydemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import groovy.transform.CompileStatic

@CompileStatic
public class MainActivity extends AppCompatActivity {

    static final String BUNDLE_PARAM_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        def nameEditText = findViewById(R.id.name_tv) as EditText
        def sayButton = findViewById(R.id.submit_btn) as Button

        sayButton.onClickListener = {
            def intent = new Intent(this, SayHelloActivity.class)
            def content = nameEditText.text.toString()

            if(!TextUtils.isEmpty(content)) {
                intent.putExtra(BUNDLE_PARAM_NAME, content)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please Input name...", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
