package org.missioncollege.abcflash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.media.MediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import android.content.DialogInterface.OnClickListener;

public class SinglePic extends Activity {
    Integer[] cards = {R.drawable.flashcarda, R.drawable.flashcardb, R.drawable.flashcardc,
            R.drawable.flashcardd, R.drawable.flashcarde, R.drawable.flashcardf ,R.drawable.flashcardg,
            R.drawable.flashcardh, R.drawable.flashcardi, R.drawable.flashcardj, R.drawable.flashcardk,
            R.drawable.flashcardl,  R.drawable.flashcardm, R.drawable.flashcardn, R.drawable.flashcardo,
            R.drawable.flashcardp, R.drawable.flashcardq, R.drawable.flashcardr, R.drawable.flashcards,
            R.drawable.flashcardt,  R.drawable.flashcardu, R.drawable.flashcardv, R.drawable.flashcardw,
            R.drawable.flashcardx,  24, R.drawable.flashcardy, R.drawable.flashcardz, 27};
    Integer[] sounds = {R.raw.apple, R.raw.banana, R.raw.car, R.raw.dog, R.raw.elephant, R.raw.fish, R.raw.gorilla,R.raw.horse,
            R.raw.igloo, R.raw.jam, R.raw.key, R.raw.lamp, R.raw.moon, R.raw.net, R.raw.octopus, R.raw.pig,
            R.raw.queen, R.raw.rocket, R.raw.sun, R.raw.tent, R.raw.umbrella, R.raw.violin, R.raw.watch,
            R.raw.xbox, 24, R.raw.yacht, R.raw.zebra, 27 };

    ImageView pic;
    int id;
    SinglePic thisSinglePic = null;
    Timer timer;

    private static AudioPlayer m_player=new AudioPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_pic);
        thisSinglePic = this;
        timer = new Timer();
        Intent intent = getIntent();
        id = intent.getExtras().getInt("picId");
        pic = (ImageView) findViewById(R.id.imgSingle);
        pic.setImageResource(cards[id]);
        //m_player.play(this.getApplicationContext(), sounds[id]);
        //ImageView view = (ImageView) findViewById(R.id.imgSingle);
        //view.setImageResource(id);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_player.play(thisSinglePic.getApplicationContext(), sounds[id]);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        thisSinglePic.finish();
                    }
                },800);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_pic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
