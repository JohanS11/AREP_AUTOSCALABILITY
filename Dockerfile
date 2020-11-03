FROM openjdk:8

WORKDIR /usrapp/bin

ENV PORT 6000

COPY /target/dependency /usrapp/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","lab8.App"]
