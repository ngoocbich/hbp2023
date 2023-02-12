import controller.IController;
import controller.TextController;
import model.IModel;
import model.ZeroToHundredModel;
import view.IView;
import view.TextView;

public class NumberProgram {
  public static void main(String []args) {
    IModel model = new ZeroToHundredModel();
    IView view = new TextView(System.out);
    IController controller = new TextController(model,System.in,view);
    controller.go();
  }
}
