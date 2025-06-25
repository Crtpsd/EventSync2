package com.utilpartylist.eventsync;

import java.util.ArrayList;
import java.util.HashMap;

public class Authentication {
    private static String email,password;

    public static ArrayList<HashMap<String,Object>> Users = new ArrayList<>();

    public static void createUser (String email,String password){
        {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("email",email);
            hashMap.put("password",password);

        }
    }

    public static void loginUser (String user, String password){

    }



    public static boolean isLogged (){
        if (email.equals(null)){
            return false;
        } if (password.equals(null)) {
            return false;
        } else {
            return true;
        }
    }
}