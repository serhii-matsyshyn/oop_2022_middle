package ucu.oop_2022_middle.readers;

import lombok.Getter;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLReader {
    private static final String API_KEY = "d558cf5335bb4c82aab3a0baed89cfb4a16aca967c04a22673641077241b9578";



    private static JSONObject jsonObject;
    public static JSONObject getJSON() {
        return jsonObject;
    }
    @SneakyThrows
    public static void setJSON(String domain) {
        String query = domain;
        URL url = new URL("https://api.peopledatalabs.com/v5/company/clean?website=" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        jsonObject = new JSONObject(text);

    }
    public static void clearJSON () {
        jsonObject = null;
    }

    public static  void clear() {

    }
    public static void main(String[] args) throws IOException {

        //String query = URLEncoder.encode("SELECT NAME FROM COMPANY WHERE WEBSITE='ucu.edu.ua'", StandardCharsets.UTF_8);
        String query = "ucu.edu.ua";
        System.out.println(query);
        //URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
        URL url = new URL("https://api.peopledatalabs.com/v5/company/clean?website=" + query);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("name"));

        //System.out.println(jsonObject.getJSONArray("data").getJSONObject(0).getInt("employee_count"));
    }

}