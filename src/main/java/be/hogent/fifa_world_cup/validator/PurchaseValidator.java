package be.hogent.fifa_world_cup.validator;

import be.hogent.fifa_world_cup.validation.Purchase;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PurchaseValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Purchase.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Purchase purchase = (Purchase) target;

        try {
            int code1 = purchase.getVoetbalCode_1();
            int code2 = purchase.getVoetbalCode_2();

            if (code1 > code2) {
                errors.rejectValue("voetbalCode_1", "lengthOfCode.purchase.voetbalCode_1",
                        "voetbalCode1 moet kleiner zijn dan voetbalCode_2");
            }
        }catch(NullPointerException e) {

            //handle this by the purchase class
        }
    }
}
