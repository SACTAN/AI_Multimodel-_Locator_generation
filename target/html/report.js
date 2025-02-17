$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/backEnd.feature");
formatter.feature({
  "name": "API",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.scenario({
  "name": "Test 1",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.step({
  "name": "Add Coins details are here",
  "rows": [
    {
      "cells": [
        "Bitcoin",
        "Tether",
        "Ethereum"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "ApiStepDef.add_Coins_details_are_here(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Retrieve the ID of bitcoin(BTC), usd tether(USDT), and Ethereum(ETH), using the \"/cryptocurrency/map\" call",
  "keyword": "When "
});
formatter.match({
  "location": "ApiStepDef.retrieve_the_ID_of_bitcoin_BTC_usd_tether_USDT_and_Ethereum_ETH_using_the_call(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Once you have retrieved the IDs of these currencies, convert them to Bolivian Boliviano, using the \"/tools/price-conversion\" call",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDef.once_you_have_retrieved_the_IDs_of_these_currencies_convert_them_to_Bolivian_Boliviano_using_the_call(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test 2",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.step({
  "name": "Retrieve the Ethereum (ID 1027) technical documentation website from the \"/cryptocurrency/info\" call",
  "keyword": "When "
});
formatter.match({
  "location": "ApiStepDef.retrieve_the_Ethereum_ID_technical_documentation_website_from_the_call(Integer,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirm that the following logo URL is present: \"https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDef.confirm_that_the_following_logo_URL_is_present(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirm that the technical_doc URl is present: \"[https://github.com/ethereum/wiki/wiki/White-Paper]\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDef.confirm_that_the_technical_doc_URl_is_present(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirm that the symbol of the currency is ETH: \"ETH\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDef.confirm_that_the_symbol_of_the_currency_is_ETH(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirm that the date added is: \"2015-08-07T00:00:00.000Z\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDef.confirm_that_the_date_added_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirm that the platform is null: \"null\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDef.confirmThatThePlatformIsNull(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirm that the currency has the mineable tag associated with it: \"mineable\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApiStepDef.confirm_that_the_currency_has_the_mineable_tag_associated_with_it(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test 3",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.step({
  "name": "Add Coins details are here 10 \"/cryptocurrency/info\"",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiStepDef.add_Coins_details_are_here(Integer,String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat io.restassured.path.json.JsonPath.getInt(JsonPath.java:245)\n\tat stepdef.api.ApiStepDef.add_Coins_details_are_here(ApiStepDef.java:113)\n\tat ✽.Add Coins details are here 10 \"/cryptocurrency/info\"(features/backEnd.feature:20)\n",
  "status": "failed"
});
formatter.step({
  "name": "Check which currencies have the mineable tag associated with them \"/cryptocurrency/info\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApiStepDef.check_which_currencies_have_the_mineable_tag_associated_with_them(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify that the correct cryptocurrencies have been printed out",
  "rows": [
    {
      "cells": [
        "Bitcoin",
        "Litecoin",
        "Namecoin",
        "Terracoin",
        "Peercoin",
        "Novacoin",
        "Devcoin",
        "Feathercoin",
        "Mincoin",
        "Freicoin"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ApiStepDef.verify_that_the_correct_cryptocurrencies_have_been_printed_out(String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("features/frontEnd.feature");
formatter.feature({
  "name": "Frontend Task",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Ui"
    }
  ]
});
formatter.scenario({
  "name": "Test 1",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Ui"
    }
  ]
});
formatter.step({
  "name": "Open Browser and navigate to",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeStepDef.open_Browser_and_navigate_to()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on View All Button \"50\"",
  "keyword": "When "
});
formatter.match({
  "location": "HomeStepDef.clickOnViewAllButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that hundred result display 50",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStepDef.verify_that_hundred_result_display(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test 2",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Ui"
    }
  ]
});
formatter.step({
  "name": "Open Browser and navigate to website and perform login",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeStepDef.open_Browser_and_navigate_to_website_and_perform_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select random five cryptocurrencies Add to Watchlist",
  "rows": [
    {
      "cells": [
        "Bitcoin",
        "Litecoin",
        "Namecoin",
        "Terracoin",
        "Peercoin"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "HomeStepDef.select_random_five_cryptocurrencies_Add_to_Watchlist(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Open the watchlist in a different browser tab",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStepDef.open_the_watchlist_in_a_different_browser_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the Watchlist tab",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStepDef.click_on_the_Watchlist_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify all the options you selected are added to the watchlist",
  "rows": [
    {
      "cells": [
        "Bitcoin",
        "Litecoin",
        "Namecoin",
        "Terracoin",
        "Peercoin"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStepDef.verify_all_the_options_you_selected_are_added_to_the_watchlist(String\u003e)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:87)\n\tat org.junit.Assert.assertTrue(Assert.java:42)\n\tat org.junit.Assert.assertTrue(Assert.java:53)\n\tat stepdef.ui.HomeStepDef.verify_all_the_options_you_selected_are_added_to_the_watchlist(HomeStepDef.java:76)\n\tat ✽.verify all the options you selected are added to the watchlist(features/frontEnd.feature:15)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Test 3",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Ui"
    }
  ]
});
formatter.step({
  "name": "Open Browser and navigate to",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeStepDef.open_Browser_and_navigate_to()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Display the dropdown menu on the Cryptocurrencies tab \"Cryptocurrencies\"",
  "keyword": "When "
});
formatter.match({
  "location": "HomeStepDef.display_the_dropdown_menu_on_the_Cryptocurrencies_tab(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click any of the \"Ranking\" options on this menu",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStepDef.clickAnyOfTheOptionsOnThisMenu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Record the data on the current page",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStepDef.record_the_data_on_the_current_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Apply any combination of filters, displayed in the three dropdown menus above the tabs \"Exchanges\" \"Spot\"",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStepDef.apply_any_combination_of_filters_displayed_in_the_three_dropdown_menus_above_the_tabs(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check against the data recorded in Step four",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStepDef.checkAgainstTheDataRecordedInStepFour()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Compare Ranking filter data with Stock filter\nExpected: iterable with items [\"Bitcoin\", \"Ethereum\", \"Binance Coin\", \"Cardano\", \"Tether\", \"XRP\", \"Solana\", \"Polkadot\", \"Dogecoin\", \"USD Coin\", \"Terra\", \"Uniswap\", \"Wrapped Bitcoin\", \"Litecoin\", \"Binance USD\", \"Avalanche\", \"Chainlink\", \"Bitcoin Cash\", \"SHIBA INU\", \"Algorand\", \"Polygon\", \"Stellar\", \"Internet Computer\", \"Cosmos\", \"VeChain\", \"Axie Infinity\", \"Filecoin\", \"FTX Token\", \"TRON\", \"Ethereum Classic\", \"Bitcoin BEP2\", \"Dai\", \"THETA\", \"Fantom\", \"Tezos\", \"Hedera\", \"Crypto.com Coin\", \"Monero\", \"PancakeSwap\", \"Elrond\", \"EOS\", \"NEAR Protocol\", \"Flow\", \"Aave\", \"Klaytn\", \"The Graph\", \"eCash\", \"IOTA\", \"Quant\"] in any order\n     but: not matched: \"Binance\"\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:18)\n\tat stepdef.ui.HomeStepDef.checkAgainstTheDataRecordedInStepFour(HomeStepDef.java:109)\n\tat ✽.Check against the data recorded in Step four(features/frontEnd.feature:24)\n",
  "status": "failed"
});
});