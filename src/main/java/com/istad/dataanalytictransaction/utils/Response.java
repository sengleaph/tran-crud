package com.istad.dataanalytictransaction.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
//use <T> to create the generic for using every method of class without write or correct again and again
public class Response<P> {
    public enum Status{
        OK, BAD_REQUEST, UNAUTHORIZED, EXCEPTION,
        VALIDATION_EXCEPTION, WRONG_CREDENTIAL, ACCESS_DENIED,
        NOT_FOUND, DUPLICATE_ENTRY, SUCCESS_DELETE, CREATE_SUCCESS ,
        UPDATE_SUCCESS
    }
// use T as the generic for get all the information
    private P payload;
    private Object message;
    private boolean success = false;
    private  Object metadata;
    private Status status;

    // create the method

    public static <P> Response<P> ok(){
        Response<P> response = new Response<>();
        response.setSuccess(true);
        response.setStatus(Status.OK);
        return response;
    }

    public static <P> Response<P> createSuccess(){
        Response<P> response = new Response<>();
        response.setStatus(Status.CREATE_SUCCESS);
        response.setSuccess(true);
        return response;
    }
    public static <P> Response<P> badRequest(){
        Response<P> response = new Response<>();
        response.setStatus(Status.BAD_REQUEST);
        response.setSuccess(false);
        return response;
    }

    public static <P> Response<P> updateSuccess(){
        Response<P> response= new Response<>();
        response.setStatus(Status.UPDATE_SUCCESS);
        response.setSuccess(true);
        return response;
    }

    public static <P> Response<P> deleteSuccess(){
        Response<P> response = new Response<>();
        response.setStatus(Status.SUCCESS_DELETE);
        response.setSuccess(true);
        return response;
    }

    public static <P> Response<P> notFound(){
        Response<P> response = new Response<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }
    public static <P> Response<P> exception(){
        Response<P> response = new Response<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

}
