package edu.eci.cosw.spademo;

import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.persistence.ClientsRepository;
import edu.eci.cosw.spademo.stub.IStub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@SpringBootApplication
@EnableJpaRepositories("edu.eci.cosw.spademo.persistence")
@EntityScan("edu.eci.cosw.spademo.model")
public class DemoApplication {
    @Autowired
    IStub stub;
    @Autowired
    ClientsRepository cr;
        public static void main(String[] args) {
        /*EnviadorMail EnviadorMail = new EnviadorMail("oscar.ard.jim@gmail.com",
                "Este es el asunto de mi correo", "Este es el cuerpo de mi correo probando el envio de correo electronico que ya funciona :D");
        EnviadorMail EnviadorMail2 = new EnviadorMail("oscar.ardila-j@mail.escuelaing.edu.co",
                "Este es el asunto de mi correo", "Este es el cuerpo de mi correo probando el envio de correo electronico que ya funciona :D");
        EnviadorMail EnviadorMail3 = new EnviadorMail("david.galvis@mail.escuelaing.edu.co",
                "Este es el asunto de mi correo", "Este es el cuerpo de mi correo probando el envio de correo electronico que ya funciona :D");
        EnviadorMail EnviadorMail4 = new EnviadorMail("davidggalvis@gmail.com",
                "Este es el asunto de mi correo", "Este es el cuerpo de mi correo probando el envio de correo electronico que ya funciona :D");
        
        EnviadorMail EnviadorMail1 = new EnviadorMail("juan.gomez-r@mail.escuelaing.edu.co",
                "Este es el asunto de mi correo", "Este es el cuerpo de mi correo probando el envio de correo electronico que ya funciona :D");
        */
        SpringApplication.run(DemoApplication.class, args);
        
        
    }

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    //protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    protected class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(AuthenticationManagerBuilder builder) throws Exception {
            builder.authenticationProvider(new AuthenticationProvider() {

                @Override
                public Authentication authenticate(Authentication a) throws AuthenticationException {
                    ClientApp cliente = cr.findOne(Integer.parseInt(a.getName()));
                    if(cliente!=null && a.getCredentials().toString().equals(cliente.getPassword())){
                        List<GrantedAuthority> permisos = new ArrayList<>();
                        permisos.add(new SimpleGrantedAuthority("USER"));
                        return new UsernamePasswordAuthenticationToken(a.getName(), a.getCredentials().toString(), permisos);
                    }
                    return null;
                }

                @Override
                public boolean supports(Class<?> type) {
                    return type.equals(UsernamePasswordAuthenticationToken.class);
                }
            });
            /*builder
                    .jdbcAuthentication()
                    .dataSource(cr)
                    .usersByUsernameQuery(cr.findAll())
                    .authoritiesByUsernameQuery(getAuthoritiesQuery());*/
            //crear todos los usuarios existentes que estan registrados en la App
            /*for(int i=0; i<stub.getClientsApp().size(); i++){
                ClientApp c = stub.getClientsApp().get(i);
                builder.inMemoryAuthentication().withUser(c.getIdClients()+"").password(c.getPassword()+"").roles("USER");
                System.out.println("CREANDO USUARIOSS"+c.getIdClients());
            }
            
            builder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
            *///builder.inMemoryAuthentication().withUser("yo").password("yo").roles("USER");
            
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/app/**", "/clientsApp", "/clientsApp/**", "/roles/**", "/supermarkets", "/supermarkets/**", "/email").permitAll()
                    
                    .anyRequest().authenticated().and()
                    .logout().logoutSuccessUrl("/app/index.html#/viewLogin")
                    
                    .permitAll()
                    .and().csrf()
                    .csrfTokenRepository(csrfTokenRepository()).and()
                    .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
                    .csrf().disable();
        }

        private Filter csrfHeaderFilter() {
            return new OncePerRequestFilter() {
                @Override
                protected void doFilterInternal(HttpServletRequest request,
                        HttpServletResponse response, FilterChain filterChain)
                        throws ServletException, IOException {
                    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                            .getName());
                    if (csrf != null) {
                        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                        String token = csrf.getToken();
                        if (cookie == null || token != null
                                && !token.equals(cookie.getValue())) {
                            cookie = new Cookie("XSRF-TOKEN", token);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                        }
                    }
                    filterChain.doFilter(request, response);
                }
            };
        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }
    }
}
