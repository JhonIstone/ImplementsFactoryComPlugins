package sistemajava;

import java.io.File;
import java.io.IOException;

import abstractFactory.ISistema;

public class sistemaJava implements ISistema{

	@Override
	public void build(File file) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		new javacBuilder(file);		
	}
	
	@Override
	public void highlighter(File file) throws IOException {
		// TODO Auto-generated method stub
		new TextJava(file);
	}
	
	public void highlighter(){
		// TODO Auto-generated method stub
		new TextJava();
	}

	
}
