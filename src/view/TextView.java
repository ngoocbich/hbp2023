package view;

import java.io.PrintStream;

public class TextView implements IView{
  private PrintStream out;

  public TextView(PrintStream out) {
    this.out = out;
  }

  @Override
  public void showString(String s) {
    out.println(s);
  }

  @Override
  public void showOptions() {
    //print the UI
    out.println("Menu: ");
//    out.println("I: Zero-Hundred Instructions");
    out.println("P: Play Zero-Hundred");
    out.println("D: Decision Making Program");
    out.println("A: Ask a Yes/No Question Program");
    out.println("Q: Quit");
    out.print("Enter your choice: ");
  }
  @Override
  public void showOptionError() {
    out.print("\nInvalid option. Please try again.");
  }

  @Override
  public void showInstruction() {
    out.println("INSTRUCTIONS:");
    out.println("Pick a number: 0, 1, or 100.");
    out.println("The lowest number wins.");
    out.println("BUT WAIT! There's a special rule. " +
            "If PlayerA picks 0 and PlayerB picks 100, then PlayerA wins.");
  }

  @Override
  public void showDecisionInstruction() {
    out.println("INSTRUCTIONS:");
    out.println("Enter a series of items separated by a comma");
    out.println("Example: 'apple, kiwi, banana'" );
    out.println("Sit back and allow the program to generate a pick for you!");
  }


  @Override
  public void showYesNoInstruction() {
    out.println("INSTRUCTIONS:");
    out.println("Enter a yes/no question.");
    out.println("Example: 'Should I take a walk today??'" );
    out.println("The program will always have an answer for you!");
  }

}
