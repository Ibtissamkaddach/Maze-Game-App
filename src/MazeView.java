package com.example.mazegameapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MazeView extends View {
    private MazeGenerator mazeGenerator;
    private Paint paint;
    private int cellSize;

    public MazeView(Context context, int width, int height) {
        super(context);
        mazeGenerator = new MazeGenerator(width, height);
        paint = new Paint();
        cellSize = 50; // Size of each cell in the maze
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int[][] maze = mazeGenerator.getMaze();
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if (maze[x][y] == 1) {
                    paint.setColor(0xFF000000); // Black for walls
                } else {
                    paint.setColor(0xFFFFFFFF); // White for paths
                }
                canvas.drawRect(x * cellSize, y * cellSize, (x + 1) * cellSize, (y + 1) * cellSize, paint);
            }
        }
    }
}
