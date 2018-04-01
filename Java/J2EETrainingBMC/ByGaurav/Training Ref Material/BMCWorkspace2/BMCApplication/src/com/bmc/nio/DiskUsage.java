/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmc.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiskUsage {
    public static void main(String[] args) throws IOException {
        Path path=Paths.get("C:");
        FileStore store=Files.getFileStore(path);
        System.out.println((store.getTotalSpace()/1024));
        System.out.println(store.getUsableSpace());
        
    }
    
}
