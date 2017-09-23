package Graph;

import java.awt.*;
import java.io.*;

public class UndiGraphList extends GraphList{
    UndiGraphList(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void draw(String fileName)throws IOException{}

    @Override
    protected void drawEdge(Graphics2D graph, double angle, Color c){}
}
