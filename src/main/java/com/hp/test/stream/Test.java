package com.hp.test.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    protected List<Employee> employeeList = Arrays.asList(
            new Employee(1, "张三", 16, 99.99D),
            new Employee(1, "李四", 38, 55.55D),
            new Employee(3, "田七", 18, 49.33D),
            new Employee(3, "王五", 60, 66.66D),
            new Employee(5, "赵六", 16, 77.77D),
            new Employee(5, "", 19, 50D),
            new Employee(7, "孙悟空", 99, 19999.0D),
            new Employee(8, "齐天大圣", 99, 99999.0D)
    );

    public static void main(String[] args) {
        /*
        Test t = new Test();
        List<Employee> list = t.filterEmployee(t.employeeList, new FilterEmployeeByAge());
        System.out.println("@@@@@@@@@@@@@@@@@@");
        list.forEach(System.out::println);
        */

        Test t = new Test();
//        t.test4();
//        t.test5();
//        t.test6();
//        t.test7();
//        t.test8();
//        t.test9();
//        t.test10();
//        t.test11();
//        t.test12();
//        t.test13();
        t.test14();
    }

    /*
     * 优化方案1
     * */
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> resultList = new ArrayList<>();
        for (Employee employee : list) {
            if (myPredicate.filter(employee)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }

    public void test1() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for (Employee employee : employeeList) {
            if (employee.getAge() > 18) {
                employees.add(employee);
            }
        }
        System.out.println("年龄大于18的：" + employees);
        employees = new ArrayList<Employee>();
        for (Employee employee : employeeList) {
            if (employee.getWeight() > 50) {
                employees.add(employee);
            }
        }
        System.out.println("体重大于50的：" + employees);


        List<Employee> employeeList2 = this.filterEmployee(employeeList, new FilterEmployeeByAge());
        System.out.println("年龄大于18的：");
        for (Employee employee : employeeList2) {
            System.out.println(employee);
        }
        System.out.println("体重大于50的：");
        employeeList2 = this.filterEmployee(employeeList, new FilterEmployeeByWeight());
        for (Employee employee : employeeList2) {
            System.out.println(employee);
        }

    }

    /*
     *
     * 方案2使用内部类
     * */
    public void test2() {
        List<Employee> employees = this.filterEmployee(employeeList, new MyPredicate<Employee>() {
            public boolean filter(Employee employee) {
                return employee.getAge() > 18;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /*
     * 方案3使用Lambda
     * */
    public void test3() {
        filterEmployee(employeeList, (e) -> e.getAge() > 18).forEach(System.out::println);
    }

    /**
     * 使用stream api
     */
    public void test4() {
        List<Employee> employees = employeeList.stream().filter(t -> t.getAge() > 18).collect(Collectors.toList());
        employees.forEach(System.out::println);
    }

    /**
     * 使用stream api，对应拿出别的属性
     */
    public void test5() {
        List<String> employeeNames = employeeList.stream().filter(t -> t.getAge() > 18)
                .map(x -> x.getName())
                .collect(Collectors.toList());
        employeeNames.forEach(System.out::println);
    }

    /**
     * 使用stream api，对应拿出别的属性
     */
    public void test6() {
        List<String> employeeNames = employeeList.stream().filter(t -> t.getAge() > 18)
                .map(Employee::getName)
                .collect(Collectors.toList());
        employeeNames.forEach(System.out::println);
    }

    public void test7() {
        Collections.sort(
                employeeList, (e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return Integer.compare(e1.getAge(), e2.getAge());
                    //如果想实现倒叙的排序，直接在Integer前加-
                    //return -Integer.compare(e1.getAge(),e2.getAge());
                }
        );
        employeeList.stream().forEach(System.out::println);
    }

    public void test8() {
        System.out.println(stringHander("aa22bbcc", s -> ((String) s).toUpperCase()));
    }

    public String stringHander(String str, MyFunction myFunction) {
        return (String) myFunction.getValue(str);
    }

    /**
     * 按照age排序，输出对象
     */
    public void test9() {
        List<Employee> collect = employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }

    /**
     * 按照age倒叙排序，输出对象
     */
    public void test10() {
        List<Employee> collect = employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }

    /**
     * 按照age倒叙排序，输出对象
     */
    public void test101() {
        List<Employee> collect = employeeList.stream().sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }

    /**
     * 按照age 降序、weight升序排序，输出对象
     */
    public void test11() {
        List<Employee> collect = employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()
                .thenComparingDouble(Employee::getWeight)).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    public void test12() {
        String collect = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("-->"));
        System.out.println(collect);

    }

    /*
     *聚合函数的应用
     * */
    public void test13() {
        // 7
        long count = employeeList.stream().filter(employee -> employee.getName().isEmpty()).count();
        IntSummaryStatistics intSummaryStatistics = employeeList.stream().mapToInt(Employee::getAge).summaryStatistics();
        int max = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        long sum = intSummaryStatistics.getSum();
        double average = intSummaryStatistics.getAverage();
        System.out.println("姓名为空的人数：" + count);
        System.out.println("最大的年龄：" + max);
        System.out.println("最小的年龄：" + min);
        System.out.println("年龄和：" + sum);
        System.out.println("平均年龄：" + average);
        List<Employee> employees = employeeList.stream().filter(employee -> employee.getAge() == min).collect(Collectors.toList());
        System.out.println("最小年龄的员工信息" + employees);
    }

    /*
     * 其中map有三种构造方法的重载：
     * 正常的key-value结构
     * toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper);
     * key存在冲突时，解决方案
     * toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper,BinaryOperator<U> mergeFunction);
     * 第四个参数是排序的方式
     * toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper,BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier);
     * */
    public void test14() {
        //得到姓名中包含"三"的人的姓名和员工号
        Map<Integer, String> map = employeeList.stream().filter(employee -> employee.getName().contains("三")).collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(map);
        //若key存在冲突那么，可以调用tomap的第二个重载方式
        Map<Integer, String> map2 = employeeList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName, (n, m) -> n + "," + m));
        System.out.println(map2);
        System.out.println("-------------------------");
        //tomap四个参数，第四个参数是排序方式
        Map<Integer, String> map3 = employeeList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName, (n, m) -> n + "," + m, TreeMap::new));
        System.out.println(map3);

    }

}
