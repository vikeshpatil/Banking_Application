import java.math.BigDecimal;

public class Account {
    private String name;
    private String code;
    private BigDecimal balance;

    public Account(String name, String code) {
        this.name = name;
        this.code = code;
        this.balance = new BigDecimal("0");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        this.balance = amount;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("0")) > 0) {
            this.balance = this.balance.add(amount);
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("0")) > 0) {
            this.balance = this.balance.subtract(amount);
        }
    }

}
