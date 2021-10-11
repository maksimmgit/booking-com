package com.booking.api;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ImagesCommentsTest {
    private final String url = "https://api.imgur.com/3/";
    private final String imagesUploadUri = "image";
    private final String imagesGetUri = "account/me/images";

    String galleryId = "SmvdfMO";
    //private final String imagesComment = String.format("gallery/%s/comment", galleryId);
    private final String imagesComment = "gallery/SmvdfMO/comment/";
    private final String imageGalleryVotes = String.format("gallery/%s/votes", galleryId);


    private Map<String, String> respObj = new HashMap<>();




    @When("^I am sending a get request to see my images response code is (\\d+)$")
    public void iAmSendingAGetRequestToSeeMyImagesResponceCodeIs(int expect) {
        Map<String, String> respObj = given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer 73903254e2c762cca2bf402579c3ebb5a73c522d")
                .when()
                .get(url+imagesGetUri)
                .then()
                .assertThat()
                .statusCode(expect)
                .extract()
                .jsonPath()
                .get();

        System.out.println(respObj.get("link"));
    }

    @When("^I am sending a post request to upload image response code is (\\d+)$")
    public void iAmSendingAPostRequestResponceCodeIs(int expected) {
        //Map<String, String> respObj = given()
        respObj = given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer 73903254e2c762cca2bf402579c3ebb5a73c522d")
                .body("R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7")
                .log()
                .body()
                .when()
                .post(url+imagesUploadUri)
                .then()
                .log()
                .body()
                .assertThat()
                .statusCode(expected)
                .extract()
                .jsonPath()
                .getMap("data");
        System.out.println(respObj.get("id"));

    }


    @And("^posting a comment to the uploaded image\\. response code is (\\d+)$")
    public void postingACommentToTheUploadedImage(int expected) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("image_id","SmvdfMO");
        requestParams.put("comment","hey ho3");
        respObj = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 73903254e2c762cca2bf402579c3ebb5a73c522d")
                .header("Content-Type","multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .body(requestParams.toJSONString())
                .contentType(ContentType.JSON)
                .log()
                .headers()
                .log()
                .body()
                .when()
                .post(url+imagesComment)
                .then()
                .log()
                .body()
                .assertThat()
                .statusCode(expected)
                .extract()
                .jsonPath()
                .get();

    }

    @Then("i can get gallery votes")
    public void iCanGetGalleryVotes() {
        Map<String, Integer> respObj = given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer 73903254e2c762cca2bf402579c3ebb5a73c522d")
                .when()
                .get(url+imageGalleryVotes)
                .then()
                .log()
                .body()
                .extract()
                .jsonPath()
                .getMap("data");
        System.out.println("Upvotes: " + respObj.get("ups"));
        System.out.println("Downvotes: " + respObj.get("downs"));
    }


}
