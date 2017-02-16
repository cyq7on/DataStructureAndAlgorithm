package com.cyq7on.stackandqueue;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cyq7on on 17-2-16.
 */
public class CatDogQueue {
    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }

    private Queue<PetQueue> catQueue;
    private Queue<PetQueue> dogQueue;

    public CatDogQueue() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("cat")) {
            catQueue.add(new PetQueue(pet));
        } else {
            dogQueue.add(new PetQueue(pet));
        }
    }

    public Pet pollAll() {
        if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            if (catQueue.peek().getTimestap() < dogQueue.peek().getTimestap()) {
                return catQueue.poll().getPet();
            } else {
                return dogQueue.poll().getPet();
            }
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            return null;
        }
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            return null;
        } else {
            return (Dog) dogQueue.poll().getPet();
        }
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            return null;
        } else {
            return (Cat) catQueue.poll().getPet();
        }
    }

    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetQueue {
        private Pet pet;
        private long timestap;

        public PetQueue(Pet pet) {
            this.pet = pet;
            timestap = new Date().getTime();
        }

        public Pet getPet() {
            return pet;
        }

        public long getTimestap() {
            return timestap;
        }
    }
}
