package dasz.model;

import dasz.constraint.Divided;

import javax.validation.constraints.Min;

public class NumberBean {

    @Divided(by = 3)
    @Min(value = 3)
    private Integer number;

    public NumberBean(@Min(value = 3) Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
