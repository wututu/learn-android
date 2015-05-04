JNIDemo
=======

1. 创建一个JNIDemo的Android工程
2. 在项目下创建一个文件夹jni。（注意必须是jni目录）
3. 在jni目录下创建两个文件：Android.mk 和 first_jni.c(.c文件的名字可以任意)
4. 编写Android.mk文件：(参见Demo当中的Androd.mk文件)
     - LOCAL_MODULE    := firstjni  （决定编译出来的so文件的名字）
     - LOCAL_SRC_FILES := first_jni.c  （指定需要编译的文件）
5. 在src当中创建java文件，此为与so库对应的接口。（如当前Demo当中的FirstJNI.java）
> 注意：
> 
> - 必须包含一个static的静态代码块。用于加载so库。
> - 通过natvie声明so当中定义的接口

6. 在.c文件当中实现接口java中定义的方法
> 注意：
> 
> - .c文件当中需要包含jni.h头文件，否则一些JNIEXPORT 无法识别
> - .c文件中的方法名：JNIEXPORT jstring JNICALL Java_com_example_jnidemo_FirstJNI_sayHello(JNIEnv *env, jobject thiz)
> 翻译为：JNIEXPORT `返回值类型` JNICALL `Java_包名_类名_方法名`(JNIEnv *env, jobject thiz)
7. 代码编写完成后，需要编译.c文件为so库。在项目的根目录下.(jni,src等所在的目录),运行ndk-build编译


**其他：**

编写完接口java文件之后，可以通过javah工具生成一个对应的.h文件，用于JNI实现。
> 实现方法：在bin/classes 目录下执行javah -jni com.example.jnidemo.FirstJNI 即可在当前目录下生成一个.h文件



ndk环境搭建请Google之。
