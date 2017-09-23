package Graph;

import java.io.*;
import java.util.*;

public class GraphList extends Graph {
    protected LinkedList<LinkedList<Integer>> AdjL;

    public GraphList(String fileName) throws IOException {
        readFile(fileName);
    }

    public GraphList(GraphMatrix gM) {
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
        for (int i = 0; i < AdjL.size(); i++) {
            LinkedList<Integer> l = AdjL.get(i);
            for (int j = 1; j < l.size(); j++) {
                writer.write(i + " " + l.get(j) + "\r\n");
            }
           /* ListIterator it = l.listIterator();
            it.next();
            while(it.hasNext()){
                writer.write(i+" "+(Integer)it.next() +"\r\n");
            }*/
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

    public Graph changeStorageType() throws IOException {
        return new GraphMatrix(this);
    }
}
