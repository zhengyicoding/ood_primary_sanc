package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
/**
 * The EnclosureListPanel class represents a panel for displaying the list of monkeys in each enclosure.
 * It contains a text area to display the enclosure list.
 */
public class EnclosureListPanel extends JPanel {

  private JPanel enclosureListPanel;
  private JTextArea enclosureListArea;

  /**
   * Constructs a new EnclosureListPanel.
   * Initializes the panel with a text area to display the list of monkeys in each enclosure.
   */
  public EnclosureListPanel() {
    setLayout(new BorderLayout());

    enclosureListPanel = new JPanel(new GridLayout(0, 1));
    enclosureListPanel.setBorder(
        BorderFactory.createTitledBorder("List of monkeys in every enclosure"));


    enclosureListArea = new JTextArea();
    enclosureListArea.setText("");
    enclosureListArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(enclosureListArea);
    enclosureListPanel.add(scrollPane, BorderLayout.CENTER);
    this.add(enclosureListPanel, BorderLayout.NORTH);
  }

  /**
   * Updates the enclosure list with the specified string.
   * @param string The string containing the updated enclosure list.
   */
  public void updateEnclosureList(String string) {
    enclosureListArea.setText(string);
  }
}
