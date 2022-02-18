import java.util.Scanner;

public class Main {
    public static void Main(String[] args){
        BankAccount cust1 = new BankAccount("Quyen Linh TA", "4782487247384");
        cust1.showMenu();
    }
}

class BankAccount{
    int balance;
    int previous_transaction;
    String customer_name;
    String customer_id;

    BankAccount(String cname, String cid){
        this.customer_name = cname;
        this.customer_id = cid;
    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previous_transaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previous_transaction = -amount;
        }
    }

    void gerPreviousTransaction(){
        if(previous_transaction > 0){
            System.out.println("Deposited amount: " + previous_transaction);
        }
        else if(previous_transaction < 0 ){
            System.out.println("Withdraw amount: " + Math.abs(previous_transaction));
        }
        else {
            System.out.println("No transaction was executed!");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome "+ customer_name + "!");
        System.out.println("Your ID account is "+ customer_id);
        System.out.println("________________________________");
        System.out.println("Check Balance");
        System.out.println("Deposit");
        System.out.println("Withdraw");
        System.out.println("Previous Transaction");
        System.out.println("Exit");

        do{
            System.out.println("===============================================");
            System.out.println("Choose your operation");
            System.out.println("===============================================");
            option = scanner.next().charAt(0);

            switch (option){
                case 'A':
                    System.out.println("------------------------------");
                    System.out.println("Your balance is: " + balance);
                    System.out.println("------------------------------");
                    break;
                case 'B':
                    System.out.println("------------------------------");
                    System.out.println("Enter your amount deposit: ");
                    System.out.println("------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("Your balance currently is: " + balance);
                    break;
                case 'C':
                    System.out.println("------------------------------");
                    System.out.println("Enter your amount withdraw: ");
                    System.out.println("------------------------------");
                    int w = scanner.nextInt();
                    withdraw(w);
                    System.out.println("Your balance currently is: " + balance);
                    break;
                case 'D':
                    System.out.println("------------------------------");
                    System.out.println("Your previous transaction : ");
                    gerPreviousTransaction();
                    System.out.println("------------------------------");
                    break;
                case 'E':
                    System.out.println("****************************************");
                    System.out.println("Ending process!");
                    System.out.println("------------------------------");
                    break;
                default:
                    System.out.println("Invalid Option! Please enter again!");
                    break;
            }
        }
        while(option != 'E');
        System.out.println("Thank you for using our services!");
    }
}