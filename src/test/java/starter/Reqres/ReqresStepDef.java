package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario1
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponse.PAGE,equalTo(page));
    }

    @And("Validate user json schema validator")
    public void validateUserJsonSchemaValidator()  {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/CreateUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME,equalTo(name))
                .body(ReqresResponse.JOB,equalTo(job));
    }

    //Scenario3
    @Given("Put update user with valid json {int}")
    public void putUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //Scenario4
    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} no content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    //Tugas Get Single User
    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body page single user should be {int}")
    public void responseBodyPageSingleUserShouldBeId(int id) {
        SerenityRest.then().body(ReqresResponse.DATA_ID,equalTo(id));
    }

    @And("Validate single user json schema validator")
    public void validateSingleUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas Get Single User invalid id/not found
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
    @And("Validate unknown user json schema validator")
    public void validateUnknownUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/SingleUserNotfoundSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas Post Register successful
    @Given("Post register with valid json")
    public void postRegisterWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterSuccess.json");
        reqresAPI.postRegisterSuccess(json);
    }
    @When("Send post register request")
    public void sendPostRegisterRequest() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESS);
    }

    @Then("Status code should be {int} Success")
    public void statusCodeShouldBeSuccess(int success) {
        SerenityRest.then().statusCode(success);
    }

    @And("Response body should by token {string}")
    public void responseBodyShouldByToken(String token) {
        SerenityRest.then().body(ReqresResponse.TOKEN,equalTo(token));
    }

    @And("Validate register success json schema validator")
    public void validateRegisterSuccessJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostRegisterSuccessSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas Post Login Unsuccessful
    @Given("Post login with valid json")
    public void postLoginWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/LoginUnsuccess.json");
        reqresAPI.postLoginUnsuccess(json);
    }

    @When("Send post login request")
    public void sendPostLoginRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_UNSUCCESS);
    }

    @Then("Status code should be {int} Unsuccessful")
    public void statusCodeShouldBeUnsuccessful(int unsuccess) {
        SerenityRest.then().statusCode(unsuccess);
    }

    @And("Response body should by error {string}")
    public void responseBodyShouldByEror(String error) {
        SerenityRest.then().body(ReqresResponse.ERROR,equalTo(error));
    }
    @And("Validate login user unsuccessful json schema validator")
    public void validateLoginUserUnsuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginUnsuccessSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas Post
    @Given("Post task create user with valid json")
    public void postTaskCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PostUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @And("Validate post task json schema validator")
    public void validatePostTaskJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas PUT
    @Given("Task put update user with valid json {int}")
    public void taskPutUpdateUserWithValidJsonId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @And("Validate task put json schema validator")
    public void validateTaskPutJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PutUpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas Delete
    @Given("Task delete user with id {int}")
    public void taskDeleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send task delete user request")
    public void sendTasDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
}
