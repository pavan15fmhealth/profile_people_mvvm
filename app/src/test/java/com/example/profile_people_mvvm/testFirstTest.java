package com.example.profile_people_mvvm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.hamcrest.MatcherAssert.*;
import static com.google.common.truth.Truth.assertThat;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class testFirstTest {

    @Test
    public void validateTheInput(){
        String str = "Name";
        testFirst testfirst = new testFirst();

        boolean res = testfirst.validate(str);

        assertThat(res).isEqualTo(true);

    }

    @Test
    public void validateInput(){
        String str = "NA@me";
        testFirst testfirst = new testFirst();

        boolean res = testfirst.validate(str);

        assertThat(res).isEqualTo(false);

    }


}