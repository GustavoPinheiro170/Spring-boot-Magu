package br.com.magu.magu.models.Clients;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Identification {
    @ApiModelProperty("Document Number")
    private BigDecimal number;

    @ApiModelProperty("Type of Document")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identification that)) return false;
        return getNumber().equals(that.getNumber()) && getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getType());
    }
}
