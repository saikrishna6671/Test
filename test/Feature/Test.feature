@search
Feature: testing google search functionality
@Test1
Scenario: Search With sample text and validate search results
Given user is on Google Home Page
When I search for "Duck"
Then I should see results with "Duck"
And I close the browser

@Test2
Scenario: Make a  get request to webservice and validate the response
Given I make a Get request to a webservice "https://jsonplaceholder.typicode.com/posts"
Then response status code is "200"
And response jsonBody contains xpath "userId[0]" equal to "1"
And response jsonBody contains xpath "id[0]" equal to "1"
And response jsonBody contains xpath "title[0]" equal to "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"


