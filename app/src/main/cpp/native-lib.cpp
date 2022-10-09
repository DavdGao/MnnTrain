#include <jni.h>
#include <string>

//#include <MNN/MNNDefine.h>
//#include <math.h>
//#include <stdlib.h>
//#include <MNN/Interpreter.hpp>
//#include <MNN/Tensor.hpp>
//#include <algorithm>
//#include <fstream>
//#include <map>
//#include <random>
//#include <set>
//#include <sstream>
//#include <stack>
//#include <string>
//#include "MNN_generated.h"
//#include "core/Macro.h"
//#define MNN_OPEN_TIME_TRACE
//#include <MNN/AutoTime.hpp>
//using namespace MNN;
//using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_mnntrain_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    // train model
//    auto interpreter = Interpreter::createFromFile("fail");


    // original
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

