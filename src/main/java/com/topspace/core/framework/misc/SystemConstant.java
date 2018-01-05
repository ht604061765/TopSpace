/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午2:24:53
 * TODO //
 */
package com.topspace.core.framework.misc;


public class SystemConstant {

    private static String systemRealPath;
    private static String contextPath;
    
    public static String certPicKey = "certCodedlpt";

    public static void setRealPath(String path) {
        if(path.endsWith("\\") || path.endsWith("/")){
            systemRealPath = path;
        }else{
            systemRealPath = path + "/";
        }
    }

    public static String getRealPath() {
        return systemRealPath;
    }

    public static void setContextPath(String ctxPath) {
        contextPath = ctxPath;
    }

    public static String getContextPath() {
        return contextPath;
    }

    private SystemConstant() {
    }

    
    public static void main(String[] args) {
		String filePathString = getContextPath();
		System.out.println("111" + filePathString);
	}
}


