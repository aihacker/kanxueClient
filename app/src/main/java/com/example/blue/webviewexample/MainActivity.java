package com.example.blue.webviewexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{
    private String TAG = this.getClass().getSimpleName();
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);
        init();
    }

    private void init() {
        listView = findViewById(R.id.lv_show);
        //适配器的使用流程：新建一个适配器 ---> 绑定数据源 ---> 视图加载适配器
        /**
         * Constructor. This constructor will result in the underlying data collection being
         * immutable, so methods such as {@link #clear()} will throw an exception.
         *
         * @param context The current context.
         * @param resource The resource ID for a layout file containing a TextView to use when
         *                 instantiating views.
         * @param objects The objects to represent in the ListView.
         */
        String[] arr_data = {"看雪论坛：https://bbs.pediy.com/forum-161.htm", "52破解：http://www.52pojie.cn"};
        dataList = new ArrayList<Map<String,Object>>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        /**
         * Constructor
         *
         * @param context The context where the View associated with this SimpleAdapter is running
         * @param data A List of Maps. Each entry in the List corresponds to one row in the list. The
         *        Maps contain the data for each row, and should include all the entries specified in
         *        "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *        item. The layout file should include at least those named views defined in "to"
         * @param from A list of column names that will be added to the Map associated with each
         *        item.
         * @param to The views that should display column in the "from" parameter. These should all be
         *        TextViews. The first N views in this list are given the values of the first N columns
         *        in the from parameter.
         */
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.layout_item, new String[]{"img", "name", "desc"}, new int[]{R.id.img, R.id.name, R.id.desc});

        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

    }
    private List<Map<String,Object>> getData(){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("img", R.mipmap.kxlt);
            map.put("name","看雪论坛");
            map.put("desc","看雪论坛是著名的安全论坛");
            dataList.add(map);

            Map<String, Object> map2 = new HashMap<String,Object>();
            map2.put("img", R.mipmap.wapj);
            map2.put("name","52破解");
            map2.put("desc","吾爱破解是优秀的破解论坛");
            dataList.add(map2);

            Map<String, Object> map3 = new HashMap<String,Object>();
            map3.put("img", R.mipmap.wapj);
            map3.put("name","逆向未来");
            map3.put("desc","逆向未来是逆向相关的论坛");
            dataList.add(map3);

            Map<String, Object> map4 = new HashMap<String,Object>();
            map4.put("img", R.mipmap.wapj);
            map4.put("name","BUNOOB");
            map4.put("desc","BUNOOB是编程语言学习论坛");
            dataList.add(map4);

            Map<String, Object> map5 = new HashMap<String,Object>();
            map5.put("img", R.mipmap.kxlt);
            map5.put("name","U3D逆向");
            map5.put("desc","看雪U3D手游安全分析");
            dataList.add(map5);

            Map<String, Object> map6 = new HashMap<String,Object>();
            map6.put("img", R.mipmap.kxlt);
            map6.put("name","姜维讲道");
            map6.put("desc","姜维是一个安全大牛");
            dataList.add(map6);

            Map<String, Object> map7 = new HashMap<String,Object>();
            map7.put("img", R.mipmap.kxlt);
            map7.put("name","freebuf");
            map7.put("desc","freebuf安全论坛");
            dataList.add(map7);

            Map<String, Object> map8 = new HashMap<String,Object>();
            map8.put("img", R.mipmap.wapj);
            map8.put("name","乌云论坛");
            map8.put("desc","乌云论坛很不错的安全论坛");
            dataList.add(map8);

            Map<String, Object> map9 = new HashMap<String,Object>();
            map9.put("img", R.mipmap.wapj);
            map9.put("name","老罗android之旅");
            map9.put("desc","优秀的系统源码博客集");
            dataList.add(map9);

            Map<String, Object> map10 = new HashMap<String,Object>();
            map10.put("img", R.mipmap.kxlt);
            map10.put("name","安全客");
            map10.put("desc","有思想的安全新媒体");
            dataList.add(map10);

            Map<String, Object> map11 = new HashMap<String,Object>();
            map11.put("img", R.mipmap.kxlt);
            map11.put("name","飘云阁");
            map11.put("desc","历史悠久的安全论坛");
            dataList.add(map11);

            Map<String, Object> map12 = new HashMap<String,Object>();
            map12.put("img", R.mipmap.kxlt);
            map12.put("name","APIClould");
            map12.put("desc","免费的视频教程论坛");
            dataList.add(map12);

            Map<String, Object> map13 = new HashMap<String,Object>();
            map13.put("img", R.mipmap.kxlt);
            map13.put("name","计算机与安全");
            map13.put("desc","思维导图看世界");
            dataList.add(map13);

            Map<String, Object> map14 = new HashMap<String,Object>();
            map14.put("img", R.mipmap.kxlt);
            map14.put("name","SecWiKi");
            map14.put("desc","安全界的wiki");
            dataList.add(map14);

            Map<String, Object> map15 = new HashMap<String,Object>();
            map15.put("img", R.mipmap.wapj);
            map15.put("name","安全脉搏");
            map15.put("desc","SecPluse互联网安全论坛");
            dataList.add(map15);

            Map<String, Object> map16 = new HashMap<String,Object>();
            map16.put("img", R.mipmap.wapj);
            map16.put("name","吾爱漏洞");
            map16.put("desc","漏洞安全论坛");
            dataList.add(map16);

            Map<String, Object> map17 = new HashMap<String,Object>();
            map17.put("img", R.mipmap.wapj);
            map17.put("name","MottoIN");
            map17.put("desc","最新安全资讯");
            dataList.add(map17);

            Map<String, Object> map18 = new HashMap<String,Object>();
            map18.put("img", R.mipmap.wapj);
            map18.put("name","and-rev");
            map18.put("desc","and-rev安全博客");
            dataList.add(map18);

            Map<String, Object> map19 = new HashMap<String,Object>();
            map19.put("img", R.mipmap.kxlt);
            map19.put("name","乌云知识库");
            map19.put("desc","乌云的知识遗产");
            dataList.add(map19);

            Map<String, Object> map20 = new HashMap<String,Object>();
            map20.put("img", R.mipmap.kxlt);
            map20.put("name","Frida使用");
            map20.put("desc","一篇好的Frida文章");
            dataList.add(map20);

            Map<String, Object> map21 = new HashMap<String,Object>();
            map21.put("img", R.mipmap.kxlt);
            map21.put("name","Droidsec");
            map21.put("desc","Droidsec安全论坛");
            dataList.add(map21);

            Map<String, Object> map22 = new HashMap<String,Object>();
            map22.put("img", R.mipmap.kxlt);
            map22.put("name","Paper");
            map22.put("desc","Paper 安全技术精粹");
            dataList.add(map22);

            Map<String, Object> map23 = new HashMap<String,Object>();
            map23.put("img", R.mipmap.kxlt);
            map23.put("name","在线C编辑器");
            map23.put("desc","C语言开发环境在线版");
            dataList.add(map23);

//            for(int i=0;i<8;i++){
//                Map<String, Object> map38 = new HashMap<String,Object>();
//                map38.put("img", R.mipmap.ic_launcher);
//                map38.put("name","看雪论坛");
//                map38.put("desc","致力于PC、移动、物联网安全研究及逆向工程");
//                dataList.add(map38);
//            }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String text = listView.getItemAtPosition(position) + "";
//        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, WebViewActivity.class);
        String url = "";
        switch (position){
            case 0:
                url = "https://bbs.pediy.com/forum-161.htm";
                break;
            case 1:
                url = "https://www.52pojie.cn/forum-65-1.html";
                break;
            case 2:
                url = "https://www.pd521.com/forum-37-1.html";
                break;
            case 3:
                url = "http://www.runoob.com/python3/python3-tutorial.html";
                break;
            case 4:
                url = "https://www.kanxue.com/book-24-98.htm";
                break;
            case 5:
                url = "http://www.wjdiankong.cn";
            case 6:
                url = "http://www.freebuf.com";
                break;
            case 7:
                url = "https://wooyun.js.org";
                break;
            case 8:
                url = "https://www.kancloud.cn/alex_wsc/androids/401771";
                break;
            case 9:
                url = "https://www.anquanke.com";
                break;
            case 10:
                url = "https://www.chinapyg.com/forum-304-1.html";
                break;
            case 11:
                url = "http://www.apicloud.com/video_list";
                break;
            case 12:
                url = "http://mp.weixin.qq.com/mp/homepage?__biz=MjM5OTk4MDE2MA==&hid=2&sn=18a4c87f0856db1438c33a1eb26ae37d&scene=25#wechat_redirect";
                break;
            case 13:
                url = "https://www.sec-wiki.com";
                break;
            case 14:
                url = "https://www.secpulse.com/archives/category/articles/mobile-security";
                break;
            case 15:
                url = "http://www.52bug.cn";
                break;
            case 16:
                url = "http://www.mottoin.com";
                break;
            case 17:
                url = "https://and-rev.blogspot.com";
                break;
            case 18:
                url = "https://www.tuicool.com/sites/a2UJrq";
                break;
            case 19:
                url = "https://www.chinawbk.com/show/451430.html";
                break;
            case 20:
                url = "http://www.droidsec.cn";
                break;
            case 21:
                url = "https://paper.seebug.org/650";
                break;
            case 22:
                url = "http://clin.icourse163.org";
                break;
        }
        intent.putExtra("url", url);
        Log.i(TAG, url);
        startActivity(intent);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
//        switch (scrollState){
//            case SCROLL_STATE_FLING:
//                Log.i(TAG, "用户手指离开屏幕之前，用力滑了一下，视图仍依靠惯性继续滑动");
//                Map<String,Object> map = new HashMap<String,Object>();
//                map.put("img",R.mipmap.ic_launcher);
//                map.put("name","添加项");
//                map.put("desc","模拟下滑更新数据项");
//                dataList.add(map);
//                simpleAdapter.notifyDataSetChanged();
//                break;
//            case SCROLL_STATE_IDLE:
//                Log.i(TAG, "视图已经停止滑动");
//                break;
//            case SCROLL_STATE_TOUCH_SCROLL:
//                Log.i(TAG, "手指没有离开屏幕，视图正在滑动");
//                break;
//        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
