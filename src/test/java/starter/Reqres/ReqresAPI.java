package starter.Reqres;

import io.restassured.http.ContentType;
import jdk.internal.dynalink.beans.StaticClass;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/features/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/features/JSON/Schema";

    public static String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String POST_REGISTER_SUCCESS = URL+"/api/register";
    public static String POST_LOGIN_UNSUCCESS = URL+"/api/login";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";



    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post Create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post register success")
    public void postRegisterSuccess(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login unsuccessful")
    public void postLoginUnsuccess(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Task update user")
    public void taskUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}