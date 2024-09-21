```java
public interface PasswordEncoder {
String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
    
    //
    // FORE MORE SECURITY
    //
    default boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}
```


`upgradeEncoding()`

This is a default method,

so they are returning a Boolean value, false.

In the scenarios where if you want to perform

the hashing again one more time,

then this method has to be overrided

with the written value as true.

So whenever this method is returning true,

what is going to happen is the encoded password,

which is going to happen during the registration process,

it is going to be encoded again for better security.

So during the registration,

it is going to be hashed two times.

Since it is hashed two times

during the login operation also,

the hashing is going to happen two times

for that particular encoded password.

But this may be required for super-critical applications,

by default a single time hashing along with the random

generated salt value is more than enough.

