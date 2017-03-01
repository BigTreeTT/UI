package com.example.longteng.androidui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private ImageView imageView1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animotion);
        imageView = (ImageView) findViewById(R.id.picture);
        imageView1 = (ImageView) findViewById(R.id.picture1);
        button = (Button) findViewById(R.id.startAnimation);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.startAnimation){
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.picture_enter);
            imageView.startAnimation(animation);

            Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.picture_exit);
            imageView1.startAnimation(animation1);

            Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.button_rotate);
            button.startAnimation(animation2);
        }
    }
}
