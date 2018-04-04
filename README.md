# haidaojobs

海岛兼职服务器代码设计
采用SSM框架

## cn/clvstudio
	为蠢驴工作室通用代码模块
	
## /com/clv
    为该项目特有模块
    
### /server
	业务模块的逻辑业务设计
	/user
	用户版的独有功能
	/merchant
	商家版的独有功能
	/admin
	管理员（代理商）版独有功能
	/job
	工作（兼职/实习）相关功能
	/tool
	各实现工具
	
### /mapper(dao)
	数据持久层，负责与数据库进行联络
	
### /controller
	业务模块的流程控制
	
### /model
	数据模型
	
## /com/mysubmail
    赛邮提供的短信接口
    
## /mapper
	mapper实现
	
## WebContent(View)
	 展示层，负责前台页面的表示
	 
## WebContent/WEN-INF

### /classes
	SSM框架的配置文件
### /lib
	各种jar包
	
-----------------------------------

*   开发团队: 蠢驴工作室
