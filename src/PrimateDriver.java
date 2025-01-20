import model.Sanctuary;
import view.*;
import controller.PrimateController;

public class PrimateDriver {

  public static void main(String[] args) {
    Sanctuary model = new Sanctuary();
    SanctuaryOverview view = new SanctuaryOverview();
    PrimateController controller = new PrimateController(model, view);
    controller.go();
  }
}