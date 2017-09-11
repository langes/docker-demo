# docker-demo
This demo comes with a vagrantfile to deploy a small lab. The basic configuration is done with ansible.

**Currently this vagrant setup requires vmware_fusion and a valid license for the vagrant vmware plugin.**
**This setup is not production ready, please consider that if you use it.**

## Basic vagrant commands
### Run the boxes
```
vagrant up
```

### Current machine states
```
vagrant status
```

### SSH into the machines
```
vagrant ssh <machine name>
```

### Delete the machines
```
vagrant destroy
```
 

## docker-simple
Contains all necessary docker-compose files to create a proxy with some example services. Everything runs on the same host for an easy start.

## docker-swarm
A setup for a small docker swarm cluster.
