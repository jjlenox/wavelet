import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.*;
class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    List<String> list = new ArrayList<String>();
    String StringList = new String("");
    
    public String handleRequest(URI url) {
        //list.add("Messages: ");
        //StringList = "";
        //for (int i = 0; i < list.size(); i++){
        //        
        //    }
        if (url.getPath().equals("/")) {
            
            return String.format(StringList);
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    //list.add(parameters[1]);
                    StringList = StringList + parameters[1] + "\r\n";
                    return String.format(StringList);
                }
            }
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
