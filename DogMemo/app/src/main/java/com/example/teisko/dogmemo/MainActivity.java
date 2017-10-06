package com.example.teisko.dogmemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import static com.example.teisko.dogmemo.R.id.ballShape;

// tutki https://stackoverflow.com/questions/5123407/losing-data-when-rotate-screen

public class MainActivity extends AppCompatActivity {

    private TextView numberOfTouches;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);

        numberOfTouches = (TextView) findViewById(R.id.numberOfTouches);
        numberOfTouches.setVisibility(View.INVISIBLE);

        TextView ballShape = (TextView) findViewById(R.id.ballShape);
        ballShape.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ballShapeOnClick(findViewById(R.id.ballShape));
                }
                /*else if (event.getAction() == MotionEvent.ACTION_UP) {
                }*/
                return false;
            }
        });
    }

    public void ballShapeOnClick(View view) {
        numberOfTouches.setVisibility(View.VISIBLE);
        number = Integer.parseInt(numberOfTouches.getText().toString()) + 1;
        numberOfTouches.setText("" + number);
    }
}
