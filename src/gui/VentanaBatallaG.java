package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Geralt;
import modelo.Jaskier;
import modelo.Monstruo;
import modelo.Yennefer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class VentanaBatallaG extends JFrame implements ActionListener {

	private JPanel contentPane;

	Geralt miGeralt = new Geralt();
	Yennefer miYeni = new Yennefer();
	Jaskier miJaskier = new Jaskier();
	Monstruo miMonstruo = new Monstruo();
	private JLabel vidaTuya;
	private JLabel vidaEnemigo;
	private JTextPane cuadroMensajes;
	private JButton btnPocion;

	/**
	 * Create the frame.
	 */
	public VentanaBatallaG() {

		//Creacion JPanel
		setResizable(false);
		setTitle("The  Witcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Creamos los JLabel,JButton y JTexPane necesarios
		JLabel lblBatalla = new JLabel("Modo Batalla");
		lblBatalla.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblBatalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatalla.setBounds(133, 11, 147, 14);
		contentPane.add(lblBatalla);

		vidaTuya = new JLabel("Geralt:");
		vidaTuya.setText("Geralt: "+ miGeralt.getSalud());
		vidaTuya.setBounds(10, 68, 173, 14);
		contentPane.add(vidaTuya);

		vidaEnemigo = new JLabel("Kikimora:");
		vidaEnemigo.setText("Kikimora: "+ miMonstruo.getSalud());
		vidaEnemigo.setBounds(244, 68, 170, 14);
		contentPane.add(vidaEnemigo);

		cuadroMensajes = new JTextPane();
		cuadroMensajes.setEditable(false);
		cuadroMensajes.setText("Info Batalla:");
		cuadroMensajes.setBounds(10, 26, 414, 39);
		contentPane.add(cuadroMensajes);

		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(this);
		botonAtacar.setActionCommand("atacar");
		botonAtacar.setBounds(10, 213, 89, 47);
		contentPane.add(botonAtacar);

		JButton btnAard = new JButton("Aard");
		btnAard.addActionListener(this);
		btnAard.setActionCommand("aard");
		btnAard.setBounds(118, 213, 89, 47);
		contentPane.add(btnAard);

		JButton btnIgni = new JButton("Igni");
		btnIgni.addActionListener(this);
		btnIgni.setActionCommand("igni");
		btnIgni.setBounds(224, 213, 89, 47);
		contentPane.add(btnIgni);

		btnPocion = new JButton("Poci\u00F3n: " + (Math.abs(miGeralt.getPocionesTomadas()-3)));
		btnPocion.addActionListener(this);
		btnPocion.setActionCommand("pocion");
		btnPocion.setBounds(335, 213, 89, 47);
		contentPane.add(btnPocion);



		JLabel lblKikimora = new JLabel("");
		lblKikimora.setIcon(new ImageIcon(VentanaBatallaY.class.getResource("/img/kikimora.png")));
		lblKikimora.setBounds(244, 85, 180, 117);
		contentPane.add(lblKikimora);

		JLabel lblGeralt = new JLabel("Geralt");
		lblGeralt.setIcon(new ImageIcon(VentanaBatallaG.class.getResource("/img/geralt.png")));
		lblGeralt.setBounds(10, 112, 89, 90);
		contentPane.add(lblGeralt);

		JLabel lblAtaqueBsico = new JLabel("Ataque b\u00E1sico");
		lblAtaqueBsico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaqueBsico.setBounds(10, 272, 89, 14);
		contentPane.add(lblAtaqueBsico);

		JLabel lblMagia = new JLabel("Magia (28-32)");
		lblMagia.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagia.setBounds(118, 271, 89, 14);
		contentPane.add(lblMagia);

		JLabel lblMagia_1 = new JLabel("Magia (15-25)");
		lblMagia_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagia_1.setBounds(224, 272, 89, 14);
		contentPane.add(lblMagia_1);

		JLabel lblRecuperaSalud = new JLabel("Recupera salud");
		lblRecuperaSalud.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecuperaSalud.setBounds(323, 272, 111, 14);
		contentPane.add(lblRecuperaSalud);


	}
	//Control de comportamiento al pulsar un boton.
	public void actionPerformed(ActionEvent arg0) {

		if (miMonstruo.getSalud()<=50 && miMonstruo.getSalud()>=35) {/* El monstruo intentara huir cuando su salud este entre estos valores, 
			si su salud esta por debajo se considera que ya esta moribundo e incapaz de huir lo sufientemente rapido*/
			if (miMonstruo.huir()==true) {
				cuadroMensajes.setText("Info Batalla: " + miMonstruo.getEspecie() + " logró huir. ");
				try {
					VentanaMonsHuida huir = new VentanaMonsHuida();
					huir.setVisible(true);
					this.dispose();//cerramos esta ventana al abrir la nueva ventana
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		switch (arg0.getActionCommand()) {
		case "atacar": // Boton Ataque estandar 
			miGeralt.pelear(1, miMonstruo); // implementa la opcion 1  del metodo pelear de la clase geralt
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Geralt ha quitado: "+miGeralt.getFuerza()+" puntos."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "aard"://Boton ataque magico
			miGeralt.pelear(2, miMonstruo);// implementa la opcion 2  del metodo pelear de la clase geralt
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Geralt ha quitado: "+miGeralt.getFuerza()+" puntos."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "igni"://Boton ataque magico
			miGeralt.pelear(3, miMonstruo);// implementa la opcion 3  del metodo pelear de la clase geralt
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Geralt ha quitado: "+miGeralt.getFuerza()+" puntos."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "pocion"://Boton curacion, solo 3 usos
			miGeralt.pelear(4, miMonstruo);// implementa la opcion 4  del metodo pelear de la clase geralt
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Geralt se ha curado."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			btnPocion.setText("Poci\u00F3n: " + (Math.abs(miGeralt.getPocionesTomadas()-3)));//muestra las pociones	que te quedan en el botón 
			break;
		}

		if (miGeralt.getSalud()<0) { //para que la vida no sea nunca un número negativo
			miGeralt.setSalud(0);
		}

		if (miMonstruo.getSalud()<0) {//para que la vida no sea nunca un número negativo
			miMonstruo.setSalud(0);
		}



		if (miGeralt.getSalud()<=0 && miMonstruo.getSalud()>0) { //solo muere el monstruo
			try {
				VentanaDerrota derrota = new VentanaDerrota();
				derrota.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (miMonstruo.getSalud()<=0 && miGeralt.getSalud()>0) { //solo muere el/la héroe/heroína
			try {
				VentanaVictoria victoria = new VentanaVictoria();
				victoria.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (miMonstruo.getSalud()<=0 && miGeralt.getSalud()<=0) { //mueren ambos
			try {
				VentanaDerrota derrota = new VentanaDerrota();
				derrota.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		vidaTuya.setText("Geralt: "+ miGeralt.getSalud());// Actualiza la Salud de Geralt en la interfaz grafica cada vez que peleamos
		vidaEnemigo.setText("Kikimora: "+ miMonstruo.getSalud());// Actualiza la Salud del monstruo en la interfaz grafica cada vez que peleamos

		if (miGeralt.getPocionesTomadas()==3) {
			btnPocion.setEnabled(false);
		}

	}
}
