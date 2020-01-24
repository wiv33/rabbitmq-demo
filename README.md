# RabbitMQ demo

## Reference 
- [rabbitMQ-tutorial-java](https://www.rabbitmq.com/tutorials/tutorial-one-java.html)
- [another-language](https://github.com/rabbitmq/rabbitmq-tutorials)

## Description 
this tutorials is required rabbitmq server and another two server that is receiver and sender or server and client

you can run command to profiles active in jar or docker 

if your choice is docker go to a docker-compose file in chapter directory

by Example jar command

    java -jar rabbitmq-demo.jar --spring.profiles.active=tut1,hello-world,receiver

    java -jar rabbitmq-demo.jar --spring.profiles.active=tut1,hello-world,sender

docker command
> Goto chap{version}

    docker-compose up