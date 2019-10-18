package graal;

//import org.bouncycastle.jce.provider.BouncyCastleProvider;
import io.micronaut.runtime.Micronaut;
//import java.security.Security;

public class Application {

    public static void main(String[] args) {
		//Security.addProvider(new BouncyCastleProvider());
		//System.loadLibrary("sunec");
		//System.loadLibrary("D:/workspaces/binaries_noprogram/graalvm-ce-19.1.1/jre/bin/sunec.dll");
		//System.loadLibrary("D:/workspaces/binaries_noprogram/graalvm-ce-19.1.1/jre/bin/sunmscapi.dll");
        Micronaut.run(Application.class);
    }
}