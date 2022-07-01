import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class ReadHtmlPage_HttpURLConnection {
    private String urlAdress = "http://127.0.0.1:8080/lesson23";
    private HttpURLConnection httpURLConnection = null;
    private URL url = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;

    void tryConnect()throws MalformedURLException, IOException {
        //Создаем URL
        url = new URL(urlAdress);
        //Открываем соединение - обращаемся обычным GET запросом
        //Кастим к HttpUrlConnection
        httpURLConnection = (HttpURLConnection) url.openConnection();
        // (Можем настроить соединение)
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(200);
        httpURLConnection.setReadTimeout(200);
        //Запускаем соединение
        httpURLConnection.connect();
        //Проверяем ответ
        if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("HTTP_OK");
        }
        //Создаем input stream из соединения
        inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
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
