package com.example.chapter_2;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> dataList = new ArrayList<>();
    public static final String[] names = {"敬礼我的超级英雄", "我们不一Young", "花木兰预告片", "请平安出行", "黑美人鱼", "纸短情长", "田馥甄", "我们一起学猫叫", "确认过眼神", "你吃饭了吗","蜘蛛侠上映","还珠格格","轻轻地牵着你的耳朵","最好的我们","你妈觉得你冷"};
    public static final String[] indexs = {"1  ","2  ","3  ","4  ","5  ","6  ","7  ","8  ","9  ","10  ","11  ","12  ","13  ","14  ","15  "};
    public static final String[] nums = {"548900","521233","502122","456679","321233","301345","259867","245632","234212","221342","220456","201345","198934","187453","134564"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DataAdapter adapter = new DataAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
    private void initDatas(){
        for(int i=0; i<15; i++){
            Data data;
            if(i == 0||i == 7) {
                data = new Data(names[i], indexs[i], nums[i], R.drawable.re);
            }
            else if(i == 5){
                data = new Data(names[i], indexs[i], nums[i], R.drawable.xin);
            }
            else{
                data = new Data(names[i], indexs[i], nums[i], R.drawable.it);
            }

            dataList.add(data);
        }
    }
}
