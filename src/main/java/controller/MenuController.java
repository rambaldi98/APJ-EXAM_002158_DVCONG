package controller;

import commons.ScannerUntil;
import model.Gender;
import view.Menu;

import static view.Menu.*;

public class MenuController {
    public static Gender chooseGender(){
        System.out.println("Enter Genger");
        System.out.println("1. MALE" +"\n"+
                "2. FEMALE" +"\n"+
                "3. ANOTHER");
        String chose = ScannerUntil.scanner.nextLine();
        switch (chose){
            case "1":
                return Gender.MALE;
            case "2":
                return Gender.FEMALE;
            case "3":
                return Gender.ANOTHER;
            default:
                menuContinue();
                chooseGender();
                break;
        }
        return Gender.ANOTHER;
    }

    public static void menuManager(){
        menu();
        switch (ScannerUntil.scanner.nextLine()){
            case "2":
                DirectoryController.addNewDirectory();
                menuContinue();
                menuManager();
                break;
            case "1":
                menuList();
                DirectoryController.displayList();
                menuContinue();
                menuManager();
                break;
            case "4":
                menuDeleteMember();
                menuContinue();
                menuManager();
                break;
            case "3":
                menuEditMember();
                menuContinue();
                menuManager();
                break;
            case "5":
                menuFindAll();
                menuContinue();
                menuManager();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.err.println("Invalid");
                menuContinue();
                menuManager();
                break;
        }
    }

    public static void menuDeleteMember(){
        System.out.println("Enter phone number delete");
        DirectoryController.deleteMember(ScannerUntil.scanner.nextLine());

    }

    public static void menuEditMember() {
        System.out.println("enter phone number edit");
        DirectoryController.editMember(ScannerUntil.scanner.nextLine());
    }

    public static void menuFindAll(){
        System.out.println("enter phone or name find");
        DirectoryController.findMember(ScannerUntil.scanner.nextLine());
    }

    public static void menuEdit2(){
        System.out.println("Enter phone number delete");

    }

}
