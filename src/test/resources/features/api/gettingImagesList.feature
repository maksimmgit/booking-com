Feature: Testing api
  As a registered user i want use an Api


  Scenario: Uploading a new image
    When I am sending a get request to see my images response code is 200
    Then I am sending a post request to upload image response code is 200
    And posting a comment to the uploaded image. response code is 200

    Scenario: posting a comment
      When posting a comment to the uploaded image. response code is 200
      Then i can get gallery votes
