# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.22.1)

project("mnntrain")

add_library(
        mnntrain
        SHARED
        native-lib.cpp)

set(JNI_DIR ${CMAKE_SOURCE_DIR}/../jniLibs)

add_library(MNN SHARED IMPORTED)
set_target_properties(MNN PROPERTIES IMPORTED_LOCATION ${JNI_DIR}/${ANDROID_ABI}/libMNN.so)

add_library(MNNTrain SHARED IMPORTED)
set_target_properties(MNNTrain PROPERTIES IMPORTED_LOCATION ${JNI_DIR}/${ANDROID_ABI}/libMNNTrain.so)

add_library(MNN_Express SHARED IMPORTED)
set_target_properties(MNN_Express PROPERTIES IMPORTED_LOCATION ${JNI_DIR}/${ANDROID_ABI}/libMNN_Express.so)

include_directories(${CMAKE_SOURCE_DIR}/include/)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/data)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/datasets)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/grad)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/models)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/nn)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/optimizer)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/parameters)
include_directories(${CMAKE_SOURCE_DIR}/include/MNN/transformer)




find_library(log-lib log)

target_link_libraries(
        mnntrain

        MNN
        MNN_Express
        MNNTrain
        ${log-lib})