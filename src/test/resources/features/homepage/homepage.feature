Feature: Check homepage features

    Scenario: Open AI Chat
        Given Hans is on the homepage
        When he opens the AI Chat
        Then he is on the "AI" page

    Scenario: Set default search engine to DuckDuckGo
        Given Hans is on the homepage
        When he sets DuckDuckGo as his default search engine
        Then he should see instructions on how to do this

    Scenario: Download the browser
        Given Hans is on the homepage
        When he downloads the browser
        Then he is on the "download" page
