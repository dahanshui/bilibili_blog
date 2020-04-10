/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.15 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (73),(73),(73),(73),(73);

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL,
  `appreciation` bit(30) NOT NULL,
  `commentabled` bit(30) NOT NULL,
  `content` longtext,
  `create_date` datetime DEFAULT NULL,
  `first_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `published` bit(30) NOT NULL,
  `share_statement` bit(30) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `recommend` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK292449gwg5yf7ocdlmswv9w4j` (`type_id`),
  KEY `FK8ky5rrsxh01nkhctmo7d48p82` (`user_id`),
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`),
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`appreciation`,`commentabled`,`content`,`create_date`,`first_picture`,`flag`,`published`,`share_statement`,`title`,`update_date`,`views`,`type_id`,`user_id`,`recommend`,`description`) values (20,'\0\0\0\0','\0\0\0\0','<p>内容丰富</p>\n',NULL,'https://picsum.photos/id/1005/800/450','翻译','\0\0\0','\0\0\0','用户故事','2020-04-10 08:18:34',NULL,1,1,'','1'),(21,'\0\0\0\0','\0\0\0\0','<p>1111111</p>\n','2020-03-17 12:32:51','https://picsum.photos/id/1005/800/450','原创','\0\0\0','\0\0\0\0','数据格式','2018-03-17 12:32:51',4,2,1,'','1'),(22,'\0\0\0','\0\0\0','<p>1</p>\n','2020-03-17 12:35:15','https://picsum.photos/id/1005/800/450','转载','\0\0\0','\0\0\0','度护甲','2020-04-10 08:22:26',5,3,1,'','1'),(23,'\0\0\0\0','\0\0\0\0','<p>哈哈哈哈11111</p>\n','2020-03-18 17:18:53','https://picsum.photos/id/1005/800/450','原创','\0\0\0','\0\0\0\0','陈','2017-01-18 09:19:06',3,2,1,'','1'),(26,'\0\0\0\0','\0\0\0','<pre><code class=\"language-java\">    public static void main(String[] args) {\n        SpringApplication.run(DemoJdbcApplication.class, args);\n    }\n    //这里配置静态资源文件的路径导包都是默认的直接导入就可以\n    @Override\n    protected void addResourceHandlers(ResourceHandlerRegistry registry) {\n        registry.addResourceHandler(&quot;/static/**&quot;).addResourceLocations(ResourceUtils\n        .CLASSPATH_URL_PREFIX + &quot;/static/&quot;);\n        super.addResourceHandlers(registry);\n    }\n</code></pre>\n<h1 id=\"最强解决方案\">最强解决方案</h1>\n<p>js，css文件导入项目后先重新启动软件， 保证编码格式正确js引入加入type=“text/javascript” css引入加入rel=“stylesheet” 重启idea软件 重启idea软件 重启idea软件 重要的事情说三遍</p>\n<p>每次导入新的css和js都要重新启动。</p>\n<p>重启后还是报错再看下面方法** 如若还是不行请加上下方第一步操作</p>\n<p>可能这个问题折磨的你都要炸了，尤其是刚开始接触这个问题真的感觉太神奇了，还有这种操作。</p>\n<p>不着急我们进入主题。 先说说为什么导不进去,心急的同学可以直接查看解决方法</p>\n<p>出现这个问题是springboot在启动的时候没有带上static下的js和css文件一起跑，还有可能出现只带一部分跑，楼主就踩的是第二个雷 //安利一下就是有些可以正常导入，有些不可以 楼主把解决这个问题的步骤，记录下来。为大家奉上 下面是解决问题时间， 先把项目关闭</p>\n<h2 id=\"no1\">No.1</h2>\n<p>在springboot自身带有的那个(项目名+Application)类中继承WebMvcConfigurationSupport重写里面的addResourceHandlers方法 在这里可以理解为配置在项目启动时扫描static下面的所有文件，也就是告诉springboot在启动的时候带上他们全部一起跑。//贴上代码</p>\n<p>/*\nApplication文件路径发生变化，要重新配置Bean组件的扫描信息\n*/\n@SpringBootApplication\npublic class DemoJdbcApplication extends WebMvcConfigurationSupport {</p>\n<pre><code>public static void main(String[] args) {\n    SpringApplication.run(DemoJdbcApplication.class, args);\n}\n<p>//这里配置静态资源文件的路径导包都是默认的直接导入就可以\n@Override\nprotected void addResourceHandlers(ResourceHandlerRegistry registry) {\nregistry.addResourceHandler(&quot;/static/**&quot;).addResourceLocations(ResourceUtils\n.CLASSPATH_URL_PREFIX + &quot;/static/&quot;);\nsuper.addResourceHandlers(registry);\n}\n</code></pre></p>\n<p>}</p>\n<h2 id=\"no2\">No.2</h2>\n<p>//js和css引入一定要注意编码格式规范加入type=&quot;text/javascript&quot;和rel=&quot;stylesheet&quot;这个也可能是导致这个错误的原因， 在扫描不到的js文件或者css文件上加入/static整成相对路径还有就是因为我们扫描的时候就带上了static 不写可能还是扫描不到 尝试的时候可以先把其他的注掉就先试一个 改正完成后先重启软件重新启动看页面信息 如若还是不好使 看终极第三部</p>\n<h2 id=\"no3\">No.3</h2>\n<p>在页面中的html标签中加入th标签库使用thymeleaf为我们提供的引入页面工具</p>\n<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n然后将src href路径改成这种格式 <link th:href=\"@{/static/js/bootStrap-addTabs/bootstrap.addtabs.css}\" rel=\"stylesheet\">\n<p>最后完美的按照步骤执行下来还是没有解决的话一定要记得重启一次， 还是不行回过头来看看路径到底有没有错。</p>\n<p>是不是感觉很神奇？没错就是这样的。</p>\n<p>Over~</p>\n','2020-03-19 06:12:13','https://picsum.photos/id/1005/800/450','原创','\0\0\0\0','\0\0\0\0','SpringBoot','2020-04-10 08:24:18',13,1,1,'','SpringBoot 前台页面get不到js,css文件 版权声明：本文为博主原创文章，遵循 CC 4.0 by-sa 版权协议，转载请附上原文出处链接和本声明。 本文链接：https://blog.csdn.net/YiQieFuCong/article/details/85009401 ......'),(27,'\0\0\0\0','\0\0\0\0','<h1 id=\"进行数据的增删改查\">进行数据的增删改查</h1>\n<h2 id=\"h1\">h1</h2>\n<p>可能这个问题折磨的你都要炸了，尤其是刚开始接触这个问题真的感觉太神奇了，还有这种操作。</p>\n<p>不着急我们进入主题。 先说说为什么导不进去,心急的同学可以直接查看解决方法</p>\n<p>出现这个问题是springboot在启动的时候没有带上static下的js和css文件一起跑，还有可能出现只带一部分跑，楼主就踩的是第二个雷 //安利一下就是有些可以正常导入，有些不可以 楼主把解决这个问题的步骤，记录下来。为大家奉上 下面是解决问题时间， 先把项目关闭</p>\n<h2 id=\"h2\">h2</h2>\n<p>在springboot自身带有的那个(项目名+Application)类中继承WebMvcConfigurationSupport重写里面的addResourceHandlers方法 在这里可以理解为配置在项目启动时扫描static下面的所有文件，也就是告诉springboot在启动的时候带上他们全部一起跑。//贴上代码</p>\n','2020-03-19 06:26:19','https://picsum.photos/id/1005/800/450','翻译','\0\0\0','\0\0\0','chenhuang','2018-03-19 06:26:19',12,2,1,'','在springboot自身带有的那个(项目名+Application)类中继承WebMvcConfigurationSupport重写里面的addResourceHandlers方法 在这里可以理解为配置在项目启动时扫描static下面的所有文件，也就是告诉springboot在启动的时候带上他们全部一起跑。//贴上代码');

/*Table structure for table `t_blog_tags` */

DROP TABLE IF EXISTS `t_blog_tags`;

CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`),
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`),
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_tags` */

