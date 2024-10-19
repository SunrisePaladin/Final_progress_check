import java.util.*;

abstract class Animal {
    protected String name;
    protected Date birthDate;
    protected List<String> commands;
    private static int totalAnimals = 0;

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
        totalAnimals++;
    }

    public static int getTotalAnimals() {
        return totalAnimals; // Метод для получения общего количества животных
    }

    public abstract String getType();

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, Дата рождения: %s", getType(), name, birthDate);
    }
}

class Dog extends Animal {
    public Dog(String name, Date birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Собака";
    }
}

class Cat extends Animal {
    public Cat(String name, Date birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Кошка";
    }
}

class Hamster extends Animal {
    public Hamster(String name, Date birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Хомяк";
    }
}

class Horse extends Animal {
    public Horse(String name, Date birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Лошадь";
    }
}

class Camel extends Animal {
    public Camel(String name, Date birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Верблюд";
    }
}

class Donkey extends Animal {
    public Donkey(String name, Date birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getType() {
        return "Осёл";
    }
}