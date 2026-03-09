import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoinGeckoAPITest {

    @Test
    public void testBitcoinEndpoint() {
        // 1. Send GET request
        Response response = RestAssured
                .given()
                .baseUri("https://api.coingecko.com")
                .basePath("/api/v3/coins/bitcoin")
                .when()
                .get();

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code check");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        // Example: get USD price
        Double usdPrice = jsonPath.getDouble("market_data.current_price.usd");
        System.out.println("USD Price: " + usdPrice);
        Double usdmarketCap = jsonPath.getDouble("market_data.market_cap.usd");
        System.out.println("USD Price: " + usdmarketCap);
        Double eurMarketCap = jsonPath.getDouble("market_data.market_cap.eur");
        System.out.println("EUR Market Cap: " + eurMarketCap);
        Double gbpVolume = jsonPath.getDouble("market_data.total_volume.gbp");
        System.out.println("GBP Volume: " + gbpVolume);

        String text=jsonPath.getString("links.homepage");
       if(text!=null)
       {
           System.out.println(text);
       }




    }
}
