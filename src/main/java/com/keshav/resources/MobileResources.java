package com.keshav.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mobile")
public class MobileResources {

	List<Mobile> mobileList = new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMobile(){
		return Response.ok(mobileList).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMobile(Mobile mobile) {
		mobileList.add(mobile);
		return Response.ok(mobile).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMobile(@PathParam("id") int id,Mobile mobileToUpdate) {
		mobileList.stream().map(mobile->{
			if(mobile.getId()==id) {
				return mobileToUpdate;
			}else {
				return mobile;
			}
		}).collect(Collectors.toList());
		return Response.ok(mobileList).build();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteMobile(@PathParam("id") int id) {
		Integer mobileIdToDelete = null;
		for(int i=0;i<mobileList.size();i++) {
			if(mobileList.get(i).getId()==id) {
				mobileIdToDelete = id;
			}
		}
		if(mobileIdToDelete!=null) {
			mobileList.remove(mobileIdToDelete);
			return Response.ok(mobileList).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	 
}
