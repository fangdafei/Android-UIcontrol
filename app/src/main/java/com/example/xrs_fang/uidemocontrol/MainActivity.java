package com.example.xrs_fang.uidemocontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ////实例化创建radioGroup
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        //绑定匿名监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //根据ID获取RadioButton实例
                RadioButton rb = MainActivity.this.findViewById(i);

                Toast.makeText(MainActivity.this, getResources().getString(R.string.text_title)+rb.getText(), Toast.LENGTH_SHORT).show();

            }
        });

        //实例化创建checkbox
        CheckBox cb = (CheckBox)findViewById(R.id.checkobx1);
        //绑定匿名监听器
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if (b){//选中
                   Toast.makeText(MainActivity.this, R.string.checkBoxSelect, Toast.LENGTH_SHORT).show();
               }else {//取消选中
                   Toast.makeText(MainActivity.this, R.string.disSelect, Toast.LENGTH_SHORT).show();
               }
           }
       });


        //ImageView实例化
        ImageView imageV = (ImageView)findViewById(R.id.imageV);
        //设置图片
        imageV.setImageResource(R.drawable.test2);


        final TextView textV = (TextView)findViewById(R.id.textv);//从内部类中访问本地变量textV; 需要被声明为最终类型
        //SeekBar
        SeekBar seekB = (SeekBar)findViewById(R.id.seekbar1);
        //绑定监听器
        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //正在拖动  %比
                String str = MainActivity.this.getResources().getString(R.string.seekBar1);
                String strP = MainActivity.this.getResources().getString(R.string.seekBar2);
                textV.setText(str+i+strP);//当前进度：100%
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //开始拖动
                Log.e("tag", "onStartTrackingTouch:");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //停止拖动
                Log.e("tag", "onStopTrackingTouch: ");
            }
        });




    }

    //点击按钮
    public void buttonC1(View view)
    {
        Log.e("tag", "buttonClick: 点击了按钮");
        Toast.makeText(this, R.string.ToastText, Toast.LENGTH_SHORT).show();
    }
    
    
    //点击图片
    public void imagevbtn(View v){
        //设置弹窗位置
        Toast toast = Toast.makeText(this, "点击了图片", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,20);
        toast.show();

    }




}
