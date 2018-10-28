package example.akshat.com.inventro;

public class MartialArt {
    private  int martialArtID;
    private  String martialArtName;
    private double maritalArtPrice;
    private String martialArtColor;

    public MartialArt(int id,String name,double price,String color){
        setMartialArtID(id);
        setMartialArtName(name);
        setMaritalArtPrice(price);
        setMartialArtColor(color);
    }

    public int getMartialArtID() {
        return martialArtID;
    }

    public String getMartialArtName() {
        return martialArtName;
    }

    public double getMaritalArtPrice() {
        return maritalArtPrice;
    }

    public String getMartialArtColor() {
        return martialArtColor;
    }

    public void setMartialArtID(int martialArtID) {
        this.martialArtID = martialArtID;
    }

    public void setMartialArtName(String martialArtName) {
        this.martialArtName = martialArtName;
    }

    public void setMaritalArtPrice(double maritalArtPrice) {
        this.maritalArtPrice = maritalArtPrice;
    }

    public void setMartialArtColor(String martialArtColor) {
        this.martialArtColor = martialArtColor;
    }

    @Override
    public String toString() {
        return getMartialArtID()+" "+getMartialArtName()+" "+getMaritalArtPrice()+" "+getMartialArtColor();
    }
}
