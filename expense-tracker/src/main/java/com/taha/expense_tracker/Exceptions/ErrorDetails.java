package com.taha.expense_tracker.Exceptions;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(
        description = "ErrorDetails DTO (Date Transfer Object) to"
        + "transfer the error response data between client and system"
)
public class ErrorDetails {

    @Schema(description = "Error occurred date time")
    private LocalDateTime localDateTime;

    @Schema(description = "Error message")
    private String message;

    @Schema(description = "Error details")
    private String details;

    @Schema(description = "Error code")
    private String errorCode;

}
