/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core.internalMenu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lennon
 */
public class testMenu extends JPanel implements ActionListener{
    
                public testMenu()
		{
                        this.setVisible(true);
			add( createButton("	", Color.BLACK) );
			add( createButton("	", Color.RED) );
			add( createButton("	", Color.GREEN) );
			add( createButton("	", Color.BLUE) );
			add( createButton("	", Color.ORANGE) );
			add( createButton("	", Color.YELLOW) );
			add( createButton("Clear Drawing", null) );
		}



		private JButton createButton(String text, Color background)
		{
			JButton button = new JButton( text );
			button.setBackground( background );
			button.addActionListener( this );

			return button;
		}

		public void actionPerformed(ActionEvent e)
		{
			JButton button = (JButton)e.getSource();


		}
}
