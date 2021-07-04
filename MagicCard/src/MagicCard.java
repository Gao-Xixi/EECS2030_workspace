import java.util.ArrayList;
import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Scanner input = new Scanner("System.in");
        System.out.println("Please enter your name: ");
        String username = input.nextLine();
        System.out.println(username + ", choose a card in your mind and remember it.");
//        String[][] cards = new String[7][3];
        ArrayList<ArrayList> cards = new ArrayList<>();
        cards.add(new ArrayList("!1", "@1", "#1"));

    }

}
