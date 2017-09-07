# docker-demo

In order to work with the demo you need to install git and the docker-ce package. For the docker package please follow the instructions on their website.
https://docs.docker.com/engine/installation/linux/docker-ce/centos/


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
