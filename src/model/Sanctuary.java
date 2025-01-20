package model;

import enums.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a sanctuary for housing, taking medical care and moving of monkeys.
 * Any newly come monkeys are put into isolation and then move to enclosure after
 * receiving medical care.
 * The sanctuary manages isolation cages and enclosures for different species of monkeys.
 * Also, it manages records of all monkeys, which sanctuary they are in and a full name list.
 */
public class Sanctuary {
  /**
   * The isolation cages for housing new coming monkeys into isolation.
   */
  private IsolationCages isolation;
  /**
   * The enclosures for housing monkeys based on their species.
   */
  private HashMap<Species, SingleEnclosure> enclosures;

  /**
   * The maximum capacity of enclosures in the sanctuary.
   */
  private static final int ENCLOSURECAPACITY = 8;

  /**
   * Constructs a new instance of the model.Sanctuary class.
   * Initializes the isolation cages and enclosures.
   */
  public Sanctuary() {
    isolation = new IsolationCages();
    enclosures = new HashMap<>();
  }

  public Monkey getMonkey(String name) {
    for (Monkey monkey : isolation.getMonkey()) {
      if (monkey.getName().equals(name)) {
        return monkey;
      }
    }
    throw new IllegalStateException(String.format("Can't find the monkey %s in isolation", name));
  }

  /**
   * Adds a new monkey to the sanctuary, placing it in the isolation cages.
   *
   * @param monkey The monkey to be added to the sanctuary.
   */
  public void addNewMonkey(Monkey monkey) {
    if (getIsolatedMonkeyNames().contains(monkey.getName())) {
      throw new IllegalArgumentException("There is already a monkey with the same name");
    }
    isolation.addMonkey(monkey);
  }

  /**
   * Provides medical care to a monkey in isolation, marking it as healthy.
   *
   * @param monkey The monkey to receive medical care.
   * @throws IllegalStateException If the monkey is not found in isolation.
   */
  public void provideMedicalCare(Monkey monkey) {
    if (isolation.getMonkey().contains(monkey)) {
      monkey.setHealth(Health.HEALTHY);
    } else {
      throw new IllegalStateException(
          String.format("model.Monkey %s is not found in isolation", monkey.getName()));
    }
  }

  /**
   * A helper function to create a new enclosure based on species or retrieve the single
   * enclosure if the enclosure for the species is already created.
   * Throw exception message if all 8 enclosures are taken and no new one can be created.
   *
   * @param species the species of monkey
   * @return
   */
  private SingleEnclosure getEnclosure(Species species) {
    SingleEnclosure enclosure = enclosures.get(species);
    if (enclosure == null) {
      if (enclosures.size() < ENCLOSURECAPACITY) {
        enclosure = new SingleEnclosure(species);
        enclosures.put(species, enclosure);
      } else {
        throw new IllegalStateException(
            "All 8 enclosures are full, cannot add more new monkey species");
      }
    }
    return enclosure;
  }

  /**
   * Moves a monkey from isolation to an appropriate enclosure based on its species.
   *
   * @param monkey The monkey to be moved from isolation to an enclosure.
   * @throws IllegalStateException If the monkey is not found in isolation.
   */
  public void moveToEnclosure(Monkey monkey) {
    if (isolation.getMonkey().contains(monkey)) {
      SingleEnclosure enclosure = getEnclosure(monkey.getSpecies());
      enclosure.addMonkey(monkey);
      isolation.removeMonkey(monkey);
    } else {
      throw new IllegalStateException(
          String.format("model.Monkey %s not found in isolation", monkey.getName()));
    }
  }

  /**
   * A potential helper function in case any monkey needs to be taken out from the enclosure.
   *
   * @param monkey the monkey which needs to be taken out of the enclosure.
   */
  private void removeFromEnclosure(Monkey monkey) {
    Species species = monkey.getSpecies();
    SingleEnclosure enclosure = enclosures.get(species);
    if (enclosure != null) {
      enclosure.removeMonkey(monkey);
      if (enclosure.getMonkey().isEmpty()) {
        enclosures.remove(species);
      }
    }
  }

  /**
   * Retrieves a list of unique species present in the sanctuary, including those in enclosures
   * and isolation cages.
   *
   * @return A list of unique species present in the sanctuary.
   */
  public List<Species> reportSpecies() {
    Set<Species> speciesSet = new HashSet<>();
    speciesSet.addAll(enclosures.keySet());
    for (Monkey monkey : isolation.getMonkey()) {
      speciesSet.add(monkey.getSpecies());
    }
    return speciesSet.stream().sorted().collect(Collectors.toList());
  }

  /**
   * Retrieves a list of monkeys in a specific enclosure based on the species.
   *
   * @param species The species of monkeys in the enclosure.
   * @return A list of strings representing the monkeys in the specified enclosure, including
   * the monkeys' name, sex and favorite food information.
   */
  public List<String> getSingleEnclosureList(Species species) {
    List<String> singleEnclosureList = new ArrayList<>();
    SingleEnclosure enclosure = enclosures.get(species);
    if (enclosure != null) {
      for (Monkey monkey : enclosure.getMonkey()) {
        singleEnclosureList.add(monkey.toString());
      }
    }
    return singleEnclosureList;
  }

  /**
   * Retrieves a list of strings representing all enclosures in the sanctuary, including information
   * of the monkey species of each enclosure, each monkey's name, sex and favorite food in all of
   * the enclosures/
   *
   * @return A list of strings representing all enclosures in the sanctuary including species
   * information, each monkey's name, sex, and favorite food information in each enclosure.
   */
  public List<String> getAllEnclosuresList() {
    List<Map.Entry<Species, SingleEnclosure>> entries = new ArrayList<>(enclosures.entrySet());
    entries.sort(Map.Entry.comparingByKey());
    List<SingleEnclosure> allEnclosure =
        entries.stream().map(Map.Entry::getValue).toList();
    List<String> allEnclosureList = new ArrayList<>();
    for (int i = 0; i < allEnclosure.size(); i++) {
      if (i == 0) {
        allEnclosureList.add(allEnclosure.get(i).toString());
      } else allEnclosureList.add("\n" + allEnclosure.get(i).toString());
    }
    return allEnclosureList;
  }


  /**
   * Retrieves a list of names of monkeys currently in isolation.
   *
   * @return A list of names of monkeys currently in isolation.
   */
  public List<String> getIsolatedMonkeyNames() {
    return isolation.getMonkeyName();
  }

  public List<Monkey> getIsolatedMonkey() {
    return isolation.getMonkey();
  }

  /**
   * Retrieves a list of names of all monkeys present in the sanctuary, including those in enclosures
   * and isolation cages.
   *
   * @return A list of names of all monkeys present in the sanctuary.
   */
  public List<String> getAllMonkeys() {
    List<SingleEnclosure> allEnclosure = new ArrayList<>(enclosures.values());
    List<Monkey> monkeyList = new ArrayList<>(isolation.getMonkey());
    for (SingleEnclosure enclosure : allEnclosure) {
      monkeyList.addAll(enclosure.getMonkey());
    }
    Collections.sort(monkeyList);
    List<String> nameList = new ArrayList<>();
    for (int i = 0; i < monkeyList.size(); i++) {
      if (i == 0) {
        nameList.add((i + 1) + ". " + monkeyList.get(i).getName());
      } else {
        nameList.add("\n" + (i + 1) + ". " + monkeyList.get(i).getName());
      }
    }
    return nameList;
  }
}
