package com.studyproj.banking.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(name = "Transaction Request DTO", description = "Transaction Request DTO Model")
@Getter
@Setter
public class TransactionRequest {

    @Schema(description = "Transaction Value", example = "100.00")
    @DecimalMin(value = "0.1", message = "{transaction.value}")
    private double amount;

    @Schema(description = "Transaction Date", pattern = "dd-MM-yyyy")
    @NotNull(message = "{transaction.date}")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate transactionDate;

    @Schema(description = "Transaction Account", example = "1")
    @Min(value = 1, message = "{transaction.account}")
    private long accountId;

    @Schema(description = "Transaction ID generated automatically", example = "1")
    @JsonIgnore
    private Long id;
}
