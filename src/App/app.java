package App;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import abstractFactory.ISistema;

public class app extends JFrame{
	
	public static void createProducts(ISistema factory) throws IOException {
		System.out.println("Informe a opcao desejada: ");
		System.out.println("1: TextHighlighter");
		System.out.println("2: Builder");
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		
		if (op == 1) {
			System.out.println("Precione 1 para abrir um arquivo e 2 para abrir um Highlighter vazio:");
			sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			if (option == 1) {
				JFrame jframe = new JFrame();
				JButton button = new JButton();
				
				jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				jframe.setLayout(new FlowLayout());
				jframe.setLocationRelativeTo(null);
				
				button = new JButton("Select File");
				button.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent event) { 
						JFileChooser fileChooser = new JFileChooser();
						int response = fileChooser.showOpenDialog(null);
						
						if (response == JFileChooser.APPROVE_OPTION) {
							File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
							jframe.setVisible(false);
							if (file != null)
								try {
									factory.highlighter(file);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
					} 
				});
				
				jframe.add(button);
				jframe.pack();
				jframe.setVisible(true);
			}else {
				factory.highlighter();
			}
		}else {
			JFrame jframe = new JFrame();
			JButton button = new JButton();
			
			jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jframe.setLayout(new FlowLayout());
			jframe.setLocationRelativeTo(null);
			
			button = new JButton("Select File");
			button.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent event) { 
					JFileChooser fileChooser = new JFileChooser();
					int response = fileChooser.showOpenDialog(null);
					
					if (response == JFileChooser.APPROVE_OPTION) {
						File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
						jframe.setVisible(false);
						if (file != null)
							try {
								factory.build(file);
							} catch (InterruptedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				} 
			});
				
			jframe.add(button);
			jframe.pack();
			jframe.setVisible(true);
		}
	}
	
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{

    	int op = 1;

	    do {
	    	File currentDir = new File("./src/plugins");
	    	String[] plugins = currentDir.list();
	    	int i;
	    	URL[] jars = new URL[plugins.length];
	    	for (i = 0; i < plugins.length; i++) {
	            System.out.println(i + 1 + " - " + plugins[i].split("\\.")[0]);
	            jars[i] = (new File("./src/plugins" + plugins[i])).toURL();
	        }
	    	URLClassLoader ulc = new URLClassLoader(jars);
	    	System.out.println(i + 1 + " - Plugin refresh");
	        System.out.println("Escolha sua opção ou 0 para sair: ");
	        Scanner sc = new Scanner(System.in);
	        op = sc.nextInt();
	        if (op != 0 && op != i + 1) {
	            String factoryName = plugins[op - 1].split("\\.")[0];
	            ISistema factory = (ISistema) Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc).newInstance();
	            createProducts(factory);
	        }
	    }while(op != 0);
    }	
}