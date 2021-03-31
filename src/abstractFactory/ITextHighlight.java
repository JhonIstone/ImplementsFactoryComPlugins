package abstractFactory;

import java.io.File;
import java.io.IOException;

public interface ITextHighlight {
    public abstract void setHighlight(File file) throws IOException;
    public abstract void setHighlight();
}
