# Err, Exception Handling across Services

> I shelved this project to work on something else. I might revisit this in this future.


## Motivation
Every since 2012 where I wrote my first line of code in java, I never truly found an elegant solutions for error handling. 
There is hibernate for relational database. Log4j or logback for logging. And many widely accepted standards for many other requirements.
I have been working as a full stack developer for over 5 years now. I often work with system or application that crosses multiple platform. 
I took inspiration from multiple API documentation that I have seen over the years.

There are quite many solution but this is my take on it.

## Error Structure

#### Code
Also HTTP status code, it's a easy to understand number that proxy or load balancer knows what to do.

#### URL
Think of it as an `URI`, being a unique identifier that will guarantee uniqueness across systems and company.
Also an `URL` where user/programmer can go to to seek help regarding the error and what causes it.
Also included, `?uuid=1234` for tracing, where internal engineer can use that info for tracing. 

#### Message
Just an error message that is detail enough for anyone to understand what to do next.
Message must not contain any information of object manipulated, you might accidentally leak user/security info.
Same for stacktrace, or internal error message, just don't include any dynamic info. 
Error message *must be static message* you wrote and never inferred. 

```json
{
  "code": 500,
  "url": "https://err.fuxing.dev/RateLimitException?uuid=1234",
  "message": "What happened, detailed enough to understand what to do next."
}
```

## Across Services
Basically the structure above is just the format. 
This package uses the java reflection to parse and properly type the error. (I might change this.) 
As you might want to catch and handled them across your service.
Or you might just want to propagate the error down stream. 


## What you can do with the unified URL
`https://err.fuxing.dev/RateLimitException?uuid=1234`

With an unified err domain you can start converging your error information into one platform.
These are some things you can do with such a platform.

- External user can use it to get help.
- Internal engineer can use it for debugging as that's all you need to debug (trace id, and error).
- Company SSO, reroute internal engineer to something like `https://trace.err.fuxing.dev?type=RateLimitException?uuid=1234`
  - Start tracing immediately to debug the error. 
  
