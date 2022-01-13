package ch6.ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("a.txt")) {

        } catch (FileNotFoundException e) {//파일이없을때 exception
            e.printStackTrace();
        } catch (IOException e) {//close exception
            e.printStackTrace();
        }
    }
}
