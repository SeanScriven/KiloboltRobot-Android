package com.kiloboltrobot.robotgame;

import com.kiloboltrobot.framework.Game;
import com.kiloboltrobot.framework.Graphics;
import com.kiloboltrobot.framework.Screen;
import com.kiloboltrobot.framework.Graphics.ImageFormat;


public class SplashLoadingScreen extends Screen {

    public SplashLoadingScreen(Game game) {
        super(game);
    }

    /*
     * load first image as an RGB565, nothing is painted in this method
     */
    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.splash= g.newImage("splash.jpg", ImageFormat.RGB565);

        game.setScreen(new LoadingScreen(game));

    }

    @Override
    public void paint(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}
