# ModuleTest
多模块多组件的项目,针对不同业务情形下的组件化/模块化解决方案,无论是新项目.刚起步的项目,还是耦合严重的旧项目 目标希望提供一种通用方案

传统mvp如我们所知 在model中获取数据 通常调用retrofit的api再调用rxjava 将回调统一 回调包裹返回的数据类型 经过一系列的事件 不同线程的处理 后拿到数据类型
对象 

presenter控制层 通常依赖view层和model层   完成model回调view的操作

view层 我们通常让activity/fragment实现view的接口  依赖于presenter 让presenter来请求数据 并传入api执行所需的参数

实现mvp的主要目的是解耦 将职责分出去 让activity/fragment的压力不会太重 而实际使用来看 我们的一些业务复杂的页面还是到达了千行代码的量级

显然这样的解耦是力度不够的 众所周知activity作为view来说 职责不够纯粹 因为他有自身的生命周期 无论是数据和控制层都要随生命周期 周转

如果能将生命周期的监听分发出去 那么就可以有新的一层或者复用旧层为activity分忧 谷歌发现了这个问题推出了lifecycle和livedata

通过注册监听的方式 可以将生命周期执行分发出去 我们的项目在这基础之上(针对于模块化复用的条件下) 甚至将view也从activity中分离 看看实际activity的代码

```java
public class QrcodeTestActivity extends BaseLifecycleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarTransparent(this);
        AlliancePage alliancePage=new AlliancePage(this,null);
        setContentView(alliancePage);
    }
    
}
```

只需要setview 刷新页面里的数据即可 无需关心内部的实现 这在多模块开发中是非常方便的

我近期在为某旧APP做新的版本 同时旧APP和新APP都要同步一个新的项目模块 这个模块是内嵌在app里的 

这种情况下 代码的复用就显得尤为重要 几乎能提升一倍的效率 目前该项目 在独立模块下 开发 测试也是在独立开的application模块下

并将模块打成aar上传到公司的maven库中 其他组成员使用的时候 只需依赖这个库  compile 'module.chenhong.com:testmodule:1.0.0@aar'

像上述代码一样setpage在所需的载体中 即可 数据的加载和处理 都是在内部进行 也很好的同步了生命周期 避免内存泄漏

接下来需要维护的就是 模块提供给外部的接口 还有模块间调用服务 模块间传递数据 等





















