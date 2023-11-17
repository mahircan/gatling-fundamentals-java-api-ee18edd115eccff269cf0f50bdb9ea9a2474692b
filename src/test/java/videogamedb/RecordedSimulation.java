package videogamedb;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://www.videogamedb.uk")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("application/json")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Sec-Fetch-Dest", "empty");
    headers_0.put("Sec-Fetch-Mode", "cors");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Content-Type", "application/json");
    headers_2.put("Origin", "https://www.videogamedb.uk");
    headers_2.put("Sec-Fetch-Dest", "empty");
    headers_2.put("Sec-Fetch-Mode", "cors");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    headers_2.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Content-Type", "application/json");
    headers_3.put("Origin", "https://www.videogamedb.uk");
    headers_3.put("Sec-Fetch-Dest", "empty");
    headers_3.put("Sec-Fetch-Mode", "cors");
    headers_3.put("Sec-Fetch-Site", "same-origin");
    headers_3.put("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDAzMDI4MCwiZXhwIjoxNzAwMDMzODgwfQ.esXlN4XCmM5jn-tIe8Qs254Aqbx8uCTEh0b-G4JkGWc");
    headers_3.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
    headers_3.put("sec-ch-ua-mobile", "?0");
    headers_3.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Origin", "https://www.videogamedb.uk");
    headers_5.put("Sec-Fetch-Dest", "empty");
    headers_5.put("Sec-Fetch-Mode", "cors");
    headers_5.put("Sec-Fetch-Site", "same-origin");
    headers_5.put("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDAzMDI4MCwiZXhwIjoxNzAwMDMzODgwfQ.esXlN4XCmM5jn-tIe8Qs254Aqbx8uCTEh0b-G4JkGWc");
    headers_5.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
    headers_5.put("sec-ch-ua-mobile", "?0");
    headers_5.put("sec-ch-ua-platform", "macOS");


    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("request_0")
          .get("/api/videogame")
          .headers(headers_0)
      )
      .pause(33)
      .exec(
        http("request_1")
          .get("/api/videogame/2")
          .headers(headers_0)
      )
      .pause(186)
      .exec(
        http("request_2")
          .post("/api/authenticate")
          .headers(headers_2)
          .body(RawFileBody("videogamedb/recordedsimulation/0002_request.json"))
      )
      .pause(43)
      .exec(
        http("request_3")
          .post("/api/videogame")
          .headers(headers_3)
          .body(RawFileBody("videogamedb/recordedsimulation/0003_request.json"))
      )
      .pause(18)
      .exec(
        http("request_4")
          .put("/api/videogame/3")
          .headers(headers_3)
          .body(RawFileBody("videogamedb/recordedsimulation/0004_request.json"))
      )
      .pause(11)
      .exec(
        http("request_5")
          .delete("/api/videogame/3")
          .headers(headers_5)
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
