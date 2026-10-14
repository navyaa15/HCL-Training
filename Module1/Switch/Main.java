package Switch;

public class Main {
    public static void main(String[] args) {

        int day = 3;
        String dayName;
        String type;

        switch (day) {
            case 1:
                dayName = "Monday";
                type = "Weekday";
                break;

            case 2:
                dayName = "Tuesday";
                type = "Weekday";
                break;

            case 3:
                dayName = "Wednesday";
                type = "Weekday";
                break;

            case 4:
                dayName = "Thursday";
                type = "Weekday";
                break;

            case 5:
                dayName = "Friday";
                type = "Weekday";
                break;

            case 6:
                dayName = "Saturday";
                type = "Weekend";
                break;

            case 7:
                dayName = "Sunday";
                type = "Weekend";
                break;

            default:
                dayName = "Invalid day";
                type = "Invalid";
        }

        System.out.println("Day: " + dayName);
        System.out.println("Type: " + type);
    }
}