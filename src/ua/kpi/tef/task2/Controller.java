package ua.kpi.tef.task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void startGame(){
        Scanner sc = new Scanner(System.in);

        model.setNumber((int)(Math.random()*100));

        int winNumber = model.getNumber();
        System.out.println(winNumber);
        int guess;
        int min = 0;
        int max = 100;
        int guessCount = 0;

        ArrayList<Integer> list = new ArrayList<>();

        view.printMessage(View.INPUT_INT_DATA);

        while ((guess = sc.nextInt()) < min || (guess > max)) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_INT_DATA);
            guessCount++;
            list.add(guess);
        }

        while (guess != winNumber) {

            while (guess < min || (guess > max)) {
                view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_INT_DATA);
                list.add(guess);
                guess = sc.nextInt();
                guessCount++;
            }

            if (guess == winNumber) break;

            if (guess > winNumber) {
                max = guess;
            }
            else min = guess;

            view.printMessage(View.WRONG_NUMBER);
            view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
            view.printMessage(View.YOUR_QUESS + guess);
            list.add(guess);
            guessCount++;
            guess = sc.nextInt();
        }

        guessCount++;
        list.add(guess);
        view.printMessage(View.YOU_WIN);
        view.printMessage(View.YOUR_QUESS + guess);
        view.printMessage(View.RANGE_OF_NUMBERS + min + " " + max);
        view.printMessage(View.NUMBER_OF_GUESSES + guessCount);
        view.printListOfGuesses(list);

    }

    // The Utility methods
    // I dont get it
    // Should this method be called every time Uzver made a bad choice and change the Winnumber to something different ???

    public int rand(int min, int max) {

        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }
}
