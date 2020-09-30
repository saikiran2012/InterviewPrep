package main.StackAndQueue;
/*
Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeue cat. You may use the built-in Linked List data structure.
 */

import java.util.Date;

public class AnimalShelter<Animal> {
    Queue<Cat> catQueue;
    Queue<Dog> dogQueue;

    public void EnqueueAny(String name, boolean isCat) {
        if(isCat) {
            catQueue.add(new Cat(name));
        } else {
            dogQueue.add(new Dog(name));
        }
    }


    public Animal DequeueAny() {
        if(catPeek().timestamp.compareTo(dogPeek().timestamp) < 0) {
            return (Animal)dequeueCat();
        } else {
            return (Animal)dequeueDog();
        }
    }

    Dog dequeueDog() {
        if(!dogQueue.isEmpty()) {
            return dogQueue.remove();
        }
        return null;
    }

    Cat dequeueCat() {
        if(!catQueue.isEmpty()) {
            return catQueue.remove();
        }
        return null;
    }

    Dog dogPeek() {
        if(!dogQueue.isEmpty()) {
            return dogQueue.peek();
        }
        return null;
    }

    Cat catPeek() {
        if(!catQueue.isEmpty()) {
            return catQueue.peek();
        }
        return null;
    }


}

abstract class Animal {
    Date timestamp;
    String name;
    public Animal(String name) {
        this.name = name;
        timestamp = new Date(System.currentTimeMillis());
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}
