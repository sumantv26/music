package com.sumu.musicapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicDetails extends AppCompatActivity implements View.OnClickListener {
    private String songName;
    private String artistName;
    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    @BindView(R.id.prev_button)
    ImageButton prevButton;
    @BindView(R.id.play_button)
    ImageButton playButton;
    @BindView(R.id.next_button)
    ImageButton nextButton;
    private RelativeLayout rootLayout;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rootLayout=findViewById(R.id.constraint_layout);
        ButterKnife.bind(this);

        //palette api for background color
        final Window window=this.getWindow();
        Bitmap image= BitmapFactory.decodeResource(getResources(),R.drawable.music);
        Palette.from(image).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                vibrantSwatch=palette.getVibrantSwatch();
                lightVibrantSwatch=palette.getLightVibrantSwatch();
                darkVibrantSwatch=palette.getDarkVibrantSwatch();

                if (vibrantSwatch!=null){
                    rootLayout.setBackgroundColor(lightVibrantSwatch.getRgb());
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(darkVibrantSwatch.getRgb()));
                    window.setStatusBarColor(darkVibrantSwatch.getRgb());
                }
            }
        });

        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        Intent intent=getIntent();
        songName=intent.getStringExtra("songName");
        artistName=intent.getStringExtra("artistName");

        TextView songNameTv=findViewById(R.id.detail_song_name);
        songNameTv.setText(songName);
        TextView artistNameTv=findViewById(R.id.detail_artist_name);
        artistNameTv.setText("Artist: "+artistName);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.prev_button:
                Toast.makeText(MusicDetails.this,"Previous Song is Playing",Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_button:
                Toast.makeText(MusicDetails.this,"Song is Playing",Toast.LENGTH_SHORT).show();
                break;
            case R.id.next_button:
                Toast.makeText(MusicDetails.this,"Next Song is Playing",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
