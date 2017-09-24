package Graph;

import java.awt.*;
import java.io.*;

public abstract class Graph {
    protected final int R = 150;
    protected final int WIN_X = 640;
    protected final int WIN_Y = 480;
    protected final int POINT_R = 6;
    protected final int TEXT_SIZE = 17;
    protected final int INTERVAL = 17;

    protected int vertexNum;

    protected abstract void read(BufferedReader reader) throws IOException;

    protected abstract void write(BufferedWriter writer) throws IOException;

    public abstract void readConsole() throws IOException;

    public abstract void readFile(String fileName) throws IOException;

    public abstract void writeConsole() throws IOException;

    public abstract void writeFile(String fileName) throws IOException;

    public abstract String getStorageType();

    public abstract Graph changeStorageType() throws IOException;

    public abstract void draw(String fileName) throws IOException;

    protected abstract void drawEdge(Graphics2D graph, double angle, Color c);

    protected void drawVertex(Graphics2D graph, double angle, Color c) {
        int x, y, addX, addY;
        double centerX = WIN_X / 2, centerY = WIN_Y / 2;
        graph.setFont(new Font("Arial", Font.PLAIN, TEXT_SIZE));
        graph.setColor(c);

        for (int i = 1; i <= vertexNum; i++) {
            addX = INTERVAL;
            addY = INTERVAL;
            x = (int) (centerX + R * Math.cos(i * angle));
            y = (int) (centerY + R * Math.sin(i * angle));
            graph.fillOval(x - POINT_R / 2, y - POINT_R / 2, POINT_R, POINT_R);
            if (x < centerX && y < centerY) {
                addX *= -1;
                addY *= -1;
            } else if (x < centerX && y >= centerY) {
                addX *= -1;
            } else if (x >= centerX && y < centerY) {
                addY *= -1;
            }
            graph.drawString("" + i, x + addX, y + addY);
        }
    }
}
