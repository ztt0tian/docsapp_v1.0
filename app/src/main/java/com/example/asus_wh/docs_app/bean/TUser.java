package com.example.asus_wh.docs_app.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by asus-wh on 2017/10/11.
 */

public class TUser extends BmobUser {
    private String dusername;
    private String dpassword;
    private String demail;

    public String getDusername() {
        return dusername;
    }

    public void setDusername(String dusername) {
        this.dusername = dusername;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public TUser() {
        this.setTableName("TUser");
    }
}
