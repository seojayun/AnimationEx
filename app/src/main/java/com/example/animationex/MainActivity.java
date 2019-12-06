package com.example.animationex;
//교과서 없는 내용 :gif 이미지를 적용시키기
// 1. dependencies -> library dependency -> 검색창에 com.github.bumptech.glide:glide:3.7.0 입력 후 확인
//4. res 폴더에서 오른쪽 마우스 클릭 new  - > new Resource Directory 로 폴더 생성(anim 설정)      anim 오른쪽 마우스 클릭 - > new Animation Resource File 로 xml 2개 생성(in.xml/move.xml)   ->in.xml이동
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {

    ImageView iv1;
    Animation animation,animation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1=(ImageView)findViewById(R.id.iv1);
//        GlideDrawableImageViewTarget glideD = new GlideDrawableImageViewTarget(iv1);  //2.  GlideDrawableImageViewTarget 변수 선언 후 생성
        Glide.with(this).load(R.drawable.puma).into(iv1);  //3.이미지를 적용시켜준다.


        animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.in);
        iv1.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(getApplicationContext(),"움직이는 고양이를 눌러주세요",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation1=AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
                animation.setFillAfter(true);
                iv1.startAnimation(animation1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
