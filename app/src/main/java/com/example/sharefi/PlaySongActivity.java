package com.example.sharefi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class PlaySongActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private ImageButton btnPlayPause = null;
    private SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playback_ui);
        btnPlayPause = findViewById(R.id.btnPlay);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        displaySongBasedOnIndex();
        Log.d("temasek", "Resttieved position is: " + currentIndex);
        playSong(fileLink);
    }

    public void onBackPressed(){
        super.onBackPressed();
        player.release();
    }

    public void displaySongBasedOnIndex() {
        Song song = songCollection.getCurrentSong(currentIndex);
        title = song.getTitle();
        artiste = song.getArtiste();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();
        TextView textTitle = findViewById(R.id.txtSongTitle);
        textTitle.setText(title);
        TextView textArtiste = findViewById(R.id.txtArtistName);
        textArtiste.setText(artiste);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);

    }

    public void playSong(String songUrl){
        try{
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            gracefullyStopsWhenMusicEnds();

            btnPlayPause.findViewById(R.id.btnPlay);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View view){
        if (player.isPlaying()){
            player.pause();
            btnPlayPause.findViewById(R.id.btnPlay);
        }
        else {
            player.start();
            btnPlayPause.findViewById(R.id.btnPlay);
        }
    }

    public void playNext(View view) {
        currentIndex = songCollection.getNextSong(currentIndex);
        Toast.makeText(this,"After clicking playNext,\nthe current index of this song\n" +
                "in the SongCollection array is now :" +currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playNext, the index is now :"+ currentIndex);
        displaySongBasedOnIndex();
        playSong(fileLink);
    }

    public void playPrevious(View view) {
        currentIndex = songCollection.getPrevSong(currentIndex);
        Toast.makeText(this, "After clicking playPrevious, \nthe current index of this song\n" +
                "in the songCollection array is now :" + currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playPrevious, the index is now :" + currentIndex);
        displaySongBasedOnIndex();
        playSong(fileLink);
    }
    private void gracefullyStopsWhenMusicEnds(){
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getBaseContext(), "The song had ended and the onCompleteListener is activated\n" +
                        "The button text is changed to 'Play'", Toast.LENGTH_LONG).show();
                btnPlayPause.findViewById(R.id.btnPlay);
            }
        });
    }

}