package videogamedb.feeders;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.http;

public class VideoGameDbFeedersJson extends Simulation {
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private static FeederBuilder.FileBased<Object> jsonFeeder = jsonFile("data/gameJsonFile.json").circular();

    private static ChainBuilder getSpecificGame =
            feed(jsonFeeder)
                    .exec(http("Get video game with name - #{name}")
                            .get("/videogame/#{id}")
                            .check(jmesPath("name").isEL("#{name}")));

    private ScenarioBuilder scn = scenario("Video game db - Section 6 code ")
            .repeat(10).on(
                    exec(getSpecificGame)
                            .pause(1)
            );

    {
        setUp(
                scn.injectOpen(atOnceUsers(5))
        ).protocols(httpProtocol);
    }

}

