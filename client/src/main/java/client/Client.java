package client;

import org.springframework.web.client.RestTemplate;
import service.core.ClientRequest;

import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        String host = "localhost:8080";
        if (args.length > 0)
            host = args[0];

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + host + "/";
        Scanner in = new Scanner(System.in);

        // print welcome message
        System.out.println("Welcome to the Live Score System, created by");
        for (String s : art)
            System.out.println(s);

        /*while (true){
            ClientRequest request = new ClientRequest();
            System.out.println("Choose league from the list below (or type \"exit\"): ");
            for (String s : leagues)
                System.out.println(s);
            String input = in.nextLine();
            if (input.equals("exit")){
                break;
            }
        }*/

    }


    private static final String[] leagues = {
            "0.  UEFA Champions League",
            "1.  Primeira Liga",
            "2.  Premier League",
            "3.  Eredivisie",
            "4.  Bundesliga",
            "5.  Ligue 1",
            "6.  Serie A (Italy)",
            "7.  La Liga",
            "8.  EFL Championship",
            "9.  Serie A (Brazil)",
            "10. FIFA World Cup",
            "11. UEFA European Championship"
    };

    private static final String[] art = {
            "    ____  _________________   ___                                  __",
            "   / __ \\/ ____/ ___/_  __/  /   |  ____________  __________  ____/ /",
            "  / /_/ / __/  \\__ \\ / /    / /| | / ___/ ___/ / / / ___/ _ \\/ __  / ",
            " / _, _/ /___ ___/ // /    / ___ |(__  |__  ) /_/ / /  /  __/ /_/ /  ",
            "/_/ |_/_____//____//_/    /_/  |_/____/____/\\__,_/_/   \\___/\\__,_/   \n"
    };

    private static void pressEnter(){
        System.out.print("Press ENTER to continue");
    }
}
