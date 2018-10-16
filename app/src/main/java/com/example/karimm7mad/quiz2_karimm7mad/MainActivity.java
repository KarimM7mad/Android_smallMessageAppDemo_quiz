package com.example.karimm7mad.quiz2_karimm7mad;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements figure1_fragment.figure1Interface, figure2_fragment.figure2Interface, figure3_fragment.figure3Interface {


    public FragmentManager fm = this.getSupportFragmentManager();
    public FragmentTransaction ft;

    public figure1_fragment f1;
    public figure2_fragment f2;
    public figure3_fragment f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //force Portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //create Fragments and assign the mainActivity as their listener
        this.f1 = new figure1_fragment();
        this.f1.setF1Listener(this);
        this.f2 = new figure2_fragment();
        this.f2.setF2Listener(this);
        this.f3 = new figure3_fragment();
        this.f3.setF3Listener(this);

        //assign the view
        this.ft = this.fm.beginTransaction();
        this.ft.add(R.id.container, this.f1, "f1");
        this.ft.commit();
    }

    //overriding OS back Btn
    @Override
    public void onBackPressed() {
        this.ft = this.fm.beginTransaction();
        this.ft.remove(this.f1);
        this.ft.remove(this.f2);
        this.ft.remove(this.f3);
        this.ft.commit();
        this.finish();
        this.moveTaskToBack(false);
        System.exit(0);
    }

    //implement Interface of frag1
    @Override
    public void login() {
        this.ft = this.fm.beginTransaction();
        this.ft.replace(R.id.container, this.f2, "f2");
        this.ft.commit();
        this.f1.passwordEntry.setText("");
        this.f1.emailEntry.setText("");
    }

    //implement Interface of frag2
    @Override
    public void logout() {
        this.ft = this.fm.beginTransaction();
        this.ft.replace(R.id.container, this.f1, "f1");
        this.ft.commit();
    }

    @Override
    public void checkMsg(int x) {
        this.ft = this.fm.beginTransaction();
        this.ft.replace(R.id.container, this.f3, "f3");
        this.ft.commit();
        this.f3.setMsgNum(x);
    }

    //implement Interface of frag3
    @Override
    public void goBack() {
        this.ft = this.fm.beginTransaction();
        this.ft.replace(R.id.container, this.f2, "f2");
        this.ft.commit();
    }
}
