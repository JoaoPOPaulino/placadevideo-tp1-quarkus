package br.unitins.tp1.placadevideo.resource;

import br.unitins.tp1.placadevideo.dto.EnderecoRequestDTO;
import br.unitins.tp1.placadevideo.dto.EnderecoResponseDTO;
import br.unitins.tp1.placadevideo.model.Cliente;
import br.unitins.tp1.placadevideo.service.EnderecoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    public EnderecoService enderecoService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(EnderecoResponseDTO.valueOf(enderecoService.findById(id))).build();
    }

    @GET
    @Path("/search/{idCliente}")
    public Response findByCliente(@PathParam("Cliente") Long idCliente) {

        return Response.ok(enderecoService.findByCliente(idCliente).
                                stream().
                                map(o -> EnderecoResponseDTO.valueOf(o)).
                                toList())
                                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(enderecoService.findAll().
                                stream().
                                map(o -> EnderecoResponseDTO.valueOf(o)).
                                toList()).build();
    }

    @POST
    public Response create(@Valid EnderecoRequestDTO dto, Cliente cliente) {
        return Response.status(Status.CREATED).entity(EnderecoResponseDTO.valueOf(enderecoService.create(dto, cliente))
        ).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid EnderecoRequestDTO dto) {
        enderecoService.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        enderecoService.delete(id);
        return Response.noContent().build();
    }

}