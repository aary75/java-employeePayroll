package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public @ToString class EmployeeDTO {

    // Attributes
    @NotBlank(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public double salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern="dd MM yyyy")
    @NotNull(message = "startDate should Not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note connot be Empty")
    public String note;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;

    @NotNull (message = "department should Not be Empty")
    public List<String> department;
    private Long employeeId;


}
