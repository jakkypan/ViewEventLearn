/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.conflict.outer;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by panhongchao on 15/12/17.
 */
public class ConflictOuterActivity extends Activity {
    private HorizontalScrollViewEx mListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListContainer = new HorizontalScrollViewEx(this);
        for (int i = 0; i < 3; i++) {
            mListContainer.addView(createList(null));
        }
        setContentView(mListContainer);
    }

    private ListView createList(ViewGroup layout) {
        ListView listView = new ListView(this);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("conflict" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1, datas);
        listView.setAdapter(adapter);
        return listView;
    }
}
