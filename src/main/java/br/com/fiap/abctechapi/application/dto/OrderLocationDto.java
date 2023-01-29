
package br.com.fiap.abctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@AllArgsConstructor
public class OrderLocationDto {
    private Double latitude;
    private Double longitude;
    @NotNull
    @PastOrPresent
    private Date dateTime;

}
