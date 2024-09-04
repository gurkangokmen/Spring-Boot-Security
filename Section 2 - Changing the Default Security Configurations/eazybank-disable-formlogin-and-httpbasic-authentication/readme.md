http://localhost:8080/myAccount

http://localhost:8080/myBalance

http://localhost:8080/myCards

http://localhost:8080/contact

http://localhost:8080/myLoans

http://localhost:8080/notices


```
shift + shift: SpringBootWebSecurityConfiguration.java

Disable form login and basic authentication:
```

```
Why?

When There is not need form login for example, mobile application, other apis, etc.
```

`Source Code:`
https://github.com/eazybytes/springsecurity6

`Important Notes:`


```
Scenario 1: 
-----------------------------------------------------------------------------------------------------------------------
ProjectSecurityConfig.java:
http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable())
                .httpBasic(Customizer.withDefaults());
        return http.build();
-----------------------------------------------------------------------------------------------------------------------
application.properties:
spring.security.user.name = eazybytes
spring.security.user.password = 12345
-----------------------------------------------------------------------------------------------------------------------

UsernamePasswordAuthenticationFilter
BasicAuthenticationFilter

-----------------------------------------------------------------------------------------------------------------------
If we remove login form, it does not go to UsernamePasswordAuthenticationFilter, it goes to BasicAuthenticationFilter.
It goes directly to BasicAuthenticationFilter.

We see login popup. (http://localhost:8080/myAccount)
```



```
Scenario 1: 
-----------------------------------------------------------------------------------------------------------------------
ProjectSecurityConfig.java:
http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable())
                .httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.disable());
        return http.build();
-----------------------------------------------------------------------------------------------------------------------
application.properties:
spring.security.user.name = eazybytes
spring.security.user.password = 12345
-----------------------------------------------------------------------------------------------------------------------

UsernamePasswordAuthenticationFilter
BasicAuthenticationFilter

-----------------------------------------------------------------------------------------------------------------------
If we remove login form and basic authentication, it does not go to UsernamePasswordAuthenticationFilter and BasicAuthenticationFilter.

We see 403 Forbidden Error. (http://localhost:8080/myAccount)
```


```
control + alt + F8: Evaluate Expression
```