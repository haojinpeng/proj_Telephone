import java.util.*;

public class Operate {

    //业务处理类
    private Vector<Person> vector = new Vector<>();

    Scanner scanner = new Scanner(System.in);
    TelNoteRegex noteRegex = new TelNoteRegex();

    //用户添加信息业务逻辑控制
    public void addLogic() {

    }

    //用户查询信息业务逻辑控制
    public void searchLogic() {

    }

    //修改信息业务逻辑控制
    public void modifyLogic() {

    }

    //删除信息业务逻辑控制
    public void deleteLogic() {

    }

    //排序信息业务逻辑控制
    public void orderLogic() {

    }

    //添加用户信息
    public void addOperation() {
        Person person = new Person();

        while (true) {
            //String.matches() 这个方法主要是返回是否匹配指定的字符串
            System.out.println("输入姓名，1-10位字母");
            String name = scanner.next();
            if (name.matches(noteRegex.nameRegex())) {
                person.setName(name);
                break;    //跳出当前循环体
            } else {
                System.out.println("输入姓名有误，请检查");
            }
        }
        while (true) {
            System.out.println("输入年龄，1-100+");
            String age = scanner.next();
            if (age.matches(noteRegex.ageRegex())) {
                person.setAge(age);
                break;
            } else {
                System.out.println("输入年龄有误，请检查");
            }
        }
        while (true) {
            System.out.println("输入性别:(男 m or M) (女 f or F)");
            String sex = scanner.next();
            if (sex.matches(noteRegex.sexRegex())) {
                person.setSex(sex);
                break;
            } else {
                System.out.println("输入性别有误，请检查");
            }
        }
        while (true) {
            System.out.println("输入电话号码:6-10位数字");
            String telNum = scanner.next();
            if (telNum.matches(noteRegex.telNumRegex())) {
                person.setTelNum(telNum);
                break;
            } else {
                System.out.println("输入电话号码有误，请检查");
            }
        }
        while (true) {
            System.out.println("输入地址:1-50位字母或数字");
            String address = scanner.next();
            if (address.matches(noteRegex.addressRegex())) {
                person.setAddress(address);
                break;
            } else {
                System.out.println("输入地址有误，请检查");
            }
        }
        vector.add(person);
        System.out.println("添加成功！");
    }

    //查询当前用户信息
    public void showInfo(Object o) {
        //　instanceof 严格来说是Java中的一个双目运算符，
        // 用来测试一个对象是否为一个类的实例，
        if (o != null && o instanceof Person) {
            Person p = (Person) o;
            System.out.println("序号 " + p.getId() + "#\t姓名 " + p.getName()
                    + "\t年龄 " + p.getAge() + "\t性别" + p.getSex() + "\t电话号码"
                    + p.getTelNum() + "\t住址" + p.getAddress());
        }
    }

    //查询全部用户信息
    public void showAll() {
        //用遍历集合实现
        for (Person person : vector
        ) {
            showInfo(person);
        }
    }

    //查询全部用户信息(序号从1开始，借助索引值)
    public void showAll1() {
        for (int i = 0; i < vector.size(); i++) {
            Person p = vector.get(i);
            System.out.println("序号 " + (i + 1) + "#\t姓名 " + p.getName()
                    + "\t年龄 " + p.getAge() + "\t性别" + p.getSex() + "\t电话号码"
                    + p.getTelNum() + "\t住址" + p.getAddress());
        }
    }

    //按姓名查询用户信息
    public void searchByName() {
        while (true) {
            System.out.println("输入姓名：1-10位字母");
            String name = scanner.next();

            boolean flag = true;
            if (name.matches(noteRegex.nameRegex())) {
                for (Person p : vector) {
                    if (p.getName().equals(name)) {
                        flag = false;
                        showInfo(p);
                    }
                }
                if (flag) {
                    System.out.println("没有这个人");
                }
                break;
            } else {
                System.out.println("输入姓名有误，请检查");
            }
        }
    }

    //按年龄查询用户信息
    public void searchByAge() {
        while (true) {
            System.out.println("请输入年龄，1-100+");
            String age = scanner.next();

            boolean flag = true;
            if (age.matches(noteRegex.ageRegex())) {
                for (Person p : vector) {
                    if (p.getAge().equals(age)) {
                        flag = false;
                        showInfo(p);
                    }
                }
                if (flag) {
                    System.out.println("没有符合的年龄");
                }
                break;
            } else {
                System.out.println("输入年龄有误，请检查");
            }

        }
    }

    //按性别查询用户信息
    public void searchBySex() {
        while (true) {
            System.out.println("输入性别:(男 m or M) (女 f or F)");
            String sex = scanner.next();

            boolean flag = true;
            if (sex.matches(noteRegex.sexRegex())) {
                for (Person p : vector) {
                    if (p.getSex().equals(sex)) {
                        flag = false;
                        showInfo(p);
                    }
                }
                if (flag) {
                    System.out.println("没有对应的性别");
                }
                break;
            } else {
                System.out.println("输入性别有误，请检查");
            }
        }
    }

