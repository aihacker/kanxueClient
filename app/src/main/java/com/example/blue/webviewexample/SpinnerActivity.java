package com.example.blue.webviewexample;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SpinnerActivity extends Activity implements View.OnClickListener{
    private TextView textView;
    private Spinner spinner;
    private ProgressBar progressBar;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView show;
    private ProgressDialog progressDialog;
    private Button showDialog;
//    private List<String> list;
//    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_spinner);
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);
        setProgress(1000);  //Max = 10000
        init();
        initProgressBar();
    }

    private void initProgressBar() {
        progressBar = findViewById(R.id.horizontalProgressBar);
        add = findViewById(R.id.add);
        reduce = findViewById(R.id.reduce);
        reset = findViewById(R.id.reset);
        show = findViewById(R.id.textView);
        showDialog = findViewById(R.id.showDialog);
        showDialog.setOnClickListener(this);
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);

        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        show.setText("第一进度百分比：" + (int)(first/(float)max*100)+"% 第二进度百分比：" + (int)(second/(float)max*100)+"%");
    }

    private void init() {
        textView = findViewById(R.id.tv_title);
        spinner = findViewById(R.id.spinner);
        textView.setText("您选择的是北京");
//        list = new ArrayList<String>(); // 1.设置数据源
//        list.add("北京");
//        list.add("上海");
//        list.add("广州");
//        list.add("深圳");
//        list.add("杭州");
//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);  //2.新建ArrayAdapter
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    //3.adap设置一个下拉列表样式
//        spinner.setAdapter(arrayAdapter);   //4.spinner加载适配器
        // 1.添加一个下拉列表项的list
        dataList = new ArrayList<Map<String, Object>>();
        getData();
        //第二步：为下拉菜单定义一个是配置器
        simpleAdapter = new SimpleAdapter(this, dataList, R.layout.item_spinner, new String[]{"image","text"}, new int[]{R.id.image_spinner, R.id.tv_spinner});
        //第三步：设置下拉列表样式
        simpleAdapter.setDropDownViewResource(R.layout.item_spinner);
        //第四步：适配器关联下拉列表
        spinner.setAdapter(simpleAdapter);
        //第五步：为下拉列表设置响应事件
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city = ((Map)simpleAdapter.getItem(position)).get("text").toString();
                textView.setText("你选择的城市是：" + city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        spinner.setOnItemSelectedListener(this);
    }

    private void getData() {
        Map<String ,Object> map1 = new HashMap<String, Object>();
        map1.put("image",R.mipmap.ic_launcher);
        map1.put("text","北京");
        dataList.add(map1);
        Map<String ,Object> map2 = new HashMap<String, Object>();
        map2.put("image",R.mipmap.ic_launcher);
        map2.put("text","上海");
        dataList.add(map2);
        Map<String ,Object> map3 = new HashMap<String, Object>();
        map3.put("image",R.mipmap.ic_launcher);
        map3.put("text","广州");
        dataList.add(map3);
        Map<String ,Object> map4 = new HashMap<String, Object>();
        map4.put("image",R.mipmap.ic_launcher);
        map4.put("text","深圳");
        dataList.add(map4);
        Map<String ,Object> map5 = new HashMap<String, Object>();
        map5.put("image",R.mipmap.ic_launcher);
        map5.put("text","杭州");
        dataList.add(map5);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add:
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            case R.id.reduce:
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            case R.id.reset:
                progressBar.setProgress(10);
                progressBar.setSecondaryProgress(20);
                break;
            case R.id.showDialog:
                progressDialog = new ProgressDialog(SpinnerActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("慕课网");
                progressDialog.setMessage("欢迎大家来听课");
                progressDialog.setIcon(R.mipmap.kxlt);
                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(50);
                progressDialog.setIndeterminate(false);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SpinnerActivity.this, "欢迎来测试", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
        }
        show.setText("第一进度百分比：" + (int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"% 第二进度百分比：" + (int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%");
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////        String city = arrayAdapter.getItem(position);
////        textView.setText("您选择的是" + city);
////        String city = list.get(position);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}
