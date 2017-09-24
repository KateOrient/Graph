
import Graph.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        GraphMatrix g = new GraphMatrix("gM.txt");
        g.draw("gM.jpg");
    }
}

