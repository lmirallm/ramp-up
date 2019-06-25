package factory.car.resource;

import java.rmi.server.UID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import factory.car.entity.Car;
import factory.car.service.CarService;

@Path("car")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

	@EJB
	private CarService carService;
	
	@GET
	public Response getAllCars() {
		return Response.status(Status.OK).entity(carService.getCars()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getCarById(final UID id) {
		Car carFromDB=carService.getCar(id); 
		if(carFromDB!=null) {
			return Response.status(Status.OK).entity(carFromDB).build();
		}else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	public Response createCar(Car car) {
		if(carService.createCar(car))
		return Response.status(Status.OK).entity("Car with ID "+car.getId()+" created correctly").build();
		else
		return Response.status(Status.BAD_REQUEST).entity("Car with ID "+car.getId()+" could not be created").build();	
	}
	
	@PUT
	public Response updateCar(Car car) {
		if(carService.updateCar(car)) {
		return Response.status(Status.OK).entity("Car with ID "+car.getId()+" updated correctly").build();
		}else {
			return Response.status(Status.BAD_REQUEST).entity("Car with ID "+car.getId()+"could not be updated").build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCar(final UID id) {
		if(carService.deleteCar(id)) {
		return Response.status(Status.OK).entity("Car with ID "+id+" deleted correctly").build();
		}else {
		return Response.status(Status.BAD_REQUEST).entity("Car with ID "+id+" not found").build();
		}
	}
}
