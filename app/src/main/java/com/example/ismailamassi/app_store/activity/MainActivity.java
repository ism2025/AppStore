package com.example.ismailamassi.app_store.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ismailamassi.app_store.Adapter.ItemsAdapter;
import com.example.ismailamassi.app_store.R;
import com.example.ismailamassi.app_store.SystemControl.SystemControl;
import com.example.ismailamassi.app_store.helper.AppConstant;
import com.example.ismailamassi.app_store.items.MarketItems;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addApp2();

        RecyclerView[] recyclerViews = {
                findViewById(R.id.rv),
                findViewById(R.id.rv1),
                findViewById(R.id.rv2),
                findViewById(R.id.rv3),
                findViewById(R.id.rv4),
                findViewById(R.id.rv5),
                findViewById(R.id.rv6),
                findViewById(R.id.rv7),
        };
        for (RecyclerView rv : recyclerViews) {
            if (rv.getId() == R.id.rv || rv.getId() == R.id.rv1) {
                rv.setAdapter(new ItemsAdapter(this, SystemControl.games));
            } else if (rv.getId() == R.id.rv2 || rv.getId() == R.id.rv5) {
                rv.setAdapter(new ItemsAdapter(this, SystemControl.apps));
            } else if (rv.getId() == R.id.rv3 || rv.getId() == R.id.rv7) {
                rv.setAdapter(new ItemsAdapter(this, SystemControl.songs));
            } else if (rv.getId() == R.id.rv4 || rv.getId() == R.id.rv6) {
                rv.setAdapter(new ItemsAdapter(this, SystemControl.books));
            }

            rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    private void addApp(int app_type, int app_icon, String app_title, float app_rating) {
        new MarketItems(app_type, app_icon, app_title, app_rating);
    }

    private void addApp2() {
        for (int i = 0; i < AppConstant.app_icons.length; i++) {
            new MarketItems(AppConstant.app_type[i], AppConstant.app_icons[i], AppConstant.app_title[i], AppConstant.app_rating[i]);
        }
    }

}
