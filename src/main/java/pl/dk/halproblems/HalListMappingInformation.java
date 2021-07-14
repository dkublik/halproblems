package pl.dk.halproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.config.HypermediaMappingInformation;
import org.springframework.hateoas.mediatype.hal.HalMediaTypeConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.List;

// TODO uncomment me to have everywhere hal "_links" instead of bean "links"
// @Component
class HalListMappingInformation implements HypermediaMappingInformation {

    private final HalMediaTypeConfiguration halMediaTypeConfiguration;

    public HalListMappingInformation(HalMediaTypeConfiguration halMediaTypeConfiguration) {
        this.halMediaTypeConfiguration = halMediaTypeConfiguration;
    }

    @Override
    public Class<?> getRootType() {
        return List.class;
    }

    @Override
    public List<MediaType> getMediaTypes() {
        return halMediaTypeConfiguration.getMediaTypes();
    }

    @Override
    public ObjectMapper configureObjectMapper(ObjectMapper mapper) {
        return halMediaTypeConfiguration.configureObjectMapper(mapper);
    }
}
