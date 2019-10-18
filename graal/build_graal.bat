@echo off
call "C:\Program Files\Microsoft SDKs\Windows\v7.1\Bin\SetEnv.cmd" /x64 /Debug
call gradlew assemble
%GRAAL_HOME%\bin\native-image --class-path ./build/libs/graal-*-all.jar  -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" -H:Name=graal -H:Class=graal.Application -H:+ReportUnsupportedElementsAtRuntime -H:+AllowVMInspection -H:+ReportExceptionStackTraces