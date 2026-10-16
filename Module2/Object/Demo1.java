package Object;
import Object.SingleObject;

public class Demo1 {
    public static void main(String[] args) {
        SingleObject obj1 = SingleObject.createInstance();
        SingleObject obj2 = SingleObject.createInstance();

        System.out.println(obj1 == obj2);
        System.out.println(obj1.hashCode() == obj2.hashCode());
    }
}