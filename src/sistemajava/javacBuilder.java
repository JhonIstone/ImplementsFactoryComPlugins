package sistemajava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import abstractFactory.IBuilder;

public class javacBuilder implements IBuilder{

    public javacBuilder(File file) throws InterruptedException, IOException {
        compile(file);
    }

    public void compile(File file) throws InterruptedException, IOException {
        // TODO Auto-generated method stub
    	String[] comand = {"javac", file.getAbsolutePath()};
    	
    	Process compilejava = new ProcessBuilder(comand).start();  
    	compilejava.waitFor();
    }    
}
