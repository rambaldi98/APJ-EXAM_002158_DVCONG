package commons;

import HandleException.BirthdayException;
import HandleException.EmailException;
import HandleException.PhoneNumberException;

public class FunctionValidation {
    private static String pattern = "";

    public static boolean isValidPhone(String str){
        pattern = "^\\d{9,12}$";
        return str.matches(pattern);
    }

    public static String getValidPhone(String strDisplay,String errMess){
        String result =null;
        System.out.println(strDisplay);
        try {
            result = ScannerUntil.scanner.nextLine();
            if(!isValidPhone(result))
                throw new PhoneNumberException(errMess);

            }
        catch (PhoneNumberException e) {
            System.err.println(errMess);
            result =getValidPhone(strDisplay,errMess);
        }
        return result;
    }


    // email exception
    public static boolean isValidEmail(String str) {
        pattern = "^[a-z0-9._-]+@[a-z0-9._-]+\\.[a-z]{2,3}";
        return str.matches(pattern);
    }

    public static String getValidEmail(String strDisplay, String errMess) {
        String result =null;
        System.out.println(strDisplay);
        try{
            result = ScannerUntil.scanner.nextLine();
            if(!isValidEmail(result)) {
                throw new EmailException(errMess);
            }
        } catch (EmailException e){
            System.err.println(errMess);
            result = getValidEmail(strDisplay,errMess);
        }
        return result;
    }

    // ngay thang nam
    public static boolean isValidBirthday(String str) {
        pattern = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";
        return str.matches(pattern);
    }

    public static String getValidBirthday(String strDisplay, String errMess) {
        String result =null;
        System.out.println(strDisplay);
        try{
            result = ScannerUntil.scanner.nextLine();
            if(!isValidBirthday(result)) {
                throw new BirthdayException(errMess);
            }
        } catch (BirthdayException e){
            System.err.println(errMess);
            result = getValidBirthday(strDisplay,errMess);
        }
        return result;
    }




}
