package sistemacpp;

import java.io.IOException;

import java.io.File;

import abstractFactory.ISistema;

public class sistemaCpp implements ISistema{

	@Override
	public void build(File file) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		new cppBuilder(file);
	}

	@Override
	public void highlighter(File file) throws IOException {
		// TODO Auto-generated method stub
		new TextCpp(file);
	}

	@Override
	public void highlighter() {
		// TODO Auto-generated method stub
		new TextCpp();
	}
}
