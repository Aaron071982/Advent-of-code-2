import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{

        File f = new File("src/input");
        Scanner s = new Scanner(f);
        int total = 0;

        while(s.hasNext()){
            String line = s.nextLine();
            System.out.println(line);
            total += checkGame(colorCame(line));
        }
        System.out.println(total);

    }
    public static ArrayList<HashMap<String, String>> colorCame(String input){
        input = input.substring(input.indexOf(": ") + 2);
        String[] subset = input.split("; ");
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        for (int i = 0; i <subset.length; i++){
            HashMap<String, String> tempMap = new HashMap<>();
            String single = subset[i].replace(",", "");
            String[] group = single.split(" ");

            for (int j = 1; j < group.length; j+=2){
                tempMap.put(group[j], group[j-1]);
            }
            result.add(tempMap);
        }
        return result;
    }

    public static int checkGame(ArrayList<HashMap<String, String>> game){
        int red = 0;
        int green = 0;
        int blue = 0;

        for (int i = 0; i<game.size(); i++){
            HashMap<String, String> currentSubSet = game.get(i);

            //catch red
            try{
                if(Integer.parseInt(currentSubSet.get("red")) > red){
                    red = Integer.parseInt(currentSubSet.get("red"));
                }
            }
            catch (NumberFormatException e){

            }

            //catch green
            try{
                if(Integer.parseInt(currentSubSet.get("green")) > green){
                    green = Integer.parseInt(currentSubSet.get("green"));
                }
            }
            catch (NumberFormatException e){

            }

            //catch blue
            try{
                if(Integer.parseInt(currentSubSet.get("blue")) > blue){
                    blue = Integer.parseInt(currentSubSet.get("blue"));
                }
            }
            catch (NumberFormatException e){

            }

        }
        return red*green*blue;
    }

}