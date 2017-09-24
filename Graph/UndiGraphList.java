package Graph;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;

public class UndiGraphList extends GraphList{
    UndiGraphList(String fileName) throws IOException {
        super(fileName);
    }

   /* @Override
    public void draw(String fileName)throws IOException{}*/

    @Override
    protected void drawEdge(Graphics2D graph, double angle, Color c){
        int x1, x2, y1,y2;
        int centerX = WIN_X/2, centerY = WIN_Y/2;
        LinkedList<Integer> l;
        for (int i = 1; i <= vertexNum; i++) {
            l = AdjL.get(i);
            for (int j = 1; j <l.size();j++){
                x1 = (int) (centerX + R * Math.cos(i * angle));
                y1 = (int) (centerY + R * Math.sin(i * angle));
                x2 = (int) (centerX + R * Math.cos(l.get(j) * angle));
                y2 = (int) (centerY + R * Math.sin(l.get(j) * angle));
                graph.drawLine(x1, y1, x2, y2);
            }
        }
    }
}
