package com.myblog;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
    List<Employee> emp = Arrays.asList(
            new Employee("adam",32,"chennai"),
            new Employee("mike",32,"chennai"),
            new Employee("sam",26,"pune"),
            new Employee("stallin",35,"bengaluru")
    );
//        Map<Integer, List<Employee>> emps = emp.stream().collect(Collectors.groupingBy(e->e.getAge()));
//        System.out.println(emps);
//        System.out.println(emps.get(32));

//    emps.forEach((age,empList)-> System.out.println(age+"__"+empList));

//        for(Map.Entry<Integer, List<Employee>> entry:emps.entrySet()){
//            int age =entry.getKey();
//            List<Employee> value = entry.getValue();
//
////            System.out.println(age +":"+ value);
//            for(Employee ep:value){
//                System.out.println(ep.getAge());
//                System.out.println(ep.getName());
//                System.out.println(ep.getCity());
//                System.out.println("________________");
//            }
//        }

//        for (Employee e:emp){
//            List<Employee> es = emps.get(e.getAge());
//            for (Employee ep :es){
//                System.out.println(ep.getAge());
//                System.out.println(ep.getName());
//                System.out.println(ep.getCity());
//                System.out.println("________________");
//            }
//        }

        Map<String, List<Employee>> emps1 = emp.stream().collect(Collectors.groupingBy(e->e.getCity()));

        for(Map.Entry<String,List<Employee>> cityValue:emps1.entrySet()){
            String city = cityValue.getKey();
            List<Employee> value1 = cityValue.getValue();
//            System.out.println(value1+""+cityValue);
            for(Employee ep:value1){
                System.out.println(ep.getName());
                System.out.println(ep.getAge());
                System.out.println(ep.getCity());
                System.out.println("________________");
            }
        }

    }
}
