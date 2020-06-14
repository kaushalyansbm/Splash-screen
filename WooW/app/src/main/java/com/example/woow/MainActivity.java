package com.example.woow;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    public static  int splash_time=5000;
    Animation top;
    Animation bottom;
    Animation mid;

    TextView midle,botom;
    ImageView im,im2;
    long du=2300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        top= AnimationUtils.loadAnimation(this,R.anim.anim_top);
        bottom= AnimationUtils.loadAnimation(this,R.anim.anim_bottom);
        mid= AnimationUtils.loadAnimation(this,R.anim.anim_middle);

        im=findViewById(R.id.i6);
        midle=findViewById(R.id.t1);
        botom=findViewById(R.id.t2);
        im2=(ImageView) findViewById(R.id.i6);



        im.setAnimation(top);
        midle.setAnimation(mid);
        botom.setAnimation(bottom);

        ObjectAnimator rotate=ObjectAnimator.ofFloat(im2,"rotation",0f,180f);
        rotate.setDuration(du);
        AnimatorSet as=new AnimatorSet();
        as.playTogether(rotate);
        as.start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent sec=new Intent(MainActivity.this,login.class);
                startActivity(sec);
                finish();
            }
        },splash_time);




    }
}
