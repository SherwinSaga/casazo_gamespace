package com.example.casazo_gamespace;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound {
    public static void playSound(Context context, String sound){
        int audioRes = 0;
        switch (sound) {
            case "red":
                audioRes = R.raw.fa;
                break;
            case "green":
                audioRes = R.raw.mi;
                break;
            case "blue":
                audioRes = R.raw.si;
                break;
            case "yellow":
                audioRes = R.raw.sol;
                break;
            case "lose":
                audioRes = R.raw.lose;
                break;
            case "start":
                audioRes = R.raw.game_start;
                break;
            case"swipe":
                audioRes = R.raw.swipe;
                break;
            case"fail":
                audioRes = R.raw.fail;
                break;
            case "click":
                audioRes = R.raw.click;
                break;
            case "rotate":
                audioRes = R.raw.rotate;
                break;
            case "rotate2":
                audioRes = R.raw.rotate2;
                break;
        }
        MediaPlayer mediaPlayer = MediaPlayer.create(context, audioRes);
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });

            mediaPlayer.start();
        }
    }
}
