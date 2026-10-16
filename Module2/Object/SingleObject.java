package Object;

public class SingleObject {
    private SingleObject() {}

    static final SingleObject obj = new SingleObject();

    public static SingleObject createInstance() {
        return obj;
    }
}
