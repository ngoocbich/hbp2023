package view;

public interface IView {
  void showString(String s);
  void showOptions();
  void showOptionError();

  void showInstruction();

  void showYesNoInstruction();

  void showDecisionInstruction();
}
