# java-lang-features
To store java language feature examples by release

## Main Features 11

### HttpClient and WebSocket 
No longer blocking. Based on builders / lambdas 

See SampleHttpClientTest - the new client produces a CompletableFuture which puts work off to a 
separate thread when using async mode.

Similar support for WebSockets added.

### Local Variable syntax 

Local variable type inference means you can do this (started in v10)
```var url = new URL("http://www.google.co.uk/```

### Nests

StringIterable shows a private inner class. This inner class has access to the private field of its
enclosing parent class.
