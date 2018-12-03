package com.prodevans.DevOpsAssessmentTool.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.prodevans.DevOpsAssessmentTool.user.DetailsService;
import com.prodevans.DevOpsAssessmentTool.user.User;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
	 @Autowired
	 DetailsService detailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

    	        http.authorizeRequests()
   		    	        .antMatchers("/api/users/**")
		                .authenticated()
    	        		.and()  	        			
    	                .httpBasic()
    	                .and()
    	                .logout()
      	                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
    	                .deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true)
    	                .and()
    	                .csrf()
    					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    				
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/api/register");
	    getHttp().csrf().disable();
	    
	}
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder(User.PASSWORD_ENCODER);
    }
}
