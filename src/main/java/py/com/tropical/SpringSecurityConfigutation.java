package py.com.tropical;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SpringSecurityConfigutation extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(HttpSecurity http) throws Exception {
		  http
		      .authorizeRequests()
		      		.antMatchers("*/api/**","*/css/**","*/js/**","*/vendor/**","*/fonts/**","*/images/**","/login").permitAll()
		      		.antMatchers("*/api/fechas").permitAll()
		      		.and()
		      .formLogin()
		          .loginPage("/login") 
		          .permitAll()
		      .and()
		      		.csrf()
		      		.disable();        
		}
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder passwordEncoder = passwordEncode();
		UserBuilder user = User.builder().passwordEncoder( password -> passwordEncoder.encode(password));
		builder.inMemoryAuthentication()
		.withUser(user.username("admin").password("1234").roles("ADMIN","USER"));
	}
	
	
}
