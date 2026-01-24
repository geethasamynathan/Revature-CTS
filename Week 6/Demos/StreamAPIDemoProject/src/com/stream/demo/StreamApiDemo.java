package com.stream.demo;
import java.util.*;
import java.util.stream.*;
import java.util.List;

public class StreamApiDemo {
public static void main(String[] args) {
	List<Employee> employees = List.of(
		    new Employee(1,"Ravi","IT","Developer",75000,5,"Chennai",true,28,'A'),
		    new Employee(2,"Anu","HR","Manager",90000,10,"Bangalore",true,35,'A'),
		    new Employee(3,"Kiran","IT","Tester",55000,3,"Hyderabad",true,25,'B'),
		    new Employee(4,"Meena","Finance","Analyst",65000,6,"Chennai",true,30,'A'),
		    new Employee(5,"Suresh","IT","Developer",80000,7,"Bangalore",false,32,'A'),
		    new Employee(6,"Priya","HR","Executive",45000,2,"Chennai",true,24,'C'),
		    new Employee(7,"Arun","Sales","Lead",70000,8,"Pune",true,34,'B'),
		    new Employee(8,"Divya","IT","Architect",120000,12,"Bangalore",true,40,'A'),
		    new Employee(9,"Manoj","Finance","Clerk",40000,1,"Hyderabad",true,23,'C'),
		    new Employee(10,"Neha","Sales","Executive",48000,3,"Delhi",true,26,'B'),
		    new Employee(11,"Vijay","IT","DevOps",95000,9,"Chennai",true,36,'A'),
		    new Employee(12,"Sneha","HR","Recruiter",52000,4,"Pune",true,27,'B'),
		    new Employee(13,"Ajay","Finance","Manager",100000,11,"Delhi",true,42,'A'),
		    new Employee(14,"Kavya","IT","Developer",72000,5,"Hyderabad",true,29,'A'),
		    new Employee(15,"Rahul","Sales","Manager",88000,9,"Bangalore",false,38,'A'),
		    new Employee(16,"Pooja","HR","Executive",47000,2,"Chennai",true,25,'C'),
		    new Employee(17,"Nitin","IT","Tester",58000,4,"Pune",true,28,'B'),
		    new Employee(18,"Sanjay","Finance","Analyst",67000,6,"Bangalore",true,31,'A'),
		    new Employee(19,"Asha","IT","Developer",76000,6,"Delhi",true,30,'A'),
		    new Employee(20,"Ramesh","Sales","Executive",49000,3,"Hyderabad",true,27,'B')
		);
//	System.out.println("\n1️⃣ Active IT Employees");
//    employees.stream()
//            .filter(e -> e.department.equals("IT"))
//            .filter(e -> e.active)
//            .forEach(System.out::println);
//
//    System.out.println("\n2️⃣ Employee Names");
//    employees.stream()
//            .map(e -> e.name)
//            .forEach(System.out::println);

//    System.out.println("\n3️⃣ Salary Ascending");
//    employees.stream()
//            .sorted(Comparator.comparingDouble(e -> e.salary))
//            .forEach(System.out::println);

//    System.out.println("\n4️⃣ Salary Descending");
//    employees.stream()
//            .sorted((a, b) -> Double.compare(b.salary, a.salary))
//            .forEach(System.out::println);
//
//    System.out.println("\n5️⃣ Top 5 Salaries");
//    employees.stream()
//            .sorted((a, b) -> Double.compare(b.salary, a.salary))
//            .limit(5)
//            .forEach(System.out::println);
//
    System.out.println("\n6️⃣ Skip First 5 Junior Employees");
    employees.stream()
            .sorted(Comparator.comparingInt(e -> e.experience))
            .skip(5)
            .forEach(System.out::println);
//
//    System.out.println("\n7️⃣ Employee Count");
//    System.out.println(employees.stream().count());
//
//    System.out.println("\n8️⃣ Any employee earning > 1L?");
//    System.out.println(employees.stream().anyMatch(e -> e.salary > 100000));
//
//    System.out.println("\n9️⃣ All employees active?");
//    System.out.println(employees.stream().allMatch(e -> e.active));
//
//    System.out.println("\n🔟 No Interns?");
//    System.out.println(employees.stream().noneMatch(e -> e.role.equals("Intern")));
//
//    System.out.println("\n11️⃣ First IT Employee");
//    employees.stream()
//            .filter(e -> e.department.equals("IT"))
//            .findFirst()
//            .ifPresent(System.out::println);
//
//    System.out.println("\n12️⃣ Any HR Employee");
//    employees.stream()
//            .filter(e -> e.department.equals("HR"))
//            .findAny()
//            .ifPresent(System.out::println);
//
//    System.out.println("\n13️⃣ Minimum Salary");
//    employees.stream()
//            .min(Comparator.comparingDouble(e -> e.salary))
//            .ifPresent(System.out::println);
//
//    System.out.println("\n14️⃣ Maximum Salary");
//    employees.stream()
//            .max(Comparator.comparingDouble(e -> e.salary))
//            .ifPresent(System.out::println);
//
//    System.out.println("\n15️⃣ Total Salary Expense");
//    double totalSalary =
//            employees.stream()
//                     .map(e -> e.salary)
//                     .reduce(0.0, Double::sum);
//    System.out.println(totalSalary);
//
//    System.out.println("\n16️⃣ Collect IT Employees (List)");
//    List<Employee> itEmployees =
//            employees.stream()
//                     .filter(e -> e.department.equals("IT"))
//                     .collect(Collectors.toList());
//    itEmployees.forEach(System.out::println);
//
//    System.out.println("\n17️⃣ Unique Cities (Set)");
//    Set<String> cities =
//            employees.stream()
//                     .map(e -> e.city)
//                     .collect(Collectors.toSet());
//    System.out.println(cities);
//
//    System.out.println("\n18️⃣ Group By Department");
//    Map<String, List<Employee>> deptMap =
//            employees.stream()
//                     .collect(Collectors.groupingBy(e -> e.department));
//    deptMap.forEach((k, v) -> System.out.println(k + " -> " + v.size()));
//
//    System.out.println("\n19️⃣ Partition Active / Inactive");
//    Map<Boolean, List<Employee>> statusMap =
//            employees.stream()
//                     .collect(Collectors.partitioningBy(e -> e.active));
//    System.out.println(statusMap);
//
//    System.out.println("\n20️⃣ Salary Summary Statistics");
//    DoubleSummaryStatistics stats =
//            employees.stream()
//                     .collect(Collectors.summarizingDouble(e -> e.salary));
//    System.out.println(stats);
//
//    System.out.println("\n21️⃣ Peek Debug Example");
//    employees.stream()
//            .peek(e -> System.out.println("Before Filter: " + e))
//            .filter(e -> e.salary > 70000)
//            .peek(e -> System.out.println("After Filter: " + e))
//            .forEach(System.out::println);
//
//    System.out.println("\n22️⃣ Distinct Departments");
//    employees.stream()
//            .map(e -> e.department)
//            .distinct()
//            .forEach(System.out::println);
}

}

