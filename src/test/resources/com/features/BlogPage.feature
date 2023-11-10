Feature: Blog Page Functionality

 Scenario: Navigate to Blog Page and Perform Actions
    Given I navigate to the blog page
    When I select a blog for a tree
    Then I view all blogs
    And I check a link in the blog
    And I perform an incorrect search
    Then all assertions should pass