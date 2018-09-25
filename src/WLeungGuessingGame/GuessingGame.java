package WLeungGuessingGame;

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args)
    {
        Scanner guess = new Scanner(System.in);
        System.out.println("Which game would you like to play? 1 = Player Guessing Game, 2 = AI Guessing Game.");
        int gameMode = guess.nextInt();
        if(gameMode == 1)
        {
            System.out.println("Choose difficulty. 1 = Easy, 2 = Normal, 3 = Hard, 4 = Expert");
            int max = 10;
            int difficulty = guess.nextInt();
            if(difficulty == 1)
            {
                System.out.println("You have chosen Easy.");
            }
            else
            {
                if (difficulty == 2)
                {
                    max = 100;
                    System.out.println("You have chosen Normal.");
                }
                else
                {
                    if (difficulty == 3)
                    {
                        max = 1000;
                        System.out.println("You have chosen Hard.");
                    }
                    else
                    {
                        if(difficulty == 4)
                        {
                            max = 10000;
                            System.out.println("You have chosen Expert.");
                        }
                    }
                }
            }
            System.out.println("Start Guessing!");
            int min = 1;
            double rndNum = Math.floor(Math.random() * max) + min;
            int pGuess = 1;
            boolean gameRunning = true;
            while(gameRunning == true) {
                pGuess = guess.nextInt();
                if (pGuess == rndNum) {
                    System.out.println("You win! The number was " + rndNum);
                    gameRunning = false;
                }
                else
                {
                    if(pGuess > rndNum)
                    {
                        System.out.println("Your guess is greater than the random number.");
                    }
                    else
                    {
                        System.out.println("Your guess is less than the random number.");
                    }
                }
            }
        }
        else
        {
            System.out.println("Hello. What is your first name? (Don't include spaces.");
            String name = guess.next();
            System.out.println("Okay " + name + ". " + "Think of a range of numbers from 1 to any number and choose a number from that range. Now enter the largest number of your range.");
            int max = guess.nextInt();
            boolean gameRunning = true;
            int aiGuess = max/2;
            int Guesses = 1;
            String gOrL = "";
            while(gameRunning == true)
            {
                System.out.println(name + " , is your number " + aiGuess + "? Type g if your number is greater than the guess. Type l if your number is less than the guess. Type yes if it is your number.");
                gOrL = guess.next().toLowerCase();
                if(gOrL.equals("yes"))
                {
                    System.out.println("Your number was " + aiGuess + ". It took the AI " + Guesses + " guesses to guess your number. Thanks for playing!" );
                    gameRunning = false;
                }
                else
                {
                    Guesses++;
                    if (gOrL.equals("g"))
                    {
                        aiGuess = aiGuess + max / (Guesses + 1);
                    }
                    else
                    {
                        if(gOrL.equals("l"))
                        {
                            aiGuess = aiGuess - max / (Guesses + 1);
                        }
                    }
                }
            }
        }
    }
}
