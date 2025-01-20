package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import controller.PrimateController;
import enums.FavFood;
import enums.Sex;
import enums.Species;
/**
 * The RegistrationPanel class represents a panel for registering new monkeys.
 * It contains input fields for the monkey's name, species, sex, size, weight, age, and favorite food,
 * as well as buttons for registering a new monkey and clearing input fields.
 */

public class RegistrationPanel extends JPanel {
  private JTextField nameField, sizeField, weightField, ageField;
  private JComboBox<Species> speciesComboBox;
  private JComboBox<Sex> sexComboBox;
  private JComboBox<FavFood> favFoodComboBox;
  private JButton registerMonkeyButton, clearInputButton;
  private JLabel registrationStatusLabel;
  private JPanel noticePanel, registrationPanel;

  /**
   * Constructs a new RegistrationPanel.
   * Initializes the panel with input fields, combo boxes, buttons, and labels for monkey registration.
   */
  public RegistrationPanel() {
    setPreferredSize(new Dimension(800, 400));

    // notice area
    noticePanel = new JPanel(new GridLayout(1, 1));
    noticePanel.setPreferredSize(new Dimension(800, 50));
    this.add(noticePanel);
    this.registrationStatusLabel = new JLabel("");
    noticePanel.add(registrationStatusLabel);

    // register area
    registrationPanel = new JPanel(new GridLayout(0, 2));
    registrationPanel.setBorder(BorderFactory.createTitledBorder("Register New Monkey"));
    // create fields and combo boxes for adding a new monkey
    registrationPanel.add(new JLabel("Name: "));
    nameField = new JTextField();
    registrationPanel.add(nameField);

    registrationPanel.add(new JLabel("Species: "));
    speciesComboBox = new JComboBox<>(Species.values());
    registrationPanel.add(speciesComboBox);

    registrationPanel.add(new JLabel("Sex: "));
    sexComboBox = new JComboBox<>(Sex.values());
    registrationPanel.add(sexComboBox);

    registrationPanel.add(new JLabel("Size:"));
    sizeField = new JTextField();
    registrationPanel.add(sizeField);

    registrationPanel.add(new JLabel("Weight:"));
    weightField = new JTextField();
    registrationPanel.add(weightField);

    registrationPanel.add(new JLabel("Age:"));
    ageField = new JTextField();
    registrationPanel.add(ageField);

    registrationPanel.add(new JLabel("Favorite Food:"));
    favFoodComboBox = new JComboBox<>(FavFood.values());
    registrationPanel.add(favFoodComboBox);


    // create a button to register new monkeys
    registerMonkeyButton = new JButton("Register New Monkey");
    registerMonkeyButton.setActionCommand("Register Button");
    registrationPanel.add(registerMonkeyButton);

    clearInputButton = new JButton("Clear input");
    clearInputButton.setActionCommand("ClearInput Button");
    registrationPanel.add(clearInputButton);

    this.add(registrationPanel);

  }

  /**
   * Adds action listeners to the register button.
   * @param controller The PrimateController object to handle registration actions.
   */
  public void addFeatures(PrimateController controller) {
    this.registerMonkeyButton.addActionListener(evt -> controller.register(
        nameField.getText(),
        (Sex) sexComboBox.getSelectedItem(),
        (Species) speciesComboBox.getSelectedItem(),
        sizeField.getText(),
        weightField.getText(),
        ageField.getText(),
        (FavFood) favFoodComboBox.getSelectedItem()
    ));
  }

  /**
   * Sets the registration status message with the specified color.
   * @param message The status message to display.
   * @param color The color of the status message.
   */
  public void setRegistrationStatusMessage(String message, Color color) {
    registrationStatusLabel.setText(message);
    registrationStatusLabel.setForeground(color);
  }

  /**
   * Clears all input fields.
   */
  public void clearInput() {
    nameField.setText("");
    speciesComboBox.setSelectedIndex(0);
    sexComboBox.setSelectedIndex(0);
    sizeField.setText("");
    weightField.setText("");
    ageField.setText("");
    favFoodComboBox.setSelectedIndex(0);
  }
}
