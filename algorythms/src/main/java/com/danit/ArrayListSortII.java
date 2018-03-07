package com.danit;

import java.util.*;

public class ArrayListSortII {

    static class Employee {
        public int salary;
        public int id;

        Employee(int salary, int id){
            this.salary=salary;
            this.id=id;
        }

        int getSalary(){
            return this.salary;
        }

        int getId(){
            return this.id;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int salary = in.nextInt();
            employees.add(new Employee(salary, i));
        }

        Collections.sort(employees, Comparator.comparingInt(Employee::getSalary));

        for (int i = 0; i < employees.size(); i++) {
            System.out.print(employees.get(i).getId()+ " ");

        }

    }
}
