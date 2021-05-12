package controller.service;

import model.Directory;

import java.util.ArrayList;
import java.util.List;

public class FindMember  {

      public static List<Directory> findList(String str, List<Directory> directoryList) {
        List<Directory> directories = new ArrayList<>();
        for(Directory b : directoryList){
            boolean isNumber = b.getPhoneNumber().contains(str);
            boolean isName = b.getName().toLowerCase().contains(str.toLowerCase());
            if(isName|| isNumber)
                directories.add(b);
        }
        return directories;
    }
}
