package ucu.oop_2022_middle.readers;

import lombok.SneakyThrows;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import ucu.oop_2022_middle.domain_data.DomainData;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SerperReader {
    private static final String API_KEY = "44f0cf46599f5cc6fa44e472cd1c487fcf6ea6c8";


    private JSONArray jsonObject;

    public JSONArray getJSON() {
        return jsonObject;
    }

    @SneakyThrows
    public void setJSON(String domain) {
        String query = domain;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[{\"q\":\"" + query+ "\",\"gl\":\"ua\",\"hl\":\"uk\",\"autocorrect\":true},{\"q\":\"google inc\",\"gl\":\"ua\",\"hl\":\"uk\",\"autocorrect\":true},{\"q\":\"tesla inc\",\"gl\":\"ua\",\"hl\":\"uk\",\"autocorrect\":true}]");
        Request request = new Request.Builder()
                .url("https://google.serper.dev/search")
                .method("POST", body)
                .addHeader("X-API-KEY", API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        jsonObject = new JSONArray(response.body().string());

    }

    public static DomainData getDomainData2(String domain, DomainData domainData) {

        SerperReader pdlReader = new SerperReader();
        try {
            pdlReader.setJSON(domain);
        } catch (Exception e){
            System.out.println("Error while getting domain data");
            System.out.println(e);
            return domainData;
        }
        JSONArray jsonObject = pdlReader.getJSON();

        System.out.println(jsonObject);

        JSONObject data = jsonObject.getJSONObject(0).getJSONObject("knowledgeGraph").getJSONObject("attributes");

        if (!data.isNull("Адреса")) {
            domainData.setAddress(data.getString("Адреса"));
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
