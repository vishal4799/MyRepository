import com.bmc.ola.utils.AESEncryptor;
//import org.apache.shiro.crypto.hash.Sha256Hash;
public class EncryptorAES {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//String passwordToDecrypt = "D1l4OwdFSakll3YcL7/PFw==";//prmnn
		//String passwordToDecrypt = "Ub/zoNW2RNrSbDSwDJKQCg==";//bmcAdm1n
		//String passwordToDecrypt = "xv2wexXzKbXVOreholsZAQ=="; //admin
		//String passwordToDecrypt = "fmjqVom3LFSP4s1lyNzLCg=="; //vishal
		//String passwordToDecrypt = "P4IQiIJInv6zPnCmIVhulA=="; //admin
		//String passwordToDecrypt = "qURUsTvaBnXyqsRG5SbRIDF5smB5Q1zBOOSpP30WKlQ="; //smbCollectorManual
		//String passwordToDecrypt = "0sS2kRgY6KG8/zNPzeLYQA=="; //param
		//String passwordToDecrypt = "B7H75kJcibnbA7ddVcxFdw=="; //administrator5
		//String passwordToDecrypt = "LPAI4tRacHHpZaoVZ1a3KA=="; //admin12345
		//String passwordToDecrypt = "bixP5jC/PYIQCPyKQ7s0LA=="; //RSSO#Admin#";
		//String passwordToDecrypt = "1lj6j0edcab45Dh+KPX1RQ=="; //1;
		//String passwordToDecrypt = "FAAJrPjNYv1rrBePFFozfg=="; //2;
		String passwordToDecrypt = "J7bv62zWVQJ+FgPrm8+dBQ=="; //1;
		
		System.out.println("password:"+AESEncryptor.decrypt(passwordToDecrypt)+"::");
	}

}
