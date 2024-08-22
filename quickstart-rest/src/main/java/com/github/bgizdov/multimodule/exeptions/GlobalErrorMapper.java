package com.github.bgizdov.multimodule.exeptions;

import io.quarkus.security.ForbiddenException;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

/** Global error mapper to handle exceptions and map them to appropriate HTTP responses. */
public class GlobalErrorMapper {

  /**
   * Maps exceptions to REST responses.
   *
   * @param exception the exception to map
   * @return a RestResponse containing the error details
   */
  @ServerExceptionMapper
  public RestResponse<ErrorResponse> mapException(QuickstartException exception) {
    int code = this.getCodeFromException(exception);
    String status = "internal_server_error";
    String message = "Internal server error logged. Please try again later.";
    if (exception instanceof UserNotFoundException) {
      code = 404;
      status = "user_not_found";
      message = exception.getMessage();
    }

    return this.buildResponse(code, message, status);
  }

  /**
   * Builds a REST response from the given status, code, and message.
   *
   * @param status the HTTP status code
   * @param code the error code
   * @param message the error message
   * @return a RestResponse containing the error details
   */
  protected RestResponse<ErrorResponse> buildResponse(int status, String code, String message) {
    Error error = new Error(status, code, message);
    ErrorResponse errorResponse = new ErrorResponse(error);
    return RestResponse.status(Response.Status.fromStatusCode(status), errorResponse);
  }

  /**
   * Gets the HTTP status code from the given exception.
   *
   * @param exception the exception to map
   * @return the HTTP status code
   */
  protected int getCodeFromException(Exception exception) {
    if (exception instanceof NotAuthorizedException) {
      return 401;
    } else if (exception instanceof ForbiddenException) {
      return 403;
    } else {
      return 500;
    }
  }
}
