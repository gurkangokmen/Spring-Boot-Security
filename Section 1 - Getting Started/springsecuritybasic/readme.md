
# Section1: Getting Started (Spring Security Basic)

## Dependecies:
```
<!-- Spring Security -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- Spring Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Devtools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

> ** Scenario 1: **

```
Go to **http://localhost:8080/welcome**
Enter username, password
Change code, so devtools restart your app.
Again go to **http://localhost:8080/welcome**, it does not ask username and password due to it stores your session in browser.

Note: despite it generates new password
There is not any application.properties configuration for this scenario 1
```

> ** Scenario 2: **

```
Go to **http://localhost:8080/welcome**
Enter username, password
Change code, restart your app manually (without devtools).
Again go to **http://localhost:8080/welcome**, it does not ask username and password due to it stores your session in browser.

Note: despite it generates new password
There is not any application.properties configuration for this scenario 2
```

## Docs

```
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.security
```

## Shortcuts

```
shift + shift: search everywhere
ctrl + shift + f: search in files
```