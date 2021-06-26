package Create_Party_Manually;

import java.util.Scanner;

public class CreatePartyMenu {
    public static void main(String[] args) {
        //Create party menu
        System.out.println("\nCreate your party:");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Manually                                 │");
        System.out.println("│[2] Randomly                                 │");
        System.out.println("│                                             │");
        System.out.println("│[3] Go back                                  │");
        System.out.println("┖---------------------------------------------┚");

        int selectedOption = 0;
        boolean isInt = false;
        Scanner scanner = new Scanner(System.in);

        //Verifying if selected option is available
        while (true) {
            selectedOption = scanner.nextInt();

            if (selectedOption >= 1 && selectedOption <= 3) {
                break;
            } else {
                System.out.println("\nPlease enter [1], [2] or [3].");
            }
        }

        switch (selectedOption) {
            //Entering manual party creator
            case 1:
                //Access to the method in CreatePartyManually class to configure a new party member
                CreatePartyManually partyManually = new CreatePartyManually();
                partyManually.createCharacterManually();
                break;

            //Entering random party generator
            case 2:
                //Access to the method in CreatePartyRandomly class to create a new party
                CreatePartyRandomly partyRandomly = new CreatePartyRandomly();
                partyRandomly.createCharacterRandomly();
                break;

//Access to the method to move user back to previous step
            case 3:
                System.out.println("Go back to main menu.");
                break;

            default:
//Quit method
                System.out.println("Things went south. Try again.");
        }
    }
}