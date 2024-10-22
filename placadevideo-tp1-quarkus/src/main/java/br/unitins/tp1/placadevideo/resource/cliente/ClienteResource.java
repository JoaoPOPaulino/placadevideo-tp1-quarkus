package br.unitins.tp1.placadevideo.resource.cliente;

import br.unitins.tp1.placadevideo.dto.ClienteRequestDTO;
import br.unitins.tp1.placadevideo.dto.ClienteResponseDTO;
import br.unitins.tp1.placadevideo.dto.EnderecoRequestDTO;
import br.unitins.tp1.placadevideo.dto.TelefoneClienteRequestDTO;
import br.unitins.tp1.placadevideo.service.cliente.ClienteService;
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

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    public ClienteService clienteService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(ClienteResponseDTO.valueOf(clienteService.findById(id))).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(clienteService.findByNome(nome).
                                stream().
                                map(o -> ClienteResponseDTO.valueOf(o)).
                                toList())
                                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(clienteService.findAll().
                                stream().
                                map(o -> ClienteResponseDTO.valueOf(o)).
                                toList()).build();
    }

    @POST
    public Response create(@Valid ClienteRequestDTO dto) {
        return Response.status(Status.CREATED).entity(ClienteResponseDTO.valueOf(clienteService.create(dto))
        ).build();
    }

    @POST
    @Path("/{id}/enderecos")
    public Response addEndereco(@PathParam("id") Long clienteId, @Valid EnderecoRequestDTO enderecoDTO) {
        clienteService.addEndereco(clienteId, enderecoDTO);
        return Response.status(Status.CREATED).build();
    }

    @POST
    @Path("/{id}/telefones")
    public Response addEndereco(@PathParam("id") Long clienteId, @Valid TelefoneClienteRequestDTO telefoneDTO) {
        clienteService.addTelefone(clienteId, telefoneDTO);;
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid ClienteRequestDTO dto) {
        clienteService.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        clienteService.delete(id);
        return Response.noContent().build();
    }

}