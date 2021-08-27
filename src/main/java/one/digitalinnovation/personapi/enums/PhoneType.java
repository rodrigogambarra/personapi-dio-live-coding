package one.digitalinnovation.personapi.enums;

import lombok.Getter;

@Getter
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private String description;

    PhoneType(String description){
        this.description = description;
    }

}
