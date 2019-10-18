@echo off
call "C:\Program Files\Microsoft SDKs\Windows\v7.1\Bin\SetEnv.cmd" /x64 /Debug
call gradlew assemble
%GRAAL_HOME%\bin\native-image --class-path ./build/libs/graal-0.1-all.jar -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" -H:Name=graal -H:Class=graal.Application -H:+ReportUnsupportedElementsAtRuntime -H:+AllowVMInspection -H:+ReportExceptionStackTraces -Djava.library.path=D:/workspaces/binaries_noprogram/graalvm-ce-19.1.1/jre/lib/svm/clibraries/windows-amd64/ --enable-all-security-services --allow-incomplete-classpath --verbose --no-fallback --initialize-at-run-time=io.netty.handler.ssl.JdkSslContext > build_native_image.log

REM -Djava.library.path=D:/workspaces/binaries_noprogram/graalvm-ce-19.1.1/jre/bin/sunec.dll;D:/workspaces/binaries_noprogram/graalvm-ce-19.1.1/jre/bin/sunmscapi.dll
REM --enable-all-security-services --allow-incomplete-classpath --verbose --no-fallback
REM -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*"
REM -H:EnableURLProtocols=http,https --enable-all-security-services -H:+JNI
REM  --rerun-class-initialization-at-runtime=io.netty.handler.codec.http2.Http2CodecUtil --initialize-at-run-time=io.netty.handler.codec.http2.DefaultHttp2FrameWriter --initialize-at-build-time=com.google.protobuf
REM --no-fallback --rerun-class-initialization-at-runtime=sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom,com.sun.jndi.dns.DnsClient,io.netty.handler.ssl.ConscryptAlpnSslEngine,io.netty.handler.ssl.JettyNpnSslEngine,io.netty.handler.ssl.ReferenceCountedOpenSslEngine,io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator,io.netty.handler.ssl.ReferenceCountedOpenSslServerContext,io.netty.handler.ssl.ReferenceCountedOpenSslClientContext,io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator -H:EnableURLProtocols=http,https
REM  -H:ClassInitialization --rerun-class-initialization-at-runtime=javax.net.ssl.SSLContext
REM --enable-url-protocols=http --enable-all-security-services --rerun-class-initialization-at-runtime=org.bouncycastle.crypto.prng.SP800SecureRandom --rerun-class-initialization-at-runtime=org.bouncycastle.jcajce.provider.drbg.DRBG$Default --rerun-class-initialization-at-runtime=org.bouncycastle.jcajce.provider.drbg.DRBG$NonceAndIV -J-Djava.security.properties=java.security.overrides
REM --enable-all-security-services
REM --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder
REM  -H:-UseServiceLoaderFeature
REM --enable-url-protocols=http --no-fallback --initialize-at-run-time=io.netty.handler.ssl.JdkSslContext
REM --enable-all-security-services --enable-url-protocols=https --no-fallback --initialize-at-run-time=io.netty.handler.ssl.JdkSslContext
REM --initialize-at-run-time=io.netty.handler.ssl.JdkSslContext
REM --no-fallback
REM -H:EnableURLProtocols=http
REM -H:+JNI -H:ReflectionConfigurationFiles="./netty_reflection_config.json" --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder
REM --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.codec.http.HttpObjectDecoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom  --rerun-class-initialization-at-runtime=sun.security.jca.JCAUtil$CachedSecureRandomHolder


REM --rerun-class-initialization-at-runtime=sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom,com.sun.jndi.dns.DnsClient,io.netty.handler.ssl.ConscryptAlpnSslEngine,io.netty.handler.ssl.JettyNpnSslEngine,io.netty.handler.ssl.ReferenceCountedOpenSslEngine,io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator,io.netty.handler.ssl.ReferenceCountedOpenSslServerContext,io.netty.handler.ssl.ReferenceCountedOpenSslClientContext,io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator -H:EnableURLProtocols=http,https