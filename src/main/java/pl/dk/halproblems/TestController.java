package pl.dk.halproblems;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
class TestController {

    private static final Link googleLink = Link.of("https://www.google.com", "google");

    @GetMapping("single")
    public Mono<TestDto> single() {
        return Mono.just(new TestDto("one").add(googleLink));
    }

    @GetMapping("list-flux")
    public Flux<TestDto> listFlux() {
        return Flux.just(
            new TestDto("one").add(googleLink),
            new TestDto("two").add(googleLink)
        );
    }

    @GetMapping("list-mono")
    public Mono<List<TestDto>> listMono() {
        return Mono.just(List.of(
            new TestDto("one").add(googleLink),
            new TestDto("two").add(googleLink)
            )
        );
    }

    @GetMapping("list-collection-model")
    public Mono<CollectionModel> list() {
        return Mono.just(CollectionModel.wrap(List.of(
            new TestDto("one").add(googleLink),
            new TestDto("two").add(googleLink)
        )));
    }
}
