import java.util.Scanner;

public class Password {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your password must be 8-16 characters long, and include at least 3 of the following:");
        System.out.println();
        System.out.println("- lower case letters, i.e., a-z");
        System.out.println("- upper case letters, i.e., A-Z");
        System.out.println("- numbers, i.e., 0-9");
        System.out.println("- the following special symbols: ~!@#$%^&*()-=+_");
        System.out.println();
        
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter your new password:");
            String userPassword = scanner.nextLine();
            isValid = verifyPassword(userPassword);

            if (isValid) {
                System.out.println("Password saved!");
            } else {
                System.out.println("Invalid password. Please try again!");
            }
        }
    }   

    public static boolean verifyPassword(String userPassword){
        int numCount = 0;
        int symbolCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int invalidCount = 0;
        String symbols = "~!@#$%^&*()-=+_";
        if (userPassword.length() < 8 || userPassword.length() > 16){
            return false;
        }
        for (int i = 0; i < userPassword.length(); i++){
            char c = userPassword.charAt(i);
            if (Character.isLetter(c)){
                if (Character.isLowerCase(c)){
                    lowerCount ++;
                } else if (Character.isUpperCase(c)){
                    upperCount ++;
                }
            
            } else if (Character.isDigit(c)){
                numCount ++;
            } else if (symbols.indexOf(c) != -1){
                symbolCount ++;
            } else {
                invalidCount ++;
            }
        }
        int[] passwordContents = {numCount, symbolCount, lowerCount, upperCount};
        if (invalidCount > 0){
            return false;
        }
        int zeroCount = 0;
        for (int element : passwordContents){
            if (element == 0){
                zeroCount ++;
            }
        }
        if (zeroCount <= 1){
            return true;
        } else {
            return false;
        }
    }
}