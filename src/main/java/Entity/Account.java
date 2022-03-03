package Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    private String id;
    private String name, cardId, branchName, branchId;
    private String status;
    private long amount;

    public Account(String id, long amount) {
        this.id = id;
        this.amount = amount;
    }



    public void blockAccunt() {
        this.status = "Block";
    }

    public void active() {
        this.status = "Active";
    }
}
