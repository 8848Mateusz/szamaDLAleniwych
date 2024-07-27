package pl.coderslab.szamadlaleniwych.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.coderslab.szamadlaleniwych.service.CustomSuccessHandler;
import pl.coderslab.szamadlaleniwych.service.CustomUserDetailsService;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests()
                        .requestMatchers("/HomePage", "/WEB-INF/views/**").permitAll()
                        .requestMatchers("/About", "/WEB-INF/views/**").permitAll()
                        .requestMatchers("/RegistrationForm", "/WEB-INF/views/**").permitAll()
                        .requestMatchers("/LoginFormAfterRegistration", "/WEB-INF/views/**").permitAll()
                        .requestMatchers("/UserHomePage", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/SearchHistory", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/SearchHistory**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/SearchHistory/**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/NameOfTheMeal**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/NameOfTheMeal/**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/NameOfTheMeal", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/FoodIngredients", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/FoodIngredients/**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/FoodIngredients**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/UserSettings", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/UserSettings**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/UserSettings/**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/UserDell**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/DeleteSearchHistory**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/DeleteSearchHistory", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/DeleteSearchHistory/**", "/WEB-INF/views/**").hasAuthority("USER")
                        .requestMatchers("/js/**", "/css/**", "/img/**", "/vendor/**").permitAll()
                        .and()
                        .formLogin()
                        .loginPage("/LoginFormAfterRegistration")
                        .loginProcessingUrl("/LoginFormAfterRegistration")
                        .successHandler(customSuccessHandler).permitAll()
                        .and()
                        .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/Logout"))
                        .logoutSuccessUrl("/LoginFormAfterRegistration?logout");
        http.headers().frameOptions().disable();
        http.csrf().disable().authorizeHttpRequests();
                return  http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
