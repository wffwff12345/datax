package com.example;




public class TestMain {
    public static String getCurrentClasspath(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String currentClasspath = classLoader.getResource("").getPath();
        // 当前操作系统
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Win")) {
            // 删除path中最前面的/
            currentClasspath = currentClasspath.substring(1, currentClasspath.length()-1);
        }
        return currentClasspath;
    }
    public static void main(String[] args) {

        System.setProperty("datax.home","D:\\datax\\datax");
        String[] datxArgs2 = {"-job", getCurrentClasspath()+"/datax/test.json", "-mode", "standalone", "-jobid", "-1"};
        try {
            Engine.entry(datxArgs2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
