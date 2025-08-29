package exceptions.mapper;

import exceptions.CarAlreadyExistsExcepiton;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CarAlreadyExistsHandler implements ExceptionMapper<CarAlreadyExistsExcepiton> {

    @Override
    public Response toResponse(CarAlreadyExistsExcepiton exception) {
        return Response
            .status(Response.Status.CONFLICT)
            .entity(exception.getMessage())
            .build();
    }
}
