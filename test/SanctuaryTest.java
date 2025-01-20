import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import enums.*;
import model.Monkey;
import model.Sanctuary;
import org.junit.jupiter.api.*;

class SanctuaryTest {
  Monkey monkey1;
  Monkey monkey2;
  Monkey monkey3;
  Monkey monkey4;
  Monkey monkey5;
  Monkey monkey6;
  Monkey monkey7;
  Monkey monkey8;
  Monkey monkey9;
  Monkey monkey10;
  Monkey monkey11;
  Monkey monkey12;
  Monkey monkey13;
  Monkey monkey14;
  Monkey monkey15;
  Monkey monkey16;
  Monkey monkey17;
  Monkey monkey18;
  Monkey monkey19;
  Monkey monkey20;
  Sanctuary sanctuary;

  @BeforeEach
  void setUp() {
    monkey1 = new Monkey("Bobo", Species.HOWLER, Sex.MALE, 20.0, 15.0, 8, FavFood.FRUITS);
    monkey2 = new Monkey("Charles", Species.GUEREZA, Sex.FEMALE, 18.0, 14.0, 7, FavFood.INSECT);
    monkey3 = new Monkey("Max", Species.SAKI, Sex.MALE, 22.0, 16.0, 9, FavFood.LEAVES);
    monkey4 = new Monkey("Luna", Species.MANGABEY, Sex.FEMALE, 19.0, 13.0, 6, FavFood.NUTS);
    monkey5 = new Monkey("Oscar", Species.TAMARIN, Sex.MALE, 21.0, 15.5, 8, FavFood.TREE_SAP);
    monkey6 = new Monkey("Sophie", Species.SPIDER, Sex.FEMALE, 17.0, 12.0, 5, FavFood.SEEDS);
    monkey7 = new Monkey("Leo", Species.DRILL, Sex.MALE, 23.0, 17.0, 10, FavFood.EGG);
    monkey8 = new Monkey("Mia", Species.SQUIRREL, Sex.FEMALE, 20.5, 14.5, 7, FavFood.FRUITS);
    monkey9 = new Monkey("Milo", Species.HOWLER, Sex.MALE, 19.5, 15.0, 8, FavFood.INSECT);
    monkey10 = new Monkey("Lily", Species.GUEREZA, Sex.FEMALE, 21.5, 16.0, 9, FavFood.LEAVES);
    monkey11 = new Monkey("Rocky", Species.SAKI, Sex.MALE, 18.5, 14.5, 6, FavFood.NUTS);
    monkey12 = new Monkey("Bella", Species.MANGABEY, Sex.FEMALE, 22.5, 16.5, 7, FavFood.TREE_SAP);
    monkey13 = new Monkey("Charlie", Species.TAMARIN, Sex.MALE, 20.0, 15.5, 8, FavFood.SEEDS);
    monkey14 = new Monkey("Molly", Species.SPIDER, Sex.FEMALE, 19.0, 13.5, 6, FavFood.EGG);
    monkey15 = new Monkey("Sam", Species.DRILL, Sex.MALE, 22.0, 16.5, 9, FavFood.FRUITS);
    monkey16 = new Monkey("Lucy", Species.SQUIRREL, Sex.FEMALE, 21.0, 15.0, 8, FavFood.INSECT);
    monkey17 = new Monkey("Maxim", Species.HOWLER, Sex.MALE, 18.0, 14.0, 7, FavFood.LEAVES);
    monkey18 = new Monkey("Zoe", Species.GUEREZA, Sex.FEMALE, 22.0, 16.5, 8, FavFood.NUTS);
    monkey19 = new Monkey("Simba", Species.SAKI, Sex.MALE, 20.0, 15.0, 6, FavFood.TREE_SAP);
    monkey20 = new Monkey("Lucian", Species.MANGABEY, Sex.FEMALE, 19.0, 14.5, 5, FavFood.SEEDS);

    sanctuary = new Sanctuary();
  }

