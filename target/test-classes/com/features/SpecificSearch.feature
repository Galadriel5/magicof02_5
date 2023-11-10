Feature: Test cases on searching products via searchbox

Scenario: To search for items by using searchbox
Given ഇനത്തിനായി തിരയുക
Then verify ശരിയായ ഇനങ്ങൾ

Scenario: Invalid product or category name in the product category textbox must not be accepted
Given അസാധുവാണ് Product അഥവാ Category

@Integration
Scenario: To check if whatsapp link is working
Given ചെക്ക് whatsapp
Then Whatsapp പേജ് തുറക്കുക

Scenario: Get screenshot
Given Plant Care