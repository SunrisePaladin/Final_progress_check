import java.io.PrintStream;
import java.util.*;

public class PetRegistry {
    private List<Animal> animals;

    public PetRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listCommands(Animal animal) {
        System.out.println("Команды для " + animal.name + ": " + animal.getCommands());
    }

    public void teachCommand(Animal animal, String command) {
        animal.addCommand(command);
        System.out.println(animal.name + " научилось новой команде: " + command);
    }

    public void listAnimalsByBirthDate() {
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "utf-8");
        Scanner scanner = new Scanner(System.in, encoding);
        System.setProperty("console.encoding", "utf-8");
        PrintStream ps = new PrintStream(System.out);
        // Scanner scanner = new Scanner(System.in);
        PetRegistry registry = new PetRegistry();

        while (true) {
            ps.println("Меню:");
            ps.println("1. Добавить новое животное");
            ps.println("2. Вывести список команд животного");
            ps.println("3. Обучить животное новой команде");
            ps.println("4. Вывести список животных по дате рождения");
            ps.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ps.println("Введите тип животного (собака/кошка/хомяк/лошадь/верблюд/осёл): ");
                    String type = scanner.nextLine();
                    ps.println("Введите имя животного: ");
                    String name = scanner.nextLine();
                    ps.println("Введите дату рождения (гггг-мм-дд): ");
                    String dateInput = scanner.nextLine();
                    Date birthDate = Date.from(java.time.LocalDate.parse(dateInput)
                            .atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());

                    Animal animal;
                    switch (type.toLowerCase()) {
                        case "dog":
                            animal = new Dog(name, birthDate);
                            break;
                        case "cat":
                            animal = new Cat(name, birthDate);
                            break;
                        case "hamster":
                            animal = new Hamster(name, birthDate);
                            break;
                        case "horse":
                            animal = new Dog(name, birthDate);
                            break;
                        case "camel":
                            animal = new Cat(name, birthDate);
                            break;
                        case "donkey":
                            animal = new Hamster(name, birthDate);
                            break;
                        default:
                            ps.println(type.toString());
                            ps.println("Неизвестный тип животного.");
                            continue;
                    }
                    registry.addAnimal(animal);
                    ps.println("Животное добавлено.");
                    break;

                case 2:
                    ps.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    Optional<Animal> foundAnimal = registry.animals.stream().filter(a -> a.name.equals(animalName))
                            .findFirst();
                    if (foundAnimal.isPresent()) {
                        registry.listCommands(foundAnimal.get());
                    } else {
                        ps.println("Животное не найдено.");
                    }
                    break;

                case 3:
                    ps.print("Введите имя животного: ");
                    String teachName = scanner.nextLine();
                    Optional<Animal> teachAnimal = registry.animals.stream().filter(a -> a.name.equals(teachName))
                            .findFirst();
                    if (teachAnimal.isPresent()) {
                        ps.print("Введите новую команду: ");
                        String command = scanner.nextLine();
                        registry.teachCommand(teachAnimal.get(), command);
                    } else {
                        ps.println("Животное не найдено.");
                    }
                    break;

                case 4:
                    registry.listAnimalsByBirthDate();
                    break;

                case 5:
                    System.out.println("Общее количество животных: " + Animal.getTotalAnimals());
                    break;

                case 6:
                    ps.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    ps.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}