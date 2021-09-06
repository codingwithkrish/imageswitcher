package com.example.imageswitcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button prvious, next;
    int postion = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        prvious = findViewById(R.id.prvious);
        next = findViewById(R.id.next);

        final int[] images = {R.drawable.im1,R.drawable.im2,R.drawable.im3,R.drawable.im4,R.drawable.im5};
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postion<images.length-1){
                    postion+=1;
                    imageSwitcher.setImageResource(images[postion]);
                }
            }
        });
        prvious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postion > 0) {
                    postion-=1;
                    imageSwitcher.setImageResource(images[postion]);
                }
            }
        });
    }
}