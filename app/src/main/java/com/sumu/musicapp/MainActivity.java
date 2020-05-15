package com.sumu.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sumu.musicapp.adapter.ItemAdapter;
import com.sumu.musicapp.data.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private ArrayList<Song> songs;
    private ListView listView;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        listView=findViewById(R.id.music_list);
        songs=new ArrayList<>();
        songs.add(new Song("Gulabi Ankhe","Sanam"));
        songs.add(new Song("Likhe jo khat tuje","Sanam"));
        songs.add(new Song("Dancing Queen","ABBA"));
        songs.add(new Song("Beautiful","Christina "));
        songs.add(new Song("Rose Garden ","Lynn "));
        songs.add(new Song("The House of the Rising Sun","The Animals"));
        songs.add(new Song("What a Wonderful World","Louis "));
        songs.add(new Song("The Cattle Call","Eddy Arnold"));
        songs.add(new Song("Heat of the Moment","Asia"));
        songs.add(new Song("Never Gonna Give You Up","Rick Astley"));
        songs.add(new Song("Upside Down","A*Teens"));
        songs.add(new Song("I Want It That Way","Backstreet"));
        songs.add(new Song("Working Class Man","Jimmy Barnes"));
        songs.add(new Song("One O'Clock Jump","Count Basie"));
        songs.add(new Song("Goldfinger","Shirley "));

        adapter=new ItemAdapter(this,songs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song=songs.get(position);
                Intent intent=new Intent(MainActivity.this,MusicDetails.class);
                intent.putExtra("songName",song.getSongName());
                intent.putExtra("artistName",song.getArtistName());
                startActivity(intent);
            }
        });

    }
}
