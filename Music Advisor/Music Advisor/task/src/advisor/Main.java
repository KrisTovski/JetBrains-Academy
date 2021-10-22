package advisor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static boolean isAuthorized = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State state = null;
        Authorization authorization = new Authorization(args);

        do {
            if (scanner.hasNextLine()) {
                String[] input = scanner.nextLine().split("\\s+");
                state = setState(input[0]);

                if (state == State.AUTH) {
                    authorization.auth();
                } else if (state != null && state != State.EXIT) {
                    Lists lists = ListsFactory.newLists(state);
                    lists.action();
                }

            }
        } while (state != State.EXIT);
        System.out.println("---GOODBYE!---");
    }

    private static State setState(String option) {
        switch (option) {
            case "auth":
                return State.AUTH;
            case "exit":
                return State.EXIT;
            case "featured":
                return State.FEATURED;
            case "new":
                return State.NEW;
            case "categories":
                return State.CATEGORIES;
            case "playlists":
                return State.PLAYLISTS;
        }
        return null;
    }

}

enum State {
    AUTH, EXIT, NEW, CATEGORIES, FEATURED, PLAYLISTS
}

class ListsFactory {

    public static Lists newLists(State type) {
        switch (type) {
            case FEATURED:
                return new FeaturedLists();
            case PLAYLISTS:
                return new PlayLists();
            case CATEGORIES:
                return new CategoriesLists();
            case NEW:
                return new NewLists();
        }
        return null;
    }
}

abstract class Lists {

    void action() {
        if (Main.isAuthorized) {
            print();
        } else {
            noAuthInfoPrint();
        }

    }

    abstract void print();

    void noAuthInfoPrint() {
        System.out.println("Please, provide access for application.");
    }

}

class PlayLists extends Lists {

    @Override
    void print() {
        System.out.println("---MOOD PLAYLISTS---");
        System.out.println("Walk Like A Badass");
        System.out.println("Rage Beats");
        System.out.println("Arab Mood Booster");
        System.out.println("Sunday Stroll");
    }

}

class CategoriesLists extends Lists {

    @Override
    void print() {
        System.out.println("---CATEGORIES---");
        System.out.println("Top Lists");
        System.out.println("Pop");
        System.out.println("Mood");
        System.out.println("Latin");
    }

}

class NewLists extends Lists {

    @Override
    void print() {
        System.out.println("---NEW RELEASES---");
        System.out.println("Mountains [Sia, Diplo, Labrinth]");
        System.out.println("Runaway [Lil Peep]");
        System.out.println("The Greatest Show [Panic! At The Disco]");
        System.out.println("All Out Life [Slipknot]");
    }

}

class FeaturedLists extends Lists {

    @Override
    void print() {
        System.out.println("---FEATURED---");
        System.out.println("Mellow Morning");
        System.out.println("Wake Up and Smell the Coffee");
        System.out.println("Monday Motivation");
        System.out.println("Songs to Sing in the Shower");
    }

}

class Authorization {
    String accessServer = "https://accounts.spotify.com";
    String clientID = "fd167311c3ef49fda3e4cacdd393c4bc";
    String clientKey = "b463c877f56745c68148e74b0c999f57";
    static String port = "8080";
    String localServer = "http://localhost:" + port;
    String authLink;
    static String authCode = null;
    String token = null;

    public Authorization(String[] args) {
        setAccess(args);
        this.authLink = (new StringBuilder().append(accessServer)
                .append("/authorize?client_id=").append(clientID)
                .append("&redirect_uri=").append(localServer)
                .append("&response_type=code")).toString();

    }

    void auth() {

        System.out.println("use this link to request the access code:");
        System.out.println(authLink);
        System.out.println("waiting for code...");

        LocalServer server = new LocalServer();
        server.start();

        while (authCode == null) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (authCode != null) {
            System.out.println("code received");
            System.out.println("making http request for access_token...");
            token = setToken();

            System.out.println("response:");
            if (token != null) {
                System.out.println(token);
                Main.isAuthorized = true;
                System.out.println("---SUCCESS---");
            }

        }
    }

    private void setAccess(String[] args) {
        if (args != null && args.length == 2) {
            if ("-access".equals(args[0])) {
                this.accessServer = args[1];
            }
        }
    }

    private String setToken() {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(accessServer + "/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code&code=" + authCode + "&client_id=" + clientID + "&client_secret=" + clientKey + "&redirect_uri=" + localServer))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            //ex.printStackTrace();
        }

        return response.body();
    }
}

class LocalServer extends Thread {

    boolean end = false;
    String query = null;

    @Override
    public void run() {
        HttpServer server = null;
        try {
            server = HttpServer.create();
            server.bind(new InetSocketAddress(Integer.valueOf(Authorization.port)), 0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                query = exchange.getRequestURI().getQuery();
                String response = "";
                if (query != null && query != "") {
                    if (query.startsWith("code=")) {
                        response = "Got the code. Return back to your program.";
                        end = true;
                        Authorization.authCode = query.split("=")[1];
                        Thread.currentThread().interrupt();
                    } else {
                        response = "Authorization code not found. Try again.";
                    }
                }
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.getResponseBody().close();
            }
        });
        server.start();
    }

}
