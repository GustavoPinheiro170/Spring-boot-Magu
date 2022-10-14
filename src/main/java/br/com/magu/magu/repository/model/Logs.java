package br.com.magu.magu.repository.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@ApiModel
@Getter
@Setter
public class Logs {

    @ApiModelProperty("id")
    String id = null;

    @ApiModelProperty("apiName")
    String apiName = null;

    @ApiModelProperty("userName")
    String userName = null;

    @ApiModelProperty("localData")
    String localData = null;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logs logs)) return false;
        return Objects.equals(getId(), logs.getId()) && Objects.equals(getApiName(), logs.getApiName()) && Objects.equals(getUserName(), logs.getUserName()) && Objects.equals(getLocalData(), logs.getLocalData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getApiName(), getUserName(), getLocalData());
    }
}
