public class BankingApplication {
    public static void main(String[] args){

    }
}

class BankAccount {
    int balance;
    int previous_transaction;
    String customer_id;
    String customer_name;

    BankAccount(String cname, String cid){
        this.customer_id = cid;
        this.customer_name = cname;
    }

    void deposit(int amount){
        if(amount !=0){
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

    void getPrevisousTransaction(){
        if(previous_transaction > 0){
            System.out.println("Deposited amount: " + previous_transaction);
        }
        else if (previous_transaction < 0){
            System.out.println("Withdraw amount: " + Math.abs(previous_transaction));
        }
        else {
            System.out.println("No transaction executed");
        }
    }



}
