package com.example.mazegameapp;

import java.util.Random;

public class MazeGenerator {
    private int[][] maze;
    private int width;
    private int height;

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        maze = new int[width][height];
        generateMaze();
    }

    private void generateMaze() {
        Random random = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                maze[x][y] = random.nextBoolean() ? 1 : 0; // 1 for wall, 0 for path
            }
        }
        maze[0][0] = 0; // Start point
        maze[width - 1][height - 1] = 0; // End point
    }

    public int[][] getMaze() {
        return maze;
    }
}
