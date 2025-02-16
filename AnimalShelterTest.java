import java.util.LinkedList;
import java.util.Queue;

class Animal {
    String name;
    String type;
    long arrivalTime;

    public Animal(String name, String type, long arrivalTime) {
        this.name = name;
        this.type = type;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Time: " + arrivalTime;
    }
}

class AnimalShelter {
    private Queue<Animal> animals;
    private Queue<Animal> dogs;
    private Queue<Animal> cats;
    private long timestamp;

    public AnimalShelter() {
        animals = new LinkedList<>();
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        timestamp = 0;
    }

    public void enqueue(String name, String type) {
        Animal animal = new Animal(name, type, timestamp++);
        animals.offer(animal);
        if (type.equals("dog")){
            dogs.offer(animal);
        }
        else if (type.equals("cat")){
            cats.offer(animal);
        }
        else {
            throw new IllegalArgumentException("INVALID ANIMAL TYPE: " + type);
        }
        System.out.println(name + " the " + type + " has been added.");
    }

    public Animal dequeueAny() {
        if (animals.isEmpty()) {
            return null;
        }

        Animal animal = animals.poll();
        if (animal.type.equals("dog")) {
            dogs.remove(animal);
        }
        else {
            cats.remove(animal);
        }
        System.out.println("Adopted: " + animal);
        return animal;
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty()) {
            return null;
        }
        Animal dog = dogs.poll();
        animals.remove(dog);
        System.out.println("Adopted dog: " + dog);
        return dog;
    }

    public Animal dequeueCat() {
        if (cats.isEmpty()) {
            return null;
        }
        Animal cat = cats.poll();
        animals.remove(cat);
        System.out.println("Adopted cat: " + cat);
        return cat;
    }

    public void printShelter() {
        System.out.println("\nAnimals In Shelter");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}

public class AnimalShelterTest {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue("Buddy", "dog");
        shelter.enqueue("Whiskers", "cat");
        shelter.enqueue("Max", "dog");
        shelter.enqueue("Bella", "cat");
        shelter.enqueue("Rocky", "dog");
        shelter.printShelter();

        shelter.dequeueAny();
        shelter.dequeueDog();
        shelter.dequeueCat();
        shelter.printShelter();

        shelter.dequeueAny();
        shelter.dequeueAny();
    }
}