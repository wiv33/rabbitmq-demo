# RabbitMQ demo

## Reference 
- [rabbitMQ-tutorial-java](https://www.rabbitmq.com/tutorials/tutorial-one-java.html)
- [another-language](https://github.com/rabbitmq/rabbitmq-tutorials)

## Explanation 
this tutorials is required rabbitmq server and another two server that is receiver and sender or server and client

you can run command to profiles active in jar or docker 

if your choice is docker go to a docker-compose file in chapter directory

by Example jar command

    docker run -d -p 5672:5672 -p 15672:15672 --name rabbit-demo-server rabbitmq:3-management

    java -jar rabbitmq-demo.jar --spring.profiles.active=tut1,hello-world,receiver

    java -jar rabbitmq-demo.jar --spring.profiles.active=tut1,hello-world,sender

docker command
> Goto chap{version}

    docker-compose up -d
    
    docker-compose logs -f chap{version}_sender_1 
    
another cmd

    docker-compose logs -f chap{version}_receiver_1
    
then

    docker-compose down
    
