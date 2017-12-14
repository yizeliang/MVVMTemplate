# MVVMDEMO


## 说明

这个项目属于尝试阶段,目前还在完善阶段.
原本想着能用于公司的下个项目,但是目前还是不会使用,待找个小项目实际运用一下,再正式使用

## 框架选择

- kotlin
- rxjava+rxAndroid
- (mvvm)databinding
- okhttp3+retrofit2
- Glide
- PullToRefreshLayout

## 存在的问题

- 自定义View或者常用View的 属性映射(待完成,还是挺多需要写的)
- 当映射的属性值没有变化时,是不会执行映射的方法的 (cn.yzl.mvvmdemo.ui.pullrefresh.ActivityPullRefreshRvVM)

## 规范

为了防止
`Warning:Application namespace for attribute bind:imageUrl will be ignored`
这样的警告,自定义bindding adapter 命名一律采用bind_开头 而不是bind:






