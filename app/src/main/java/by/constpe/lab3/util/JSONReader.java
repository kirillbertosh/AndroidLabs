package by.constpe.lab3.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import by.constpe.lab3.model.Bridge;

public class JSONReader {
    private static String getJsonResource(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder json = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            return json.toString();
        }
    }

    public static List<Bridge> read(InputStream inputStream) {
        try {
            List<Bridge> bridges = new ArrayList<>();

            String json = getJsonResource(inputStream);

            JSONArray jsonArray = new JSONObject(json).getJSONArray("bridges");
            for (int i = 0; i < jsonArray.length(); i++) {
                Bridge bridge = new Bridge();

                JSONObject buildingJson = jsonArray.getJSONObject(i);
                bridge.setName(buildingJson.getString("name"));
                bridge.setHeight(buildingJson.getString("height"));
                bridge.setDescription(buildingJson.getString("info"));
                bridge.setTableImage(buildingJson.getString("tableImage"));
                bridge.setDetailImage(buildingJson.getString("mainImage"));
                bridge.setUrl(buildingJson.getString("link"));

                bridges.add(bridge);
            }

            return bridges;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
