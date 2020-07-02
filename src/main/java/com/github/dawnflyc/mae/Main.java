package main.java.com.github.dawnflyc.mae;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;

/**
 * MC资源导出主程序
 * @author dawnflyc
 */
public class Main {

    public static void main(String[] args) {
        //先判断参数执行逻辑
        Mae mae;
        if (args.length>1){
        mae=new Mae(args[0],args[1]);
        }
        else if (args.length==1){
            if ("?".equals(args[0]) || "help".equals(args[0])){
                System.out.println("此软件可以导出Minecraft资源(Assets)文件。\n" +
                        "参数：\n" +
                        "     1、资源文件夹路径、导出文件夹路径 --- 根据两个参数处理文件。\n" +
                        "     2、资源文件夹路径 --- 不写导出路径的话，默认即是此软件的路径。\n" +
                        "     3、没有参数 --- 资源路径与导出路径默认都为软件路径，\n" +
                        "\t这样适合于把软件复制到资源文件夹里就可以直接运行。");
                return;
            }else {
                mae = new Mae(args[0]);
            }
        }
        else{
        mae=new Mae();
        }
        //因为纯java的话，需要会命令行，为了考虑小白，以后可能会包装一层C#的GUI界面
        //调用是需要判断是否成功，就需要程序返回值了
        try {
            System.exit(mae.processing() ? 1 : 0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
