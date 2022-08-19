import java.util.Scanner;

public class Main {
    static String alphabetDefinition = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // used to get input from user

        System.out.println("Encrypt or Decrypt (1/2)");

        String choice = sc.nextLine();

        if (choice.equals("E") || choice.equals("e") || choice.equals("1")){
            // getting plaintxt
            System.out.println("Input to be encrypted: ");
            String plainString = sc.nextLine(); // Used to read the input line from the user

            // getting key
            System.out.println("Key (1-25): ");
            int key = sc.nextInt();

            System.out.println(encrypt(plainString, key));

        } else if (choice.equals("D") || choice.equals("d") || choice.equals("2")) {
            // getting encrypted message
            System.out.println("Input to be encrypted: ");
            String encryptedString = sc.nextLine(); // Used to read the input line from the user

            // getting key
            System.out.println("Key (1-25): ");
            int key = sc.nextInt();

            System.out.println(decrypt(encryptedString, key));
        }


    }

    public static String encrypt(String plainTxt, int key){

        String encryptedString = "";

        for (char currentLetter: plainTxt.toCharArray()) {
            int i = 0;
            while (i < 26){
                if (currentLetter == alphabetDefinition.toCharArray()[i]){
                    encryptedString += alphabetDefinition.toCharArray()[(i + key) % 26]; // add the key to change the letters, modulo 26 to wrap
                    break;
                }
                i += 1;
            }
        }
        return encryptedString;
    }

    public static String decrypt(String encryptedTxt, int key){
        String plainString = "";

        for (char currentLetter: encryptedTxt.toCharArray()) {
            int i = 0;
            while (i < 26){
                if (currentLetter == alphabetDefinition.toCharArray()[i]){
                    plainString += alphabetDefinition.toCharArray()[(i - key) % 26]; // subtract key to undo the encryption + modulo 26 so it wraps around the array
                    break;
                }
                i += 1;
            }
        }
        return plainString;
    }

}