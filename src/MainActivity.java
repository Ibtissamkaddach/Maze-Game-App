package com.example.mazegameapp;

import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MazeView mazeView;
    private int playerX = 0;
    private int playerY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mazeView = new MazeView(this, 10, 10); // Example size 10x10
        setContentView(mazeView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                handleTouch(x, y);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void handleTouch(float x, float y) {
        // Handle user input to navigate the maze
        // For simplicity, move the player to the touched cell
        int cellSize = 50;
        int newX = (int) (x / cellSize);
        int newY = (int) (y / cellSize);
        if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10) {
            playerX = newX;
            playerY = newY;
            mazeView.invalidate();
        }
    }
}
