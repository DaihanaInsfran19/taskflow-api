package com.empresasrl.taskflowapi.dto;

import com.empresasrl.taskflowapi.model.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    @NotBlank
    @Size(min = 3)
    private String title;

    private String description;
    private Priority priority;
}
