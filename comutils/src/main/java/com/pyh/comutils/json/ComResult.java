package com.pyh.comutils.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComResult<T> {
    private Integer code;
    private String message;
    private T data;

    public ComResult(Integer code, String message)
    {
        this(code,message,null);
    }
}
