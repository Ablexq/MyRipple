package org.lenve.rippledrawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btn1;
    private TextView tv;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListener();
    }

    private void setListener() {
        //属性动画
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //缩放X 轴的
                ObjectAnimator revealAnimator = ObjectAnimator.ofFloat(tv, "scaleX", 0, 1);
                //缩放Y 轴的
                ObjectAnimator revealAnimator1 = ObjectAnimator.ofFloat(tv, "scaleY", 0, 1);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(1000);//设置播放时间
                set.setInterpolator(new LinearInterpolator());//设置播放模式，这里是平常模式
                set.playTogether(revealAnimator, revealAnimator1);//设置一起播放
                set.start();
            }
        });

        //揭露动画
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        btn,//作用在哪个View上面
                        btn.getWidth() / 2, btn.getHeight() / 2,//扩散的中心点
                        0,//开始扩散初始半径
                        btn.getHeight());//扩散结束半径
                animator.setDuration(1000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();
            }
        });

        //揭露动画
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        btn1,//作用于view
                        0, 0, //扩散中心点：左上角
                        0,//扩散开始半径
                        (float) Math.hypot(btn1.getWidth(), btn1.getHeight()));//结束半径
                animator.setDuration(1000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onClick(View v) {
//                系统默认
//                必须在 StartActivity() 或 finish() 之后立即调用；而且在 2.1 以上版本有效
                Intent intent = new Intent(MainActivity.this, MainActivityI.class);
                startActivity(intent);
//                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                overridePendingTransition(R.anim.slide_bottom_in, R.anim.slide_top_out);

//                不共享元素
//                ActivityOptionsCompat.makeSceneTransitionAnimation();
//                ActivityOptionsCompat.makeThumbnailScaleUpAnimation()
//                ActivityOptionsCompat.makeCustomAnimation()
//                ActivityOptionsCompat.makeScaleUpAnimation()
//                ActivityOptionsCompat.makeClipRevealAnimation()
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this);
//                Intent intent = new Intent(MainActivity.this, MainActivityI.class);
//                startActivity(intent, optionsCompat.toBundle());

//                //让新的Activity从一个小的范围(比如第一个activity的一个按钮)扩大到全屏
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(btn2,
//                        btn2.getWidth() / 2, btn2.getHeight() / 2, //拉伸开始的坐标
//                        0, 0);//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
//                Intent intent = new Intent(MainActivity.this, MainActivityI.class);
//                startActivity(intent, options.toBundle());

                //类似于：overridePendingTransition(R.anim.slide_bottom_in, R.anim.slide_bottom_out);
                //还不如直接用这个全版本的overridePendingTransition
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(MainActivity.this,
//                        R.anim.slide_bottom_in, R.anim.slide_bottom_out);
//                Intent intent = new Intent(MainActivity.this, MainActivityI.class);
//                startActivity(intent, options.toBundle());

//                共享一个元素
//                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, btn2, "mybtn1").toBundle();
//                Intent intent = new Intent(MainActivity.this, MainActivityI.class);
//                startActivity(intent, bundle);

//                共享多个元素
//                Bundle bundle = ActivityOptions
//                        .makeSceneTransitionAnimation(MainActivity.this,
//                          Pair.create(((View) btn2), "mybtn1"),
//                          Pair.create(((View) btn3), "mybtn2"))
//                        .toBundle();
//                Intent intent = new Intent(MainActivity.this, MainActivityI.class);
//                startActivity(intent, bundle);

            }
        });
    }

    private void findViews() {
        btn = (Button) findViewById(R.id.btn);
        btn1 = (Button) findViewById(R.id.btn1);
        tv = (TextView) findViewById(R.id.tv);
        btn2 = ((Button) findViewById(R.id.btn2));
        btn3 = ((Button) findViewById(R.id.btn3));
    }
}
