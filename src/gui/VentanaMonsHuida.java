package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;


@SuppressWarnings("serial")
public class VentanaMonsHuida extends JFrame implements ActionListener {

	@SuppressWarnings("unused")
	private JPanel contentPane;

	public VentanaMonsHuida() {
		//Valores de la ventana
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("The witcher");
		setBounds(100, 100, 499, 304);

		getContentPane().setLayout(null);

		//Creamos los JLabel y Jbutton necesarios

		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaMonsHuida.class.getResource("/img/images (1).jpg")));
		lblImagen.setBounds(39, 56, 416, 160);
		getContentPane().add(lblImagen);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener( this);
		btnSalir.setBounds(39, 227, 89, 23);
		getContentPane().add(btnSalir);

		JLabel lblvictoria = new JLabel("El monstruo ha huido");
		lblvictoria.setFont(new Font("Stencil", Font.ITALIC, 18));
		lblvictoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblvictoria.setBounds(86, 15, 316, 30);
		getContentPane().add(lblvictoria);

		JButton btnReintentar = new JButton("Reintentar");
		btnReintentar.addActionListener( this);
		btnReintentar.setActionCommand("reintentar");
		btnReintentar.setBounds(366, 227, 89, 23);
		getContentPane().add(btnReintentar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="Salir") {
			System.exit(0);// cierra el programa
		}
		if(arg0.getActionCommand()=="reintentar") {
			try {
				VentanaSeleccion miSelect = new VentanaSeleccion();
				miSelect.setVisible(true);
				this.dispose();//cierra esta ventana y abre la que le indicamos arriba
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