insert  into `t_blog_tags`(`blogs_id`,`tags_id`) values (23,15),(27,15),(20,1),(20,15),(20,17),(22,1),(26,15);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL,
  `admin_user` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  KEY `FKjt3xywsr7iscyfan44ul06v6a` (`comment_id`),
  CONSTRAINT `FKjt3xywsr7iscyfan44ul06v6a` FOREIGN KEY (`comment_id`) REFERENCES `t_comment` (`id`),
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`avatar`,`content`,`create_date`,`email`,`nickname`,`blog_id`,`comment_id`,`admin_user`) values (63,'/images/avatar.png','这是一个测试评论1','2020-03-25 12:10:46','2720@qq.com','大汗水',27,NULL,'\0'),(64,'/images/avatar.png','测试评论2','2020-03-25 12:11:04','2720@qq.com','小白',27,NULL,'\0'),(65,'/images/avatar.png','测试评论3','2020-03-25 12:11:20','2720@qq.com','小红',27,63,'\0'),(66,'/images/avatar.png','测试评论4','2020-03-25 12:13:15','2720@qq.com','小明',27,64,'\0'),(67,'/images/avatar.png','回复小红的评论','2020-03-25 12:15:49','2720@qq.com','小明',27,65,'\0'),(68,'/images/avatar.png','这是小黄的评论','2020-03-25 12:16:28','2720@qq.com','小黄',27,NULL,'\0'),(69,'/images/avatar.png','哈哈哈哈','2020-03-25 15:05:46','1@qq.com','小花',27,63,'\0'),(70,'/images/avatar.png','你是小花吗？','2020-03-25 15:06:11','122@qq.com','小名',27,69,'\0'),(71,'https://picsum.photos/id/1005/100/100','这是博主的评论','2020-03-25 15:17:30','123@qq.com','大汗水',27,68,''),(72,'https://picsum.photos/id/1005/100/100','博主发表评论','2020-03-25 15:17:42','123@qq.com','大汗水',27,NULL,'');

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tag` */

insert  into `t_tag`(`id`,`name`) values (1,'Java开发'),(15,'javaScript'),(17,'日志处理');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values (1,'javaScript'),(2,'css和html'),(3,'错误日志'),(5,'Java'),(6,'前端开发');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`avatar`,`create_date`,`email`,`password`,`type`,`update_date`,`username`,`nickname`) values (1,'https://picsum.photos/id/1005/100/100','2020-03-11 22:45:49','123@qq.com','202cb962ac59075b964b07152d234b70',1,'2020-03-11 22:45:46','123','大汗水');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
