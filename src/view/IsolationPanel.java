package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import controller.PrimateController;

/**
 * The IsolationPanel class represents a panel for managing monkeys in isolation.
 * It contains a list of monkeys in isolation, buttons for providing medical care and moving them to enclosures,
 * and a status message area.
 */
public class IsolationPanel extends JPanel {

  private JPanel noticePanel, isolationListPanel, buttonPanel;
  private DefaultListModel<String> isolationListModel;
  private JList<String> isolationJList;
  private JButton medicalCareButton, moveToEnclosureButton;
  private JLabel moveStatusLabel;
  private JScrollPane scrollPane;

  /**
   * Constructs a new IsolationPanel.
   * Initializes the panel with a list of monkeys in isolation, buttons for providing medical care and moving them to enclosures,
   * and a status message area.
   */
  public IsolationPanel() {
    setLayout(new BorderLayout());


    // notice area
    noticePanel = new JPanel(new GridLayout(1, 1));
    noticePanel.setPreferredSize(new Dimension(800, 50)); // Set preferred size
    this.moveStatusLabel = new JLabel("");
    noticePanel.add(moveStatusLabel);
    this.add(noticePanel, BorderLayout.NORTH);

    // List area
    isolationListPanel = new JPanel(new GridLayout(0, 1));
    isolationListPanel.setBorder(BorderFactory.createTitledBorder("Monkeys in isolation area"));
    isolationListModel = new DefaultListModel<>();
    isolationJList = new JList<>(isolationListModel);
    isolationJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPane = new JScrollPane(isolationJList);
    isolationListPanel.add(scrollPane, BorderLayout.CENTER);
    this.add(isolationListPanel, BorderLayout.CENTER);


    // Button area
    buttonPanel = new JPanel(new GridLayout(1, 1));
    medicalCareButton = new JButton("Provide Medical Care");
    medicalCareButton.setActionCommand("MedicalCare Button");
    buttonPanel.add(medicalCareButton);

    moveToEnclosureButton = new JButton("Move to Enclosure");
    moveToEnclosureButton.setActionCommand("MoveToEnclosure Button");
    buttonPanel.add(moveToEnclosureButton);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }

  /**
   * Updates the list of monkeys in isolation.
   * @param isolationList The list of monkeys in isolation to be displayed.
   */
  public void updateIsolationList(List<String> isolationList) {
    isolationListModel.clear();
    for (String element : isolationList) {
      isolationListModel.addElement(element);
    }
  }

  /**
   * Adds action listeners to the medical care and move to enclosure buttons.
   * @param controller The PrimateController object to handle button actions.
   */
  public void addFeatures(PrimateController controller) {
    this.medicalCareButton.addActionListener(evt -> {
      controller.provideMedicalCare(isolationJList.getSelectedIndex());
    });
    this.moveToEnclosureButton.addActionListener(evt -> {
      controller.moveToEnclosure(isolationJList.getSelectedIndex());
    });
  }

  /**
   * Sets the status message with the specified color.
   * @param message The status message to display.
   * @param color The color of the status message.
   */
  public void setStatusMessage(String message, Color color) {
    moveStatusLabel.setText(message);
    moveStatusLabel.setForeground(color);
  }
}
