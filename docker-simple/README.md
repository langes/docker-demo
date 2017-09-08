# docker-simple

## Some basic docker commands
```
docker ps -a
docker inspect <container id>
docker exec -it <container id> sh
docker kill
docker rm
```

## Some basic docker-compose commands
```
docker-compose up -d
docker-compose down
docker-compose scale <service name>=<number of instances>
```

## Start traefik
```
cd docker-simple/traefik
docker-compose up -d
```

## Start nginx
```
cd docker-simple/nginx
docker-compose up -d
```

## Start registry
```
cd docker-simple/registry
docker-compose up -d
```

## Build a docker image for your app
```
cd docker-simple/java-demo
docker build -t java-demo .
```
