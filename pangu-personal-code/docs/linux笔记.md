# Linux 笔记

### 1、-bash: rz: command not found

> 【解决方法】安装lrzsz,使用命令： `yum install lrzsz` 等待执行完毕即可使用

### 2、查看所有用户信息

> 【解决方法】使用命令 ： `cat /etc/passwd`

### 3、解压 .tar.gz 文件

> 【解决方法】使用命令 ： `tar zxvf xxxx.tar.gz`

### 4、查看有那些可以安装的open jdk 版本信息

> 【解决方法】使用命令 ： `yum search java|grep jdk`

### 5、安装openjdk

> 【解决方法】使用命令 ： `yum install java-1.8.0-openjdk`

### 6、查看系统是否安装完整vim

> 【解决方案】使用命令 : `rpm -qa|grep vim`

### 7、开放服务器的端口相关

> 【解决方案】使用命令 : 查看：`sudo firewall-cmd --zone=public --list-ports`

> 【解决方案】使用命令 : 开放8081端口：`sudo firewall-cmd --zone=public --add-port=8081/tcp --permanent`

> 【解决方案】使用命令 : 重新启动防火墙：`sudo firewall-cmd --reload`

### 8、-bash: netstat: command not found or -bash: ifconfig: command not found

> 【解决方案】使用命令 : `yum -y install net-tools`

### 9、查看8081端口占用的进程

> 【解决方案】使用命令 : `netstat -tunlp | grep 8081`

### 10、

> 【解决方案】使用命令 : ``