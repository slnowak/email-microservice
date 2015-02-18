# email-microservice
This microservice allows you to send an email to given recipients, using single HTTP POST request.
It could be used as a notification sender for your application.

Usage:
```
gradle shadowJar
```

```
java -jar build/libs/email-microservice-1.0-all.jar 'server'
```

Then, you simply need to hit a
```
http://localhost:8080/emailservice/
```
with a HTTP POST request containing following json:
```
{
    "recipients": ["recipient1@domain.com", "recipient2@domain.com"],
    "sender": "sender.email.address@domain.com",
    "password": "password to a sender account",
    "subject": "mail subject"
    "content": "mail content"
}
```

At this point, only sending from gmail account is supported. 
Should be extended with other domains soon.





