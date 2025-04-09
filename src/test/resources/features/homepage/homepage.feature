Feature: Check homepage features

    Scenario: Check DuckDuckGo logo
        Given Hans is on the homepage
        Then he should see the logo of DuckDuckGo

    Scenario: Set default search engine to DuckDuckGo
        Given Hans is on the homepage
        When he sets DuckDuckGo as his default search engine
        Then he should see instructions on how to do this
