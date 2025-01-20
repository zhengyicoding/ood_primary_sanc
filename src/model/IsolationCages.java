package model;

import model.HousingUnit;

/**
 * Represents a housing unit specialized for isolating monkeys.
 * Inherits functionality from the {@link HousingUnit} abstract class.
 * This class provides specific behavior for managing monkeys in isolation cages.
 */
public class IsolationCages extends HousingUnit {

  /**
   * The maximum capacity of the isolation cages.
   */
  private static final int MAX_CAP = 20;

  /**
   * Constructs a new instance of the {@code model.IsolationCages} class.
   * Initializes the list of monkeys and sets the maximum capacity of the isolation cages.
   */
  public IsolationCages() {
    super();
  }

  /**
   * Adds a monkey to the isolation cages.
   * Throws an exception if the isolation cages are already at maximum capacity
   * or if the monkey is already in isolation.
   *
   * @param monkey The monkey to be added to the isolation cages.
   * @throws IllegalStateException If the isolation cages are full or if the monkey is already in isolation.
   */
  @Override
  public void addMonkey(Monkey monkey) throws IllegalStateException {
    if (monkeys.size() < MAX_CAP) {
      if (!monkeys.contains(monkey)) {
        monkeys.add(monkey);
      } else {
        throw new IllegalStateException(
            String.format("model.Monkey %s already in isolation", monkey.getName()));
      }
    } else {
      throw new IllegalStateException("Isolation cages are all full, cannot add new monkeys");
    }
  }
}
