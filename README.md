# docker-demo

In order to work with the demo you need to install git and the docker-ce package. For the docker package please follow the instructions on their website.
https://docs.docker.com/engine/installation/linux/docker-ce/centos/

## Open ports

## Start the docker service
```
systemctl start docker
systemctl enable docker
```

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

## Install docker-compose
https://docs.docker.com/compose/install/#install-compose
```
export docker_compose_version=1.16.1
curl -L https://github.com/docker/compose/releases/download/$docker_compose_version/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
```

## Start traefik
```
cd traefik
docker-compose up -d
```

## Start nginx
```
cd nginx
docker-compose up -d
```

## Start registry
```
cd registry
docker-compose up -d
```

## Build a docker image for your app
```
cd java-demo
docker build -t java-demo .
docker push registry.sbs.guj.de:443/java-demo
```

# Build a docker swarm
## On the master
```
docker swarm init
docker swarm join-token worker
```

## On the node
```
docker swarm join --token <worker token> <host>:<port>
```
