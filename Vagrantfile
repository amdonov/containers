# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.box = "chef/centos-7.1"

  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false
  
  # Avoid problems with Booz Allen Web Gateway
  config.vm.box_download_insecure = true

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # config.vm.network "forwarded_port", guest: 80, host: 8080

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  # config.vm.synced_folder "../data", "/vagrant_data"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
     vb.memory = "5125"
	 vb.name = "docker_host"
  end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Define a Vagrant Push strategy for pushing to Atlas. Other push strategies
  # such as FTP and Heroku are also available. See the documentation at
  # https://docs.vagrantup.com/v2/push/atlas.html for more information.
  # config.push.define "atlas" do |push|
  #   push.app = "YOUR_ATLAS_USERNAME/YOUR_APPLICATION_NAME"
  # end

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
   config.vm.provision "shell", inline: <<-SHELL
     sudo yum update -y
     sudo yum install -y docker
	 sudo cat > /etc/pki/ca-trust/source/anchors/ca.crt << EOF
-----BEGIN CERTIFICATE-----
MIIDyzCCArOgAwIBAgIBATANBgkqhkiG9w0BAQUFADBrMRwwGgYDVQQKDBNCb296
IEFsbGVuIEhhbWlsdG9uMQwwCgYDVQQLDANCQUgxEDAOBgNVBAcMB0FzaGJ1cm4x
CzAJBgNVBAgMAlZBMQswCQYDVQQGEwJVUzERMA8GA1UEAwwIYXNoYm1jd2cwHhcN
MTMwMTI5MTYwNjMzWhcNMjMwMTI5MTYwNjMzWjBrMRwwGgYDVQQKDBNCb296IEFs
bGVuIEhhbWlsdG9uMQwwCgYDVQQLDANCQUgxEDAOBgNVBAcMB0FzaGJ1cm4xCzAJ
BgNVBAgMAlZBMQswCQYDVQQGEwJVUzERMA8GA1UEAwwIYXNoYm1jd2cwggEiMA0G
CSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCfGLT5CyeBYNJdR/4UbFhnf05lCyjh
KVGrNKAAVwmbwEeKLPdhoghmdUgowsUpN4qcUNWtKPY6wAagZyw3SvW8rIAFbzxq
YsYSGdbCDzpkxZjyOKlXrbBSkaLekcsgvTj9FgbCmZ8kO0Tc/uE53QhIpEkT0gu1
LTLD5HEa5B2tJNufgtOhQesq4wONF/hhS+9itnVnkZLnqQwE7bcy/H426VDBIXWd
o8pPlaEzVtCbN8NUHXUvC/XmfCiB0i/zI9F8KBGXFPumSRVej66DdRv/6cBZN+Q4
5A486hkDxudYJrrcpingZnQLobrmEoC7E3nu/edjTWz+l5tAE/5o043TAgMBAAGj
ejB4MCoGCWCGSAGG+EIBDQQdDBtjZXJ0IGZvciBNY0FmZWUgV2ViIEdhdGV3YXkw
LwYDVR0RBCgwJoEkR09fQ3liZXJfU2VjdXJpdHlfT3BlcmF0aW9uc0BiYWguY29t
MAwGA1UdEwQFMAMBAf8wCwYDVR0PBAQDAgEGMA0GCSqGSIb3DQEBBQUAA4IBAQBV
EZezNi3k5yxj9hfVQyvJAyFJQGPzhOcIVXIB/GjfUd5H2OALrVWoSYTs8U2i0EX7
VPZ9f5ma77xqTDxI7wnV5eqXa4JVr4cFYcFlNFNLqm9itchcdPSNVR0cLNOn0l5M
fDf6bu25yRcK2pGCRd6DsadA7p6NTkKZ1vz6w7BTx5UPaZk5yDG/HBXdfyccxPQZ
/Q3/qouy19c7TCKlhX+siO4ON76hxl4BcWtEiyp5rb/AhkrjGrodiYoBzRqmQecJ
pCrl+1DLRatvOeWDMLxTqT0Mkb1PiK550gBINUz8hPPL4bTH9YVhs5f4EwYzhRFO
69YGt6dt3XehCp4wnzQ2
-----END CERTIFICATE-----
	 EOF
	 sudo update-ca-trust
	 sudo systemctl enable docker
	 sudo systemctl start docker
   SHELL
end
