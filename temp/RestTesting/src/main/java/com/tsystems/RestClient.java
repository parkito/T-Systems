package com.tsystems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
public class RestClient {
    public static void main(String[] args) throws IOException {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/RestTesting/rest/car/post");
        Car car = new Car("Bentley");
        ObjectMapper mapper = new ObjectMapper();
        String JSONCar = mapper.writeValueAsString(car);
        ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, JSONCar);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);
        Car newCar = mapper.readValue(output, Car.class);
        System.out.println("Old car: " + car);
        System.out.println("Output from Server ....");
        System.out.println(newCar);
    }
}