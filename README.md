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
## 系统设计及应用
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
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/开发环境.png)
  * application-dev 开发环境
  * application-pro 产品环境
  * logback-spring.xml 是日志logback配置文件
  * messages.properties 国际化的全局配置文件（可自行定义属性）
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/工具类.png)
  * MarkdownUtils 是将Markdown编辑器的值转换为Html
  * 后面两个是进行简单的MD5加密到数据库
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/错误视图.png)
  * 404 500 以及其他错误就会跳转到相应视图
## 二、环境配置
* 连接数据库配置和日志级别设定
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/dev.png)
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/pro.png)
## 数据库导入
* 数据库导入可使用命令行或者客户端工具进行导入---此处不做过多赘述
## tomcat部署
* 使用SpringBoot内嵌的tomcat服务器，不需要部署
# 测试地址
## 前台访问地址
http://localhost:8081
## 后台访问地址
http://localhost:8081/admin
# 打包
## 通过Maven进行打包
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/打包.png)
## 打包成功后会在target目录下生成一个（项目名.jar）的包
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/jar.png)
# 系统截图
## 前台页面
* 首页
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/index.png)
* 博客详情页面
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/详情页.png)
* 博客分类
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/分类.png)
* 博客标签
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/标签.png)
* 博客归档
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/归档.png)
* 关于我
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/关于我.png)
## 后台界面
* 登录
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/后台登录.png)
* 博客管理
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/博客管理-列表.png)
* 博客发布
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/博客管理-发布.png)
* 分类管理
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/博客分类.png)
* 标签管理
![p01](https://github.com/dahanshui/bilibili_blog/blob/master/show_picture/博客标签.png)
如果你觉得还不错的话，给个星星吧！


















