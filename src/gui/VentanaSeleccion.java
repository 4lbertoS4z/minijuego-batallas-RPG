package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Geralt;
import modelo.Jaskier;
import modelo.Yennefer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings({ "serial", "unused" })
public class VentanaSeleccion extends JFrame implements ActionListener {

	private JPanel contentPane;


	public VentanaSeleccion() {
		//Valores de la ventana
		setResizable(false);
		setTitle("The  Witcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Creamos los JLabel y Jbutton necesarios

		JLabel lblNewLabel = new JLabel("Selecci\u00F3n de personaje");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 31);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Geralt");
		btnNewButton.setIcon(new ImageIcon(VentanaSeleccion.class.getResource("/img/geralt.png")));
		btnNewButton.addActionListener(this); 
		btnNewButton.setActionCommand("Geralt");
		btnNewButton.setBounds(10, 70, 90, 90);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Yennefer");
		btnNewButton_1.setIcon(new ImageIcon(VentanaSeleccion.class.getResource("/img/yennefer.png")));
		btnNewButton_1.addActionListener(this); 
		btnNewButton_1.setActionCommand("Yennefer");
		btnNewButton_1.setBounds(170, 70, 90, 90);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Jaskier");
		btnNewButton_2.setIcon(new ImageIcon(VentanaSeleccion.class.getResource("/img/jaskier.png")));
		btnNewButton_2.addActionListener(this); 
		btnNewButton_2.setActionCommand("Jaskier");
		btnNewButton_2.setBounds(335, 70, 90, 90);
		contentPane.add(btnNewButton_2);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="Geralt") {//Al pulsar el boton nos lleva a la ventana de batalla de geralt
			try {
				VentanaBatallaG miBatallaG = new VentanaBatallaG();
				miBatallaG.setVisible(true);
				this.dispose();//cierra esta ventana y abre la que le indicamos arriba
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		if(arg0.getActionCommand()=="Yennefer") {//Al pulsar el boton nos lleva a la ventana de batalla de Yennefer
			try {
				VentanaBatallaY miBatallaY = new VentanaBatallaY();
				miBatallaY.setVisible(true);
				this.dispose();//cierra esta ventana y abre la que le indicamos arriba
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		if(arg0.getActionCommand()=="Jaskier") {//Al pulsar el boton nos lleva a la ventana de batalla de Jaskier
			try {
				VentanaBatallaJ miBatallaJ = new VentanaBatallaJ();
				miBatallaJ.setVisible(true);
				this.dispose();//cierra esta ventana y abre la que le indicamos arriba
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
