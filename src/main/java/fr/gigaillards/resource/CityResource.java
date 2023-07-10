package fr.gigaillards.resource;

import fr.gigaillards.entity.City;
import fr.gigaillards.repository.CityRepository;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("city")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CityResource {

    @Inject
    CityRepository cityRepository;

    @GET
    public Uni<List<City>> findAll() {
        return cityRepository.findAll();
    }

    @POST
    @WithTransaction
    public Uni<Response> createOne(@Valid City city) {

        return cityRepository.createCity(city);
    }
}
