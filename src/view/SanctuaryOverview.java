package view;

import javax.swing.*;
import java.awt.*;

/**
 * The SanctuaryOverview class represents the main frame of the Primate Sanctuary application.
 * It contains tabs for different functionalities such as registration, isolation, enclosure list, and full name list.
 */
public class SanctuaryOverview extends JFrame {

  /**
   * The tabbed panel for monkey registration, uer needs to input monkey information
   * and register the monkey into sanctuary by clicking a register button
   */
  public RegistrationPanel registrationPanel;
  /**
   * The tabbed panel to show a list of monkeys in isolation, user can select the monkey to
   * conduct operations of provide medical care and move to enclosure by clicking relevant
   * buttons
   */
  private IsolationPanel isolationPanel;

  /**
   * The panel for displaying the list of every enclosure, with information of species, name, sex
   * and favoriate food of each monkey in every enclosure
   */
  private EnclosureListPanel enclosureListPanel;

  /**
   * The panel for displaying the list of all monkeys' names in alphabetical order
   */
  private AllMonkeyListPanel allMonkeyListPanel;

  public SanctuaryOverview() {

    setTitle("Primate Sanctuary");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(900, 600);
    setLocationRelativeTo(null);


    JTabbedPane tabbedPane = new JTabbedPane();

    registrationPanel = new RegistrationPanel();
    isolationPanel = new IsolationPanel();
    enclosureListPanel = new EnclosureListPanel();
    allMonkeyListPanel = new AllMonkeyListPanel();

    tabbedPane.addTab("Registration", registrationPanel);
    tabbedPane.addTab("Isolation", isolationPanel);
    tabbedPane.addTab("Enclosure", enclosureListPanel);
    tabbedPane.addTab("Full Name List", allMonkeyListPanel);


    // Add the JTabbedPane to the frame
    add(tabbedPane, BorderLayout.CENTER);

    pack();
  }

  /**
   * Returns the registration panel for the controller to interact with the view
   * @return The registration panel.
   */
  public RegistrationPanel getRegistrationPanel() {
    return registrationPanel;
  }

  /**
   * Returns the isolation panel for the controller to interact with the view
   * @return The isolation panel.
   */
  public IsolationPanel getIsolationPanel() {
    return isolationPanel;
  }

  /**
   * Returns the all monkey list panel for the controller to interact with the view
   * @return The all monkey list panel.
   */
  public AllMonkeyListPanel getAllMonkeyListPanel() {
    return allMonkeyListPanel;
  }

  /**
   * Returns the enclosure list panel for the controller to interact with the view
   * @return The enclosure list panel.
   */
  public EnclosureListPanel getEnclosureListPanel(){
    return enclosureListPanel;
  }
}
