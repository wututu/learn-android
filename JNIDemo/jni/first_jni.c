#include <jni.h>
#include <string.h>

JNIEXPORT jstring JNICALL Java_com_example_jnidemo_FirstJNI_sayHello(JNIEnv *env, jobject thiz)
{
    return (*env)->NewStringUTF(env, "Hello from JNI!");
}
