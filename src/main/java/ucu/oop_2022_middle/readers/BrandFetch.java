package ucu.oop_2022_middle.readers;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import ucu.oop_2022_middle.domain_data.DomainData;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BrandFetch {
    private static final String API_KEY = "Bearer zzDaqWEdg6vpusJqsyxDegxkmzNTs1tEKVH+TvdCK+Q=";


    private JSONObject jsonObject;

    public JSONObject getJSON() {
        return jsonObject;
    }

    @SneakyThrows
    public void setJSON(String domain) {
        String query = domain;
        URL url = new URL("https://api.brandfetch.io/v2/brands/" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        jsonObject = new JSONObject(text);

    }

    public static DomainData getDomainData2(String domain, DomainData domainData) {

        BrandFetch pdlReader = new BrandFetch();
        try {
            pdlReader.setJSON(domain);
        } catch (Exception e){
            System.out.println("Error while getting domain data");
            System.out.println(e);
            return domainData;
        }
        JSONObject jsonObject = pdlReader.getJSON();

        System.out.println(jsonObject);


//        if (!jsonObject.isNull("name")) {
//            domainData.setName(jsonObject.getString("name"));
//        }
//
//        if (!jsonObject.isNull("twitter_url")) {
//            domainData.setTwitter(jsonObject.getString("twitter_url"));
//        }
//
//        if (!jsonObject.isNull("facebook_url")) {
//            domainData.setFacebook(jsonObject.getString("facebook_url"));
//        }
//
//        if (!jsonObject.isNull("size")) {
//            domainData.setEmployees(jsonObject.getString("size"));
//        }
        JSONObject logos = jsonObject.getJSONArray("logos"
        ).getJSONObject(0).getJSONArray("formats").getJSONObject(0);
        if (logos != null) {
            domainData.setIcon(logos.getString("src"));
        }

        logos = jsonObject.getJSONArray("logos"
        ).getJSONObject(1).getJSONArray("formats").getJSONObject(0);
        if (logos != null) {
            domainData.setLogo(logos.getString("src"));
        }

        JSONArray links = jsonObject.getJSONArray("links");
        for (int i = 0; i < links.length(); i++) {
            JSONObject link = links.getJSONObject(i);
            if (link.getString("name").equals("facebook")) {
                if (!link.isNull("url")) {
                    domainData.setFacebook(link.getString("url"));
                }
            }
            if (link.getString("name").equals("twitter")) {
                if (!link.isNull("url")) {
                    domainData.setTwitter(link.getString("url"));
                }
            }
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
