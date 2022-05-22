package be.hogent.fifa_world_cup.validation;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class Purchase {

    @Email(message = "{validation.email.notValid}")
    @NotEmpty(message = "{validation.email.NotEmpty}")
    private String email;

    /*
    @Min(value =, message = "{validation.amount_tickets.range}")
    @Max(value = 25, message = "{validation.amount_tickets.range}")

     */
    @Range(min = 1, max=25, message = "{validation.amount_tickets.range}")
    @NotNull(message = "{validation.amount_tickets.NotNull}")
    private Integer amount_tickets;

    @NotNull(message = "{validation.voetbalCode_1.NotNull}")
    private Integer voetbalCode_1;

    @NotNull(message = "{validation.voetbalCode_2.NotNull}")
    private Integer voetbalCode_2;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAmount_tickets() {
        return amount_tickets;
    }

    public void setAmount_tickets(Integer amount_tickets) {
        this.amount_tickets = amount_tickets;
    }

    public Integer getVoetbalCode_1() {
        return voetbalCode_1;
    }

    public void setVoetbalCode_1(Integer voetbalCode_1) {
        this.voetbalCode_1 = voetbalCode_1;
    }

    public Integer getVoetbalCode_2() {
        return voetbalCode_2;
    }

    public void setVoetbalCode_2(Integer voetbalCode_2) {
        this.voetbalCode_2 = voetbalCode_2;
    }

}
