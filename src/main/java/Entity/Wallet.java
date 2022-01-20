package Entity;

public class Wallet {
    private String id;
    private int amont;

    public Wallet(String id, int amont) {
        this.id = id;
        this.amont = amont;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmont() {
        return amont;
    }

    public void setAmont(int amont) {
        this.amont = amont;
    }
}
