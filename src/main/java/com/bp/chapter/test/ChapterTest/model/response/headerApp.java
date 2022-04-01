package com.bp.chapter.test.ChapterTest.model.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class headerApp {

    @JsonPropertyOrder("1")
    @JsonAlias("code")
    @JsonProperty("code")
    Integer code;

    @JsonPropertyOrder("2")
    @JsonAlias("message")
    @JsonProperty("message")
    String message;

}
