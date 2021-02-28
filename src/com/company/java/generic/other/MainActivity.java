package com.company.java.generic.other;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static com.fuck.generictest.Test.getSuck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public static void init(){
        Pair<String> pair=new Pair<String>("abc","lmn");
        String kko=pair.<String>getFirstO();
        pair.<String>setFirst("333");
        int s=Test.<Integer>getSuck(0);
        int r=getSuck(6);

        Test test=new Test();
        test.<Integer>fuck(1);
        test.fuck(110);

       int a= BigCock.bigDick;

    }
}
