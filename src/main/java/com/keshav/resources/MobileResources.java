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

	List<String> mobileList = new ArrayList<>();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllMobile(){
		return Response.ok(mobileList).build();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response addMobile(String mobileName) {
		mobileList.add(mobileName);
		return Response.ok(mobileName).build();
	}
	
	@PUT
	@Path("/{oldMobileName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response updateMobile(@PathParam("oldMobileName") String oldMobileName,
								@QueryParam("newMobilename") String newMobilename) {
		mobileList = mobileList.stream().map(mobile->{
			if(mobile.equals(oldMobileName)) {
				return newMobilename;
			}else {
				return mobile;
			}
		}).collect(Collectors.toList());
		return Response.ok(mobileList).build();
	}
	
	@DELETE
	@Path("{mobile}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteMobile(@PathParam("mobile") String mobile) {
		boolean isRemoved = mobileList.remove(mobile);
		if(isRemoved) {
			return Response.ok(mobileList).build();
		}else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	 
}
