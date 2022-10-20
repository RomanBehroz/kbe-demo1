package com.romanyou.KBE.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @Author Roman Behroz
 * Error Handling, Custom Error
 */
public class ErrorMessage {

    private HttpStatus status;
    private String message;
}
