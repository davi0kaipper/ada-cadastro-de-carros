package exception.mapper;

import exception.CarNotExistsException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CarNotExistsHandler implements ExceptionMapper<CarNotExistsException> {

    @Override
    public Response toResponse(CarNotExistsException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .build();
    }
}