    //按电话号码查询用户信息
    public void searchByTelNum() {
        while (true) {
            System.out.println("输入电话号码:6-10位数字");
            String telNum = scanner.next();

            boolean flag = true;
            if (telNum.matches(noteRegex.telNumRegex())) {
                for (Person p : vector) {
                    if (p.getTelNum().equals(telNum)) ;
                    flag = false;
                    showInfo(p);
                }
                if (flag) {
                    System.out.println("没有对应电话");
                }
                break;
            } else {
                System.out.println("输入电话有误，请检查");
            }

        }
    }

    //按照地址查询用户信息
    public void searchByAdd() {
        while (true) {
            System.out.println("输入地址:1-50位字母或数字");
            String address = scanner.next();

            boolean flag = true;
            if (address.matches(noteRegex.addressRegex())) {
                for (Person p : vector) {
                    if (p.getAddress().equals(address)) {
                        flag = false;
                        showInfo(p);
                    }
                    if (flag) {
                        System.out.println("没有对应的地址");
                    }
                }
                break;
            }else {
                System.out.println("输入地址有误，请检查");
            }

        }
    }

    //修改指定记录信息
    public void modify() {

        System.out.println("请输入记录序号");
        System.out.println("请输入正确的数字，最小是：1  最大是：" + vector.size());

        int num = scanner.nextInt();
        if (String.valueOf(num).matches(noteRegex.menuRegex(1, vector.size()))) {
            for (Person p : vector) {
                if (p.getId() == num) {
                    a:
                    while (true) {
                        int n = new Menu().subModifyMenu();
                        switch (n) {
                            case 1:
                                while (true) {
                                    System.out.println("输入姓名：1-10位字母");
                                    String name = scanner.next();
                                    if (name.matches(noteRegex.nameRegex())) {
                                        p.setName(name);
                                        break;
                                    } else {
                                        System.out.println("输入姓名有误，请检查");
                                    }
                                }
                            case 2:
                                while (true) {
                                    System.out.println("输入年龄：1-100+");
                                    String age = scanner.next();
                                    if (age.matches(noteRegex.ageRegex())) {
                                        p.setAge(age);
                                        break;
                                    } else {
                                        System.out.println("输入年龄有误，请检查");
                                    }
                                }
                            case 3:
                                while (true) {
                                    System.out.println("输入性别:(男 m or M) (女 f or F)");
                                    String sex = scanner.next();
                                    if (sex.matches(noteRegex.sexRegex())) {
                                        p.setSex(sex);
                                        break;
                                    } else {
                                        System.out.println("输入性别有误，请检查");
                                    }
                                }
                            case 4:
                                while (true) {
                                    System.out.println("输入电话号码:6-10位数字");
                                    String telNum = scanner.next();
                                    if (telNum.matches(noteRegex.telNumRegex())) {
                                        p.setTelNum(telNum);
                                        break;
                                    } else {
                                        System.out.println("输入电话号码有误，请检查");
                                    }
                                }
                            case 5:
                                while (true) {
                                    System.out.println("输入地址:1-50位字母或数字");
                                    String addr = scanner.next();
                                    if (addr.matches(noteRegex.addressRegex())) {
                                        p.setAddress(addr);
                                        break;
                                    } else {
                                        System.out.println("输入住址有误，请检查");
                                    }
                                }
                            case 6:
                                break a;
                            default:
                                break;
                        }
                    }
                }
            }
        } else {
            System.out.println("输入数值有误，请输入正确的数字");
        }
    }

    //删除指定用户信息
    public void delete() {
        System.out.println("请输入记录序号");
        System.out.println("请输入正确的数字，最小是：1  最大是：" + vector.size());

        int num = scanner.nextInt();
        if (String.valueOf(num).matches(noteRegex.menuRegex(1, vector.size()))) {
            vector.remove(num-1);  //vector是一个数组，所以下标要减去1
            System.out.println("删除成功！请继续操作！");
        }else {
            System.out.println("输入数值有误，请输入正确的数字");
        }
    }

    //删除全部用户信息
    public void deleteAll() {
        vector.clear();
        System.out.println("电话簿内容已清空，请继续操作！");
    }

    //按用户姓名排序信息
    public void orderName() {
        List<Person> p = vector;
        Collections.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        vector = (Vector)p;
        System.out.println("按姓名排序结果：");
        showAll1();
        //  TreeSet<Person> personTreeSet = new TreeSet<>(new OrderNameComparator());

    }

    //按用户年龄排序信息
    public void orderAge() {
        List<Person> p = vector;
        Collections.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        vector = (Vector)p;
        System.out.println("按年龄排序结果：");
        showAll1();
    }

    //按用户性别排序信息
    public void orderSex() {
        List<Person> p = vector;
        Collections.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSex().compareTo(o2.getSex());
            }
        });
        vector = (Vector)p;
        System.out.println("按性别排序结果：");
        showAll1();
    }

   /* class OrderNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }*/
}