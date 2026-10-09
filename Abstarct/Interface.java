interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {
    public void show() {
        System.out.println("Interface A");
    }

    public void display() {
        System.out.println("Interface B");
    }
}

public class Interface {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
        obj.display();
    }
}
