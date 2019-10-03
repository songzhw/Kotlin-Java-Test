package generics.java;

import generics.java.data.Animal;
import generics.java.data.Cat;

import java.util.ArrayList;
import java.util.List;

class CopyDemo {
    public <T> void copy(List<T> dest, List<T> src) {
        dest.add(src.get(0));
    }

    public static void main(String[] args) {
        CopyDemo obj = new CopyDemo();
        List<Cat> cats = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        obj.copy(animals, cats);
    }
}
