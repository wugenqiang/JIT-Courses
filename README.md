# 课程攻略共享计划
金陵科技学院课程攻略共享计划，欢迎贡献

## 下载文件注意项

当想下载单个文件查看时，可以进入相应的界面，如下图所示，如果提示下载就可以从这里下载

![image-20200424103123091](https://gitee.com/wugenqiang/PictureBed/raw/master/CS-Notes/20200424103125.png)

但是当你点击的时候会出现：

![image-20200424103241526](https://gitee.com/wugenqiang/PictureBed/raw/master/CS-Notes/20200424103242.png)

别慌！我们有办法：

以 `https://raw.githubusercontent.com/wugenqiang/JIT-Courses/master/软件项目管理与案例分析/ppt课件/第10章.ppt` 这个路径为例，将 `https://raw.githubusercontent.com/wugenqiang/JIT-Courses/master` 改为 `https://wugenqiang.github.io/JIT-Courses` 即可，看下图演示：

![](https://gitee.com/wugenqiang/PictureBed/raw/master/CS-Notes/20200424103814.gif)

好啦，尽情的畅游在知识的海洋里吧！

## 上传文件注意项

文件上传，单个文件不大于 50 M，需要压缩，如果还是不行，可以同邮件把文件发给我，我来处理，邮箱：18360861937@163.com 感谢大家一起来完善这个共享计划，让更多的学生受益！

如果不小心真的提交了，但是不知道如何操作的话，参考下面：

我自己处理的方式是回退到提交之前的版本：

（1）步骤一：查看版本号  git reflog，按 q 即退出

![image-20200424101858784](https://gitee.com/wugenqiang/PictureBed/raw/master/CS-Notes/20200424101859.png)

比如说回退到 016a39b 版本

（2）步骤二：执行命令 git reset --hard 版本号

例如：git reset --hard 016a39b 即可

（3）步骤三：重新提交文件上传，记住单个文件不能大于 50 M 