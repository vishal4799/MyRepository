import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
 
/**
 * List files and directories on a FTP server using Apache Commons Net API.
 */
public class FetchSSHDirectory {
 
    public static void main(String[] args) {
        String server = args[0];//"clm-pun-020514";
        int port = 21;
        String user = args[1];//"root";
        String pass = args[2];//"bmcAdm1n";
 
        FTPClient ftpClient = new FTPClient();
 
        try {
 
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
 
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Connect failed");
                return;
            }
 
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            //ftpClient.changeWorkingDirectory("/");
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            }
 
            // Lists files and directories
//            FTPFile[] files1 = ftpClient.listFiles("/vishal");
//            printFileDetails(files1);
 
            // uses simpler methods
            String[] files2 = ftpClient.listNames("/home/a*");
            printNames(files2);
 
 
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        } finally {
            // logs out and disconnects from server
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
 
    private static void printFileDetails(FTPFile[] files) {
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : files) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
 
            System.out.println(details);
        }
    }
 
    private static void printNames(String files[]) {
        if (files != null && files.length > 0) {
            for (String aFile: files) {
                System.out.println(aFile);
            }
        }
    }
 
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
}