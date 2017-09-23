package Graph;


import java.io.*;
import java.util.*;

public class GraphMatrix extends Graph {
    protected int[][] AdjM;

    public GraphMatrix(GraphList gL) {
        vertexNum = gL.vertexNum;
        AdjM = new int[vertexNum + 1][vertexNum + 1];
        for (int i = 1; i <= vertexNum; i++) {
            for (int j = 1; j <= vertexNum; j++) {
                AdjM[i][j] = 0;
            }
        }
        for(int i = 1; i< gL.AdjL.size(); i++){
            LinkedList<Integer> l = gL.AdjL.get(i);
            ListIterator it = l.listIterator();
            AdjM[i][i] = (Integer)it.next();
            while(it.hasNext()){
                AdjM[i][(Integer)it.next()]--;
            }
        }
    }

    public GraphMatrix(String fileName) throws IOException {
        readFile(fileName);
    }

    @Override
    protected void read(BufferedReader reader) throws IOException {
        String s;
        s = reader.readLine();
        vertexNum = Integer.parseInt(s);
        AdjM = new int[vertexNum + 1][vertexNum + 1];
        for (int i = 1; i <= vertexNum; i++) {
            s = reader.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int j = 1;
            while (st.hasMoreTokens()) {
                AdjM[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        reader.close();
    }

    @Override
    protected void write(BufferedWriter writer) throws IOException {
        writer.write(vertexNum+"\r\n");
        for (int i = 1; i <= vertexNum; i++) {
            for (int j = 1; j <= vertexNum; j++) {
                writer.write(AdjM[i][j] + " ");
            }
            writer.write("\r\n");
        }
        writer.flush();
    }

    @Override
    public void readConsole() throws IOException{
        read(new BufferedReader(new InputStreamReader(System.in)));
    }

    @Override
    public void readFile(String fileName) throws  IOException{
        read(new BufferedReader(new FileReader(fileName)));
    }

    @Override
    public void writeConsole() throws IOException{
        write(new BufferedWriter(new OutputStreamWriter(System.out)));

    }

    @Override
    public void writeFile(String fileName) throws  IOException{
        write(new BufferedWriter(new FileWriter(fileName)));
    }

    @Override
    public String getStorageType() {
        return "Matrix";
    }

    @Override
    public Graph changeStorageType() throws IOException {
        return new GraphList(this);
    }
}