  @Test
  void createInvalidMonkey() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Monkey("Bobo", Species.HOWLER, Sex.MALE, -20.0, 15.0, 8, FavFood.NUTS);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Monkey("Bobo", Species.HOWLER, Sex.MALE, 20.0, -15.0, 8, FavFood.INSECT);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Monkey("Bobo", Species.HOWLER, Sex.MALE, 20.0, 15.0, -8, FavFood.FRUITS);
    });
  }

  @Test
  void addNewMonkey() {
    sanctuary.addNewMonkey(monkey1);
    assertEquals("[Bobo]", sanctuary.getIsolatedMonkeyNames().toString());
  }

  @Test
  void addToFullIsolation() {
    List<Monkey> allMonkeys =
        Arrays.asList(monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7, monkey8,
            monkey9, monkey10, monkey11, monkey12, monkey13, monkey14, monkey15, monkey16, monkey17,
            monkey18, monkey19, monkey20);
    for (Monkey monkey : allMonkeys) {
      sanctuary.addNewMonkey(monkey);
    }
    Monkey newMonkey = new Monkey("Kiki", Species.HOWLER, Sex.MALE, 20.0, 15.0, 8, FavFood.NUTS);
    assertThrows(IllegalStateException.class, () -> {
      sanctuary.addNewMonkey(newMonkey);
    });
  }

  @Test
  void moveUnhealthyToEnclosure() {
    sanctuary.addNewMonkey(monkey14);
    assertThrows(IllegalArgumentException.class, () -> {
      sanctuary.moveToEnclosure(monkey14);
    });
  }

  @Test
  void moreHealthyToEnclosure() {
    sanctuary.addNewMonkey(monkey14);
    sanctuary.provideMedicalCare(monkey14);
    sanctuary.moveToEnclosure(monkey14);
    assertEquals("[[Species SPIDER:\n" +
            "1. Name: Molly, enums.Sex: FEMALE, Favorite food: EGG.]]",
        sanctuary.getAllEnclosuresList().toString());
  }

  @Test
  void reportSpecies() {
    sanctuary.addNewMonkey(monkey1);
    sanctuary.addNewMonkey(monkey2);
    sanctuary.addNewMonkey(monkey3);
    assertEquals("[GUEREZA, HOWLER, SAKI]", sanctuary.reportSpecies().toString());
    sanctuary.provideMedicalCare(monkey2);
    sanctuary.moveToEnclosure(monkey2);
    assertEquals("[GUEREZA, HOWLER, SAKI]", sanctuary.reportSpecies().toString());
  }

  @Test
  void getAllEnclosure() {
    sanctuary.addNewMonkey(monkey1);
    sanctuary.addNewMonkey(monkey2);
    sanctuary.addNewMonkey(monkey3);
    sanctuary.provideMedicalCare(monkey1);
    sanctuary.moveToEnclosure(monkey1);
    sanctuary.provideMedicalCare(monkey2);
    sanctuary.provideMedicalCare(monkey3);
    sanctuary.moveToEnclosure(monkey2);
    sanctuary.moveToEnclosure(monkey3);
    sanctuary.getAllEnclosuresList();
    assertEquals(
        "[[Species GUEREZA:\n" +
            "1. Name: Charles, enums.Sex: FEMALE, Favorite food: INSECT.], \n" +
            "[Species HOWLER:\n" +
            "1. Name: Bobo, enums.Sex: MALE, Favorite food: FRUITS.], \n" +
            "[Species SAKI:\n" +
            "1. Name: Max, enums.Sex: MALE, Favorite food: LEAVES.]]",
        sanctuary.getAllEnclosuresList().toString());
  }

  @Test
  void getSingleEnclosureList() {
    assertEquals("[]", sanctuary.getSingleEnclosureList(Species.HOWLER).toString());
    sanctuary.addNewMonkey(monkey1);
    sanctuary.addNewMonkey(monkey2);
    sanctuary.addNewMonkey(monkey3);
    assertEquals("[]", sanctuary.getSingleEnclosureList(Species.HOWLER).toString());
    sanctuary.provideMedicalCare(monkey1);
    sanctuary.moveToEnclosure(monkey1);
    assertEquals("[Name: Bobo, enums.Sex: MALE, Favorite food: FRUITS]",
        sanctuary.getSingleEnclosureList(Species.HOWLER).toString());
    sanctuary.provideMedicalCare(monkey2);
    sanctuary.provideMedicalCare(monkey3);
    sanctuary.moveToEnclosure(monkey2);
    sanctuary.moveToEnclosure(monkey3);
    assertEquals("[Name: Charles, enums.Sex: FEMALE, Favorite food: INSECT]",
        sanctuary.getSingleEnclosureList(Species.GUEREZA).toString());
    assertEquals("[Name: Max, enums.Sex: MALE, Favorite food: LEAVES]",
        sanctuary.getSingleEnclosureList(Species.SAKI).toString());
  }

  @Test
  void getAllMonkey() {
    List<Monkey> allMonkeys =
        Arrays.asList(monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7, monkey8,
            monkey9, monkey10, monkey11, monkey12, monkey13, monkey14, monkey15, monkey16, monkey17,
            monkey18, monkey19, monkey20);
    for (Monkey monkey : allMonkeys) {
      sanctuary.addNewMonkey(monkey);
    }
    assertEquals(
        "[1. Bella, \n" +
            "2. Bobo, \n" +
            "3. Charles, \n" +
            "4. Charlie, \n" +
            "5. Leo, \n" +
            "6. Lily, \n" +
            "7. Lucian, \n" +
            "8. Lucy, \n" +
            "9. Luna, \n" +
            "10. Max, \n" +
            "11. Maxim, \n" +
            "12. Mia, \n" +
            "13. Milo, \n" +
            "14. Molly, \n" +
            "15. Oscar, \n" +
            "16. Rocky, \n" +
            "17. Sam, \n" +
            "18. Simba, \n" +
            "19. Sophie, \n" +
            "20. Zoe]",
        sanctuary.getAllMonkeys().toString());
  }
}