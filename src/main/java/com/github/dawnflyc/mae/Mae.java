package main.java.com.github.dawnflyc.mae;


import java.io.File;

/**
 * 程序处理核心
 * @author dawnflyc
 */
public class Mae {

    /**
     * 源文件夹
     */
    private final File source;
    /**
     * 导出文件夹
     */
    private final File out;

    /**
     * 构造
     * @param source 源文件夹
     * @param out 导出文件夹
     */
    public Mae(String source, String out) {
        this.source = new File(source);
        this.out = new File(out);
        if (!this.source.isDirectory() || !this.out.isDirectory()){
            throw new IllegalArgumentException();
        }
    }

    public Mae(String source) {
        this.source = new File(source);;
        this.out = new File("./");
        if (!this.source.isDirectory() || !this.out.isDirectory()){
            throw new IllegalArgumentException();
        }
    }

    public Mae() {
        this.source =  new File("./");
        this.out =  new File("./");
        if (!this.source.isDirectory() || !this.out.isDirectory()){
            throw new IllegalArgumentException();
        }
    }

    public File getSource() {
        return source;
    }

    public File getOut() {
        return out;
    }

    /**
     * 开始处理
     * @return
     */
    public boolean processing(){
        boolean result=false;
        //TODO 这里写具体逻辑，今天有些晚，明天写
        return result;
    }
}
