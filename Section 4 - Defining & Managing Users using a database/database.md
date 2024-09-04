1️⃣

CHECK PORT IS USED OR NOT:

```
netstat -ano | findstr :9411
```

If port is used you will see details, otherwise you didn't see anything.

-------------------------------------------------------------
2️⃣

KILL PORT

```
PS C:\Users\Unfaithful> netstat -ano | findstr :3306
  TCP    0.0.0.0:3306           0.0.0.0:0              LISTENING       2716
  TCP    0.0.0.0:33060          0.0.0.0:0              LISTENING       2716
  TCP    [::]:3306              [::]:0                 LISTENING       2716
  TCP    [::]:33060             [::]:0                 LISTENING       2716
```

```
PS C:\Users\Unfaithful>  taskkill /PID 2716 /F
SUCCESS: The process with PID 2716 has been terminated.
```


-------------------------------------------------------------
3️⃣

RUN MYSQL ON DOCKER

```
docker run -p 3306:3306 --name springsecurity -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eazybank -d mysql
```

-------------------------------------------------------------
4️⃣

```
https://github.com/sqlectron/sqlectron-gui/releases/tag/v1.38.0
```