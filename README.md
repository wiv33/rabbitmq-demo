# RabbitMQ demo

## Reference 
- [rabbitMQ-tutorial-java](https://www.rabbitmq.com/tutorials/tutorial-one-java.html)
- [another-language](https://github.com/rabbitmq/rabbitmq-tutorials)

## Go to a Chapter in this repository 
- [chap1](https://github.com/wiv33/rabbitmq-demo/tree/master/src/main/java/com/psawesome/rabbitmqdemo/tutorials/chap1)
    - hello-world
- [chap2](https://github.com/wiv33/rabbitmq-demo/tree/master/src/main/java/com/psawesome/rabbitmqdemo/tutorials/chap2)
    - Work-queues
- [chap3](https://github.com/wiv33/rabbitmq-demo/tree/master/src/main/java/com/psawesome/rabbitmqdemo/tutorials/chap3)
    - FANOUT Exchange
- [chap4](https://github.com/wiv33/rabbitmq-demo/tree/master/src/main/java/com/psawesome/rabbitmqdemo/tutorials/chap4)
    - Direct Exchange: Routing
- [chap5](https://github.com/wiv33/rabbitmq-demo/tree/master/src/main/java/com/psawesome/rabbitmqdemo/tutorials/chap5)
    - Topic Exchange
- [chap6](https://github.com/wiv33/rabbitmq-demo/tree/master/src/main/java/com/psawesome/rabbitmqdemo/tutorials/chap6)
    - Direct Exchange: RPC

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
    

Thank you