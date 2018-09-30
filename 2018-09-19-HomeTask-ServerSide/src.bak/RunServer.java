import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class RunServer {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> personArrayList = new ArrayList<>();

        String wrongFormatMessage = "Wrong format of the line, please try again!\n";
        String addSuccessfull = "Person successfully added!";
        String personNotFound = "Person with such ID not found";

        ServerSocket serverSocket = new ServerSocket(31280);
        System.out.println("Server is ready for connection!");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected successfully");
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        while (true){
            System.out.println("Waiting for new data...");
            String line = br.readLine();
            //System.out.println(line);

            if (line.contains("exit".toLowerCase())) break;

            String[] arr = line.trim().split(";");
            System.out.println(Arrays.toString(arr));

            if (arr.length == 5)
            {
                if (arr[0].trim().toLowerCase().equals("add")){
                    personArrayList.add(parsePerson(arr));
                    bw.write(addSuccessfull + "\n");
                    bw.flush();
                    System.out.println(addSuccessfull);
                }
                else{
                    bw.write(wrongFormatMessage);
                    bw.flush();
                }
            }
            else if (arr.length == 2){
                switch (arr[0].trim().toLowerCase()) {
                    case "get": {
                        if (arr[1].trim().toLowerCase().equals("all")){
                            String result = "";
                            for (Person person: personArrayList){
                                result += serializePerson(person);
                            }
                            //System.out.println(personArrayList);
                            bw.write(result);
                            break;
                        }
                        int id = Integer.parseInt(arr[1].trim());
                        if (id < personArrayList.size() && id >= 0) {
                            Person person = personArrayList.get(id);
                            System.out.println(person);
                            bw.write(serializePerson(person) + "\n");
                            bw.flush();
                        }
                        else{
                            System.out.println(personNotFound);
                            bw.write(personNotFound + "\n");
                            bw.flush();
                        }
                        break;
                    }
                    case "remove": {
                        int id = Integer.parseInt(arr[1].trim());
                        if (id < personArrayList.size() && id >= 0) {
                            personArrayList.remove(id);
                            bw.write("Person successfully removed");
                            bw.flush();
                        }
                        break;
                    }
                    default:
                        bw.write(wrongFormatMessage);
                        break;
                }
            }
            //bw.flush();
        }
        bw.close();
        br.close();
        socket.close();
    }

    private static Person parsePerson(String[] arr){
        String name = arr[1].trim();
        int age = Integer.parseInt(arr[2].trim());
        String phone = arr[3].trim();
        String city = arr[4].trim();
        return new Person(name, age, phone, city);
    }

    private static String serializePerson(Person person){
        return person.toString();
    }
}
