package Graph;

import java.util.*;
import java.io.*;

public abstract class Graph {
    protected int vertexNum;

    protected abstract void read(BufferedReader reader) throws IOException;

    protected abstract void write(BufferedWriter writer) throws IOException;

    public abstract void readConsole() throws IOException;

    public abstract void readFile(String fileName) throws IOException;

    public abstract void writeConsole() throws IOException;

    public abstract void writeFile(String fileName) throws IOException;

    public abstract String getStorageType();

    public abstract Graph changeStorageType() throws IOException;
}
