//package generics.variant;
//
//import generics.data.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class ListVariant {
//    public static void main(String[] args) {
//        Vegatable cabbage = new Vegatable();
//        Animal cow = new Animal();
//        Cat cat = new Cat();
//        Dog dog = new Dog();
//
//        List<? extends Animal> list = new ArrayList<>();
//        list.add(cabbage);
//        list.add(cow);
//        list.add(cat);
//        list.add(dog);
//        Animal anim = list.get(0);
//        list = new ArrayList<Cat>();
//
//        List<? super Animal> list5 = new ArrayList<>();
//        list5.add(cabbage); //植物嘛, 自然不行
//        list5.add(cow);
//        list5.add(cat);
//        list5.add(dog);
//        Animal anim5 = list5.get(0);
//        list5 = new ArrayList<Being>();
//
//        ArrayList<Animal> list2 = new ArrayList<>();
//        list2.add(cabbage); //植物嘛, 自然不行
//        list2.add(cow);
//        list2.add(cat);
//        list2.add(dog);
//        Animal anim2 = list.get(0);  // 能读, 也能写
//        list2 = new ArrayList<Cat>(); // 不能被赋值
//
//        List<?> list3 = new ArrayList<>();
//        list3.add(cabbage);
//        list3.add(cow);
//        list3.add(cat);
//        Animal animal3 = list3.get(0);
//        list3 = new ArrayList<Cat>();
//
//
//        List<Object> list4 = new ArrayList<>();
//        list4.add(cabbage);
//        list4.add(cow);
//        list4.add(cat);
//        Animal animal4 = list4.get(0); //Require Animal, Found Object
//        list4 = new ArrayList<Cat>(); // Incompatible type
//    }
//}
