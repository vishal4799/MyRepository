package com.bmc.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class WatcherDemo {
	public static void main(String[] args) throws IOException {
        
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path directory = Paths.get("C:\\Java");
        WatchKey key = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
 
        boolean stopPolling = false;
        for (;;) {
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             List<WatchEvent<?>> keys = key.pollEvents();
            for (WatchEvent<?> watchEvent : keys) {
                Kind<?> watchEventKind = watchEvent.kind();
                if (watchEventKind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                if (watchEventKind == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("File Created:" + watchEvent.context());
                } else if (watchEventKind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("File Modified:" + watchEvent.context());
                } else if (watchEventKind == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("File deleted:" + watchEvent.context());
                    
                    if ("stop.txt".equals(watchEvent.context().toString())) {
                        stopPolling = true;
                    }
                }
                key.reset();
 
            }
            if (stopPolling) {
 
                break;
            }
 
        }
        watchService.close();
    }

}
