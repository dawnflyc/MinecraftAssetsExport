# **MinecraftAssetsExport**

#### 介绍

这是一套导出Minecraft资源文件的项目，游戏目录Assets里面经过hash排序的资源文件。

#### 原理

assets下indexes文件夹下有着hash排序的json格式对照表。

assets下objects下便是hash排序后的文件。

只需要解析json文件，找到对应的排序后文件，验证然后重命名再导出到导出文件夹里即可。

原理非常简单，但是手工整理非常麻烦。

开发MC周边会多处用到这些文件，比如音乐文件等。

