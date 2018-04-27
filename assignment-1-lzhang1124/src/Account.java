public class Account {
    private Name name;
    private Amount balance;

    public Account(Name name,Amount balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return this.name.first + " " + this.name.last;
    }

    public Amount getBalance(){
        return this.balance;
    }


    //updated account after deposit
    public  Account deposit(Account acc, Amount deposit){
        Integer cent = acc.balance.getCents()+ deposit.getCents();
        Integer dollar = acc.balance.getDollars() + deposit.getDollars();

        if(cent >=100){
            cent -= 100;
            dollar++;
        }
        return new Account(acc.name, new Amount(dollar,cent));
    }

    //updated account after withdraw
    public Account withdraw(Account acc,Amount withdraw){
        Integer cent = acc.balance.getCents();
        Integer dollar = acc.balance.getDollars();
        if(cent < withdraw.getCents()){
            dollar--;
            cent += 100;
        }

        cent -= withdraw.getCents();
        dollar -= withdraw.getDollars();
        return new Account(acc.name, new Amount(dollar,cent));
    }
}
