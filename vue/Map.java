package vue;

import models.Case;

import java.util.Arrays;

/**
 * Created by gtoubassi on 8/7/18.
 */
public class Map {
    private  int WIDTH = 200;
    private  int HEIGHT = 100;

    int[] data;

    public Map(int l) {
        HEIGHT=l*50;
        WIDTH=l*50;
        data = new int[WIDTH * HEIGHT];
        Arrays.fill(data, -1);
        frameWall(0,0,WIDTH,HEIGHT);

    }

    public int isWall(float x, float y) {
        if((y*WIDTH+x)<WIDTH*HEIGHT)
        return data[((int)y) * WIDTH + ((int)x)];
        else
            return -1;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    private void frameWall(int rectX, int rectY, int width, int height) {
        int textureOffset = 0;
        for (int x = rectX; x < rectX + width; x++) {
            data[rectY * WIDTH + x] = textureOffset++;
        }
        for (int y = rectY; y < rectY + height; y++) {
            data[y * WIDTH + rectX + width - 1] = textureOffset++;
        }
        for (int x = rectX + width - 1; x >= rectX; x--) {
            data[(rectY + height - 1) * WIDTH + x] = textureOffset++;
        }
        for (int y = rectY + height - 1; y >= rectY ; y--) {
            data[y * WIDTH + rectX] = textureOffset++;
        }
    }

    public void MakeMap(Case[] cases,int l){
        Case c;
        int x=1;
        int y=1;
        for (int i=0; i<l*l;i++){
            c = cases[i];

            if (c.getN()) {
                frameWall(x,y,0,25);
            }

            if (c.getS()) {
                frameWall(x,y+25,0,25);
            }

            if (c.getO()) {
                frameWall(x,y,25,0);
            }

            if (c.getE()) {
                frameWall(x+25,y,25,0);
            }

            x += 25;

            if (i % l == l - 1) {
                y += 25;
                x = 1;
            }
        }
    }


}
