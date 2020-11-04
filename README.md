# AutoScalability AREP 2020-2 

## Description

  The main goal of this workshop is to introduce AWS autoscaling technique in order to design secure and stable apps. 
  Ref : https://docs.aws.amazon.com/es_es/autoscaling/ec2/userguide/GettingStartedTutorial.html
  For this intro I will use a prime finder app developed in Java.  Primes are used in several routines in information technology, 
  such as public-key cryptography, which relies on the difficulty of factoring large numbers into their prime factors. 
  In abstract algebra, objects that behave in a generalized way like prime numbers include prime elements and prime ideals.
 
## Design 

  This is the intended design for this project
  
  ![com](imgs/comp.jpg)
 
## CI/CD 

This project has continuos integration via 

**CircleCi LoadBalancer** [![CircleCI](https://circleci.com/gh/JohanS11/LAB2-AREP.svg?style=svg)](https://app.circleci.com/pipelines/github/JohanS11/LoadBalancer)

**CircleCi RESTServer** [![CircleCI](https://circleci.com/gh/JohanS11/LAB2-AREP.svg?style=svg)](https://app.circleci.com/pipelines/github/JohanS11/RESTServer)

    
### Class Diagram
  
  **Load Balancer**
  
  ![uml](imgs/classLoad.jpg)
  
  **REST Server**
  
  ![uml](imgs/classRest.jpg)
  
  
## User's guide

  This is the guide that will setup this proyect at your local machine in order to be able to run it.
  
  ### Prerequisites
  
  It is necessary having these tools installed on your computer:
  
  * Docker
  * Docker-compose
  * Git
 
  ### Setting up this project at your local machine

1. **Download these docker images**

```sh
  $ docker pull chan1100/lab5arep
  $ docker pull chan1100/webdocker
```
  
2. **Clone this repository:** 

```sh
  $ git clone https://github.com/JohanS11/LAB5Arep.git 
```

3. **Go to the docker-compose directory**

 ```sh
  $ cd docker-compose
```

4. **Execute the docker-compose.yml file**

 ```sh
  $ docker-compose up -d --scale web=3
```

5. **Now you should be able to see this project at http://ec2-3-82-154-139.compute-1.amazonaws.com:9001/?data=4**

 ### Architecture Description

   You can find the architecture description of this project at [Architecture Description](https://github.com/JohanS11/LAB5Arep/blob/master/LAB5Arep.pdf)

   ### Testing the application
   
   ***Web App running on AWS with the describedarchitecture ***
   
   ![uml](imgs/web.jpg)
   
   
   ***Load Balancing logs***
   
   ![uml](imgs/loadBalancing.jpg)
   
   ***docker images and docker container ls on the EC2 instance***
   
   ![uml](imgs/IMAGES.jpg)
       
  ## This project was built with:
  
   - Apache Maven 3.6.3
   - Docker 
   - Spark web
   - Java 1.8.0_211
   - Git 2.26.2
   - AWS (EC2)
   
  ## Docker Cheat Sheet
  
  ***List all containers***
  
 ```sh
  $ docker container ls 
  $ docker ps -a (List all containers not just running)
```

***List all images***
  
  ```sh
  $ docker images  
```

***Build an image from the Dockerfile***
  
  ```sh
  $ docker build -t <myimage> 
```
***Run a container***

  ```sh
  $ docker run -d -p <localport>:<containerport> --name firstdockercontainer <image> 
```
***Run a docker-compose with 3 instances of web***

```sh
  $ docker-compose up -d --scale web=3
```

***Get a shell into the container***

```sh
  $ docker exec -it <docker ID> /bin/bash
```
[Here is a batch scrip to reset all the stuff :=)](https://github.com/JohanS11/LAB5Arep/blob/master/docker-compose/docker-reset.sh)
  
   
  ## Author
  
  Johan Sebastian Arias Amador ([JohanS11](https://github.com/JohanS11))
  
  ## License
  
  This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](https://github.com/JohanS11/LAB2-AREP/blob/master/LICENSE) file for more details.
