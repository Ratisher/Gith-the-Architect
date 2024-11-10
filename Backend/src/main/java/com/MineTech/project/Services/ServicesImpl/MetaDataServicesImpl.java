package com.MineTech.project.Services.ServicesImpl;

import com.MineTech.project.Services.MetaDataServices;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

@Service
@AllArgsConstructor
public class MetaDataServicesImpl implements MetaDataServices {

    @Override
    public String getAIResponse(String cordOne, String cordTwo) {
        String url = "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=" + cordOne + "&lon=" + cordTwo + "&zoom=18";
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }

                JSONObject jsonObject = new JSONObject(json.toString());

                JSONObject address = jsonObject.optJSONObject("address");
                List<String> additionalInfo = new ArrayList<>();
                if (address != null) {
                    address.keySet().forEach(key -> {
                        if (!key.equals("house_number") && !key.equals("building")) {
                            additionalInfo.add(key + ": " + address.optString(key));
                        }
                    });
                }

                StringBuilder responseText = new StringBuilder();
                additionalInfo.forEach(info -> responseText.append(info).append("\n"));

                return responseText.toString();

            } else {
                return "Ошибка: " + response.getStatusLine().getReasonPhrase();
            }
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }
}
