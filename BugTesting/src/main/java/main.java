
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rajat
 */
public class main {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Integer> expenses = new ArrayList<Integer>();
    final static String[] arr = {"1. I wish to review my expenditure",
        "2. I wish to add my expenditure",
        "3. I wish to delete my expenditure",
        "4. I wish to sort the expenditures",
        "5. I wish to search for a particular expenditure",
        "6. Close the application"
    };

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        optionsSelection();

    }

    private static void optionsSelection() {
        for (int i = 0; i < 6; i++) {
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int options = sc.nextInt();
            switch (options) {
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses + "\n");
                    optionsSelection();
                    break;
                case 2:
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    System.out.println(expenses + "\n");
                    optionsSelection();

                    break;
                case 3:
                    System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if (con_choice == options) {
                        expenses.clear();
                        System.out.println(expenses + "\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    optionsSelection();
                    break;
                case 4:
                    sortExpenses(expenses);
                    optionsSelection();
                    break;
                case 5:
                    searchExpenses(expenses);
                    optionsSelection();
                    break;
                case 6:
                    closeApp();
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;
            }
        } else {System.out.println("You have made an invalid choice!");}
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        //Complete the method
        Scanner in = new Scanner(System.in);
        boolean found = false;
        int searchFor = in.nextInt();
        for (int i = 0; i < leng; i++) {
            if (arrayList.get(i).equals(searchFor)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("\nExpense found!\n");
        } else {
            System.out.println("\nExpense not found.\n");
        }
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength = arrayList.size();
        //Complete the method. The expenses should be sorted in ascending order.
        //Insertion Sort
        for (int i = 1; i < arrlength; i++) {
            int key = arrayList.get(i);
            int j = i - 1;
            while (j >= 0 && arrayList.get(j) > key) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
            }
            arrayList.set(j + 1, key);
        }
        System.out.println(arrayList.toString());
    }
}
