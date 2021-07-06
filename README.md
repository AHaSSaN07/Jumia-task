# Jumia-task

This repo contains jumia's phone service implementation, both front-end and back-end.

###### to build an image of back-end run the below command in the main repository directory :

> docker build  -t jumia_task .

###### then run the below to start a container:

> docker run -p 8080:8080 jumia_task


###### to build an image of front-end , navigate to front-end directory then run the below command:

> docker build -t front-end .

###### then run the below to start a container:

> docker run -p 3000:3000 front-end

the application should be running on
> localhost:30000
