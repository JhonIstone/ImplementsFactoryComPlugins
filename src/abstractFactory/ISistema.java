package abstractFactory;

import java.io.File;
import java.io.IOException;

public interface ISistema{
	public abstract void build(File file) throws InterruptedException, IOException;
	public abstract void highlighter(File file) throws IOException;
	public abstract void highlighter();
}
