package com.tsystems;

import com.tsystems.Car;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
@Path("/car")
public class GetCarService {

    @GET
    @Path("/{brandName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("brandName") String brandName) {
        return new Car(brandName);
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car patchCar(Car car) {
        return new Car(car.getModel());
    }
}
