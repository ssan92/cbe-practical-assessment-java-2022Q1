package com.bp.chapter.test.ChapterTest.request;

import com.bp.chapter.test.ChapterTest.entity.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequest implements Serializable {

    @JsonAlias("name")
    @JsonProperty(value = "name",required = true)
    private String name;

    @JsonAlias("category")
    @JsonProperty(value = "category",required = true)
    private String category;

    @JsonAlias("direction")
    @JsonProperty(value = "direction",required = false)
    private String direction;

    @JsonAlias("identifier")
    @JsonProperty(value = "identifier",required = true)
    private String identifier;

    @JsonAlias("user")
    @JsonProperty(value = "user",required = false)
    private UserRequest user;

}
