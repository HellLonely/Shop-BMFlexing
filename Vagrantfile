# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure("2") do |config|

  config.vm.box = "ubuntu/mantic64"
  config.vm.hostname = "bmflexing"

  config.vm.provider "virtualbox" do |vb|
    vb.name = "BMFlexing - Server VM"
    # vb.gui = true
    vb.cpus = 1
    vb.memory = "1024"
  end
  
  config.vm.network :forwarded_port, guest: 3306, host: 3307
  config.vm.network "private_network", ip: "192.168.0.100"

  config.vm.provision "shell", inline: <<-SHELL
    # Actualizar repositorios e instalar MySQL Server
    sudo apt-get update
    sudo apt-get install -y mysql-server
    sudo apt install python3.10
    sudo apt install git
    # Configurar MySQL para permitir conexiones externas
    sudo sed -i "s/bind-address.*/bind-address = 0.0.0.0/" /etc/mysql/mysql.conf.d/mysqld.cnf
    sudo service mysql restart

    # Crear un usuario y una base de datos de ejemplo
    sudo mysql -e "CREATE DATABASE administration"
    sudo mysql -e "CREATE DATABASE bicicletas"
    sudo mysql -e "CREATE USER 'developer'@'%' IDENTIFIED BY 'developer'"
    sudo mysql -e "CREATE USER 'appconector'@'%' IDENTIFIED BY 'appconector'"
    sudo mysql -e "GRANT ALL PRIVILEGES ON *.* TO 'developer'@'%' with grant option"
    sudo mysql -e "GRANT INSERT, DELETE, UPDATE, SELECT ON bicicletas.* TO 'appconector'@'%'"
    sudo mysql -e "FLUSH PRIVILEGES"
  SHELL
end
