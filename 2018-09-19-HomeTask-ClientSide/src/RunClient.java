import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RunClient {
    public static void main(String[] args) throws IOException {
        String serverName = "localhost";
        InetAddress ia = InetAddress.getByName(serverName);
        Socket socket = new Socket(ia, 31280);

        BufferedReader socketBr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter socketBw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        // String responce = "";
        while (true){
            printRootMenu();
            String action = consoleReader.readLine();
            if (action.equals("1")){
                socketBw.write(userDetails());
            }
            else if (action.equals("2")){
                socketBw.write(getUser());
            }
            else if (action.equals("3")){
                socketBw.write(removeUser());
            }
            else if (action.equals("0")) break;
            socketBw.flush();

            System.out.println(socketBr.readLine());
        }
    }

    private static String userDetails() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        //TODO: Add regexp validation of fields
        System.out.println("Enter user name:");
        String name = consoleReader.readLine();

        System.out.println("Enter user age:");
        String age = consoleReader.readLine();

        System.out.println("Enter user phone:");
        String phone = consoleReader.readLine();

        System.out.println("Enter user city:");
        String city = consoleReader.readLine();

        return "add;" + name + ";" + age + ";" + phone + ";" + city + ";\n";

    }

    private static String getUser() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please give user ID");
        String id = consoleReader.readLine();
        return "get;" + id + ";\n";
    }

    private static String removeUser() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please give user ID to remove:");
        String id = consoleReader.readLine();
        return "remove;" + id + ";\n";
    }

    private static void printRootMenu(){
        System.out.println("1. Add new person");
        System.out.println("2. Show person by ID");
        //System.out.println("3. Show all persons");
        System.out.println("3. Remove person by ID");
        System.out.println("0. Exit");
    }
}
