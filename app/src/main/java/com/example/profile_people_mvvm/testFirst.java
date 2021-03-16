package com.example.profile_people_mvvm;

public class testFirst {

    public boolean validate(String str){
        boolean a;
        if(str.contains("@"))
        {
            a = false;
        }
        else{
            a = true;
        }
        return a;
    }
}
