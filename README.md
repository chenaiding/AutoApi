使用说明
-----------------
### 基于jmeter接口自动化脚本
    1、下载jmeter脚本到本地，并使用jmeter打开。
    2、修改脚本中的csv文件中的路径，改成自己电脑上存放的路径。
    3、修改脚本中的host地址，改成自己待测试的接口host。
    4、下载沛合对接.csv文件,并修改里面的内容改成自己的接口测试用例。
    5、运行脚本。

### 基于java语言接口自动化脚本
    1、下载源码到本地，并使用idea打开。
    2、修改application.properties文件中的接口url和路径。
    3、本地准备一个数据库并建一张表，用来存放自己的测试用例。
        举例：CREATE TABLE `check_balance` (
        `id` int(10) NOT NULL,
        `param` varchar(10000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
        `expect` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
        `create_time` datetime(3) DEFAULT NULL,
        PRIMARY KEY (`id`);
    4、修改databaseConfig.xml中数据库连接地址和数据库的登录账户和信息。
    5、运行testNG.xml。


