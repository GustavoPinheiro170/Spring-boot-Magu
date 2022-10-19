package br.com.magu.magu.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@ApiModel
@Getter
@Setter
public class Error {
    @ApiModelProperty("errorInfo")
    String errorInfo = null;

    public Error(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Error error)) return false;
        return getErrorInfo().equals(error.getErrorInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrorInfo());
    }
}
