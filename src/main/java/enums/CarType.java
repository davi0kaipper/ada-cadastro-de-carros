package enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CarType {
    MANUAL,
    AUTOMATICO;

    public static final String a = CarType.casesString();

    public static CarType fromString(String value) {
        return switch (value) {
            case "MANUAL" -> CarType.MANUAL;
            case "AUTOMATICO" -> CarType.AUTOMATICO;
            default -> CarType.MANUAL;
        };
    }

    public static String casesString() {
        return Arrays.stream(CarType.values())
            .map(Enum::name)
            .collect(Collectors.joining("|"));
    }
}
