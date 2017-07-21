package ua.kpi.tef.homework01;

import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
    // The Constants
    public static final double PI = 3.14;

    // The Regex
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «http://www.my-site.com»
    public static final String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
    // «+38(044)555-55-55»
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setStringValue(inputStringWithScanner(sc));

        view.printMessage(model.getStringValue());
    }

    // The Utility methods

    public String inputStringWithScanner(Scanner sc) {

        view.printMessage(view.INPUT_FIRST_STRING_DATA);

        while( ! sc.hasNext()) {
            view.printMessage(view.WRONG_INPUT_DATA + view.INPUT_FIRST_STRING_DATA);
            sc.next();
        }

        String phrase;

        while (!(phrase = sc.next()).equals("Hello")) {
            view.printMessage(view.WRONG_INPUT_DATA + view.INPUT_FIRST_STRING_DATA);
        }

        String result = phrase;

        view.printMessage(view.INPUT_SECOND_STRING_DATA);

        while (!(phrase = sc.next()).equals("world!")) {
            view.printMessage(view.WRONG_INPUT_DATA + view.INPUT_FIRST_STRING_DATA);
        }

        result += " " + phrase;

        return result;
    }
}
