package view;

import commons.ScannerUntil;
import model.Gender;

public class Menu {

    public static void menu(){
        System.out.println("----------directory manager-------");
        System.out.println("1. show all member" +"\n"+
                "2. add new member" +"\n"+
                "3. edit member" +"\n"+
                "4. delete memeber" +"\n"+
                "5. find member" +"\n"+
                "0. exits");

    }

    public static void menuContinue() {
        System.out.println("-----Enter to continue----------");
        ScannerUntil.scanner.nextLine();
    }

    public static void menuMember(){
        System.out.println("----------------edit member menu----------------");
        System.out.println("1. edit group" +"\n"+
                "2. edit name" +"\n"+
                "3. edit gender" +"\n"+
                "4. edit address" +"\n"+
                "5. edit birthday" +"\n"+
                "6. edit email" +"\n"+
                "0. back to menu");
    }

    public static void menuList(){
//        System.out.println("--------------------------List member--------------------");
        System.err.println(
                "phoneNumber" +"\t\t\t"+
                "name" +"\t\t\t"+
                "group" +"\t\t\t"+
                "gender" +"\t\t\t"+
                "address" +"\t\t\t"+
                "birthday" +"\t\t\t"+
                "email");
    }


}
