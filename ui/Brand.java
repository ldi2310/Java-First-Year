package GiaoDien;

public class Brand {
    private String brandID;
    private String brandNAME;

    public Brand(String brandID, String brandNAME) {
        this.brandID = brandID;
        this.brandNAME = brandNAME;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandNAME() {
        return brandNAME;
    }

    public void setBrandNAME(String brandNAME) {
        this.brandNAME = brandNAME;
    }
}
