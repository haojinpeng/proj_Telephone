public class TelNoteRegex {

    //正则表达式验证

    //对菜单输入选项的验证
    public String menuRegex(int min,int max){
        return "["+min+"-"+max+"]";
    }

    //对用户输入姓名的验证
    public String nameRegex(){
        return "[a-zA-Z]{1,10}";
    }

    //对用户输入年龄的验证
    public String ageRegex(){
        return "^([1-9]\\d{0,1}|100)$";
    }

    //对用户输入性别的验证
    public String sexRegex(){
        return "[mMfF]";
    }

    //对用户输入电话号码的验证
    public String telNumRegex(){
        return "\\d{6,10}";
    }

    //对用户输入地址的验证
    public String addressRegex(){
        return "\\w{1,50}";
    }
}
