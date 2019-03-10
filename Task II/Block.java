import java.util.date;
import java.util.Base64;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;


public class Block{
private date timestamp;
private string hash,prevhash,data;

public Block(date stamp, string x){
this.timestamp= stamp;
this.data= x;
this.hash=computehash();
}
public static void computehash(){
string tohash = this.timestamp+this.prevhash+this.data;
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			byte[] hash = digest.digest(tohash.getBytes("UTF-8"));
			string encoded=Base64.getEncoder().encodeToString(hash);}
		catch(NoSuchAlgorithmException e) {
			e.printstacktrace();
		}
}
	}
this.hash=encoded;	
}