package filip.vukas.alarmapp;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper extends Thread{

    private final String BaseURL = "http://192.168.31.173/";
    private String url;

        public HttpHelper(String state) {
            this.url = BaseURL + state;
        }

        @Override
        public void run() {
            try {
                Log.d("HttpHelper", url);
                URL url = new URL(this.url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");

                connection.connect();

                connection.getResponseCode();
            } catch (IOException e) {
                Log.d("Main", "error");
                e.printStackTrace();
            }
        }
}
