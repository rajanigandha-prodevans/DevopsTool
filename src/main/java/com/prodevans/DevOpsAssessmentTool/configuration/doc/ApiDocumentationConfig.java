package com.prodevans.DevOpsAssessmentTool.configuration.doc;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Devops Assessment tool API",
                version = "V1.0.0",
                title = "Devops Assessment tool API",
                contact = @Contact(
                   name = "Rajanikant Devmore", 
                   email = "contact@prodevans.com", 
                   url = "http://www.prodevans.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public interface ApiDocumentationConfig {

}