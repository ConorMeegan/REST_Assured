package client;

import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import service.core.ClientRequest;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final Scanner in = new Scanner(System.in);
    private static final String regex = "//";

    public static void main(String[] args){
        String host = "localhost:8080";
        if (args.length > 0)
            host = args[0];

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + host + "/";

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

            System.out.println("Requesting data for " + league.split(regex)[0] + " from the date " + dateString);
            ClientRequest request = new ClientRequest();
            request.setLeague(league.split(regex)[1].strip());
            request.setDate(dateString);
            System.out.println(request.getLeague() + " " + request.getDate());
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
