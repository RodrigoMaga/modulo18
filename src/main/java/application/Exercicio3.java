package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Exercicio3 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Employee> employeeList = readEmployees();

        double salary = 2000.00;

        List<String> emailList = employeeList.stream()
                .filter(e -> e.getSalary() > salary)
                .map(Employee::getEmail)
                .sorted().toList();

        emailList.forEach(System.out::println);

        double total = employeeList.stream()
                .filter(e -> e.getName().charAt(0) == 'B')
                .map(Employee::getSalary)
                .reduce(0.0, (prevSalary, nextSalary) -> soma(prevSalary, nextSalary));

        System.out.println(total);




    }

    public static double soma(double d1, double d2){
        return d1 + d2;
    }

    public static List<Employee> readEmployees() {

        String path = "c:\\temp\\in.txt";
        List<Employee> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();


            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.valueOf(fields[2])));
                line = br.readLine();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }

}
