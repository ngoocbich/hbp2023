package controller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import model.IModel;
import view.IView;

public class TextController implements IController {
  private Scanner in;
  private IView view;
  private IModel model;

  public TextController(IModel model, InputStream in, IView view) {
    this.model = model;
    this.view = view;
    this.in = new Scanner(in);

  }

  public void go() {
    boolean quit = false;
    //tell view to show options
    while (!quit) {
      //tell view to show the string so far.
      view.showString(this.model.getString());
       view.showOptions();
      //accept user input
      String option = in.next();
      Random rand = new Random();
      switch (option) {

        case "P":
        case "p":
          view.showInstruction();
          System.out.print("Enter your number: ");
          //ask for string input
          in.nextLine();
          String input = in.nextLine();

          try{
            Integer correctInt = Integer.parseInt(input);
            if ((correctInt != 0)
                    && (correctInt != 100)
                    && (correctInt != 1)){
              System.out.print("Please enter a valid number: 0, 1, or 100. \n");
              System.out.print("Enter a new number: ");
              input = in.nextLine();
            }
          }catch (NumberFormatException ex) {
            System.out.print("Please enter a valid number: 0, 1, or 100. Not a string. \n");
          }

          String randNum = Integer.toString(model.generateNumber());
          //give to model
          model.setString("The random number was: " + randNum);
          model.setUserNum(Integer.valueOf(input));
          model.setNum(Integer.valueOf(randNum));
          System.out.print(model.compareNumber());
          System.out.print("\n______________________________________\n");
          break;

        case "D":
        case "d":
          view.showDecisionInstruction();
          System.out.print("Enter your list: ");
          //ask for string input
          in.nextLine();
          String items = in.nextLine();
          String str[] = items.split(",");
          Integer randInt = rand.nextInt(str.length + 1);
          System.out.print("The pick is " + str[randInt] + " !!! \n");
          System.out.print("\n______________________________________\n");
          break;

        case "A":
        case "a":
          view.showYesNoInstruction();
          System.out.print("Enter your yes/no question: ");
          //ask for string input
          in.nextLine();
          String ques = in.nextLine();
          ArrayList strList =
                  new ArrayList<>(Arrays.asList("Yes!", "nope.. not a good idea", "maybe?",
                          "ask me again", "NOOOO", "Absolutely", "hmmmm... I think so",
                          "hahahha what a silly question."));
          Integer randAns = rand.nextInt(strList.size());
          System.out.print(strList.get(randAns) + "\n");
          System.out.print("______________________________________\n");
          break;

        case "Q":
        case "q":
          quit = true;
          break;

        default:
          view.showOptionError();
      }
    }
  }


}
