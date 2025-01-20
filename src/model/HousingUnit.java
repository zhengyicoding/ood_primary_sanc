package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Abstract class representing a generic implementation of the {@link Housing} interface.
 * This class provides basic functionality for managing monkeys in a housing unit.
 */
public abstract class HousingUnit implements Housing {

  /** The list of monkeys residing in the housing unit. */
  protected List<Monkey> monkeys;

  /**
   * Constructs a new instance of the {@code HousingImpl} class.
   * Initializes the list of monkeys as an empty ArrayList.
   */
  public HousingUnit() {
    this.monkeys = new ArrayList<>();
  }

  @Override
  public void removeMonkey(Monkey monkey) throws IllegalStateException {
    if (monkeys.contains(monkey)) {
      monkeys.remove(monkey);
    } else {
      throw new IllegalArgumentException(
          String.format("The monkey %s is not found", monkey.getName()));
    }
  }

  @Override
  public List<Monkey> getMonkey() {
    List<Monkey> monkeyList = new ArrayList<>(monkeys);
    Collections.sort(monkeyList);
    return monkeyList;
  }

  @Override
  public List<String> getMonkeyName() {
    List<String> nameList = new ArrayList<>();
    List<Monkey> monkeyList = getMonkey();
    for (Monkey monkey : monkeyList) {
      nameList.add(monkey.getName());
    }
    return nameList;
  }
}
