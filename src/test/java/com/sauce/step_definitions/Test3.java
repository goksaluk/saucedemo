package com.sauce.step_definitions;

import com.sauce.utilities.ConfigurationReadar;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test3 {
    Response response;
    RequestSpecification request;
    JsonPath jsonPath;

//    @BeforeAll
//    public static void setUp(){
//        RestAssured.baseURI="https://api.publicapis.org/entries";
//    }
@BeforeAll
public static void setUp(){
    RestAssured.baseURI = "http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr";
}

    @Test
    public void test1(){
       // Response response=
        response=given().
                contentType(ContentType.JSON).   /// telling the api what kind of data format i am sending
                accept(ContentType.JSON).       /// telling the api what kind of data format i want in return
                when().get("https://api.publicapis.org/entries").prettyPeek();

          response.then().statusCode(200).
                //body("entries.Description[1]",equalTo("Collection of axolotl pictures and facts"));
                assertThat().body("entries.Description[1]",equalTo("Collection of axolotl pictures and facts")).header("Transfer-Encoding","chunked").
                  and().assertThat().header("Server", "Caddy").
                  and().body("entries.Category[0]", equalTo("Animals"));
                        //assertThat().header("X-Rate-Limit-Duration",1);
    }

    @Test
    public void test2(){
        jsonPath = given().accept(ContentType.JSON).
                when().get("https://api.publicapis.org/entries").jsonPath();

        assertThat(jsonPath.getString("entries.Category[0]"), is("Animals"));
        //assertThat(jsonPath.);

        List<String> list = jsonPath.getList("entries.Category");
        System.out.println("list = " + list.size());

        Map<String, String > Map = jsonPath.getMap("entries[0]");

        List<Map<String, String >> listMap = jsonPath.getList("entries");

        System.out.println("listMap = " + listMap);

    }

    @Test
    public void test3(){
        response = given().contentType(ContentType.JSON).when().get(",,...").prettyPeek();
        response.then().statusCode(200);

        jsonPath = response.jsonPath();

        String link = jsonPath.getString("uuu");

        assertThat(jsonPath.getString("mm.lii"), is("ttttt") );
        assertThat(jsonPath.getInt("wwee.kyyy"), equalTo(20));
        //assertThat(sta);

    }

    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa3.vytrack.com/user/login");
    }

    @Test
    public void withKey(){
        given().
                queryParam("apikey", "e0484f01").
                queryParam("t", "Goonies").
                when().get("http://www.omdbapi.com").
                prettyPeek().
                then().statusCode(200).
                body("Title", equalTo("The Goonies")).
                body("Year", equalTo("1985"));
    }

    @Test
    public void challenged(){
        given().
                auth().
                basic("admin", "admin").
                when().
                get("https://the-internet.herokuapp.com/basic_auth").
                then().
                statusCode(200);
    }

    @Test
    public void testAccessToken(){
        // team_member_email
        String email = ConfigurationReadar.get("team_member_email");
        String password = ConfigurationReadar.get("team_member_password");

        Response response = given().log().everything().
                queryParam("email", email).
                queryParam("password", password).
                when().get("/sign");
        String accessToken = response.path("accessToken");




        response. prettyPeek().
                then().statusCode(200);

        System.out.println("accessToken = " + accessToken);

        // eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxOTc0IiwiYXVkIjoic3R1ZGVudC10ZWFtLW1lbWJlciJ9.raPyuRcS8xM5eOhEW4qxepwbs9XHPjlV4Xo8CIPxaPs !!!!!!!!!!!! Asagidaki teste konuyor.....
    }

    @Test
    public void getAllCampuses(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxOTc0IiwiYXVkIjoic3R1ZGVudC10ZWFtLW1lbWJlciJ9.raPyuRcS8xM5eOhEW4qxepwbs9XHPjlV4Xo8CIPxaPs";
        given().
                header("Authorization", token).
                when().
                get("/api/campuses").
                prettyPeek().
                then().
                statusCode(200);
    }


}
