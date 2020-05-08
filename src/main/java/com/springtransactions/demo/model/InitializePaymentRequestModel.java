package com.springtransactions.demo.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InitializePaymentRequestModel {

    @NonNull
    @NotEmpty
    Integer staffId1;
    @NonNull
    @NotEmpty
    Integer staffId2;
    @NonNull
    @NotEmpty
    Double amount;

    public InitializePaymentRequestModel(@NotEmpty Integer staffId1, @NotEmpty Integer staffId2, @NotEmpty Double amount) {
        this.staffId1 = staffId1;
        this.staffId2 = staffId2;
        this.amount = amount;
    }
}