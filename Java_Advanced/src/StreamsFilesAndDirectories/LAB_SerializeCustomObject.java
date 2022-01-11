package StreamsFilesAndDirectories;

import java.io.*;

public class LAB_SerializeCustomObject {


    public static class Cube implements Serializable {
        private String name;
        private int width;
        private int length;
        private int height;

        public Cube(String name, int width, int length, int height) {
            this.name = name;
            this.width = width;
            this.length = length;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        Cube cube = new Cube("Ice Cube", 13, 42, 69);

        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("obj.txt"));

        outStream.writeObject(cube);
        outStream.close();
    }
}
