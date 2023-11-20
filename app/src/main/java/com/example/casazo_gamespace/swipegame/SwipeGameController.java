package com.example.casazo_gamespace.swipegame;

import android.graphics.Color;

import java.util.List;
import java.util.Random;


public class SwipeGameController {
    private SwipeGameModel model;
    private SwipeGameView view;
    private int Backgroundtracker;
    private String occurenceTracker1;
    private boolean isChange2nd;



    public SwipeGameController(SwipeGameModel model, SwipeGameView view) {
        this.model = model;
        this.view = view;
        this.Backgroundtracker = 0;
        this.occurenceTracker1 = "";
        this.isChange2nd = false;
    }

    public void onSwipe(String direction) {
        List<String> directions = model.getDirections();

        if (!directions.isEmpty() && direction.equals(directions.get(0))) {
            model.incrementCurrentScore();
            directions.remove(0);
            if (directions.isEmpty()) {
                generateRandomDirection();
                view.textviewDirections(model.getDirections());
                view.displayRandomImage(generateRandomVectorAssetId());
                updateBackgroundColor();
                Backgroundtracker++;
            }
            view.updateScore(model.getCurrentScore());
        } else {
            view.showGameOver(model.getCurrentScore());
            if(model.getCurrentScore() > model.getHighScore()){    //track highscore
                model.setHighScore(model.getCurrentScore());
            }
            resetGame();
            view.textviewDirections(model.getDirections());
            view.updateScore(model.getCurrentScore());
        }
    }


    public void generateRandomDirection() {
        String[] allDirections = {"UP", "DOWN", "LEFT", "RIGHT"};
        String randomDirection;
        
        while (true) {
            Random random = new Random();
            randomDirection = allDirections[random.nextInt(allDirections.length)];
            if (!randomDirection.equals(occurenceTracker1) || (randomDirection.equals(occurenceTracker1) && !isChange2nd)) {
                break;
            }
        }
        if (randomDirection.equals(occurenceTracker1)) {
            isChange2nd = true;
        } else {
            occurenceTracker1 = randomDirection;
            isChange2nd = false;
        }

        model.addDirection(randomDirection);
    }

    public int generateRandomVectorAssetId() {

        int randomIndex;
        while(true){
            randomIndex = new Random().nextInt(model.getVectorAssetIdsSize());
            if(randomIndex != model.getCurrentAsset()){ //to prevent same asset twice a row
                break;
            }
        }
        model.setCurrentAsset(randomIndex);
        return model.getAssetID(randomIndex);
    }

    public void resetGame() {
        model.clear();
        model.setCurrentScore(0);
    }



    protected void updateBackgroundColor(){

        switch (Backgroundtracker){
            case 0:
                view.setBackgroundColor(Color.argb(255, 255 ,255, 0 )); //yellow
                break;
            case 1:
                view.setBackgroundColor(Color.argb(255, 253, 255, 0));
                break;
            case 2:
                view.setBackgroundColor(Color.argb(255, 255, 250, 205));
                break;
            case 3:
                view.setBackgroundColor(Color.argb(255, 255, 255, 224));
                break;
            case 4:
                view.setBackgroundColor(Color.argb(255, 255, 165, 0)); //orange
                break;
            case 5:
                view.setBackgroundColor(Color.argb(255, 247, 135, 2));
                break;
            case 6:
                view.setBackgroundColor(Color.argb(255, 255, 165, 44));
                break;
            case 7:
                view.setBackgroundColor(Color.argb(255, 255, 209, 6));
                break;
            case 8:
                view.setBackgroundColor(Color.argb(255, 191, 255, 0)); //yellow green
                break;
            case 9:
                view.setBackgroundColor(Color.argb(255, 57, 255, 20));
                break;
            case 10:
                view.setBackgroundColor(Color.argb(255, 0, 255, 0));
                break;
            case 11:
                view.setBackgroundColor(Color.argb(255, 50, 205, 50));
                break;
            case 12:
                view.setBackgroundColor(Color.argb(255, 255, 170, 51)); //yellow orange
                break;
            case 13:
                view.setBackgroundColor(Color.argb(255, 255, 89, 11));
                break;
            case 14:
                view.setBackgroundColor(Color.argb(255, 255, 168, 54));
                break;
            case 15:
                view.setBackgroundColor(Color.argb(255, 252, 174, 30));
                Backgroundtracker = 0;
                break;
        }

    }


}
