package com.example.asus_wh.docs_app.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by asus-wh on 2017/10/11.
 */

public class User extends BmobUser {

    private BmobFile icon;
    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
    }

    /*public User() {
        this.setTableName("DOCS_USER");
    }*/
}
