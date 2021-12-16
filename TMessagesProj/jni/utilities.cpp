#include <jni.h>
#include <sys/stat.h>
#include <climits>
#include <unistd.h>
#include <string>

thread_local static char buf[PATH_MAX + 1];

extern "C" JNIEXPORT jstring Java_org_telegram_messenger_Utilities_readlink(JNIEnv *env, jclass clazz, jstring path) {
    const char *fileName = env->GetStringUTFChars(path, NULL);
    ssize_t result = readlink(fileName, buf, PATH_MAX);
    jstring value = 0;
    if (result != -1) {
        buf[result] = '\0';
        value = env->NewStringUTF(buf);
    }
    env->ReleaseStringUTFChars(path, fileName);
    return value;
}

extern "C" JNIEXPORT jstring Java_org_telegram_messenger_Utilities_readlinkFd(JNIEnv *env, jclass clazz, int fd) {
    std::string path = "/proc/self/fd/";
    path += fd;
    ssize_t result = readlink(path.c_str(), buf, PATH_MAX);
    jstring value = 0;
    if (result != -1) {
        buf[result] = '\0';
        value = env->NewStringUTF(buf);
    }
    return value;
}
