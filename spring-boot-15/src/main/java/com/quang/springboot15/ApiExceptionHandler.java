package com.quang.springboot15;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {
    /*
    * Tất cả các Exception không được khai báo sẽ được xử lí tại đây
    * */

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handlerAllException(Exception ex, WebRequest request){
        // quá trình kiểm soát lỗi ở đây
        return new ErrorMessage(500, ex.getLocalizedMessage());
    }

    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage todoExceptionHandler(Exception ex, WebRequest request){
        return new ErrorMessage(400, "Đối tượng k tồn tại");
    }

    //404: NOT FOUND
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage notFoundExceptionHandler(Exception ex, WebRequest request){
        return new ErrorMessage(404, "Không tìm thấy");
    }
}
