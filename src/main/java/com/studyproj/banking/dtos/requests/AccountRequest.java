package com.studyproj.banking.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Schema(name = "Account Request DTO", description = "Account Request DTO Model")
@Getter
@Setter
public class AccountRequest {
    @Schema(description = "Account balance", example = "1000.00")
    private double balance;

    @Schema(description = "Account status", example = "true")
    private boolean flagged;

    @Schema(description = "Account type", example = "1")
    @Range(min = 1, max = 9, message = "{account.type}")
    private int accountType;

    @Schema(description = "Account creation date", pattern = "dd-MM-yyyy")
    @NotNull(message = "{account.date}")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate creationDate;
}
