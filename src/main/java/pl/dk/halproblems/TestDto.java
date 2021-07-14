package pl.dk.halproblems;

import org.springframework.hateoas.RepresentationModel;

public class TestDto extends RepresentationModel<TestDto> {

    private final String title;

    public TestDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
