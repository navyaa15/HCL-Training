package Constructor;
class Students {

    Students() {
        System.out.println("No details");
    }

    Students(String name) {
        System.out.println(name);
    }

    Students(String name, int age) {
        System.out.println(name + " " + age);
    }
}
