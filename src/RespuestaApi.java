import com.google.gson.annotations.SerializedName;

public record RespuestaApi(
        @SerializedName("conversion_rates")
        Moneda conversionRates
) {}
