package 结构型.装饰者.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-12
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
public class CaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected CaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int i=super.read();
        if (i==-1) return i;
        else{
            return Character.toUpperCase( (char)i);
        }
    }
}
