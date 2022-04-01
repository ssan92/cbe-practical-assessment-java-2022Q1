package com.pichincha.evaluacion.practica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;


@Validated
public class ApiError {
    @JsonProperty("type")
    private String type = "about:blank";

    @JsonProperty("title")
    private String title = null;

    @JsonProperty("detail")
    private String detail = null;

    @JsonProperty("status")
    private Integer status = null;

    @JsonProperty("instance")
    private String instance = null;

    public ApiError type(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ApiError title(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ApiError detail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ApiError status(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ApiError instance(String instance) {
        this.instance = instance;
        return this;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiError apiError = (ApiError) o;
        return Objects.equals(this.type, apiError.type) &&
                Objects.equals(this.title, apiError.title) &&
                Objects.equals(this.detail, apiError.detail) &&
                Objects.equals(this.status, apiError.status) &&
                Objects.equals(this.instance, apiError.instance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, detail, status, instance);
    }

}
