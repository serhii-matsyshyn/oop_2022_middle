package ucu.oop_2022_middle.readers;

import lombok.Getter;
import lombok.SneakyThrows;
import org.json.JSONObject;
import ucu.oop_2022_middle.domain_data.DomainData;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLReader {
    private static final String API_KEY = "d558cf5335bb4c82aab3a0baed89cfb4a16aca967c04a22673641077241b9578";


    private JSONObject jsonObject;

    public JSONObject getJSON() {
        return jsonObject;
    }

    @SneakyThrows
    public void setJSON(String domain) {
        String query = domain;
        URL url = new URL("https://api.peopledatalabs.com/v5/company/clean?website=" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        jsonObject = new JSONObject(text);

    }

    public static DomainData getDomainData2(String domain, DomainData domainData) {

        PDLReader pdlReader = new PDLReader();
        try {
            pdlReader.setJSON(domain);
        } catch (Exception e){
            System.out.println("Error while getting domain data");
            return domainData;
        }
        JSONObject jsonObject = pdlReader.getJSON();

        System.out.println(jsonObject);


        if (!jsonObject.isNull("name")) {
            domainData.setName(jsonObject.getString("name"));
        }

        if (!jsonObject.isNull("twitter_url")) {
            domainData.setTwitter(jsonObject.getString("twitter_url"));
        }

        if (!jsonObject.isNull("facebook_url")) {
            domainData.setFacebook(jsonObject.getString("facebook_url"));
        }

        if (!jsonObject.isNull("size")) {
            domainData.setEmployees(jsonObject.getString("size"));
        }
        JSONObject location = jsonObject.getJSONObject("location");

        if (!location.isNull("country")) {
            domainData.setAddress(location.getString("country"));
        }

        return domainData;
    }

    public static DomainData getDomainData(String domain, DomainData domainData) {
        try {
            return getDomainData2(domain, domainData);
        } catch (Exception e) {
            System.out.println("Error while getting domain data");
            System.out.println(e);
            return domainData;
        }
    }

}
