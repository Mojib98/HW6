package Entity;

 abstract public class Branch {
    private String nameBranch;
    private String mangenName;
    private String codeBranch;
    private int numberEmployee;

     public Branch(String nameBranch, String mangenName, String codeBranch) {
         this.nameBranch = nameBranch;
         this.mangenName = mangenName;
         this.codeBranch = codeBranch;
         this.numberEmployee = 1;
     }

     public String getNameBranch() {
         return nameBranch;
     }

     public void setNameBranch(String nameBranch) {
         this.nameBranch = nameBranch;
     }

     public String getMangenName() {
         return mangenName;
     }

     public void setMangenName(String mangenName) {
         this.mangenName = mangenName;
     }

     public String getCodeBranch() {
         return codeBranch;
     }

     public void setCodeBranch(String codeBranch) {
         this.codeBranch = codeBranch;
     }

     public int getNumberEmployee() {
         return numberEmployee;
     }
 }
