package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import controller.PrimateController;
/**
 * The AllMonkeyListPanel class represents a panel for displaying the list of all monkeys in alphabetical order.
 * It contains a text area to display the list of names.
 */
public class AllMonkeyListPanel extends JPanel {
  private JPanel nameListPanel;
  private JTextArea nameListArea;
  private JScrollPane nameScrollPane;

  /**
   * Constructs a new AllMonkeyListPanel.
   * Initializes the panel with a text area to display the list of all monkeys' names.
   */
  public AllMonkeyListPanel() {
    setLayout(new BorderLayout());

    nameListPanel = new JPanel(new GridLayout(0, 1));
    nameListPanel.setBorder(
        BorderFactory.createTitledBorder("All Monkeys Name List in Alphabetical Order"));
    nameListArea = new JTextArea();
    nameListArea.setText("");
    nameListArea.setEditable(false);
    nameScrollPane = new JScrollPane(nameListArea);
    nameListPanel.add(nameScrollPane, BorderLayout.CENTER);

    this.add(nameListPanel, BorderLayout.NORTH);
  }

  /**
   * Updates the name list with the specified list of names.
   * @param nameList The string containing the list of names.
   */
  public void updateNameList(String nameList) {
    nameListArea.setText(nameList);
  }
}
