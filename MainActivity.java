package com.example.tarunkaza.ex9;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView t;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.txt1);
        File farray[] = getExternalFilesDirs(null);
        File f = farray[1];
        File f1 = new File(f, "abc.txt");
        if (!f1.exists())
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        FileOutputStream fos = null;
        FileInputStream fin;
        String space=" ";
        byte[] b=space.getBytes();
        String s = "Sample string";
        byte[] data = s.getBytes();
        try {
            fos = new FileOutputStream(f1,true);
            fos.write(data);
            fos.write(b);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fin = new FileInputStream(f1);
            f1.setReadable(true);
            InputStreamReader in=new InputStreamReader(fin);
            BufferedReader buff=new BufferedReader(in);
            s=buff.readLine();
            t.setText(s);
            fin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
