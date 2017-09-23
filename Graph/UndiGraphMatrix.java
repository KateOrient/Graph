package Graph;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class UndiGraphMatrix extends GraphMatrix {
    public UndiGraphMatrix(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void draw(String fileName) throws IOException {
        double angle = 2 * Math.PI / vertexNum;
        BufferedImage img = new BufferedImage(WIN_X, WIN_Y, BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = img.createGraphics();

        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, WIN_X, WIN_Y);
        drawVertex(graph, angle, new Color(192, 29, 20));
        drawEdge(graph, angle, new Color(192, 29, 20));

        ImageIO.write(img, "jpg", new File(fileName));
    }

    @Override
    protected void drawEdge(Graphics2D graph, double angle, Color c) {
        int x1,y1,x2,y2;
        double centerX = WIN_X / 2, centerY = WIN_Y / 2;
        graph.setColor(c);
        for (int i = 1; i <= vertexNum; i++) {
            for(int j = i+1; j<=vertexNum; j++){
                if (AdjM[i][j] == -1){
                    x1 = (int) (centerX + R * Math.cos(i * angle));
                    y1 = (int) (centerY + R * Math.sin(i * angle));
                    x2 = (int) (centerX + R * Math.cos(j * angle));
                    y2 = (int) (centerY + R * Math.sin(j * angle));
                    graph.drawLine(x1,y1,x2,y2);
                }
            }
        }
    }
}
