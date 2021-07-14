package pl.dk.halproblems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@SpringBootTest(properties = "spring.main.web-application-type=reactive")
@AutoConfigureWebTestClient
class HalproblemsApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void _linksForSingleResult() {
        // when
        ResponseSpec response = webTestClient.get()
                                             .uri("/single")
                                             .exchange();

        // then
        response.expectBody()
                .json("{"
                    + "  \"title\": \"one\","
                    + "  \"_links\": {"
                    + "    \"google\": {"
                    + "      \"href\": \"https://www.google.com\""
                    + "    }"
                    + "  }"
                    + "}");
    }

    @Test
    void linksForFluxListResult() {
        // when
        ResponseSpec response = webTestClient.get()
                                             .uri("/list-flux")
                                             .exchange();

        // then
        response.expectBody()
                .json("["
                    + "  {"
                    + "    \"title\": \"one\","
                    + "    \"links\": ["
                    + "      {"
                    + "        \"rel\": \"google\","
                    + "        \"href\": \"https://www.google.com\""
                    + "      }"
                    + "    ]"
                    + "  },"
                    + "  {"
                    + "    \"title\": \"two\","
                    + "    \"links\": ["
                    + "      {"
                    + "        \"rel\": \"google\","
                    + "        \"href\": \"https://www.google.com\""
                    + "      }"
                    + "    ]"
                    + "  }"
                    + "]");
    }

    @Test
    void linksForMonoListResult() {
        // when
        ResponseSpec response = webTestClient.get()
                                             .uri("/list-mono")
                                             .exchange();

        // then
        response.expectBody()
                .json("["
                    + "  {"
                    + "    \"title\": \"one\","
                    + "    \"links\": ["
                    + "      {"
                    + "        \"rel\": \"google\","
                    + "        \"href\": \"https://www.google.com\""
                    + "      }"
                    + "    ]"
                    + "  },"
                    + "  {"
                    + "    \"title\": \"two\","
                    + "    \"links\": ["
                    + "      {"
                    + "        \"rel\": \"google\","
                    + "        \"href\": \"https://www.google.com\""
                    + "      }"
                    + "    ]"
                    + "  }"
                    + "]");
    }

    @Test
    void _linksForMonoCollectionModelResult() {
        // when
        ResponseSpec response = webTestClient.get()
                                             .uri("/list-collection-model")
                                             .exchange();

        // then
        response.expectBody()
                .json("{"
                    + "  \"_embedded\": {"
                    + "    \"testDtoList\": ["
                    + "      {"
                    + "        \"title\": \"one\","
                    + "        \"_links\": {"
                    + "          \"google\": {"
                    + "            \"href\": \"https://www.google.com\""
                    + "          }"
                    + "        }"
                    + "      },"
                    + "      {"
                    + "        \"title\": \"two\","
                    + "        \"_links\": {"
                    + "          \"google\": {"
                    + "            \"href\": \"https://www.google.com\""
                    + "          }"
                    + "        }"
                    + "      }"
                    + "    ]"
                    + "  }"
                    + "}");
    }
}
