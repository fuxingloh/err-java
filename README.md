# Error URL
A unified language-agnostic URL based error handling **spec**.

> TLDR: Use URL for your error type, to converge user into a website for debugging and tracing.

```json
{
  "code": 500,
  "url": "https://err.fuxing.dev/RateLimitException?uuid=1234",
  "message": "What happened, detailed enough to understand what to do next."
}
```

## Motivation
Every since 2012 where I wrote my first line of code, I never truly found an elegant solutions for error handling. 
For Java, there is hibernate for relational database, Log4j or logback for logging. 
And many widely accepted standards for many other requirements and languages.
I have been working as a full stack developer for over 5 years now. 
I often work with system or application that crosses multiple platform, languages and system. 
I took inspiration from multiple API documentation that I have seen over the years and this is my take on it.

## Structure
#### Code
Also HTTP status code, it's an easy to understand number that proxy or load balancer knows what to do.

#### URL
Think of it as an `URI`, being a unique identifier that will guarantee uniqueness across systems and company.
Also an `URL` where user/programmer can go to to seek help regarding the error and what causes it.
Also included, `?uuid=1234` for tracing, where internal engineer can use that info for tracing. 

#### Message
Just an error message that is detail enough for anyone to understand what to do next.
Message must not contain any information of object manipulated, you might accidentally leak user/security info.
Same for stacktrace, or internal error message, just don't include any dynamic info. 
Error message **must be static message** you wrote and never inferred. 


## Across Services
Basically the structure above is just the spec aka the format. 
As you might want to catch and handled them across your service.
Or you might just want to propagate the error down stream. 


## What's next?
`https://err.fuxing.dev/RateLimitException?uuid=1234`

With an unified error domain you can start converging your error information into one platform.
With a platform where your error converge, you can create amazing things like this: 

- External user can use it to get help.
- Internal engineer can use it for debugging as that's all you need to debug (trace id, and error).
- Company SSO, reroute internal engineer to something like `https://trace.err.fuxing.dev?type=RateLimitException?uuid=1234`
  - Start tracing immediately to debug the error. 
  
