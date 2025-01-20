package model;

import java.util.List;
import model.Monkey;

/**
 * The model.Housing interface represents a housing unit where monkeys can reside.
 * It defines methods for adding and removing monkeys from the housing unit
 * and retrieving information about the monkeys residing in it.
 */
public interface Housing {
  /**
   * Adds a monkey to the housing unit.
   *
   * @param monkey The monkey to be added.
   * @throws IllegalStateException If the housing unit is full or certain condition fails thus
   *                               cannot accommodate more monkeys.
   */
  public void addMonkey(Monkey monkey) throws IllegalStateException;

  /**
   * Removes a monkey from the housing unit.
   *
   * @param monkey The monkey to be removed.
   * @throws IllegalArgumentException If the specified monkey is not found in the housing unit.
   */
  public void removeMonkey(Monkey monkey) throws IllegalStateException;

  /**
   * Retrieves a list of monkeys residing in the housing unit.
   *
   * @return A list of monkeys residing in the housing unit.
   */
  public List<Monkey> getMonkey();

  /**
   * Retrieves a list of the names of monkeys residing in the housing unit.
   *
   * @return A list of names of monkeys residing in the housing unit.
   */
  public List<String> getMonkeyName();
}
