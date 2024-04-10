package com.camunda.tgp;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;


public class UserClient {

    private static String uriBase = "https://reqres.in/api";
    private RestClient restClient;

    public UserClient() {
        RestClient.Builder builder = RestClient.builder();
        this.restClient = builder.baseUrl(  uriBase ).build();
	}

    public List<User> getUsers(String[] args ) {
        
        String responseBody;
        List<User> users = new ArrayList<User>();
        String page = args[0];

        responseBody = this.restClient.get().uri( UserClient.uriBase + "/users?page={page}", page ).retrieve().body(String.class);

        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree( responseBody );
            String data = jsonNode.get("data").toString();

            TypeFactory typeFactory = mapper.getTypeFactory();
            users = mapper.readValue(data, typeFactory.constructCollectionType(List.class, User.class));

        } catch (Exception e) {
            System.out.println("Exception of type " + e.getClass().getName() + " occurred.");
            e.printStackTrace();
        }

        return users;
    }

    public static void main(String[] args) {

        List<User> users = null;

        UserClient userClient = new UserClient();
        users = userClient.getUsers( args );
        
        try {
            users = userClient.getUsers( args );
         } catch (InvalidUserResponseException iurex ) {
             System.out.println( "Incorrect Data from api" );
         }

         System.out.println("User List: " + users );
    }
}

class CollectionsTypeFactory {
    static JavaType listOf(Class theClass) {
        return TypeFactory.defaultInstance().constructCollectionType( List.class, theClass);
    }
}