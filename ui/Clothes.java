package GiaoDien;

public class Clothes {
    private String clothesID;
    private String clothesNAME;
    private int clothesPRICE;
    private int menuID;
    private int brandID;

    public Clothes(String clothesID,
                   String clothesNAME,
                   int clothesPRICE,
                   int menuID,
                   int brandID) {
        this.clothesID = clothesID;
        this.clothesNAME = clothesNAME;
        this.clothesPRICE = clothesPRICE;
        this.menuID = menuID;
        this.brandID = brandID;
    }

    public String getClothesID() {
        return clothesID;
    }

    public void setClothesID(String clothesID) {
        this.clothesID = clothesID;
    }

    public String getClothesNAME() {
        return clothesNAME;
    }

    public void setClothesNAME(String clothesNAME) {
        this.clothesNAME = clothesNAME;
    }

    public int getClothesPRICE() {
        return clothesPRICE;
    }

    public void setClothesPRICE(int clothesPRICE) {
        this.clothesPRICE = clothesPRICE;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
}
