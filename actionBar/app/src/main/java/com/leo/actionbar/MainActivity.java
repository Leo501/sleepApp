package com.leo.actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button jumpChildOne_bt;
    private Button jumpFullscreenActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumpChildOne_bt=(Button)findViewById(R.id.jumpChildOne_bt);
        jumpFullscreenActivity=(Button)findViewById(R.id.jumpFullscreenActivity_bt);
        jumpChildOne_bt.setOnClickListener(this);
        jumpFullscreenActivity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jumpChildOne_bt: {
                Intent intent = new Intent(MainActivity.this, LoginActivityBar.class);
                startActivity(intent);
                break;
            }
            case R.id.jumpFullscreenActivity_bt: {
                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
