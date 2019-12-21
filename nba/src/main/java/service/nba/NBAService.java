package service.nba;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.core.nba.NBADateRequest;
import service.core.nba.NBAGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

@RestController
public class NBAService {

    public static NBADateRequest getNBADateRequest(String url) {
        String urlTarget = url;

        Gson gson = new Gson();
        String json = null;
        NBADateRequest result = null;

        json = getJsonFromUrl(urlTarget);

        if (json != null) {
            result = gson.fromJson(json, NBADateRequest.class);
        }

        return result;
    }

    public static String getJsonFromUrl(String urlTarget) {
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
                    sb.append(line + "\n");
                }

                br.close();
                return sb.toString();
            }else {
                return http.getResponseMessage();
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
            return "Error";

        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @RequestMapping(value="/nba/{date}", method= RequestMethod.GET)
    public List<NBAGame> getNBAMatches(@PathVariable("date") String date) {
        String url = "https://api-nba-v1.p.rapidapi.com/games/date/"+date;
        List<NBAGame> nbaMatches = getNBADateRequest(url).getNBAApi().getNBAGames();
        return nbaMatches;
    }
}
