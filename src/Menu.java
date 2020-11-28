import java.util.Scanner;

public class Menu {

    Operate operate = new Operate();              //业务处理类
    TelNoteRegex noteRegex = new TelNoteRegex();  //用户输入验证类
    Scanner scanner = new Scanner(System.in);

    //主菜单
    public void mainMenu() {
        while (true) {      //保证可以一直循环遍历主菜单
            System.out.println("*************************");
            System.out.println("**      1 添加记录     **");
            System.out.println("**      2 查找记录     **");
            System.out.println("**      3 修改记录     **");
            System.out.println("**      4 删除记录     **");
            System.out.println("**      5 排序记录     **");
            System.out.println("**      6 退出系统     **");
            System.out.println("*************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：6");
            int num = scanner.nextInt();
            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 6))) {
                //将 int 变量 num 转换成字符串
                //String.matches() 这个方法主要是返回是否匹配指定的字符串，如果匹配则为true,否则为false;
                switch (num) {
                    case 1:
                        addMenu();        // 添加用户菜单
                    case 2:
                        searchMenu();     //查找用户菜单
                    case 3:
                        modifyMenu();     //修改用户信息主菜单
                    case 4:
                        deleteMenu();     //删除用户信息菜单
                    case 5:
                        orderMenu();      //排序用户信息菜单
                    case 6:
                        System.exit(0);   //退出系统
                    default:
                        break;
                }
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }
    }

    //添加用户菜单
    public void addMenu() {
        while (true) {
            System.out.println("**************************");
            System.out.println("**      1 添加新记录     **");
            System.out.println("**      2 查看全记录     **");
            System.out.println("**      3 返回上一级     **");
            System.out.println("**************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：3");
            int num = scanner.nextInt();

            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 3))) {
                switch (num) {
                    case 1:
                        operate.addOperation();
                        break;
                    case 2:
                        operate.showAll();
                        break;
                    case 3:
                        mainMenu();
                    default:
                        break;
                }
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }
    }

    //查找用户菜单
    public void searchMenu() {
        while (true) {
            System.out.println("**************************");
            System.out.println("**      1 按姓名查找     **");
            System.out.println("**      2 按年龄查找     **");
            System.out.println("**      3 按性别查找     **");
            System.out.println("**      4 按号码查找     **");
            System.out.println("**      5 按住址查找     **");
            System.out.println("**      6 查看全记录     **");
            System.out.println("**      7 返回上一级     **");
            System.out.println("**************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：7");
            int num = scanner.nextInt();
            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 7))) {
                switch (num) {
                    case 1:
                        operate.searchByName();
                        break;
                    case 2:
                        operate.searchByAge();
                        break;
                    case 3:
                        operate.searchBySex();
                        break;
                    case 4:
                        operate.searchByTelNum();
                        break;
                    case 5:
                        operate.searchByAdd();
                        break;
                    case 6:
                        operate.showAll();
                        break;
                    case 7:
                        mainMenu();
                    default:
                        break;
                }
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }
    }

    //修改用户信息主菜单
    public void modifyMenu() {
        while (true) {
            System.out.println("***************************");
            System.out.println("**      1 查看全记录      **");
            System.out.println("**      2 修改指定记录    **");
            System.out.println("**      3 返回上一级      **");
            System.out.println("***************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：3");
            int num = scanner.nextInt();
            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 3))) {
                switch (num) {
                    case 1:
                        operate.showAll();
                        break;
                    case 2:
                        operate.modify();
                        break;
                    case 3:
                        mainMenu();
                    default:
                        break;
                }
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }
    }

    //修改用户信息子菜单
    public int subModifyMenu() {
        while (true) {
            System.out.println("*************************");
            System.out.println("**      1 修改姓名     **");
            System.out.println("**      2 修改年龄     **");
            System.out.println("**      3 修改性别     **");
            System.out.println("**      4 修改号码     **");
            System.out.println("**      5 修改住址     **");
            System.out.println("**      6 返回上一级   **");
            System.out.println("*************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：6");
            int num = scanner.nextInt();

            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 6))) {
                return num;
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }
    }

    //删除用户信息菜单
    public void deleteMenu() {
        while (true) {
            System.out.println("****************************");
            System.out.println("**       1 查看全记录      **");
            System.out.println("**       2 删除指定记录    **");
            System.out.println("**       3 删除全部记录    **");
            System.out.println("**       4 返回上一级      **");
            System.out.println("****************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：4");
            int num = scanner.nextInt();
            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 4))) {
                switch (num) {
                    case 1:
                        operate.showAll1();
                        break;
                    case 2:
                        operate.delete();
                        break;
                    case 3:
                        operate.deleteAll();
                        break;
                    case 4:
                        mainMenu();
                    default:
                        break;
                }
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }
    }

    //排序用户信息菜单
    public void orderMenu() {
        while (true) {
            System.out.println("****************************");
            System.out.println("**       1 按姓名排序      **");
            System.out.println("**       2 按年龄排序      **");
            System.out.println("**       3 按性别排序      **");
            System.out.println("**       4 查看全部记录    **");
            System.out.println("**       5 返回上一级      **");
            System.out.println("****************************");

            System.out.println("请输入正确的数字，最小是：1  最大是：5");
            int num = scanner.nextInt();
            if (String.valueOf(num).matches(noteRegex.menuRegex(1, 5))) {
                switch (num){
                    case 1:
                        operate.orderName();
                        break;
                    case 2:
                        operate.orderAge();
                        break;
                    case 3:
                        operate.orderSex();
                        break;
                    case 4:
                        operate.showAll1();
                        break;
                    case 5:
                        mainMenu();
                    default:
                        break;
                }
            } else {
                System.out.println("输入数值有误，请输入正确的数字");
            }
        }

        }

}
