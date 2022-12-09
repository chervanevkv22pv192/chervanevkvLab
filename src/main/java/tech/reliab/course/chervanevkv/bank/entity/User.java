package tech.reliab.course.chervanevkv.bank.entity;

import tech.reliab.course.chervanevkv.bank.entity.parentClasses.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    String job;
    double salary;
    Bank bank;
    List<CreditAccount> creditAccount;
    List<PaymentAccount> paymentAccount;
    double creditRating;

    public User(Long id, String firstName, String lastName, LocalDate birthDate, String job, double salary, Bank bank, List<CreditAccount> creditAccs, List<PaymentAccount> payAccs, double creditRating) {
        super(id, firstName, lastName, birthDate);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditAccount = new ArrayList<>();
        this.paymentAccount = new ArrayList<>();
        this.creditRating = creditRating;
    }

    public User(Long id, String firstName, String lastName, LocalDate birthDate, String job,
                double salary, Bank bank, CreditAccount creditAccount,
                PaymentAccount paymentAccount, double creditRating) {
        super(id, firstName, lastName, birthDate);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditAccount = new ArrayList<>();
        this.paymentAccount = new ArrayList<>();
        this.creditRating = creditRating;
    }

    public User(Long id, String firstName, String lastName, String patronymic, LocalDate birthDate, String job,
                double salary, Bank bank, CreditAccount creditAccount,
                PaymentAccount paymentAccount, double creditRating) {
        super(id, firstName, lastName, patronymic, birthDate);
        this.job = job;
        this.salary = salary;
        this.bank = bank;
        this.creditAccount = new ArrayList<>();
        this.paymentAccount = new ArrayList<>();
        this.creditRating = creditRating;
    }

    public User(User user) {
        super.setId(user.getId());
        super.setFirstName(user.getFirstName());
        super.setLastName(user.getLastName());
        super.setPatronymic(user.getPatronymic());
        super.setBirthDate(user.getBirthDate());
        this.job = user.getJob();
        this.salary = user.getSalary();
        this.bank = user.getBank();
        this.creditAccount = user.getCreditAccount();
        this.paymentAccount = user.getPaymentAccount();
        this.creditRating = user.getCreditRating();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<CreditAccount> getCreditAccount() {
        return creditAccount;
    }
    public void setCreditAccount(CreditAccount creditAccount) {
        if(this.creditAccount==null)
            this.creditAccount = new ArrayList<>();
        this.creditAccount.add(creditAccount);
    }
    public List<PaymentAccount> getPaymentAccount() {
        return paymentAccount;
    }
    public void setPaymentAccount(PaymentAccount paymentAccount) {
        if(this.paymentAccount==null)
            this.paymentAccount = new ArrayList<>();
        this.paymentAccount.add(paymentAccount);
    }

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        String credits = "";
        String payments = "";
        for(var c: this.creditAccount){
            credits+=c.getId()+" ";
        }
        for(var p: this.paymentAccount){
            payments+=p.getId()+" ";
        }
        return "User{" +
                "id=" + super.getId() +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", bank_id=" + bank.getId() +
                ", creditAccountId=" + credits +
                ", paymentAccountId=" + payments +
                ", creditRating=" + creditRating +
                '}';
    }
}
