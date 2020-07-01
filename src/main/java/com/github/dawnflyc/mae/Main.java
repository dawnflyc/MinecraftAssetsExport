package main.java.com.github.dawnflyc.mae;

import com.sun.xml.internal.bind.v2.model.core.ID;

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
        mae=new Mae(args[0]);
        }
        else{
        mae=new Mae();
        }
        //因为纯java的话，需要会命令行，为了考虑小白，以后可能会包装一层C#的GUI界面
        //调用是需要判断是否成功，就需要程序返回值了
        System.exit(mae.processing() ? 1 : 0);
    }

}
