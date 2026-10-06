package no.vaagenpressing.importer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Shape of API-footballs /team response.
 * Only the fields used are mapped.
 * @param response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TeamsResponse(List<Item> response) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Item(TeamDto team) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TeamDto(Integer id, String name, String code, Integer founded) {}

}
