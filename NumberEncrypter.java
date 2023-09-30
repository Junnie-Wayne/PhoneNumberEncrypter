import java.util.Scanner; // Importing the scanner class to aid in receiving input from the user

public class NumberEncrypter {
    public static void main(String[] args) {
        // Getting phone number from the user using the scanner 
        Scanner input = new Scanner(System.in); // Creating an object of the scanner class with object name "input"
        System.out.print("Enter a 10 digit phone number (e.g. 5131234567): ");
        final long PHONE_NUM = input.nextLong();
        
        // Step 1: Separating Digits
        int areaCode = (int) (PHONE_NUM / 10000000); // First 3 digits
        int centralOfficeCode = (int) ((PHONE_NUM / 10000) % 1000); // Next 3 digits
        int stationNumber = (int) (PHONE_NUM % 10000); // Last 4 digits
        
        // Printing out the separated parts of the number
        System.out.println("(" + areaCode + ") " + centralOfficeCode + " - " + stationNumber);
        
        // Step 2: Encrypting the Station Number
        int firstPart = (stationNumber / 100); // First 2 digits
        int secondPart = (stationNumber % 100); // Last 2 digits
        
        // Adding 33 to each part of the digits
        firstPart = firstPart + 33;
        secondPart = secondPart + 33;
        
        // Converting from int to char type, this is known as type casting
        char encrypted_1 = (char) firstPart;
        char encrypted_2 = (char) secondPart;
        
        // Printing out the encrypted characters in reverse order
        System.out.println("(" + areaCode + ") " + centralOfficeCode + " - " + encrypted_2 + encrypted_1);
        
        // Step 3: Encrypting the Rest of the Digits
        int combinedNumbers = (areaCode * 1000) + centralOfficeCode; // Combine the two numbers
        int result = Integer.MAX_VALUE - combinedNumbers; // Subtract from max int value

        // Printing the result
        System.out.println(result);
        
        // Step 4: Rearranging the Results
        String encryptedPhoneNumber = encrypted_2 + String.valueOf(result) + encrypted_1;
        
        // Printing out the final encrypted phone number
        System.out.println(encryptedPhoneNumber);
        
        input.close(); // Closing the input object of the scanner class to end up taking input from the user
    }
}
