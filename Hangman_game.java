import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Hangman_game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String arr[] = { "HTML", "CPU", "DART", "PYTHON", "BIT", "SQL", "PROGRAM", "MOBILE", "SIM" };
        String word = arr[random.nextInt(arr.length - 1)];
        char dis[] = new char[word.length()];
        char guess;
        int turn = 5;
        int index = -1;
        int check = 0;
        System.out.println("-------------------------------Hangman Game-------------------------------");
        for (int i = 0; i < word.length(); i++) {
            dis[i] = '_';
        }
        outer: while (turn > 0) {
            for (char X : dis) {
                System.out.print(X + " ");
            }
            if (check == word.length()) {
                System.out.println("");
                System.out.println("\n|----your Win the Game|----");
                System.out.println("");
                break outer;
            }
            System.out.println("");
            System.out.println("");
            System.out.println("guess the word");
            guess = Character.toUpperCase(sc.next().charAt(0));
            if (word.contains(Character.toString(guess))) {
                index = word.indexOf(guess);
                dis[index] = word.charAt(index);
                check++;
            } else {
                turn--;
                if (turn == 4) {
                    System.out.print("-----------------------------------------------");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("");
                    System.out.println("Its Wrong");
                } else if (turn == 3) {
                    System.out.print("-----------------------------------------------");
                    System.out.println("-                        |");
                    System.out.println("-                        |");
                    System.out.println("-                        _");
                    System.out.println("-                       / \\");
                    System.out.println("-                       \\_/ ");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Its Wrong");
                } else if (turn == 2) {
                    System.out.print("-----------------------------------------------");
                    System.out.println("-                        |");
                    System.out.println("-                        |");
                    System.out.println("-                        _");
                    System.out.println("-                       / \\");
                    System.out.println("-                       \\_/ ");
                    System.out.println("-                        |");
                    System.out.println("-                       /\\");
                    System.out.println("-                      /  \\");
                    System.out.println("-                        |");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("-");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Its Wrong");
                } else {
                    System.out.print("-----------------------------------------------");
                    System.out.println("-                        |");
                    System.out.println("-                        |");
                    System.out.println("-                        _");
                    System.out.println("-                       / \\");
                    System.out.println("-                       \\_/ ");
                    System.out.println("-                        |");
                    System.out.println("-                       /\\");
                    System.out.println("-                      /  \\");
                    System.out.println("-                        |");
                    System.out.println("-                        |");
                    System.out.println("-                       / \\");
                    System.out.println("-                      /   \\");
                    System.out.println("-                     /     \\");
                    System.out.println("");
                    System.out.println("                      GAME-OVER                   ");
                    System.out.println("");
                    break;
                }
            }
        }
    }
}
