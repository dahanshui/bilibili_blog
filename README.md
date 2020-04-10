# 个人博客系统（B站）  项目介绍                                                                                                                                                                                                                
一个根据B站视频学习来的个人博客系统，可实现日常的博客发布与展示。
## 演示地址
* 暂时未提供
## 技术栈
* 后台
   * SpringBoot+Jpa+Mysql
* 前端
   * SemanticUI+JQuery+CSS+JavaScript+Thymeleaf
## 功能
* 后台功能
   * 博客发布、更新
   * 博客分类管理
   * 博客标签管理
* 前台功能
   * 博客首页展示（博客最新推荐、博客数量最多的分类及标签）
   * 博客分类展示
   * 博客按标签展示
   * 博客归档
   * 关于我
## 商城设计及应用
* 前后台需求列表
 ![q01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/006tKfTcgy1fk7m27hbn4j31ds0ycdnp.jpg)
 * 数据库实体关系
 ![s01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/实体关系.png)
# 运行源码
## 环境准备
* JDK环境："1.8.0_131"
* 数据库：Mysql 5.5
* 操作系统：Windows
* 依赖：apache-maven-3.5.0
* 开发工具 idea
# 项目运行配置
## 一、idea打开项目（Maven项目）
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/实体关系.png)
* application-dev 开发环境
* application-pro 产品环境
* logback-spring.xml 是日志logback配置文件
* messages.properties 国际化的全局配置文件（可自行定义属性）
## 二、环境配置
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/s02.png)
* 连接数据库配置
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/l01.png)
* 进行日志级别设定
## 数据库导入
* 数据库导入可使用命令行或者客户端工具进行导入---此处不做过多赘述
## tomcat部署
* 使用SpringBoot内嵌的tomcat服务器，不需要配置
# 测试地址
## 前端访问地址
http://localhost:8081
## 后台访问地址
http://localhost:8081/admin
# 打包
## 通过Maven进行打包
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/打包01.png)
## 打包成功后会在target目录下生成一个（项目名.war）的包
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/打包02.png)
# 商城截图
## 前端页面
* 首页
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/首页1.png)
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/首页2.png)
* 登录、注册
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/登录.png)
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/注册.png)
* 产品详情
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/产品详情.png)
* 提交订单
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/fore-提交订单.png)
* 付款
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/支付.png)
* 付款成功
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/付款成功.png)
* 查看订单
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/全部订单.png)
* 同类型产品界面
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/同类型--产品界面.png)
* 购物车
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/购物车.png)
* 模态登录
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/forehome/模态登录.png)
## 后端界面
* 登录、注册
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/后台登陆.png)
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/后台注册.png)
* 分类管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/分类管理.png)
* 图片管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/图片管理.png)
* 属性管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/属性管理.png)
* 产品管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/产品管理.png)
* 属性设置
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/属性设置.png)
* 前台用户管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/前台用户管理.png)
* 后台用户管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/后台用户管理.png)
* 订单管理
![p01](https://github.com/dahanshui/Images/blob/master/tmall_ssm_Images/admin/订单管理.png)
如果你觉得还不错的话，给个星星吧！


















