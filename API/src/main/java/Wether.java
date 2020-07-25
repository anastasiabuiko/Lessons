
public class Wether {
    public static void initialize(@NonNull String apiKey, @Unit.Units String unit) {
        //noinspection ConstantConditions
        if (apiKey == null) throw new InvalidApiKeyException();

        sApiKey = apiKey;
        sUnit = unit;

        if (!Unit.isValidUnit(sUnit)) sUnit = Unit.STANDARD;
    }

    @NonNull
    static String getApiKey() {
        return sApiKey;
    }

    @NonNull
    @Unit.Units
    static String getUnit() {
        return sUnit;
    }

    private static void checkInitializeOrThrow() {
        //noinspection ConstantConditions
        if (sApiKey == null) throw new NotInitilizedException();
    }
}
