package controller;

import commons.FileHandle;
import commons.FunctionValidation;
import view.Menu;
import commons.ScannerUntil;
import model.Directory;
import controller.service.*;
import model.Gender;

import java.util.ArrayList;
import java.util.List;

public class DirectoryController {
    public static final String ENTER_PHONENUMBER = "enter phone number";
    public static final String INVALID_PHONEMUMBER = "phone number must be fomat [9-12]";
    public static final String ENTER_NAME = "enter name";
    public static final String ENTER_GROUP = "enter group";
    public static final String ENTER_ADDRESS = "enter address";
    public static final String ENTER_BIRTHDAY = "enter birthday";
    public static final String INVALID_BIRTHDAY = "phone number must be fomat DD/MM/YYYY";
    public static final String ENTER_EMAIL = "enter email";
    public static final String INVALID_EMAIL = "phone number must be fomat abc@abc.com";

    private static List<Directory> directoryList = new ArrayList<>();

    public static void addNewDirectory() {
        directoryList = FileHandle.readDirectory();
        String phone = FunctionValidation.getValidPhone(ENTER_PHONENUMBER, INVALID_PHONEMUMBER);
        while (findByNumber(phone, directoryList)!= null) {
            System.err.println("Already exits phone number");
            Menu.menuContinue();
            phone = FunctionValidation.getValidPhone(ENTER_PHONENUMBER, INVALID_PHONEMUMBER);
        }
        System.out.println(ENTER_NAME);
        String name = ScannerUntil.scanner.nextLine();

        System.out.println(ENTER_GROUP);
        String group = ScannerUntil.scanner.nextLine();
        Gender gender = MenuController.chooseGender();
        System.out.println(ENTER_ADDRESS);
        String address = ScannerUntil.scanner.nextLine();
        String birthday = FunctionValidation.getValidBirthday(ENTER_BIRTHDAY, INVALID_BIRTHDAY);
        String email = FunctionValidation.getValidEmail(ENTER_EMAIL, INVALID_EMAIL);

        Directory directory = new Directory(phone, group, name, gender, address, birthday, email);
        directoryList.add(directory);
        FileHandle.writeDrirectory(directoryList);
        System.out.println(" successfull!");

    }


    public static Directory findByNumber(String number, List <Directory> directoryList){
        return directoryList.stream().filter(
                o ->o.getPhoneNumber().equals(number))
                .findFirst().orElse(null);
    }

    public static void displayList() {
        directoryList = FileHandle.readDirectory();

        for (Directory a:directoryList
             ) {
            System.out.println(a.toString());
        }
    }
    public static void displayList(Directory directory){
        System.out.println(directory.toString());
    }

    public static void deleteMember(String number){
        directoryList = FileHandle.readDirectory();
        if(findByNumber(number,directoryList)!= null) {
            System.out.println("enter \"y\" to confirm or differnt key to finish");
            if(ScannerUntil.scanner.nextLine().equals("y")) {
                directoryList.remove(findByNumber(number, directoryList));
                FileHandle.writeDrirectory(directoryList);
                System.out.println("delete member done");
            }
        } else
        {
            System.err.println(" not find member");
        }
    }
//    public static void editMember(String number){
//        directoryList = FileHandle.readDirectory();
//        if(findByNumber(number,directoryList)!= null) {
//            directoryList.remove(findByNumber(number, directoryList));
//            FileHandle.writeDrirectory(directoryList);
////           addNewDirectory();
//
//        } else
//        {
//            System.err.println(" not find member");
//        }
//    }


    public static void editMember(String number){
        directoryList = FileHandle.readDirectory();
        Directory directory = findByNumber(number,directoryList);
        if(directory!= null) {
//            Menu.menuMember();
            directoryList.remove(directory);
            System.out.println(ENTER_GROUP);
            directory.setGroup(ScannerUntil.scanner.nextLine());
            System.out.println(ENTER_NAME);
            directory.setName(ScannerUntil.scanner.nextLine());
            directory.setGender(MenuController.chooseGender());
            System.out.println(ENTER_ADDRESS);
            directory.setAddress( ScannerUntil.scanner.nextLine());
            directory.setBirthday(FunctionValidation.getValidBirthday(ENTER_BIRTHDAY, INVALID_BIRTHDAY));
            directory.setEmail( FunctionValidation.getValidEmail(ENTER_EMAIL, INVALID_EMAIL));
            directoryList.add(directory);
            FileHandle.writeDrirectory(directoryList);
            System.out.println("successfull");
        }
        else {
            System.err.println(" not find member");
        }
    }


    public static void editMember2(){
        ;
    }

    public static void findMember(String str){
        directoryList = FileHandle.readDirectory();
        List<Directory> directories = new ArrayList<>();
        directories = FindMember.findList(str,directoryList);
        Menu.menuList();
        for (Directory b: directories
             ) {
            System.out.println(b.toString());
        }

    }
}