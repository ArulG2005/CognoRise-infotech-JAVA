import java.util.Scanner;
import java.util.Random;

public class Number_guessing_game{
    public static void main(String[] args) {
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
    int atemp=10;
    int randonnum=random.nextInt(100);
    System.out.println("-------------------| Number Guessing Game |-------------------");
    System.out.println("");
    System.out.println("");
   
    while(atemp>0){
      
        System.out.println("Guess the number 0-100");
        System.out.println("");
        int num=sc.nextInt();
        if(randonnum<num){
            System.out.println("Too high");
            System.out.println("Try Again....");
            System.out.println("");
            atemp--;
        }
        else if(randonnum>num){
            System.out.println("Too Low");
            System.out.println("Try Again....");
            System.out.println("");
            atemp--;
        }
        else{
            System.out.println("Congratulations.... 'Correct Answer'");
            System.out.println("");
            break;
        }
    }
      if(atemp==0){
        System.out.println("-------------------| Game-Over |-------------------");
        System.out.println("");
    }

    }
    
}