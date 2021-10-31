package one.digitalinnovation.crudDIO.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    NOME("home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
