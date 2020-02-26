FROM openjdk:8-jre-alpine

RUN mkdir /code
COPY build/libs /code


ENTRYPOINT [ "sh", "-c", "java -jar -Dspring.profiles.active=container -Duser.timezone=$TIMEZONE -Dnetworkaddress.cache.ttl=60 -Dnetworkaddress.cache.negative.ttl=10 /code/*.jar" ]