package GiaoDien;

public class Size {
    private String sizeID;
    private String clothesID;
    private int sizeQUANTITY;

    public Size(String sizeID, String clothesID, int sizeQUANTITY) {
        this.sizeID = sizeID;
        this.clothesID = clothesID;
        this.sizeQUANTITY = sizeQUANTITY;
    }

    public String getSizeID() {
        return sizeID;
    }

    public void setSizeID(String sizeID) {
        this.sizeID = sizeID;
    }

    public String getClothesID() {
        return clothesID;
    }

    public void setClothesID(String clothesID) {
        this.clothesID = clothesID;
    }

    public int getSizeQUANTITY() {
        return sizeQUANTITY;
    }

    public void setSizeQUANTITY(int sizeQUANTITY) {
        this.sizeQUANTITY = sizeQUANTITY;
    }
}
