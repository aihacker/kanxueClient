package com.example.blue.webviewexample;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraActivity extends Activity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.clock,R.drawable.games_control,R.drawable.messenger,R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,R.drawable.world,R.drawable.youtube};
    private String[] iconName = {"通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置", "语音", "天气", "浏览器", "视频"};
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        init();
    }

    private void init() {
        //准备数据源 ---> 添加适配器(SimpleAdapter) ---> 关联GridView ---> 添加监听器(OnItemListener)
        gridView = findViewById(R.id.gridView);
        dataList = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"image", "text"}, new int[]{R.id.iv_icon, R.id.tv_iconName});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> getData() {
        for(int i=0;i<icon.length;i++){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image", icon[i]);
        map.put("text", iconName[i]);
        dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, iconName[position], Toast.LENGTH_SHORT).show();
    }
}
