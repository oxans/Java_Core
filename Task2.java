package HW3;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    private float weight;


    public Fruit(float v){
        this.weight = v;
    }

    public float getWeight(){
        return weight;
    }

}

class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }
}
class Apple extends Fruit{
    public Apple() {
        super(1.0f);
    }

}

class Box<T extends Fruit> {
    float totalWeight = 0;
    List<T> ArrayList;

    public Box(){
        this.ArrayList = new ArrayList<>();
    }

    public void addFruit(T fruit){
        ArrayList.add(fruit);
        totalWeight = totalWeight + fruit.getWeight();
    }
    public float getTotalWeight(){
        return totalWeight;
    }
    public boolean compare(Box box){
        if (totalWeight == box.totalWeight){
            return true;
        }else
            return false;
    }



}

public class Task2{
    public static void main(String[] args){
        Box<Apple> appleBox = new Box<Apple>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        System.out.println("apple - " + appleBox.getTotalWeight());

        Box<Orange> orangeBox = new Box<Orange>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("orange - " + orangeBox.getTotalWeight());

        System.out.println(appleBox.compare(orangeBox));
    }
}