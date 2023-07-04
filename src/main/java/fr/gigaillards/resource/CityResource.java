package fr.gigaillards.resource;

import fr.gigaillards.entity.City;
import fr.gigaillards.repository.CityRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
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
    @Timed(value = "city.all.time", description = "Time taken to delete a city")
    @Counted(value = "city.all.count", description = "Amount of times the endpoint was called")
    public Uni<List<City>> findAll() {
        return cityRepository.findAll();
    }

    @POST
    @Timed(value = "city.create.time", description = "Time taken to create a city")
    @Counted(value = "city.create.count", description = "Amount of times the endpoint was called")
    @WithTransaction
    public Uni<Response> createOne(@Valid City city) {
        return cityRepository.createCity(city);
    }
}
