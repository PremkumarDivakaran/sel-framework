package org.example.configReader;

import com.google.gson.Gson;
import org.example.pojo.LoginData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoginTestDataReader {

    public static LoginData read(){
        LoginData loginData;
        try {
            Gson gson = new Gson();
            loginData = gson.fromJson(
                    new FileReader(System.getProperty("user.dir")+"/src/test/java/org/example/json/loginTestData.json")
                    , LoginData.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loginData;
    }
}
