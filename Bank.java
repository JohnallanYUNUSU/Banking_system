package bank;

import javax.swing.JOptionPane;

public class Bank {
  static double balance = 0;

  public static void main(String[] args) {
    int option = 0;
    while (option != 4) {
      String menu = "Welcome to the Bank of Java\n" +
                    "1. Check Balance\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Exit\n" +
                    "Enter an option:";
      String input = JOptionPane.showInputDialog(menu);
      
      try {
        option = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 4.");
        continue;
      }

      switch (option) {
        case 1:
          checkBalance();
          break;
        case 2:
          deposit();
          break;
        case 3:
          withdraw();
          break;
        case 4:
          exit();
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
          break;
      }
    }
  }

  public static void checkBalance() {
    JOptionPane.showMessageDialog(null, "Your current balance is $" + balance);
  }

  public static void deposit() {
    String input = JOptionPane.showInputDialog("Enter the amount to deposit: $");
    try {
      double amount = Double.parseDouble(input);
      balance += amount;
      JOptionPane.showMessageDialog(null, "$" + amount + " has been deposited to your account.");
      checkBalance();
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
    }
  }

  public static void withdraw() {
    String input = JOptionPane.showInputDialog("Enter the amount to withdraw: $");
    try {
      double amount = Double.parseDouble(input);
      if (amount > balance) {
        JOptionPane.showMessageDialog(null, "Insufficient funds.");
      } else {
        balance -= amount;
        JOptionPane.showMessageDialog(null, "$" + amount + " has been withdrawn from your account.");
        checkBalance();
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
    }
  }

  public static void exit() {
    JOptionPane.showMessageDialog(null, "Thank you for banking with us. Have a great day!");
  }
}
