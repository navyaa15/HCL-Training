package Streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {

    record EmployeeData(
            int id,
            String name,
            String dept,
            BigDecimal salary,
            LocalDate hireDate,
            Set<String> skills
    ) {}

    static EmployeeData e(
            int id, String name, String dept,
            int salary, String date, String... skills) {

        return new EmployeeData(
                id,
                name,
                dept,
                BigDecimal.valueOf(salary),
                LocalDate.parse(date),
                Set.of(skills)
        );
    }

    public static void main(String[] args) {

        List<EmployeeData> emps = List.of(
                e(1, "Asha", "Engineering", 90000,
                        "2019-03-01", "Java", "SQL"),
                e(2, "Ravi", "Engineering", 120000,
                        "2016-07-15", "Java", "Spring", "AWS"),
                e(3, "Meera", "HR", 60000,
                        "2020-01-10", "Recruiting"),
                e(4, "John", "Sales", 70000,
                        "2018-11-20", "Negotiation", "CRM"),
                e(5, "Priya", "Engineering", 105000,
                        "2021-05-05", "Java", "React"),
                e(6, "Karan", "Sales", 65000,
                        "2022-02-14", "CRM"),
                e(7, "Sara", "HR", 62000,
                        "2017-09-09", "Recruiting", "Payroll"),
                e(8, "Vikram", "Finance", 80000,
                        "2015-04-30", "Excel", "SQL")
        );

        // Engineering employees, salary descending
        System.out.println("\nQ1: Engineering employees by salary");
        emps.stream()
                .filter(emp -> emp.dept().equals("Engineering"))
                .sorted(Comparator.comparing(EmployeeData::salary).reversed())
                .map(EmployeeData::name)
                .forEach(System.out::println);

        // Top 3 earners overall
        System.out.println("\nQ2: Top 3 earners");
        emps.stream()
                .sorted(Comparator.comparing(EmployeeData::salary).reversed())
                .limit(3)
                .map(EmployeeData::name)
                .forEach(System.out::println);

        // Hired before 2018, oldest hire first
        System.out.println("\nQ3: Employees hired before 2018");
        emps.stream()
                .filter(emp -> emp.hireDate().isBefore(
                        LocalDate.of(2018, 1, 1)))
                .sorted(Comparator.comparing(EmployeeData::hireDate))
                .map(emp -> emp.name() + " (" +
                        emp.hireDate().getYear() + ")")
                .forEach(System.out::println);

        // Q4: Join all employee names
        System.out.println("\nQ4: All employee names");
        String allNames = emps.stream()
                .map(EmployeeData::name)
                .collect(Collectors.joining(", "));

        System.out.println(allNames);

        // Q5: Total payroll using reduce()
        System.out.println("\nQ5: Total payroll");
        BigDecimal payroll = emps.stream()
                .map(EmployeeData::salary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(payroll);

        // Q6: Matching operations
        System.out.println("\nQ6: Matching operations");

        boolean hasAWS = emps.stream()
                .anyMatch(emp -> emp.skills().contains("AWS"));

        boolean allAbove50000 = emps.stream()
                .allMatch(emp -> emp.salary()
                        .compareTo(BigDecimal.valueOf(50000)) > 0);

        boolean noneAbove150000 = emps.stream()
                .noneMatch(emp -> emp.salary()
                        .compareTo(BigDecimal.valueOf(150000)) > 0);

        System.out.println("Any AWS: " + hasAWS);
        System.out.println("All salary > 50000: " + allAbove50000);
        System.out.println("None salary > 150000: " + noneAbove150000);

        // Q7: Highest-paid employee using Optional
        System.out.println("\nQ7: Highest-paid employee");
        Optional<EmployeeData> highestPaid = emps.stream()
                .max(Comparator.comparing(EmployeeData::salary));

        System.out.println(
                highestPaid.map(EmployeeData::name).orElse("none")
        );

        // Q8: Average salary per department
        System.out.println("\nQ8: Average salary per department");

        Map<String, Double> averageByDept = emps.stream()
                .collect(Collectors.groupingBy(
                        EmployeeData::dept,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(
                                emp -> emp.salary().doubleValue()
                        )
                ));

        averageByDept.forEach((dept, avg) ->
                System.out.printf("%s: %.0f%n", dept, avg)
        );

        // Q9: Highest-paid employee name per department
        System.out.println("\nQ9: Top earner in each department");

        Map<String, String> topByDept = emps.stream()
                .collect(Collectors.groupingBy(
                        EmployeeData::dept,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(EmployeeData::salary)
                                ),
                                optionalEmp -> optionalEmp
                                        .map(EmployeeData::name)
                                        .orElse("none")
                        )
                ));

        topByDept.forEach((dept, name) ->
                System.out.println(dept + ": " + name)
        );

        // Q10: Partition employees by salary >= 75000
        System.out.println("\nQ10: Partition by salary");

        Map<Boolean, List<EmployeeData>> partition = emps.stream()
                .collect(Collectors.partitioningBy(
                        emp -> emp.salary()
                                .compareTo(BigDecimal.valueOf(75000)) >= 0
                ));

        System.out.println("true: " +
                partition.get(true).stream()
                        .map(EmployeeData::name)
                        .collect(Collectors.joining(", ")));

        System.out.println("false: " +
                partition.get(false).stream()
                        .map(EmployeeData::name)
                        .collect(Collectors.joining(", ")));

        // Q11: Sorted, distinct skills using flatMap()
        System.out.println("\nQ11: All distinct skills");

        List<String> allSkills = emps.stream()
                .flatMap(emp -> emp.skills().stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println(allSkills);

        // Q12: Skill frequency and most common skill
        System.out.println("\nQ12: Skill frequency");

        Map<String, Long> skillFrequency = emps.stream()
                .flatMap(emp -> emp.skills().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        skillFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " = " + entry.getValue()
                        )
                );

        Optional<Map.Entry<String, Long>> mostCommonSkill =
                skillFrequency.entrySet().stream()
                        .max(Map.Entry.comparingByValue());

        System.out.println("Most common skill: " +
                mostCommonSkill
                        .map(entry -> entry.getKey() + " = " + entry.getValue())
                        .orElse("none"));

        // E1: Build id-to-name map using toMap()
        System.out.println("\nE1: toMap()");

        Map<Integer, String> idToName = emps.stream()
                .collect(Collectors.toMap(
                        EmployeeData::id,
                        EmployeeData::name
                ));

        System.out.println(idToName);

        // Add an employee with a duplicate ID deliberately
        List<EmployeeData> duplicateEmps = new ArrayList<>(emps);
        duplicateEmps.add(
                e(1, "AshaDuplicate", "Engineering", 91000,
                        "2023-01-01", "Java")
        );

        try {
            duplicateEmps.stream()
                    .collect(Collectors.toMap(
                            EmployeeData::id,
                            EmployeeData::name
                    ));
        } catch (IllegalStateException ex) {
            System.out.println("Duplicate ID detected: " +
                    ex.getMessage());
        }

        // Fix: merge function handles duplicate keys
        Map<Integer, String> mergedMap = duplicateEmps.stream()
                .collect(Collectors.toMap(
                        EmployeeData::id,
                        EmployeeData::name,
                        (existing, replacement) -> existing
                ));

        System.out.println("Map after merging: " + mergedMap);

        // E2: collectingAndThen and maxBy
        System.out.println("\nE2: collectingAndThen");
        System.out.println(
                "maxBy returns Optional because a stream may be empty; " +
                        "collectingAndThen applies a finishing function to its result."
        );

        // E3: Demonstrate lazy evaluation
        System.out.println("\nE3: Lazy evaluation");

        Stream<String> lazyNames = emps.stream()
                .map(emp -> {
                    System.out.println("Mapping: " + emp.name());
                    return emp.name();
                });

        System.out.println("Stream created: " + lazyNames);
        System.out.println("No mapping has run yet.");

        // A terminal operation triggers the pipeline
        System.out.println("Now triggering the stream:");
        lazyNames.forEach(System.out::println);
    }
}