package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup myradioGroup;
    private TextView show;
    private Button btn1;
    private String choose;//记录选择的奶茶种类，默认是珍珠奶茶
    private CheckBox y;
    private CheckBox b;
    private CheckBox h;
    private LinearLayout Layout1;
    private EditText edittext;
    private String add = new String();//记录添加的配料
    private String inputText;//记录备注
    private SeekBar seekBar;
    private String seekprograss;//记录甜度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkbox，选择添加的配料
        iniView();

        //编辑框填入备注
        iniedit();

        //奶茶种类选项按钮布局
        myradioGroup = (RadioGroup)findViewById(R.id.whichdrink);
        myradioGroup.setPadding(500,150, 0, 0);
        myradioGroup.setOnCheckedChangeListener(new RadioGroupListener());
        choose = "种类 珍珠奶茶";
        //ImageView iv = (ImageView)findViewById(R.id.imageView);
        //iv.setPadding(250,-50, 50, 200);

        //甜度提示文字
        show=(TextView)findViewById(R.id.tip);
        //甜度进度条
        seekBar = (SeekBar)findViewById(R.id.seek);
        seekBar.setOnSeekBarChangeListener(new seekBarListener());
        seekprograss = "甜度：20";
        show.setText(seekprograss);

        //当按下"ok"按钮时，用户选择的饮品信息通过日志输出
        btn1.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v) {
                    ImageView iv = (ImageView)findViewById(R.id.whichtea);
                    iniView();
                    iniedit();
                    String output = choose + " " + add + " " + seekprograss + " " + inputText;
                    Log.d("MainActivity",output);

             }
        });

    }

    void iniView(){
        add="";
        btn1 = findViewById(R.id.button);
        y = (CheckBox)findViewById(R.id.yeguo);
        b = (CheckBox)findViewById(R.id.buding);
        h = (CheckBox)findViewById(R.id.hongdou);

        Layout1 = (LinearLayout)findViewById(R.id.layout);

                    int count = Layout1.getChildCount();//计算选择的数量
                    for(int i=0; i<count; i++){
                        View thing = Layout1.getChildAt(i);
                        if(thing instanceof CheckBox){
                            CheckBox cb = (CheckBox)thing;
                            if(cb.isChecked())
                                add += cb.getText()+" ";
                        }
                    }
                    if(add.length() == 0)
                        add = "不加东西";
                    else
                        add = "加"+add;

    }

    //根据选择饮品种类不同将结果记录在choose中，并切换图片
    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            choose = checkedId == R.id.choose1 ? "种类 珍珠奶茶":"种类 红茶玛奇朵";
            ImageView iv1 = (ImageView)findViewById(R.id.whichtea);
            if(choose == "种类 珍珠奶茶")
                iv1.setImageDrawable(getResources().getDrawable(R.drawable.zhenzhu));
            else
                iv1.setImageDrawable(getResources().getDrawable(R.drawable.hongcha));
        }
    }
    //记录备注
    void iniedit(){
        inputText="";
       edittext = (EditText)findViewById(R.id.edit);
       inputText=edittext.getText().toString();
       if(inputText.length() == 0)
          inputText = "备注无";
       else
          inputText = "备注" + inputText;

    }
    //记录甜度
    class seekBarListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            seekprograss = "";
            seekprograss += seekBar.getProgress();
            seekprograss = "甜度：" + seekprograss+" ";
            show.setText(seekprograss);
        }

    }

}
