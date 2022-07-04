package lesson_42_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class ReadHtmlPage_URLConnection {
    private String urlAdress = "http://127.0.0.1:8080/vanilajava";
    private URLConnection urlConnection = null;
    private URL url = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;

    void tryConnect()throws MalformedURLException, IOException {
        //Создаем URL
        url = new URL(urlAdress);
        //Создаем соединение - обращаемся обычным GET запросом
        urlConnection = url.openConnection();
        // (Можем настроить соединение)
        // с помощью urlConnection.setRequestProperty(, );
        //Создаем input stream из соединения
        inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        //Оборачиваем буффером
        bufferedReader = new BufferedReader(inputStreamReader);
    }

     void printBufferedReader() throws IOException {
        bufferedReader.lines()
                .forEach(System.out::println);
     }
     void closeStreams() throws IOException {
        inputStreamReader.close();
        bufferedReader.close();
     }
}
