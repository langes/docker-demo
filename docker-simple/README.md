# docker-simple

## docker basic commands
### Some basic docker commands
```
docker ps -a
docker inspect <container id>
docker exec -it <container id> sh
docker kill
docker rm
```

### Some basic docker-compose commands
```
docker-compose up -d
docker-compose down
docker-compose scale <service name>=<number of instances>
```

## Exercise
Use vagrant to ssh into box1 and start the diffrent containers.

### vagrant ssh
```
vagrant ssh box1
```

### Start traefik
```
cd /vagrant/docker-simple/traefik
docker-compose up -d
```

### Start nginx
```
cd /vagrant/docker-simple/nginx
docker-compose up -d
```

### Start registry
```
cd /vagrant/docker-simple/registry
docker-compose up -d
```

### Build a docker image for your app
```
cd /vagrant/docker-simple/java-demo
docker build -t java-demo .
docker-compose up -d
```
