package videogamedb;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulationProxy extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://videogamedb.uk")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader("PostmanRuntime/7.35.0");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Postman-Token", "7908cfa5-cac4-4a01-9d55-92b641c3da0b");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Postman-Token", "eefb432c-317a-42d5-a2b2-2dbb38488294");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Content-Type", "application/json");
    headers_2.put("Postman-Token", "cac5aca1-0535-4409-8b27-68f69f61b03e");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Content-Type", "application/json");
    headers_3.put("Postman-Token", "981be5a1-3ae0-44b5-8f7c-edd6bfc11a3a");
    headers_3.put("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDA0MzY5NywiZXhwIjoxNzAwMDQ3Mjk3fQ.-KUy6awkuxp_UjQK96DU6deU0fUhNMN0md05xuDJZKE");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Content-Type", "application/json");
    headers_4.put("Postman-Token", "bcd10f9a-fd13-4667-abf9-9c6b4a9df62f");
    headers_4.put("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDA0MzY5NywiZXhwIjoxNzAwMDQ3Mjk3fQ.-KUy6awkuxp_UjQK96DU6deU0fUhNMN0md05xuDJZKE");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Postman-Token", "25af67e5-df38-4bf9-8b21-57318d9db4ab");
    headers_5.put("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMDA0MzY5NywiZXhwIjoxNzAwMDQ3Mjk3fQ.-KUy6awkuxp_UjQK96DU6deU0fUhNMN0md05xuDJZKE");


    ScenarioBuilder scn = scenario("RecordedSimulationProxy")
      .exec(
        http("request_0")
          .get("/api/videogame")
          .headers(headers_0)
      )
      .pause(50)
      .exec(
        http("request_1")
          .get("/api/videogame/2")
          .headers(headers_1)
      )
      .pause(28)
      .exec(
        http("request_2")
          .post("/api/authenticate")
          .headers(headers_2)
          .body(RawFileBody("videogamedb/recordedsimulationproxy/0002_request.json"))
      )
      .pause(9)
      .exec(
        http("request_3")
          .post("/api/videogame")
          .headers(headers_3)
          .body(RawFileBody("videogamedb/recordedsimulationproxy/0003_request.json"))
      )
      .pause(11)
      .exec(
        http("request_4")
          .put("/api/videogame/3")
          .headers(headers_4)
          .body(RawFileBody("videogamedb/recordedsimulationproxy/0004_request.json"))
      )
      .pause(10)
      .exec(
        http("request_5")
          .delete("/api/videogame/2")
          .headers(headers_5)
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
