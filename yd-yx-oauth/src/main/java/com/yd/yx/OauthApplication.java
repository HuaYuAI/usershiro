package com.yd.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

// http://localhost:1113/oauth/authorize?response_type=code&client_id=usermessage-oauth&redirect_uri=http://localhost:1113/health&scope=all&state=hello

// http://localhost:1113/health?code=gTyM97&state=hello

// --header "Authorization":"Basic dXNlcm1lc3NhZ2Utb2F1dGg6MTIzNDU2"
// curl -X POST "localhost:1113/oauth/token" --header "Authorization":"Basic dXNlcm1lc3NhZ2Utb2F1dGg6MTIzNDU2" -d "grant_type=authorization_code&code=gTyM97&client_id=usermessage-oauth&redirect_uri=http://localhost:1113/health&scope=all"

// curl -X GET "localhost:1113/health" --header "Authorization":"Basic 23367f72-302f-4885-a3d1-4829e63e7d4a"
}
