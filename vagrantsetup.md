Description
-----------
This project is used to setup a VM running Docker for use on the Booz Allen network. Tests of Boot2Docker failed because of certificate issues associated with the Web Gateway. The Vagrant approach also allows easy customization of the VM's networks, port forwarding and file shares.

Installation
------------

 1. Boot to your BIOS settings and confirm that virtualization is enabled.
 2. Install VirtualBox 4.3.12. Later versions have issues with corporate security settings.
 3. Install a recent version of Vagrant. 
 4. Install Git for Windows.
 5. Launch Git BASH and running the following

```
git clone https://github.com/amdonov/containers.git
cd containers
vagrant up
vagrant ssh
