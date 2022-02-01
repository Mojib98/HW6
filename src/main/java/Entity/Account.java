package Entity;

public class Account {
    private String name,id,cardId,branchName,branchId,status;
    private long amount;
    public Account(String id,String name,String cardId,String branchName,String branchId) {
        this.name=name;
        this.cardId =cardId;
        this.branchId=branchId;
        this.branchName = branchName;
        this.status="Active";
        this.id = id;
        this.amount = 0;
    }
    public Account() {
    }

    public Account(String id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    public void withdraw(Long amount) {
        if (amount > this.amount)
            System.out.println("Insufficient funds!");
        else
            this.amount -= amount;

    }

    public void deposit(Long amount) {
        this.amount += amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public void blockAccunt(){
        this.status = "Block";
    }
    public void active(){
        this.status = "Active";
    }
}
