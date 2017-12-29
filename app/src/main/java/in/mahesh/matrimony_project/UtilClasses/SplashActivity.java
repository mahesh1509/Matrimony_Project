package in.mahesh.matrimony_project.UtilClasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import in.mahesh.matrimony_project.R;

/**
 * Created by mahesh on 12/11/17.
 */

public class SplashActivity extends Activity {

    private ImageView mImageViewSplash;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();

    }

    public void init(){

        mImageViewSplash= (ImageView) findViewById(R.id.imageSplash);
        mImageViewSplash.setVisibility(View.VISIBLE);

        Animation animation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.anim_alpha);
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.LinearLayout);
        linearLayout.clearAnimation();
        linearLayout.startAnimation(animation);

        animation=AnimationUtils.loadAnimation(SplashActivity.this,R.anim.translate);

        mImageViewSplash.clearAnimation();

        mImageViewSplash.startAnimation(animation);




        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent=new Intent(SplashActivity.this,WelcomeActivity.class);
                startActivity(intent);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



       /* @Override
        public void onBackPressed() {
            super.onBackPressed();
        }


*/
/*
        @Override
        public void onBackPressed() {
            this.finish();
        }*/


        /*finish();*/


    }


}


