http://localhost:8080/register

```
{
    "email":"john@example.com",
    "pwd":"EazyBytes@12345",
    "role":"user"
}
```



`It imports file application_prod.properties`
```
spring.config.import=application_prod.properties
```

`we have to identify the active profile (if you don't specify the active profile, it will take the default profile)`
```
spring.profiles.active=prod
```


`we have to set profile name in application_prod.properties(it does not take name automaticly from file name)`
```
spring.config.activate.on-profile=prod
```