# IMA management
IMA人员管理
  
项目需求：  
1. 部员和部长都可以登陆系统，部长可以进行部员的增删查改等等操作，部员则只能进行查询操作  
2. 分为六个部门，除了增删查改操作外，还需要有部门变动的功能  
3. 部员要包含 姓名 学号 电话 qq等信息  
4. 加入日志功能，可以存储操作日志  
  
项目环境：  
Java SE ------jdk8  
MySQL   ------mysql8  
IDE     ------IntelliJ IDEA 2018.2.3 (Ultimate Edition)  

项目结构：  
.  
├── .idea                                                  //IDEA默认配置文件夹  
├── resources                                              //资源目录  
│   └── execute.sql                                        //初始化SQL  
├── src                                                    //源代码目录  
│   ├── META-INF                                           
│   │   └── MANIFEST.MF                                    //信息包  
│   └── cn                                                 
│       └── albumenj                                       
│           ├── dao                                        //数据访问对象  
│           │   ├── ConnectionPool                         //连接池  
│           │   │   ├── ConcurrencySubmit.java             //多线程提交请求  
│           │   │   ├── ConnectionConfig.java              //数据库连接配置文件  
│           │   │   ├── DataCallback.java                  //数据回调接口  
│           │   │   ├── IMyPool.java                       //线程池接口  
│           │   │   ├── MyPollImpl.java                    //线程池具体实现  
│           │   │   ├── PoolSubmit.java                    //数据提交到连接池队列  
│           │   │   └── PooledConnection.java              //数据库具体访问  
│           │   ├── LogCommit.java                         //日志提交  
│           │   └── SqlCommit.java                         //数据增删查改提交  
│           ├── model                                      //模型  
│           │   ├── LogModel.java                          //日志模型  
│           │   ├── ResultModel.java                       //数据结果模型  
│           │   ├── department.java                        //部门模型  
│           │   └── user.java                              //用户模型  
│           ├── service                                    //服务  
│           │   ├── DepartmentService.java                 //部门数据服务  
│           │   └── UserService.java                       //人员数据服务  
│           ├── util                                       //工具  
│           │   ├── FlushPage.java                         //清屏  
│           │   ├── PasswordDecode.java                    //密码加密  
│           │   ├── PrintLine.java                         //分割线打印  
│           │   ├── Regex.java                             //正则表达式检测  
│           │   └── RequestEnter.java                      //获取输入  
│           ├── view                                       //页面  
│           │   ├── DepertmentPage                         //部门页面  
│           │   │   ├── AddDepartmentPage.java             //增加部门页面  
│           │   │   ├── DeleteDepartmentPage.java          //删除部门页面  
│           │   │   ├── ListDepartmentPage.java            //列举部门页面  
│           │   │   └── ModifyDepartmentPage.java          //修改部门页面  
│           │   ├── MenuPage                               //菜单页面  
│           │   │   ├── DepartmentManageMenu.java          //部门管理页面  
│           │   │   ├── LoginPage.java                     //登录页面  
│           │   │   ├── MenuPage.java                      //主菜单页面  
│           │   │   └── StaffManagePage.java               //人员管理页面  
│           │   └── StaffPage                              //人员页面  
│           │   │   ├── AddStaffPage.java                  //增加人员页面  
│           │   │   ├── DeleteStaffPage.java               //删除人员页面  
│           │   │   ├── ListStaffPage.java                 //列举人员页面  
│           │   │   └── ModifyStaffPage.java               //修改人员页面  
│           └── Application.java                           //主程序逻辑实现  
├── README.md                                              //项目说明文件  
└── IMA management.iml                                     //IDEA项目文件  
  
项目默认配置：  
默认学号：1  
默认密码：1  
