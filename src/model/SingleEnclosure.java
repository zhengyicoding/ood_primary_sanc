package model;

import enums.*;

import java.util.Collections;
import java.util.List;
import model.HousingUnit;
import model.Monkey;

/**
 * Represents a single enclosure housing unit for monkeys of a specific species.
 * Inherits functionality from the {@link HousingUnit} abstract class.
 * This class provides specific behavior for managing monkeys in a single enclosure.
 */
public class SingleEnclosure extends HousingUnit {
  /**
   * The species of monkeys housed in this enclosure.
   */
  private Species species;

  /**
   * Constructs a new instance of the {@code model.SingleEnclosure} class with the specified species.
   * Initializes the list of monkeys and sets the species of the enclosure.
   *
   * @param species The species of monkeys housed in this enclosure.
   */
  public SingleEnclosure(Species species) {
    super();
    this.species = species;
  }

  /**
   * Adds a healthy monkey of the specified species to the enclosure.
   *
   * @param monkey The monkey to be added to the enclosure.
   * @throws IllegalArgumentException If the monkey is not healthy or if it belongs to an incompatible species.
   */
  @Override
  public void addMonkey(Monkey monkey) {
    if (monkey.getSpecies().equals(this.species)) {
      if (monkey.getHealth() == Health.HEALTHY) {
        monkeys.add(monkey);
      } else {
        throw new IllegalArgumentException(
            String.format("Monkey %s is not healthy, cannot add into the enclosure",
                monkey.getName()));
      }
    } else {
      throw new IllegalArgumentException(
          "Cannot add monkey to this enclosure due to incompatible species");
    }
  }

  /**
   * Returns a string representation of the enclosure.
   * Includes the species of monkeys and the list of monkeys in the enclosure.
   *
   * @return A string representation of the enclosure.
   */
  @Override
  public String toString() {
    List<Monkey> monkeys = getMonkey();
    Collections.sort(monkeys);
    StringBuilder listStr = new StringBuilder();
    listStr.append(String.format("[Species %s:", species));
    for (int i = 0; i < monkeys.size(); i++) {
      listStr.append("\n" + (i + 1) + ". " + monkeys.get(i).toString());
      if (i < monkeys.size() - 1) {
        listStr.append(";");
      }
    }
    listStr.append(".]");
    return listStr.toString();
  }
}
