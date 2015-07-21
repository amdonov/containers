## Documentation for Microservices and Containerization
This is the the intern project during the summer of 2015, focusing on creating microservices with containers.
Kubernetes and Docker were utilized in conjunction with Vagrant.

* Written by Felix Cao, George Luo, Kevin Wu
* Booz Allen Hamilton
* Updated July 2015

## 1. Installation

1. Boot to your BIOS settings and confirm that virtualization is enabled.
2. Install VirtualBox 4.3.12. Later versions have issues with corporate security settings.
3. Install a recent version of Vagrant.
4. Install Git for Windows.
5. Launch Git BASH

Run these in command line:

```
git clone https://github.com/amdonov/containers.git
cd containers
vagrant up	
vagrant ssh
```
"vagrant up" reads the Vagrantfile.
"vagrant ssh" logs you in.


## 2. Create a Service
You can pull services from https://github.com/amdonov/containers/

Use "currency" for the simplest service

## 3. Test your Service in a Container
If you would like, you can test your service. This step is optional.
```
cd /vagrant/
docker built -t "name_of_app" .
docker run --name "instance_name" -d -p 192.168.56.30:80:8080
```
Test your service on:
```
java.test.com/
go.test.com/
node.test.com/
```

If you need to delete your images:
```
docker stop $(docker ps -qa)
docker rm $(docker ps -q -q)
docker rmi $(docker images -q)
```

## 4. Set up Kubernetes
You need to create two separate folders, with one titled "master" and the other "minion". A Vagrantfile needs to be in each. Launch GitBash for each.

You may use the master and minion folder from GitHub; if you do so, the following steps are done automatically when you vagrant up, so proceed to step 5.

Follow these instructions:
```
http://www.severalnines.com/blog/installing-kubernetes-cluster-minions-centos7-manage-pods-services

```
Instead of installing kubernetes in step 1 for master and minion, do the following steps for each:
```
yum install -y http://cbs.centos.org/kojifiles/work/tasks/5142/15142/kubernetes-node-0.19.0-0.4.gita8269e3.el7.x86_64.rpm
yum install -y http://cbs.centos.org/kojifiles/work/tasks/5142/15142/kubernetes-master-0.19.0-0.4.gita8269e3.el7.x86_64.rpm
yum install -y http://cbs.centos.org/kojifiles/work/tasks/5142/15142/kubernetes-0.19.0-0.4.gita8269e3.el7.x86_64.rpm
```

## 5. Link Docker and Github
Push you your service to GitHub.

Set up an Automated Build Repository, link your git.

Wait for build to finish.

## 6. Start Master and Minions
Start Master first, then the Minions from the website instructions.

If there are errors (normally on minion), run this line:
```
sudo systemctl start etcd
```

Reboot your master and minion and start them again from website instructions.
```
sudo poweroff
vagrant up
vagrant ssh
```
If there are any problems in later steps, rebooting helps solve most problems.


##### Diagnostics
Returns the minions and the state of the minions
```
kubctl get nodes 
```
Returns the pods created and their state
```
kubctl get pods
```
Returns the services running and the 10-dot-IP address at the server
```
kubectl get services 
```
Returns the replica controllers create by Kubernetes
```
kubectl get rc 
```
Returns performance/environment information
```
kubectl describe [typeofobject] [nameofobject]
```
************************************************************************

## 7. Create a Replication Controller Manually
Creates a replica controller that guarantees three running instances of the indicated image. The second line is an example code:
```
kubectl run-container [nameofcontainer] --image=[dockerlocation] --replicas=3 --port=[####]
kubectl run-container currency1 --image=kevinkwu/currency --replicas=3 --port=8080
```
Wait for pods to pull from docker. You can check the status using the diagnostics for the pods (kubectl get pods).

Once they complete:
```
kubectl expose rc [nameofcontainer] --port=[##] --target-port=[####] --public-ip=192.168.50.131 
kubectl expose rc currency1 --port=81 --target-port=8080 --public-ip=192.168.50.131
```

##### How to delete pods
```
kubectl delete pods --all
kubectl stop rc --all
```
If you made a json file:
```
kubectl create -f [nameoffile].json
```

## 8. Test the Website 
Enter the addresses into a browser.

With a port number:
```
192.168.50.131:portnumber/[service]
```
```

Without a port number:
```
192.168.50.131/[service]
```