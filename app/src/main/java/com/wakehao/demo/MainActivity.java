package com.wakehao.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xuhc.bar.BottomNavigationBar;
import com.xuhc.bar.BottomNavigationItemWithDot;
import com.xuhc.bar.OnDismissListener;
import com.xuhc.bar.dot.DotView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (BottomNavigationBar) findViewById(R.id.bar);
        //可动态改变item的标题
//        bar.setTitle(0,"home(99)");
        bar.showNum(0, 80);
        bar.showNum(1, 100);
       // bar.showNum(2, -2);
        bar.setNumDismissListener(new OnDismissListener() {
            @Override
            public void dismiss(DotView v, int pos) {
                Log.e("123456", "第 " + pos + " 个按钮，值为" + v.getShowNum() + " 将要消失了");
            }
        });
        bar.disMissNum(2);
        bar.setOnNavigationItemSelectedListener(new BottomNavigationBar.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull BottomNavigationItemWithDot item, int selectedPosition) {
                if (selectedPosition == 3) {

//                    startActivityForResult(new Intent(MainActivity.this,LoginActivity.class),1);
                    //用户切换item
                    bar.setItemSelected(3, true);
                    //返回false表示不响应点击事件
                    return false;
                } else return true;
            }

            @Override
            public void onNavigationItemSelectedAgain(@NonNull BottomNavigationItemWithDot item, int reSelectedPosition) {

                //连续点击了同一个reSelectedPosition位置的item
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK || requestCode != 1) return;
        //不带动画的切换item
        bar.setItemSelected(3, false);
        super.onActivityResult(requestCode, resultCode, data);
    }


    public BottomNavigationBar getBar() {
        return bar;
    }
}
