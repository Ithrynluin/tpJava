package thread.exo8;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class TestLongAction extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private final JButton btnAction;
	
	public TestLongAction(){
		this.btnAction = new JButton("Start");
		 
		btnAction.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new LongAction().traitementLong();
				//new Thread(new LongAction()).start();
				new SwingWorker(){

					@Override
					protected Object doInBackground() throws Exception {
						new LongAction().traitementLong();
						return null;
					}
					
				}.execute();
			}
		});
		
		final Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		contentPane.add(btnAction);
		setTitle("Test LongAction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestLongAction();
	}
	
	//L'application freeze, elle ne se redessine pas lorsqu'on redimensionne la fenêtre.
	
	//Solutions :
	//La classe traitementLong implement Runnable.
	//Et
	//On utilise la classe SwingWorker.
}

