package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaDerrota extends JFrame implements ActionListener {

	@SuppressWarnings("unused")
	private JPanel contentPane;

	public VentanaDerrota() {
		//Valores de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("The witcher");
		setBounds(100, 100, 499, 301);


		getContentPane().setLayout(null);

		//Creamos los JLabel y Jbutton necesarios

		JLabel lblDerrota = new JLabel("Derrota");
		lblDerrota.setIcon(new ImageIcon(VentanaDerrota.class.getResource("/img/hqdefault.jpg")));
		lblDerrota.setBounds(39, 11, 414, 160);
		getContentPane().add(lblDerrota);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener( this);
		btnSalir.setBounds(39, 208, 89, 23);
		getContentPane().add(btnSalir);

		JButton btnReintentar = new JButton("Reintentar");
		btnReintentar.addActionListener(this);
		btnReintentar.setActionCommand("reintentar");
		btnReintentar.setBounds(364, 208, 89, 23);
		getContentPane().add(btnReintentar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="Salir") {
			System.exit(0);// cierra el programa
		}
		try {
			VentanaSeleccion miSelect = new VentanaSeleccion();
			miSelect.setVisible(true);
			this.dispose();// cierra esta ventana cuando se abre la siguiente
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}

