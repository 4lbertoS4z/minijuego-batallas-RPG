package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings({ "serial", "unused" })
public class VentanaHuida extends JFrame implements ActionListener {

	private JPanel contentPane;


	public VentanaHuida() {
		//Valores de la ventana
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Creamos los JLabel y Jbutton necesarios

		JLabel lblJaskierHuyoComo = new JLabel("Jaskier huy\u00F3 como el cobarde que es, \r\nestaba mucho mejor en el bar.");
		lblJaskierHuyoComo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblJaskierHuyoComo.setBounds(0, 28, 424, 49);
		contentPane.add(lblJaskierHuyoComo);

		JLabel lblHuida = new JLabel("huida");
		lblHuida.setIcon(new ImageIcon(VentanaHuida.class.getResource("/img/intro-1582120631.jpg")));
		lblHuida.setBounds(10, 70, 402, 143);
		contentPane.add(lblHuida);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("salir");
		btnSalir.setBounds(10, 224, 89, 23);
		contentPane.add(btnSalir);

		JButton btnReintentar = new JButton("Reintentar");
		btnReintentar.addActionListener(this);
		btnReintentar.setActionCommand("reintentar");
		btnReintentar.setBounds(323, 224, 89, 23);
		contentPane.add(btnReintentar);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="salir") {
			System.exit(0);// cierra el programa
		}
		if(arg0.getActionCommand()=="reintentar") {
			try {
				VentanaSeleccion miSelect = new VentanaSeleccion();
				miSelect.setVisible(true);
				this.dispose();// cierra esta ventana cuando se abre la siguiente
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
