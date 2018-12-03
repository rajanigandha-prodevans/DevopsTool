package com.prodevans.DevOpsAssessmentTool.configuration;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DevOpsAssessmentToolApplication.class);
	}

}
