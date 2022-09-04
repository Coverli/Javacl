package com.Advance.Collection;

// 集合概述
public class statement {
    /*
        集合本质是基于某种数据结构数据容器。常见的数据结构：数组（Array）、集（Set）、
        队列（Queue）、链表（Linkedlist）、树（Tree）、堆（Heap）、栈（Stack）和映射（Map）等结构。

        Java中提供了丰富的集合接口和类，它们来自于java.util包。如下图所示是Java主要的集合接口和类，
        从图中可见Java集合类型分为：Collection和Map，
        Collection子接口有：Set、Queue和List等接口。
        每一种集合接口描述了一种数据结构。图中只列出了绍List、Set和Map这三个接口的具体实现类，
        事实上Queue也有具体实现类，由于很少使用，这里不再赘述，可以自己查询API文档。

                            <<Java Interface>>                                      <<Java Interface>>
                              Collection <E>                                            Map<K,V>
                              ^     ^     ^                                                 ^
                              |     |     |                                                 |
                 -------------      |     ---------------                                   |
                 |                  |                   |                                   |
        <<Java Interface>>   <<Java Interface>>  <<Java Interface>>                         |
             List<E>              Queue<E>             Set<E>                               |
       接口      ^  ^                                     ^                                  |
                |  |-----------------|                   |                                  |
          ------|--------------------|-------------------|----------------------------------|------------
     实现类      |                    |                   |                                  |
          <<Java Class>>       <<Java Class>>      <<Java Class>>                     <<Java Class>>
          LinkedList<E>         ArrayList<E>        HashSet<E>                          HashMap<K,V>

          提示：在Java SE中List名称的类型有两个，
          一个是java.util.List，另外一个是java.awt.List。
          java.util.List是一个接口，List集合。
          java.awt.List是一个类，用于图形用户界面开发，它是一个图形界面中的组件

          提示：学习Java中的集合，首先从两大接口入手，重点掌握List、Set和Map三个接口，
          熟悉这些接口中提供的方法。然后再熟悉这些接口的实现类，并了解不同实现类之间的区别。
    */
}
