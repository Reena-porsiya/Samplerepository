
public class Bank {
    private long currBalance = 0;

    // Bank_id is checked for authentication
    long bank_id;
    String name;

    // function to modify private data
    public long getBalance(long Id) {

        // Checking whether the user is
        // valid or not

        // Compare bank_id of user and the give Id
        // then only it will get access
        
        if (this.bank_id == Id) {

        // Return current balance
            return currBalance;
        }

        // Unauthorised user return -1
        return -1;
    }
    // Setter function to update the balance
    public void setBalance(long balance, long Id) {
        // Compare bank_id of user and the give Id
        // then only it will get access
        
        if (this.bank_id == Id) {
        // Update balance in current ID
            currBalance = currBalance + balance;
        }
    }
}

// Another class created- Employee
public class Bank {
    public static void main(String[] args) {
        // Creating employee object of Bank class
        Bank employee = new Bank();

        // Assigning employee object values
        employee.bank_id = 12345;
        employee.name = "Aryan";

        // employee.getBalance(123456)
        employee.setBalance(90000, 1909009);
        // This will not get access as bank_id is given wrong
        // unauthorised user is not getting access. This is data hiding


        long emp_balance = employee.getBalance(12345);
        // As this time it is valid user it will get access


        System.out.println("User Name" + "  " + employee.name);
        System.out.println("Bank_ID" + "  " + employee.bank_id);
        System.out.println("Current Balance" + "  " + emp_balance);
    }
}