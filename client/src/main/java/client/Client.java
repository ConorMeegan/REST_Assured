package client;

import org.springframework.web.client.RestTemplate;
import service.core.ClientNbaRequest;
import service.core.ClientSoccerRequest;
import service.core.MatchDetails;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final Scanner in = new Scanner(System.in);
    private static final String regex = "//";

    public static void main(String[] args){
        String host = "localhost";
        if (args.length > 0)
            host = args[0];

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + host + ":8081/";

        // print welcome message
        System.out.println("Welcome to the Live Score System, created by");
        for (String s : art)
            System.out.println(s);

        try {
            pressEnter();

            // print list of leagues available in the system
            System.out.println("Select league:");
            InputStream stream = Client.class.getClassLoader().getResourceAsStream("leagues.txt");
            assert stream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            ArrayList<String> leagues = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                if (!line.isBlank())
                    leagues.add(line);
            }
            int lineCount = 0;
            for (String s : leagues){
                System.out.println(lineCount++ + ".\t" + s.split(regex)[0]);
            }

            // accept user choice of league as index
            int index = in.nextInt();
            String league = leagues.get(index);

            // accept user choice of date
            // date format: yyyy-mm-dd
            boolean success = false;
            String dateString = null;
            while (!success) {
                System.out.println("Enter date (format: yyyy-mm-dd): ");
                dateString = in.nextLine();
                success = parseDate(dateString);
            }

            // send GET request to broadcaster
            System.out.println("Requesting data for " + league.split(regex)[0] + " from the date " + dateString);
            String leagueCode = league.split(regex)[1].strip();
            String leagueText = league.split(regex)[0].strip();
            ArrayList<MatchDetails> matches = null;
            if (leagueCode.equals("NBA")){
                ClientNbaRequest response = restTemplate.getForObject(url + "nba/" + dateString, ClientNbaRequest.class);
                matches = response.getMatches();
            }
            else{
                ClientSoccerRequest response = restTemplate.getForObject(url + "soccer/" + leagueCode + "/" + dateString, ClientSoccerRequest.class);
                matches = response.getMatches();
            }

            // display received data
            if (matches.isEmpty())
                System.out.println("No matches have been played in the " + leagueText + "on the following date: " + dateString);
            else{
                System.out.println("League: " + leagueText);
                System.out.println("Date: " + dateString);
                System.out.println("========================================================================================");
                System.out.println("           Home Team           |           Away Team           |   Score   |   Status");
                System.out.println("----------------------------------------------------------------------------------------");
                for (MatchDetails match : matches)
                    System.out.println(String.format("%-26s     |%-26s     | %3s : %-3s |%s", match.getHomeTeam(), match.getAwayTeam(), match.getHomeTeamScore(), match.getAwayTeamScore(), match.getStatus()));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private static final String[] art = {
            "    ____  _________________   ___                                  __",
            "   / __ \\/ ____/ ___/_  __/  /   |  ____________  __________  ____/ /",
            "  / /_/ / __/  \\__ \\ / /    / /| | / ___/ ___/ / / / ___/ _ \\/ __  / ",
            " / _, _/ /___ ___/ // /    / ___ |(__  |__  ) /_/ / /  /  __/ /_/ /  ",
            "/_/ |_/_____//____//_/    /_/  |_/____/____/\\__,_/_/   \\___/\\__,_/   \n"
    };

    private static void pressEnter(){
        System.out.print("Press ENTER to continue");
        in.nextLine();
    }

    private static boolean parseDate(String string){
        if (!string.matches("\\d{4}-\\d{2}-\\d{2}"))
            return false;

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        try{
            formatter.parse(string);
        }
        catch (DateTimeParseException e){
            return false;
        }

        return true;
    }
}
