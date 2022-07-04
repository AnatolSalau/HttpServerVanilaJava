package lesson_42_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        ReadHtmlPage_URLConnection urlConnectionTest = new ReadHtmlPage_URLConnection();
        try {
            urlConnectionTest.tryConnect();
            urlConnectionTest.printBufferedReader();
            urlConnectionTest.closeStreams();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
