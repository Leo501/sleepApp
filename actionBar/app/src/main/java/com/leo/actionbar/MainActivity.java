package com.leo.actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button jumpChildOne_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumpChildOne_bt=(Button)findViewById(R.id.jumpChildOne_bt);
        jumpChildOne_bt.setOnClickListener(listener);
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,LoginActivityBar.class);
            startActivity(intent);

        }
    };
}
