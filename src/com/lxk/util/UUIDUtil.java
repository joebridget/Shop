package com.lxk.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        UUID randomUUID = UUID.randomUUID();
        String UUid = String.valueOf(randomUUID);
        return UUid;
    }
}
