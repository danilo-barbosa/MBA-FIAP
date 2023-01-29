
package br.com.fiap.abctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {
    @Positive
    private Long operatorId;
    private List<Long> assists;
    @Valid
    private OrderLocationDto start;
    private OrderLocationDto end;

}
