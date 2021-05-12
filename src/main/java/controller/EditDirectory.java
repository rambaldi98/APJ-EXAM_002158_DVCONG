package controller;

import commons.FunctionValidation;
import commons.ScannerUntil;
import model.Directory;

import static controller.DirectoryController.*;

public class EditDirectory {
    public static Directory editGroup(Directory directory){
            System.out.println(ENTER_GROUP);
            directory.setGroup(ScannerUntil.scanner.nextLine());
        return directory;
    }

    public static Directory editName(Directory directory){
        System.out.println(ENTER_NAME);
        directory.setName(ScannerUntil.scanner.nextLine());
        return directory;
    }

    public static Directory editGenDer(Directory directory){

        directory.setGender(MenuController.chooseGender());
        return directory;
    }
    public static Directory editAddress(Directory directory){

        System.out.println(ENTER_ADDRESS);
        directory.setAddress( ScannerUntil.scanner.nextLine());
        return directory;
    }

    public static Directory editBirthday(Directory directory){
        directory.setBirthday(FunctionValidation.getValidBirthday(ENTER_BIRTHDAY, INVALID_BIRTHDAY));
        return directory;
    }
    public static Directory editEmail(Directory directory){
        directory.setEmail( FunctionValidation.getValidEmail(ENTER_EMAIL, INVALID_EMAIL));
        return directory;
    }

}
