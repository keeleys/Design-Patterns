package 结构型.装饰者.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-12
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[]args) throws IOException {
        InputStream inputStream = new CaseInputStream(new FileInputStream("F:\\temp\\sql.txt"));
        int i=0;
        while ( (i=inputStream.read())!=-1){
            System.out.print((char)i);
        }
    }
}
