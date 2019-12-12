package service.nba;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;


public class NBAService {

    public static void main(String[] args){
        DateRequest test = getObjectFromJson();
        System.out.println("Request:");
        Gson gson = new Gson();
        String dateRequest = gson.toJson(test);
        System.out.println(dateRequest);
    }


    public static DateRequest getObjectFromJson() {
        String urlTarget = "https://api-nba-v1.p.rapidapi.com/games/date/2019-11-28";

        Gson gson = new Gson();
        String json = null;
        DateRequest result = null;

        json = getJsonStringByUrl(urlTarget);

        if (json != null) {
            result = gson.fromJson(json, DateRequest.class);
        }

        return result;
    }

    public static String getJsonStringByUrl(String urlTarget) {
        try {
            URL url = new URL(urlTarget);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestMethod("GET");
            http.setRequestProperty("X-RapidAPI-Key", "4794051e44msh03068c280a619e0p105f6fjsnbc82b8495e6d");
            http.setRequestProperty("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com");
            http.setUseCaches(false);
            http.setAllowUserInteraction(false);
            http.connect();

            int status = http.getResponseCode();

            if (status == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }

                br.close();
                return sb.toString();

            }else {
                return "URL does not answer.";
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
            return "Something didn't work";

        } catch (IOException e) {
            e.printStackTrace();
            return "Something didn't work";
        }
    }
}
