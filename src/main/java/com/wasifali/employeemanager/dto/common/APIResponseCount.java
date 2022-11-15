package com.wasifali.employeemanager.dto.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseCount<T> {
    int recordCount;
    T response;

}
