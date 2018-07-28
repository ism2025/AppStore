package com.example.ismailamassi.app_store.items;

import com.example.ismailamassi.app_store.SystemControl.SystemControl;
import com.example.ismailamassi.app_store.helper.AppConstant;

public class MarketItems {
    public MarketItems(int app_type, int app_icon, String app_title, float app_rating) {
        this.app_type = app_type;
        this.app_icon = app_icon;
        this.app_title = app_title;
        this.app_rating = app_rating;
        if (app_type == AppConstant.GAME) {
            SystemControl.games.add(this);
        } else if (app_type == AppConstant.APP) {
            SystemControl.apps.add(this);
        } else if (app_type == AppConstant.SONG) {
            SystemControl.songs.add(this);
        } else if (app_type == AppConstant.BOOK) {
            SystemControl.books.add(this);
        }
    }

    public int app_type;
    public int app_icon;
    public String app_title;
    public float app_rating;
}
