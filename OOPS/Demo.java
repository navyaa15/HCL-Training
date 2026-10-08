package OOPS;

class A {
    void m() {
        System.out.println("Method of A");
    }
}

public class Demo {
    public static void main(String[] args) {

        A a = new A();
        a.m();

        Demo d = new Demo();
    }
}