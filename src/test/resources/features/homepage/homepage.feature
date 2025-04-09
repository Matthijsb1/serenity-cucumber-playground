Feature: Check homepage features

    Scenario: Open AI Search
        Given Hans is on the homepage
        When he opens the AI Search
        Then he is on the AI page

    Scenario: Set default search engine to DuckDuckGo
        Given Hans is on the homepage
        When he sets DuckDuckGo as his default search engine
        Then he should see instructions on how to do this

    Scenario: Download the browser
        Given Hans is on the homepage
        When he want to download the browser
        Then he is on the download page
