
import Graph.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        GraphMatrix g = new GraphMatrix("gM.txt");
        g.draw("hello.jpg");
    }
}
/*import
 java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main  {

    public static void main(String[] args) throws IOException{
        BufferedImage img = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = img.createGraphics();

        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, img.getWidth(), img.getHeight());
        graph.setColor(Color.BLACK);
        graph.setFont(new Font("Arial",Font.BOLD,15));
        graph.drawString("Hello it's me", 100, 100);

        try {
            ImageIO.write(img, "jpg", new File("out.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
