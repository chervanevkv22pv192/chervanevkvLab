package tech.reliab.course.chervanevkv.bank.entity;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tech.reliab.course.chervanevkv.bank.entity.parentClasses.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    String job;
    double salary;
    List<Bank> banks = new ArrayList<>();
    List<CreditAccount> creditAccounts = new ArrayList<>();
    List<PaymentAccount> paymentAccounts = new ArrayList<>();
    double creditRating;

    public User() {}

    public User(Long id, String firstName, String lastName, LocalDate birthDate, String job,
                double salary, double creditRating) {
        super(id, firstName, lastName, birthDate);
        this.job = job;
        this.salary = salary;
        this.creditRating = creditRating;
    }

    public User(Long id, String firstName, String lastName, String patronymic, LocalDate birthDate, String job,
                double salary, double creditRating) {
        super(id, firstName, lastName, patronymic, birthDate);
        this.job = job;
        this.salary = salary;
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
        this.banks = user.getBanks();
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

    public List<Bank> getBanks() {
        return banks;
    }

    public void addBank(Bank bank) {
        this.banks.add(bank);
    }

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(List<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public List<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", fullName='" + super.getFullName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", banks=" + banks.stream().map(Bank::getName).toList() +
                ", creditRating=" + creditRating +
                '}';
    }
    public JSONArray getPayAccsAsJSONArray(String bankName){
        JSONArray resultArray = new JSONArray();
        for (var acc:
                paymentAccounts) {
            if(acc.getBank().getName().equals(bankName)){
                JSONObject details = new JSONObject();
                JSONObject result = new JSONObject();
                details.put("id", acc.id);
                details.put("user", "user");
                details.put("bank", acc.getBank().getName());
                details.put("sum", acc.sum);
                result.put("payAcc", details);
                resultArray.add(result);
            }

        }
        return resultArray;
    }
    public JSONArray getCreditAccsAsJSONArray(String bankName){
        JSONArray resultArray = new JSONArray();
        for (var acc:
                creditAccounts) {
            if(acc.getBankName().equals(bankName)){
                JSONObject details = new JSONObject();
                JSONObject result = new JSONObject();
                details.put("id", acc.id);
                details.put("user", "user");
                details.put("bank", acc.getBankName());
                details.put("start", acc.start.toString());
                details.put("end", acc.end.toString());
                details.put("monthNumber", acc.monthNumber);
                details.put("sum", acc.sum);
                details.put("monthPayment",acc.monthPayment);
                details.put("interestRate",acc.interestRate);
                details.put("employeeId",acc.employee.getId());
                details.put("paymentAccountId", acc.paymentAccount.getId());
                result.put("creditAcc", details);
                resultArray.add(result);
            }

        }
        return resultArray;
    }
}