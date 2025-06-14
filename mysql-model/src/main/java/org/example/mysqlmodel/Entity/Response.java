package org.example.mysqlmodel.Entity;


import lombok.Data;

@Data
public class Response {
    private int code;
    private String message;

    public Response(String message) {
        this.message = message;
        code = 200;
    }
    public Response(int num) {
        code=num;
        message="Fail";
    }
}
