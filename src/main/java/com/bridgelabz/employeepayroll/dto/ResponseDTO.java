package com.bridgelabz.employeepayroll.dto;

import com.bridgelabz.employeepayroll.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import  org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
public @Data class ResponseDTO {
    private String message;
    private Object data;
    private int statusCode;

    public ResponseDTO(String message, Object data) {
        this.message =  message;
        this.data = data;
        this.statusCode = HttpStatus.OK.value();
    }

    public ResponseDTO(String message,int statusCode,Object  data){
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }


//    public void setMessage(String message){
//        this.message = message;
//    }
//
//    public String getMessage(){
//        return message;
//    }
//
//    public void setData(Object data){
//        this.data = data;
//    }
//
//    public Object getData(){
//        return data;
//    }
//

}
