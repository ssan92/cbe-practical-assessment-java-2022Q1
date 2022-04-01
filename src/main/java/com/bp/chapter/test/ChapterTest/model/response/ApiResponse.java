package com.bp.chapter.test.ChapterTest.model.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ApiResponse {

    @JsonPropertyOrder("1")
    @JsonAlias("status")
    @JsonProperty("status")
    HttpStatus status;

    @JsonPropertyOrder("2")
    @JsonAlias("code")
    @JsonProperty("code")
    Integer code;


    @JsonPropertyOrder("3")
    @JsonAlias("message")
    @JsonProperty("message")
    String message;

    @JsonPropertyOrder("4")
    @JsonAlias("detail")
    @JsonProperty("detail")
    String detail;


    @JsonPropertyOrder("5")
    @JsonAlias("data")
    @JsonProperty("data")
    Object data;



}
