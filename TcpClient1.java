import java.net.*;
import java.io.*;
public class TcpClient1
{
    public static void main(String arg[])
    {
        Socket c=null;
        String line;
        DataInputStream is,is1;
        PrintStream os;
        
        try
        {
            c=new Socket("localhost",9999);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        try{
            os=new PrintStream(c.getOutputStream());
            is1 =new DataInputStream(c.getInputStream());
            is=new DataInputStream(System.in);
           
            do
            {
                System.out.println("Client:");
                line=is.readLine();
                 os.println(line);
                System.out.println("Server:"+is1.readLine());
                


            }while(line.equalsIgnoreCase("quit")==false);
            is1.close();
            os.close();
        }
        catch(IOException e)
        {
             System.out.println ("Socket closed! message passing is over");

        }
    }
}

