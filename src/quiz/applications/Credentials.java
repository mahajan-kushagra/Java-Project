package quiz.applications;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Credentials {
    private static String path = "C:/Users/Public/Documents";
    private static String fileName = "DO_NOT_MODIFY.txt";
    static {
        try {
            File fcreate = new File(path + "/" + fileName);
            if (fcreate.createNewFile())
                System.out.println(
                        "A new (empty) file containing user IDs and their respective passwords has been created.");
            else
                System.out.println("Unable to create file containing user IDs and their respective passwords.");
        } catch (IOException ioEx) {
            System.out.println("IOException occured while creating data file. Stack trace: ");
            ioEx.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Unknown error occured while creating data file. Stack trace: ");
            ex.printStackTrace();
        }
    }

    static boolean addUser(String username, String password) throws FileDeletedException, UserAlreadyExistsException {
        try {
            File file = new File(path + "/" + fileName);
            if (!file.exists())
                throw new FileDeletedException();

            Scanner reader = new Scanner(file);
            try {
                while (reader.hasNextLine()) {
                    if (username.equals(reader.nextLine()))
                        throw new UserAlreadyExistsException();
                    reader.nextLine();
                    reader.nextLine();
                }
            } catch (NoSuchElementException nseEx) {
            } finally {
                reader.close();
            }

            FileWriter writer = new FileWriter(file, true);
            try {
                writer.write(username + "\n" + password + "\n\n");
            } finally {
                writer.close();
            }
        } catch (IOException ioEx) {
            System.out.println("IOException occured in Credentials.addUser() method. Stack trace: ");
            ioEx.printStackTrace();
            return false;
        } catch (Exception ex) {
            throw ex;
        }
        return true;
    }

    static boolean validate(String username, String password) {
        //
    }
}

class FileDeletedException extends Exception {
    public String toString() {
        String message = "File could not be found at the expected location; must have been tampered/modified/deleted by the external sources.";
        return message;
    }
}

class UserAlreadyExistsException extends Exception {
    public String toString() {
        String message = "The username you\'re trying to add is already taken. Please try another username";
        return message;
    }
}