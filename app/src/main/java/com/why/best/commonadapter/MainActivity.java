package com.why.best.commonadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlSerializer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new CommonAdapter<String>(MainActivity.this, mDatas, R.layout.item_list_view) {
            @Override
            protected void convert(ViewHolder viewHolder, String item) {
                viewHolder.setText(R.id.item_text_view, item);
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String s = "阿啦啦啦" + i;
            mDatas.add(s);
        }
    }
}
