/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 下午2:08:00
 * TODO //
 */
package com.topspace.core.utils;

public class PKCreator {

    private PKCreator() {
    }

    public static String getPrimaryKey() {
        java.util.UUID uuid = java.util.UUID.randomUUID();
        String su = uuid.toString().replaceAll("-", "");
        return su;
    }


}


