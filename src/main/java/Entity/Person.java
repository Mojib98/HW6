package Entity;

abstract public class Person {
    private String fullName;
   private String nationalId;
   private String branchName;

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalId() {
        return nationalId;
    }



    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Person(String fullName, String nationalId, String branchName) {
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.branchName = branchName;
    }
}
