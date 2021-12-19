import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
    JSONObject request = new JSONObject();

    @Test
    public void test_getAllFavSingers(){

        baseURI="http://localhost:3000/";
        given().
                get("/singers").
                then().
                statusCode(200).
                log().all();
    }
    @Test
    public void test_getSpecificSinger(){

        baseURI="http://localhost:3000/";
        given().queryParam("lastName","Ellis")
                .when()
                .get("/Singers")
                .then()
                .statusCode(200)
                .log().all().
                time(lessThan(5000L));
    }
    @Test
    public void test_getSpecificSingerWithSong(){

        baseURI="http://localhost:3000/";
        given().queryParam("songName","Wicked Game").
                when().get("/songs")
                .then()
                .statusCode(200)
                .log().all().
                time(lessThan(5000L));
    }


    @Test
    public void test_postNewFavSinger(){
        baseURI="http://localhost:3000/";


        request.put("firstName","Henning");
        request.put("lastName","Mey");
        request.put("subjectID",1);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
        when().
                post("/singers").
        then().
                statusCode(201).log().all();


        request.put("firstName","Lil");
        request.put("lastName","Nas");
        request.put("subjectID",2);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
        when().
                post("/singers").
        then().
                statusCode(201).log().all();

        request.put("firstName","Tom");
        request.put("lastName","Ellis");
        request.put("subjectID",2);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
        when().
                post("/singers").
        then().
                statusCode(201).log().all();

        request.put("firstName","Harun");
        request.put("lastName","Tekin");
        request.put("subjectID",4);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("/singers").
                then().
                statusCode(201).log().all();
    }
    @Test
    public void test_deletingSinger(){
        baseURI="http://localhost:3000/";
        when().
                delete("singers/5").
        then().
                statusCode(200);
    }


    @Test
    public void test_updatingDetails(){

        request.put("lastName","Wayne");
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
        when().
                patch("/singers/6").
        then().
                statusCode(200).log().all();
    }
    @Test
    public void test_changeSinger() {
        baseURI = "http://localhost:3000/";

        request.put("firstName", "Ebru");
        request.put("lastName", "Gundes");
        request.put("subjectID", 1);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                put("/singers/3").
        then().
                statusCode(200).log().all();
    }
}

