# docker-swarm

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
**You need to change the ip address for the parameter --docker.endpoint=tcp://192.168.145.144:2375 in the docker-compose.yml.**
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
