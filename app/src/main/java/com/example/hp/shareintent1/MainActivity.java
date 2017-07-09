package com.example.hp.shareintent1;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareTextUrl();
            }
        });
        //**
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });
        //**
    }

    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, "http://www.codeofaninja.com");

        startActivity(Intent.createChooser(share, "Share link!"));
    }

    private void shareImage() {
        Intent share = new Intent(Intent.ACTION_SEND);

        // If you want to share a png image only, you can do:
        // setType("image/png"); OR for jpeg: setType("image/jpeg");
        share.setType("image/*");

        // Make sure you put example png image named myImage.png in your
        // directory
        String imagePath = Environment.getExternalStorageDirectory()
                + "/myImage.png";

        File imageFileToShare = new File(imagePath);

        Uri uri = Uri.fromFile(imageFileToShare);
        share.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(share, "Share Image!"));
    }
}


/*************************************************************************************************/
//Share text:

/*
Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TEXT, "Your text here" );
        startActivity(Intent.createChooser(intent2, "Share via"));

//via Email:

        Intent intent2 = new Intent();
        intent2.setAction(Intent.ACTION_SEND);
        intent2.setType("message/rfc822");
        intent2.putExtra(Intent.EXTRA_EMAIL, new String[]{EMAIL1, EMAIL2});
        intent2.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
        intent2.putExtra(Intent.EXTRA_TEXT, "Your text here" );
        startActivity(intent2);

//Share Files:

//Image:

        boolean isPNG = (path.toLowerCase().endsWith(".png")) ? true : false;

        Intent i = new Intent(Intent.ACTION_SEND);
//Set type of file
        if(isPNG)
        {
        i.setType("image/png");//With png image file or set "image*/
/*" type
        }
        else
        {
        i.setType("image/jpeg");
        }

        Uri imgUri = Uri.fromFile(new File(path));//Absolute Path of image
        i.putExtra(Intent.EXTRA_STREAM, imgUri);//Uri of image
        startActivity(Intent.createChooser(i, "Share via"));
        break;

//APK:

        File f = new File(path1);
        if(f.exists())
        {

        Intent intent2 = new Intent();
        intent2.setAction(Intent.ACTION_SEND);
        intent2.setType("application/vnd.android.package-archive");//APk file type
        intent2.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f) );
        startActivity(Intent.createChooser(intent2, "Share via"));
        }
        break;*/
