package classesEx;

import java.io.FileWriter;
import java.io.IOException;

public class Ex_outputData {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write("80 90 100 200 350");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
