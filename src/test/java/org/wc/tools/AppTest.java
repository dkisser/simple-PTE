package org.wc.tools;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wc.tools.simplepte.SimplePteConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        assertTrue( true );
    }

    @Test
    public void SmartInstationAwareTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimplePteConfiguration.class);
        context.getEnvironment();
    }

    @Test
    public void streamTest(){
        int[] arr = new int[]{1,2,3,4,5};
        Arrays.stream(arr).map(x -> Integer.sum(x,1)).forEach(System.out::print);
    }
}
