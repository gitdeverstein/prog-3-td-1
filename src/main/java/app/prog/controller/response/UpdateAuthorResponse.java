package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
@AllArgsConstructor
@Data

public class UpdateAuthorResponse {
    private int id;
    private String name;
    private String particularity;
    private Date birthdate;
}
