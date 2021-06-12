package com.example.fitness_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class yoga extends AppCompatActivity {
    CarouselView carouselView;
    private Button saveprogress;
    int[] sampleImages= {R.drawable.yoga_1,R.drawable.yoga_2,R.drawable.yoga_3,R.drawable.yoga,R.drawable.yoga_5,R.drawable.yoga_6,R.drawable.yoga_7,R.drawable.yoga_8,R.drawable.yoga_9,R.drawable.yoga_10  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        carouselView = findViewById(R.id.carouselview);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        saveprogress=(Button) findViewById(R.id.save);

        saveprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yoga.this , yogaprogress.class);
                startActivity(intent);

            }
        });
    }

    ImageListener imageListener=new ImageListener(){
        @Override
        public void setImageForPosition(int position, ImageView imageView){
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
