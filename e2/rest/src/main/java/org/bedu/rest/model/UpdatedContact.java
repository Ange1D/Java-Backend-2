package org.bedu.rest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdatedContact {

    @NotBlank
    @Size(min=8, max = 10)
    private String number;

    public UpdatedContact(){}

    public UpdatedContact(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
