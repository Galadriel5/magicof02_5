Feature: Test cases on product reviews

Scenario: To check review of a particular product
Given application പൂർണ്ണമായും തുറക്കുക
When ചെക്ക് review

Scenario: Correct Message must be displayed for items having no reviews
Given Marjoram Seeds
When ചെക്ക് No Review
Then ഇല്ല Review
