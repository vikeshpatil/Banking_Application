import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Bank {
    private final ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String name, String code) {
        if (isCodeValid(code) && isNameValid(name)) {
            if (!isAccountExist(code)) {
                accounts.add(new Account(name, code));
            } else {
                System.out.println("Account with code " + code + " already exists!");
            }
        } else {
            System.out.println("Invalid name or code entered!");
        }
    }

    private boolean isAccountExist(String code) {
        for (Account acc : accounts) {
            if (acc.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void depositAmount(String code, String inputAmount) {
        try {
            BigDecimal amountToDeposit = new BigDecimal(inputAmount);
            if (amountToDeposit.compareTo(new BigDecimal("0")) < 0) {  //check if entered number is negative
                throw new NegativeNumberException("Please enter valid amount!");
            } else {
                if (isAccountExist(code)) {
                    for (Account acc : accounts) {
                        if (acc.getCode().equalsIgnoreCase(code)) {
                            acc.deposit(amountToDeposit);
                        }
                    }
                } else {
                    throw new UnknownAccountException("User with code " + code + " doesn't exist!");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid amount entered!");
        } catch (NegativeNumberException | UnknownAccountException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawAmount(String code, String inputAmount) {
        try {
            BigDecimal amountToWithdraw = new BigDecimal(inputAmount);
            if (amountToWithdraw.compareTo(new BigDecimal("0")) < 0) {  //check if entered number is negative
                throw new NegativeNumberException("Please enter valid amount!");
            } else {
                if (isAccountExist(code)) {
                    for (Account acc : accounts) {
                        if (acc.getCode().equalsIgnoreCase(code)) {
                            if (amountToWithdraw.compareTo(acc.getBalance()) > 0) {
                                throw new NotEnoughFundException("You don't have enough funds!");
                            } else {
                                acc.withdraw(amountToWithdraw);
                            }
                        }
                    }
                } else {
                    throw new UnknownAccountException("User with entered code " + code + " doesn't exist!");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid amount entered!");
        } catch (NegativeNumberException | UnknownAccountException | NotEnoughFundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void balance(String code) {
        try {
            if (isAccountExist(code)) {
                for (Account acc : accounts) {
                    if (acc.getCode().equalsIgnoreCase(code)) {
                        System.out.println(acc.getName() + " " + acc.getBalance());
                    }
                }
            } else {
                throw new UnknownAccountException("User with entered code " + code + " doesn't exist!");
            }
        } catch (UnknownAccountException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isCodeValid(String code) {
        String pattern = "^[A-Za-z\\d]+$";
        if (Pattern.matches(pattern, code)) {
            return true;
        }
        return false;
    }


    private boolean isNameValid(String name) {
        String pattern = "^[A-Za-z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        if (Pattern.matches(pattern, name)) {
            return true;
        }
        return false;
    }

    private class UnknownAccountException extends RuntimeException {
        public UnknownAccountException(String message) {
            super(message);
        }
    }

    private class NegativeNumberException extends RuntimeException {
        public NegativeNumberException(String message) {
            super(message);
        }
    }

    private class NotEnoughFundException extends RuntimeException {
        public NotEnoughFundException(String message) {
            super(message);
        }
    }
}