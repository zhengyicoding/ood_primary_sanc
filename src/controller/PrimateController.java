package controller;

import java.awt.Color;
import java.util.List;
import enums.FavFood;
import enums.Sex;
import enums.Species;
import model.Monkey;
import model.Sanctuary;
import view.SanctuaryOverview;

/**
 * The PrimateController class represents the controller component of the Primate Sanctuary
 * application.
 * It mediates communication between the model (Sanctuary) and the view (SanctuaryOverview).
 */
public class PrimateController {
  Sanctuary model;
  SanctuaryOverview view;

  /**
   * Constructs a new PrimateController with the specified model and view.
   * Initializes the controller and adds necessary features to the view components.
   *
   * @param model The Sanctuary model.
   * @param view  The SanctuaryOverview view.
   */
  public PrimateController(Sanctuary model, SanctuaryOverview view) {
    this.model = model;
    this.view = view;
    view.getRegistrationPanel().addFeatures(this);
    view.getIsolationPanel().addFeatures(this);
  }

  /**
   * Registers a new monkey with the specified attributes.
   * Displays appropriate status messages based on the outcome of the registration.
   *
   * @param name         The name of the monkey.
   * @param sex          The sex of the monkey.
   * @param species      The species of the monkey.
   * @param size         The size of the monkey.
   * @param weight       The weight of the monkey.
   * @param age          The age of the monkey.
   * @param favoriteFood The favorite food of the monkey.
   */
  public void register(String name, Sex sex, Species species, String size, String weight,
                       String age,
                       FavFood favoriteFood) {
    try {
      double s = Double.parseDouble(size);
      double w = Double.parseDouble(weight);
      int a = Integer.parseInt(age);
      model.addNewMonkey(new Monkey(name, species, sex, s, w, a, favoriteFood));
      view.getRegistrationPanel()
          .setRegistrationStatusMessage("Successfully registered " + name, Color.blue);
      updateIsolation();
      updateFullList();
      updateEnclosureList();
    } catch (NumberFormatException err) {
      view.getRegistrationPanel()
          .setRegistrationStatusMessage("Incorrect input for size/weight/age", Color.red);
    } catch (IllegalArgumentException err) {
      view.getRegistrationPanel()
          .setRegistrationStatusMessage(err.getMessage(),
              Color.red);
    } catch (IllegalStateException e) {
      view.getRegistrationPanel()
          .setRegistrationStatusMessage("All isolation cages are full", Color.red);
    }
    view.getRegistrationPanel().clearInput();
  }

  /**
   * Updates the list of monkeys in isolation displayed in the view.
   */
  public void updateIsolation() {
    List<String> monkeyNames = model.getIsolatedMonkeyNames();
    view.getIsolationPanel().updateIsolationList(monkeyNames);
  }

  /**
   * Provides medical care to the selected monkey in isolation.
   * Displays appropriate status messages based on the outcome of the operation.
   *
   * @param selectedIndex The index of the selected monkey.
   */
  public void provideMedicalCare(int selectedIndex) {
    Monkey monkey = model.getIsolatedMonkey().get(selectedIndex);
    try {
      model.provideMedicalCare(monkey);
      view.getIsolationPanel()
          .setStatusMessage(monkey.getName() + " received medical care and became healthy",
              Color.blue);
    } catch (IllegalArgumentException e) {
      view.getIsolationPanel().setStatusMessage(e.getMessage(), Color.red);
    }
  }

  /**
   * Moves the selected monkey from isolation to an enclosure.
   * Displays appropriate status messages based on the outcome of the operation.
   *
   * @param selectedIndex The index of the selected monkey.
   */
  public void moveToEnclosure(int selectedIndex) {
    Monkey monkey = model.getIsolatedMonkey().get(selectedIndex);
    try {
      model.moveToEnclosure(monkey);
      updateIsolation();
      updateEnclosureList();
      view.getIsolationPanel()
          .setStatusMessage(monkey.getName() + " is successfully moved to the enclosure",
              Color.blue);
    } catch (IllegalStateException | IllegalArgumentException e) {
      view.getIsolationPanel().setStatusMessage(e.getMessage(), Color.red);
    }
  }

  /**
   * Updates the list of enclosures displayed in the view.
   */
  public void updateEnclosureList() {
    List<String> enclosureList = model.getAllEnclosuresList();
    StringBuilder sb = new StringBuilder();
    for (String element : enclosureList) {
      sb.append(element).append("\n");
    }
    view.getEnclosureListPanel().updateEnclosureList(sb.toString());
  }

  /**
   * Updates the list of all monkeys displayed in the view.
   */
  public void updateFullList() {
    List<String> nameList = model.getAllMonkeys();
    StringBuilder sb = new StringBuilder();
    for (String name : nameList) {
      sb.append(name).append("\n");
    }
    view.getAllMonkeyListPanel().updateNameList(sb.toString());
  }

  /**
   * Displays the view as the driver code
   */
  public void go() {
    view.setVisible(true);
  }
}