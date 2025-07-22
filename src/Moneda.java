import com.google.gson.annotations.SerializedName;

public class Moneda {
    @SerializedName("USD")
    private double USD;
    @SerializedName("ARS")
    private double ARS;
    @SerializedName("BRL")
    private double BRL;
    @SerializedName("COP")
    private double COP;

    public double getUSD() {
        return USD;
    }

    public double getARS() {
        return ARS;
    }

    public double getBRL() {
        return BRL;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "USD=" + USD +
                ", ARS=" + ARS +
                ", BRL=" + BRL +
                ", COP=" + COP +
                '}';
    }

    public double getCOP() {
        return COP;
    }
}
