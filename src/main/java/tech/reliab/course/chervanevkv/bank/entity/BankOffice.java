package tech.reliab.course.chervanevkv.bank.entity;

public class BankOffice {
    Bank bank;
    String name;
    String address;
    boolean isWorking;
    boolean isPossiblePlaceAtm;
    int atmNumber = 0;
    boolean canApplyLoan;
    boolean canPaymentOfMoney;
    boolean canDepositMoney;
    double moneyAmount;
    double rent;

    public BankOffice() {}

    public BankOffice(Bank bank, String name, String address, boolean isWorking,
                      boolean isPossiblePlaceAtm, int atmNumber, boolean canApplyLoan,
                      boolean canPaymentOfMoney, boolean canDepositMoney, double moneyAmount,
                      double rent) {
        this.bank = bank;
        this.name = name;
        this.address = address;
        this.isWorking = isWorking;
        this.isPossiblePlaceAtm = isPossiblePlaceAtm;
        this.atmNumber = atmNumber;
        this.canApplyLoan = canApplyLoan;
        this.canPaymentOfMoney = canPaymentOfMoney;
        this.canDepositMoney = canDepositMoney;
        this.moneyAmount = moneyAmount;
        this.rent = rent;
    }

    public BankOffice(BankOffice bankOffice) {
        this.bank = bankOffice.getBank();
        this.name = bankOffice.getName();
        this.address = bankOffice.getAddress();
        this.isWorking = bankOffice.isWorking();
        this.isPossiblePlaceAtm = bankOffice.isPossiblePlaceAtm();
        this.atmNumber = bankOffice.getAtmNumber();
        this.canApplyLoan = bankOffice.isCanApplyLoan();
        this.canPaymentOfMoney = bankOffice.isCanPaymentOfMoney();
        this.canDepositMoney = bankOffice.isCanDepositMoney();
        this.moneyAmount = bankOffice.getMoneyAmount();
        this.rent = bankOffice.getRent();
    }

    public Bank getBank() {
        return bank;
    }

    public void setId(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isPossiblePlaceAtm() {
        return isPossiblePlaceAtm;
    }

    public void setPossiblePlaceAtm(boolean possiblePlaceAtm) {
        isPossiblePlaceAtm = possiblePlaceAtm;
    }

    public int getAtmNumber() {
        return atmNumber;
    }

    public void setAtmNumber(int atmNumber) {
        this.atmNumber = atmNumber;
    }

    public boolean isCanApplyLoan() {
        return canApplyLoan;
    }

    public void setCanApplyLoan(boolean canApplyLoan) {
        this.canApplyLoan = canApplyLoan;
    }

    public boolean isCanPaymentOfMoney() {
        return canPaymentOfMoney;
    }

    public void setCanPaymentOfMoney(boolean canPaymentOfMoney) {
        this.canPaymentOfMoney = canPaymentOfMoney;
    }

    public boolean isCanDepositMoney() {
        return canDepositMoney;
    }

    public void setCanDepositMoney(boolean canDepositMoney) {
        this.canDepositMoney = canDepositMoney;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "bank_id=" + bank.getId() +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", isWorking=" + isWorking +
                ", isPossiblePlaceAtm=" + isPossiblePlaceAtm +
                ", atmNumber=" + atmNumber +
                ", canApplyLoan=" + canApplyLoan +
                ", canPaymentOfMoney=" + canPaymentOfMoney +
                ", canDepositMoney=" + canDepositMoney +
                ", moneyAmount=" + moneyAmount +
                ", rent=" + rent +
                '}';
    }
}
