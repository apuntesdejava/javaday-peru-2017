/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.test;

import com.apuntesdejava.bean.validation.Empleado;
import java.util.Arrays;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testMemberWithNoValues() {
        Empleado e = new Empleado();
        e.setEmail("abc@");
        e.setDni("12345678");
        e.setProyectos(Arrays.asList("Proyecto 1", "Proy2", "Proy3"));

        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Empleado>> vs = validator.validate(e);
        vs.forEach((v) -> {
            System.out.println("--->" + v.getPropertyPath() + ":" + v.getMessage());
        });//        assertTrue(vs.isEmpty());
        //assertEquals(violations.size(), 5);
    }
}
