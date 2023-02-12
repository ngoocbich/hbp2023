package model;

import java.util.Random;

public class ZeroToHundredModel implements IModel {
  // takes in a string
  private String input;
  private Integer numGen;

  private Integer numInput;

  public ZeroToHundredModel() {
    input = "";
  }

  // returns string input
  @Override
  public void setString(String i) {
    input = i;
  }

  // gets string
  @Override
  public String getString() {
    return input;
  }

  public Integer generateNumber() {
    Random rand = new Random();
    int randNum = rand.nextInt(3);
    switch (randNum) {
      case 0:
        return 0;
      case 1:
        return 1;
      case 2:
        return 100;
    }
    return 0;
  }

  // returns number input
  public void setNum(Integer i) {
    numGen = i;
  }

  // returns number input
  public void setUserNum(Integer i) {
    numInput = i;
  }


  public String compareNumber() {
    String result = "";
    if(numGen == 0 && numInput == 100){
      result= "You won!";
    }
    if(numGen == 100 && numInput == 0){
      result= "Better luck next time.";
    }
    if(numGen == numInput){
      result= "It's a tie, try again!";
    }
    if(numGen > numInput){
      result= "You won!";
    }
    if(numGen < numInput){
      result= "You Lost!";
    }
    return result + "\n";
  }
}