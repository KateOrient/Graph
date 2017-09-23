import Graph.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        GraphList l = new GraphList("C:\\Users\\Kate\\IdeaProjects\\Graph\\src\\gL.txt");
        l.writeConsole();
        GraphMatrix m = new GraphMatrix(l);
        m.writeConsole();
    }
}
