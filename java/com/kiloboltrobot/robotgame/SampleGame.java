package com.kiloboltrobot.robotgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

import com.kiloboltrobot.R;
import com.kiloboltrobot.framework.Screen;
import com.kiloboltrobot.implementation.AndroidGame;


public class SampleGame extends AndroidGame {

    public static String map;
    boolean firstTimeCreate = true;

    /*
     * if first time SampleGame is opened load method inside the Assets class, which loads the music
     * return the first screen we will see
     */
    @Override
    public Screen getInitScreen() {

        if (firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        InputStream is = getResources().openRawResource(R.raw.map1);
        map = convertStreamToString(is);

        return new SplashLoadingScreen(this);

    }

    /*
     * handles back button presses
     */
    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }

    /*
     * takes a .txt file and returns a string
     */
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append((line + "\n"));
            }
        } catch (IOException e) {
            Log.w("LOG", e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.w("LOG", e.getMessage());
            }
        }
        return sb.toString();
    }

    @Override
    public void onResume() {
        super.onResume();

        Assets.theme.play();

    }

    @Override
    public void onPause() {
        super.onPause();
        Assets.theme.pause();

    }
}
