package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
@Builder
public class CreateAuthorResponse {
    private String name;
    private String particularity;
    private Date birthdate;


}
