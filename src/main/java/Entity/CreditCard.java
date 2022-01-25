package Entity;

public class CreditCard {
    private String name;
    private String serialCarl;
    private String accountId;
    private String cvv2;
    private String password;
    private String status;

    public CreditCard(String serialCarl, String cvv2, String password, String sate) {
        this.serialCarl = serialCarl;
        this.cvv2 = cvv2;
        this.password = password;
        this.sate = sate;
    }

    private String sate;

    public CreditCard(String name, String serialCarl, String accountId, String cvv2, String password,String statud) {
        this.name = name;
        this.serialCarl = serialCarl;
        this.accountId = accountId;
        this.cvv2 = cvv2;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialCarl() {
        return serialCarl;
    }

    public void setSerialCarl(String serialCarl) {
        this.serialCarl = serialCarl;
    }

    public CreditCard(String accountId, String cvv2, String status) {
        this.accountId = accountId;
        this.cvv2 = cvv2;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
