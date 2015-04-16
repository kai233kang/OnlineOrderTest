package com.menusifu.onlinetest;

import java.io.File;
import java.io.IOException;

public class CreateFileUtil {

    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if(file.exists()) {
            System.out.println("??????" + destFileName + "???????????");
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            System.out.println("??????" + destFileName + "?????????????");
            return false;
        }
        //???????????????
        if(!file.getParentFile().exists()) {
            //?????????????????????
            System.out.println("??????????????????");
            if(!file.getParentFile().mkdirs()) {
                System.out.println("?????????????");
                return false;
            }
        }
        //??????
        try {
            if (file.createNewFile()) {
                System.out.println("??????" + destFileName + "???");
                return true;
            } else {
                System.out.println("??????" + destFileName + "???");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("??????" + destFileName + "???" + e.getMessage());
            return false;
        }
    }


    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("????" + destDirName + "???????????");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //????
        if (dir.mkdirs()) {
            System.out.println("????" + destDirName + "???");
            return true;
        } else {
            System.out.println("????" + destDirName + "???");
            return false;
        }
    }


    public static String createTempFile(String prefix, String suffix, String dirName) {
        File tempFile = null;
        if (dirName == null) {
            try{
                //?????????????
                tempFile = File.createTempFile(prefix, suffix);
                //?????????
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("?????????" + e.getMessage());
                return null;
            }
        } else {
            File dir = new File(dirName);
            //??????????????????
            if (!dir.exists()) {
                if (!CreateFileUtil.createDir(dirName)) {
                    System.out.println("???????????????????????");
                    return null;
                }
            }
            try {
                //????????????
                tempFile = File.createTempFile(prefix, suffix, dir);
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("?????????" + e.getMessage());
                return null;
            }
        }
    }



}
