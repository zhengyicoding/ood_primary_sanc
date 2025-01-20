package model;

import enums.*;

/**
 * Represents a monkey with various attributes such as name, species, sex, size, weight, age,
 * favorite food, and health status.
 */
public class Monkey implements Comparable<Monkey> {
  /**
   * The name of the monkey.
   */
  private String name;

  /**
   * The species of the monkey.
   */
  private Species species;

  /**
   * The sex of the monkey.
   */
  private Sex sex;

  /**
   * The size of the monkey.
   */
  private double size;

  /**
   * The weight of the monkey.
   */
  private double weight;

  /**
   * The age of the monkey.
   */
  private int age;

  /**
   * The favorite food of the monkey.
   */
  private FavFood favFood;

  /**
   * The health status of the monkey.
   */
  private Health health;

  /**
   * Constructs a new model.Monkey object with the specified attributes. Set default health status
   * to TOCHECK and only changes after receiving medical care.
   *
   * @param name    The name of the monkey.
   * @param species The species of the monkey.
   * @param sex     The sex of the monkey.
   * @param size    The size of the monkey.
   * @param weight  The weight of the monkey.
   * @param age     The age of the monkey.
   * @param favFood The favorite food of the monkey.
   * @throws IllegalArgumentException if size, weight, or age is not positive.
   */
  public Monkey(String name, Species species, Sex sex, double size, double weight, int age,
                FavFood favFood) throws IllegalArgumentException {
    if (name == null || name.isEmpty() || size <= 0 || weight <= 0 || age <= 0) {
      throw new IllegalArgumentException("Please provide proper name/size/weight/age information");
    }
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favFood = favFood;
    this.health = Health.TOCHECK;
  }

  /**
   * Gets the name of the monkey.
   *
   * @return The name of the monkey.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the species of the monkey.
   *
   * @return The species of the monkey.
   */
  public Species getSpecies() {
    return species;
  }

  /**
   * Gets the health status of the monkey.
   *
   * @return The health status of the monkey.
   */
  public Health getHealth() {
    return health;
  }

  /**
   * Sets the health status of the monkey.
   *
   * @param health The health status to set.
   */
  public void setHealth(Health health) {
    this.health = health;
  }

  /**
   * Compares this monkey with another monkey based on their names.
   *
   * @param o The other monkey to compare with.
   * @return A negative integer, zero, or a positive integer as this monkey's name is less than,
   * equal to, or greater than the other monkey's name.
   */
  @Override
  public int compareTo(Monkey o) {
    return this.getName().compareTo(o.getName());
  }

  /**
   * Returns a string representation of the monkey.
   *
   * @return A string representation of the monkey, including its name, sex, and favorite food.
   */
  @Override
  public String toString() {
    return "Name: " + name + ", Sex: " + sex + ", Favorite food: " + favFood;
  }
}
