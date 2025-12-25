
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Server server = new Server();
        server.setUrl("https://9181.32procr.amypo.ai/"); // ✅ YOUR ACTUAL URL
        server.setDescription("Remote Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Parcel Damage Claim API")
                        .description("Swagger documentation for Parcel Damage Claim Validator")
                        .version("1.0"))
                .servers(List.of(server));
    }
}
