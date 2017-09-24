package Graph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class GraphList extends Graph {
    private final double ARROW_ANGLE;
    private final int ARROW_LEN;

    protected LinkedList<LinkedList<Integer>> AdjL;

    public GraphList(String fileName) throws IOException {
        ARROW_ANGLE = Math.PI/6;
        ARROW_LEN = 15;
        readFile(fileName);
    }

    public GraphList(GraphMatrix gM) {
        ARROW_ANGLE = Math.PI/6;
        ARROW_LEN = 15;
        vertexNum = gM.vertexNum;
        AdjL = new LinkedList<>();
        AdjL.add(new LinkedList<>());
        LinkedList<Integer> l;
        for (int i = 1; i <= vertexNum; i++) {
            l = new LinkedList<>();
            l.add(gM.AdjM[i][i]);
            for (int j = 1; j <= vertexNum; j++) {
                if (gM.AdjM[i][j] == -1) {
                    l.add(j);
                }
            }
            AdjL.add(l);
        }
    }

    @Override
    public void read(BufferedReader reader) throws IOException {
        String s;
        int deg;
        s = reader.readLine();
        vertexNum = Integer.parseInt(s);
        AdjL = new LinkedList<>();
        LinkedList<Integer> l;
        AdjL.add(new LinkedList<>());
        while ((s = reader.readLine()) != null) {
            l = new LinkedList<>();
            deg = Integer.parseInt(s);
            l.add(deg);
            for (int i = 0; i < deg; i++) {
                s = reader.readLine();
                StringTokenizer st = new StringTokenizer(s);
                st.nextToken();
                l.add(Integer.parseInt(st.nextToken()));
            }
            AdjL.add(l);
        }
        reader.close();
    }

    @Override
    public void write(BufferedWriter writer) throws IOException {
        writer.write(vertexNum + "\r\n");
        for (int i = 1; i <= vertexNum; i++) {
            LinkedList<Integer> l = AdjL.get(i);
            for (int j = 1; j < l.size(); j++) {
                writer.write(i + " " + l.get(j) + "\r\n");
            }
        }
        writer.flush();
    }

    @Override
    public void readConsole() throws IOException {
        read(new BufferedReader(new InputStreamReader(System.in)));
    }

    @Override
    public void readFile(String fileName) throws IOException {
        read(new BufferedReader(new FileReader(fileName)));
    }

    @Override
    public void writeConsole() throws IOException {
        write(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    @Override
    public void writeFile(String fileName) throws IOException {
        write(new BufferedWriter(new FileWriter(fileName)));
    }

    @Override
    public String getStorageType() {
        return "List";
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
                drawArrow(graph, c, x1, y1, x2, y2);
            }
        }
    }

    private void drawArrow(Graphics2D graph, Color c, int x1, int y1, int x2, int y2) {
        double lenght = Math.sqrt(Math.pow(Math.abs(x2 - x1),2)+Math.pow(Math.abs(y2 - y1),2));
        double angle;
        int x3,y3, x4,y4;
        angle = Math.atan2(y1 - y2, x2 - x1);
        x3 = (int) Math.round(x2 - ARROW_LEN*Math.cos(angle + ARROW_ANGLE));
        y3 = (int)Math.round(y2 +ARROW_LEN*Math.sin(angle + ARROW_ANGLE));
        x4 =(int) Math.round(x2 - ARROW_LEN*Math.cos(angle - ARROW_ANGLE));
        y4 =(int)Math.round(y2 + ARROW_LEN*Math.sin(angle - ARROW_ANGLE));
        graph.setColor(c);
        graph.drawLine(x2,y2,x3,y3);
        graph.drawLine(x2,y2,x4,y4);
    }

    @Override
    public Graph changeStorageType() throws IOException {
        return new GraphMatrix(this);
    }
}
