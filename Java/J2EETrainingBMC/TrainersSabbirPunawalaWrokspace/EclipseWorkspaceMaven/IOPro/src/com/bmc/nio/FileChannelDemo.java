package com.bmc.nio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileChannelDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        RandomAccessFile raf=new RandomAccessFile("D:\\IO\\File1.txt","rw");
        FileChannel channel=raf.getChannel();
        
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        
        while(channel.read(buffer)>0){
            
            buffer.flip();
            for(int i=0;i<buffer.limit();i++){
                System.out.print((char)buffer.get(i));
            }
            buffer.clear();
            
        }
        
        
        String data="Java is Fun";
        RandomAccessFile raf1=new RandomAccessFile("D:\\IO\\FileChannelData.txt","rw");
        raf1.seek(20);
        FileChannel channel1=raf1.getChannel();
        ByteBuffer buffer1=ByteBuffer.allocate(1024);
        byte byteData[]=data.getBytes();
        buffer1.put(byteData);
        buffer1.flip();
        channel1.write(buffer1);
        channel1.close();
        raf1.close();

        ByteBuffer directBuffer=ByteBuffer.allocateDirect(1024);
        
    }
    
}
