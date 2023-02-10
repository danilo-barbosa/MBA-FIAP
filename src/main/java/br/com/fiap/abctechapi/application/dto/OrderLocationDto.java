
package br.com.fiap.abctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLocationDto {
    private Double latitude;
    private Double longitude;
    @NotNull
    @PastOrPresent
    private Date dateTime;

}
