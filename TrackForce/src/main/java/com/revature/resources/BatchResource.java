package com.revature.resources;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.revature.model.BatchInfo;
import com.revature.services.BatchesService;
import com.revature.utils.LogUtil;

import io.swagger.annotations.Api;

/**
 * Class that provides RESTful services for the batch listing and batch details
 * page.
 */
@Path("batches")
@Api(value = "batches")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BatchResource {
	private BatchesService service;
	static final Logger logger = Logger.getLogger(LogUtil.class);

	public BatchResource() {
		this.service = new BatchesService();
	}

	/**
	 * Gets all batches, optionally filtered by start and end date query parameters
	 * For example, sending a GET request to /batches?start={date1}&end={date2} will
	 * return all batches with end dates between date 1 and date2
	 * 
	 * @return - Response with 200 status and a List<BatchInfo> in the response body
	 */
	@GET
	public Response getAllBatches() {
		Set<BatchInfo> batches = service.getAllBatches();
		Status status = batches == null || batches.isEmpty() ? Status.NO_CONTENT : Status.OK;

		return Response.status(status).entity(batches).build();
	}
	
	public Response getAllBatches(@DefaultValue("1510549200000") @QueryParam("start") Long startDate,
			@DefaultValue("1527480000000") @QueryParam("end") Long endDate) {
		List<BatchInfo> batches = service.getBatches(startDate, endDate);
		Status status = batches == null || batches.isEmpty() ? Status.NO_CONTENT : Status.OK;

		return Response.status(status).entity(batches).build();
	}

	/**
	 * @author Ian Buitrago
	 * @param curriculum
	 *            name
	 * @return set of batches matching curriculum
	 */
	@GET
	@Path("curriculum/{curriculum}")
	public Response getBatchesByCurri(@PathParam("curriculum") String curriculum) {
		Set<BatchInfo> batches = service.getBatchesByCurri(curriculum);
		Status status = batches == null || batches.isEmpty() ? Status.NO_CONTENT : Status.OK;
		logger.info("query  = Curriculum: " + curriculum);
		logger.info("batch size: " + batches.size());

		return Response.status(status).entity(batches).build();
	}

	/**
	 * Gets a batch by its id
	 * 
	 * @return - Response with 200 status and the BatchInfo object in the response
	 *         body
	 */
	@GET
	@Path("{id}")
	public Response getBatchById(@PathParam("id") Integer id) {
		BatchInfo batch = service.getBatchById(id);
		return Response.ok(batch).build();
	}

	@GET
	@Path("{id}/associates")
	public Response getAssociatesForBatch(@PathParam("id") Integer id) {
		return Response.ok(service.getAssociatesForBranch(id)).build();
	}
}