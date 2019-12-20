package service.soccer;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SoccerService {

    public static DateRequest getDateRequest(String urlTarget) {
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
            http.setRequestProperty("X-Auth-Token", "13a1702cdce3404ba04145de036a39b8");
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

    @RequestMapping(value="/{sport}/{league}/{date}",method=RequestMethod.GET)
    public List<Match> getMatches(@PathVariable("sport") String sport, @PathVariable("league") String league, @PathVariable("date") String date) {
        String url = "https://api.football-data.org/v2/competitions/" + league +"/matches?dateFrom="+ date +"&dateTo=" + date;
        List<Match> matches = getDateRequest(url).getMatches();
        return matches;
    }

}
