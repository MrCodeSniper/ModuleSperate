//
// Created by Administrator on 2018/10/23.
//

#include <string.h>
#include <jni.h>


jint JNICALL Java_com_hrz_logan_TestJni_init
  (JNIEnv* env, jobject  thiz,jstring j1,jstring j2,jint i1,jstring j3,jstring j4){
    return 100+i1;
  }