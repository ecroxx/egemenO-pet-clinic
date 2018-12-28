package com.example.egemenOpetclinic;

//import org.junit.Test;      --  JUNIT 4 ANNOTATION

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import org.junit.runner.RunWith;  --  JUNIT 4 ANNOTATION
//import org.springframework.test.context.junit4.SpringRunner;  --  JUNIT 4 ANNOTATION

@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)   --  JUNIT 4 ANNOTATION
@SpringBootTest
public class Egemen0PetClinicApplicationTests {

    @Test
    public void contextLoads() {
    }

}
