package br.com.magu.magu.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pages {
    private int limit;
    private int offset;
    private int total;
}
