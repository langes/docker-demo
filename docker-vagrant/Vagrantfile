# -*- mode: ruby -*-
# vi: set ft=ruby :


nodes = [
  { hostname: 'box1', box:'bento/centos-7', storagectl:'IDE Controller',osmajor:'7' },
  { hostname: 'box2', box:'bento/centos-7', storagectl:'IDE Controller',osmajor:'7' },
  { hostname: 'box3', box:'bento/centos-7', storagectl:'IDE Controller',osmajor:'7' },
]

Vagrant.configure(2) do |config|
  config.vm.provider "vmware_fusion"
  config.hostmanager.enabled = true
  config.ssh.insert_key = false
  
  nodes.each do |node|
    vagrant_root = File.dirname(__FILE__)

    vdiskmanager = '/Applications/VMware\ Fusion.app/Contents/Library/vmware-vdiskmanager'

    config.vm.define node[:hostname] do |node_config|
      node_config.vm.box = node[:box]
      node_config.vm.hostname = node[:hostname]

      node_config.vm.provider :vmware_fusion do | vmw |
        vmw.vmx['memsize'] = '3072'
      end
    
      config.vm.provision "ansible_local" do |ansible|
        ansible.playbook = "playbook.yml"
#        ansible.verbose = true
      end

    end
  end
end
