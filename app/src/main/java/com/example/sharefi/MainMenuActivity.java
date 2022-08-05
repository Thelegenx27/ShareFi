package com.example.sharefi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {

    private SongCollection songCollection = new SongCollection();
//    private ImageButton mImageButton;
//    private ImageButton mpImageButton;
//    private ImageButton mplImageButton;
//    private ImageButton mppImageButton;
//    private ImageButton mpiImageButton;
//    private ImageButton mpnImageButton;
    private ImageButton mProfilePage, mPlaylistMenu, mGroupPlay, mSearchMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        mProfilePage = (ImageButton) findViewById(R.id.Profile);
        mProfilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

        mPlaylistMenu = findViewById(R.id.playlist);
        mPlaylistMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PlaylistActivity.class));
            }
        });

        mGroupPlay = findViewById(R.id.groupPlay);
        mGroupPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GroupPlayActivity.class));
            }
        });

        mSearchMenu = findViewById(R.id.searchmenu);
        mSearchMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SearchMenuActivity.class));
            }
        });

    }

    public void handleSelection(View myView){
        String resourceId = getResources().getResourceEntryName(myView.getId());
        int currentArrayIndex = songCollection.searchSongById(resourceId);
        Log.d("temasek", "The index in the array for this song is: " + currentArrayIndex);
        sendDataToActivity(currentArrayIndex);
    }

    public void sendDataToActivity(int index) {
        Intent intent = new Intent (this, PlaySongActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }




}