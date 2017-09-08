# docker-simple

In order to work with the demo you need to install git and the docker-ce package. For the docker package please follow the instructions on their website.

## Install docker community edition
https://docs.docker.com/engine/installation/linux/docker-ce/centos/

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

# docker-swarm

## Prerequisite
1. The following ports must be available.
  * TCP port 2377 for cluster management communications
  * TCP and UDP port 7946 for communication among nodes
  * UDP port 4789 for overlay network traffic

2. Initialize the docker tcp socket
  * On the master modify the /usr/lib/systemd/system/docker.service unit file to look like this:
```
ExecStart=/usr/bin/dockerd -H 0.0.0.0 -H unix:///var/run/docker.sock
```
  * Restart the docker daemon

## Setup swarm master
```
docker swarm init
docker swarm join-token worker
```

## Setup swarm node
```
docker swarm join --token <worker token> <host>:<port>
```

## Create a new overlay network
```
docker network create --attachable --driver overlay --subnet=10.0.9.0/24 my-net
```

## Start traefik
```
cd docker-swarm/traefik
docker stack deploy -c docker-compose.yml my_traefik
```

## Start the registry
```
cd docker-swarm/registry
docker stack deploy -c docker-compose.yml my_registry
```

## Push your app to the registry
```
docker image ls
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
java-demo           latest              71c5a18f1b7d        19 hours ago        129MB
nginx               alpine              9b0dc474ee71        41 hours ago        15.5MB
traefik             latest              9f1fb114c7da        13 days ago         45MB
registry            2                   751f286bc25e        7 weeks ago         33.2MB
openjdk             8-alpine            478bf389b75b        2 months ago        101MB

docker tag 71c5a18f1b7d registry.sbs.guj.de:443/java-demo
docker push registry.sbs.guj.de:443/java-demo
```

### Test your registry
```
curl -X GET https://registry.sbs.guj.de/v2/_catalog
{"repositories":["java-demo"]}
```

```
curl -X GET https://registry.sbs.guj.de/v2/java-demo/tags/list
{"name":"java-demo","tags":["latest"]}
```
