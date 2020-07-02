package main.java.com.github.dawnflyc.mae;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

/**
 * 程序处理核心
 *
 * @author dawnflyc
 */
public class Mae {

    /**
     * 源文件夹
     */
    private final String source;
    /**
     * 导出文件夹
     */
    private final String out;

    /**
     * 构造
     *
     * @param source 源文件夹
     * @param out    导出文件夹
     */
    public Mae(String source, String out) {
        File sourceFile = new File(source);
        File outFile = new File(out);
        if (!sourceFile.isDirectory() || !outFile.isDirectory()) {
            throw new IllegalArgumentException();
        }
        this.source = source;
        this.out = out;
    }

    public Mae(String source) {
        File sourceFile = new File(source);
        File outFile = new File("./");
        if (!sourceFile.isDirectory() || !outFile.isDirectory()) {
            throw new IllegalArgumentException();
        }
        this.source = source;
        this.out = sourceFile.getPath();
    }

    public Mae() {
        File sourceFile = new File("./");
        File outFile = new File("./");
        if (!sourceFile.isDirectory() || !outFile.isDirectory()) {
            throw new IllegalArgumentException();
        }
        this.source = sourceFile.getPath();
        this.out = sourceFile.getPath();
    }

    public String getSource() {
        return source;
    }

    public String getOut() {
        return out;
    }

    /**
     * 处理
     *
     * @return 是否成功
     */
    public boolean processing() throws IOException {
        //先找到hash映射表
        File indexes = new File(this.source + File.separator + "indexes");
        File objects = new File(this.source + File.separator + "objects");
        if (indexes.isDirectory() && objects.isDirectory()) {
            File[] files = indexes.listFiles();
            File index = null;
            for (File file : files) {
                if (file.isFile() && file.getPath().endsWith(".json")) {
                    index = file;
                    break;
                }
            }
            if (index==null){
                System.out.println("找不到json序列文件！");
                return false;
            }
            // 处理json逻辑
            //解析json
            Gson gson=new Gson();
            Type type=new TypeToken<HashMap<String,HashMap<String,HashData>>>(){}.getType();
            HashMap<String,HashMap<String,HashData>> mapHashMap=gson.fromJson(new FileReader(index),type);
            HashMap<String,HashData> map=mapHashMap.get("objects");
            for (String s : map.keySet()) {
                //将源文件复制到导出文件夹
                String hash=map.get(s).getHash();
                File hashFile=new File(objects.getPath()+File.separator+hash.substring(0,2)+File.separator+hash);
                File outFile=new File(this.out+File.separator+"Minecraft Assets"+File.separator+s);
                if (!outFile.exists()) outFile.mkdirs();
                if (hashFile.isFile() && hashFile.length()==map.get(s).getSize()){
                    Files.copy(hashFile.toPath(),outFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
                }else {
                    System.out.println("导出文件错误:"+s);
                }
                System.out.println("文件\""+s+"\"导出成功！");
            }
            System.out.println("导出成功！");
            return true;
        }else {
            System.out.println("找不到indexes文件夹与objects文件夹！");
            return false;
        }
    }
}
