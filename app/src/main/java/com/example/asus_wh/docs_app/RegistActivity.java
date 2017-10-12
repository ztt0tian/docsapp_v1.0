package com.example.asus_wh.docs_app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus_wh.docs_app.Utils.CheckInput;
import com.example.asus_wh.docs_app.Utils.ShowToastTip;
import com.example.asus_wh.docs_app.bean.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegistActivity extends ActionBarActivity {
    private TextView regist_name;
    private TextView regist_email;
    private TextView regist_password;
    private TextView regist_second_password;
    private Button regist_btn_rest;
    private Button regist_btn_ok;
    private Button regist_btn_changeIcon;
    private ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        Bmob.initialize(this,"8afbcaae22fc8ee6739956da9cbc2d7a");
        Init();
        final User regist_user=new User();
        regist_btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        regist_btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_Input_format()){
                    regist_user.setUsername(regist_name.getText().toString());
                    regist_user.setPassword(regist_password.getText().toString());
                    regist_user.setEmail(regist_email.getText().toString());
                    regist_user.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if(e==null){
                                ShowToastTip.showTips(RegistActivity.this,"注册成功");
                                RegistActivity.this.finish();
                            }
                            else{
                                ShowToastTip.showTips(RegistActivity.this,"注册失败"+e.getMessage());
                            }
                        }
                    });
                }
                else{
                    return;
                }
            }
        });
        regist_btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regist_name.setText("");
                regist_password.setText("");
                regist_email.setText("");
                regist_second_password.setText("");
                regist_name.requestFocus();

            }
        });
    }
    public void Init(){
        regist_name=(TextView)findViewById(R.id.regist_name);
        regist_password=(TextView)findViewById(R.id.regist_password);
        regist_email=(TextView)findViewById(R.id.regist_email);
        regist_second_password=(TextView)findViewById(R.id.second_password);
        regist_btn_rest=(Button)findViewById(R.id.regist_reset);
        regist_btn_ok=(Button)findViewById(R.id.regist_ok);
        regist_btn_changeIcon=(Button)findViewById(R.id.change_icon);
        icon=(ImageView)findViewById(R.id.regist_icon);
    }
    public boolean check_Input_format(){
        if(CheckInput.check_textview(regist_name)&&CheckInput.isEmail(regist_email)&&CheckInput.check_password(regist_password)){
            if(regist_second_password.getText().toString().equals(regist_password.getText().toString())){
                return true;
            }
            else{
                regist_second_password.setError("前后密码不一致");
                regist_second_password.requestFocus();
                return false;
            }
        }
        return false;
    }
}
