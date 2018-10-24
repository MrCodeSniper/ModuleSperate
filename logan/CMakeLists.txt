
cmake_minimum_required(VERSION 3.4.1)

SET (CMAKE_C_FLAGS_DEBUG          "-g")
SET (CMAKE_C_FLAGS_RELEASE        "-O2 -DNDEBUG")



set(SOURCE_FILES
        clogan_core.c
        mmap_util.c mmap_util.c cJSON.c
        construct_data.c construct_data.c
        zlib_util.h zlib_util.c logan_config.h
        json_util.h json_util.c aes_util.h aes_util.c
        clogan_status.h
        directory_util.h directory_util.c base_util.h base_util.c console_util.h console_util.c)



add_library( # Sets the name of the library.
             jni_lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/jni/clogan_protocol.c

             )

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( # Specifies the target library.
                       jni_lib



                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
