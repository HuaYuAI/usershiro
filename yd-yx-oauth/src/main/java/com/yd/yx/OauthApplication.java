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

// 直接获取token
// curl -X POST "localhost:1113/oauth/token" --header "Authorization":"Basic dGVzdDE6dGVzdDExMTE=" -d "grant_type=password&username=123&password=123&client_id=test1&scope=all"
//{
//    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTg4MzEwNzgsInVzZXJfbmFtZSI6IjEyMyIsImp0aSI6IjRlZWE3OTdiLTg3MzUtNDkwMC04MDUyLTJiZGMxMjlkYmE1MSIsImNsaWVudF9pZCI6InRlc3QxIiwic2NvcGUiOlsiYWxsIl19.S6NNPl-eX2o0m3Ra8vmG1ejTbQvKAz0WN6p7PLUrwY8",
//    "token_type": "bearer",
//    "expires_in": 3599,
//    "scope": "all",
//    "jti": "4eea797b-8735-4900-8052-2bdc129dba51"
//}
// curl -X POST "localhost:1113/oauth/token" --header "Authorization":"Basic dGVzdDE6dGVzdDExMTE=" -d "grant_type=refresh_token&refresh_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTk2OTM5NzAsInVzZXJfbmFtZSI6IjEyMyIsImp0aSI6Ijg4YzQ4MzY5LTA0NzEtNDE1NS04MWJlLTZlZTljZjhjNTI0ZSIsImNsaWVudF9pZCI6InRlc3QxIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6ImRiODBlN2U5LTRkZGMtNGRkNC04NjlmLWEwMzU0NmViMzBhZSJ9.ZVPv75AoQRurj_jEpAvGF1ipKMfNgMCxFZpGTfQ21AY"
}
