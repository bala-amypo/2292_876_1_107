// package com.example.demo.config;

// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SwaggerSecurityConfig {

//     @Bean
//     public OpenAPI secureOpenAPI() {

//         SecurityScheme bearerAuth = new SecurityScheme()
//                 .type(SecurityScheme.Type.HTTP)
//                 .scheme("bearer")
//                 .bearerFormat("JWT")
//                 .in(SecurityScheme.In.HEADER)
//                 .name("Authorization");

//         return new OpenAPI()
//                 .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
//                 .components(
//                         new Components()
//                                 .addSecuritySchemes("BearerAuth", bearerAuth)
//                 );
//     }
// }

package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerSecurityConfig {

    @Bean
    public OpenAPI secureOpenAPI() {

        // ✅ Server URL
        Server server = new Server();
        server.setUrl("https://9181.32procr.amypo.ai/");
        server.setDescription("Remote Server");

        // ✅ JWT Bearer Authentication
        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        return new OpenAPI()
                .info(new Info()
                        .title("Parcel Damage Claim API")
                        .description("Swagger documentation for Parcel Damage Claim Validator")
                        .version("1.0"))
                .servers(List.of(server))
                // 🔐 Authorize button
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .components(
                        new Components()
                                .addSecuritySchemes("BearerAuth", bearerAuth)
                );
    }
}
