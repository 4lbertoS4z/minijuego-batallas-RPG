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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings({ "unused", "serial" })
public class VentanaBatallaY extends JFrame implements ActionListener {

	private JPanel contentPane;

	Geralt miGeralt = new Geralt();
	Yennefer miYeni = new Yennefer();
	Jaskier miJaskier = new Jaskier();
	Monstruo miMonstruo = new Monstruo();
	private JLabel vidaTuya;
	private JLabel vidaEnemigo;
	private JTextPane cuadroMensajes;

	//Creacion JPanel
	public VentanaBatallaY() {
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
		lblBatalla.setBounds(142, 11, 147, 14);
		contentPane.add(lblBatalla);

		vidaTuya = new JLabel("Yennefer:");
		vidaTuya.setText("Yennefer: "+ miYeni.getSalud());
		vidaTuya.setBounds(10, 69, 170, 14);
		contentPane.add(vidaTuya);

		vidaEnemigo = new JLabel("Kikimora:");
		vidaEnemigo.setText("Kikimora: "+ miMonstruo.getSalud());
		vidaEnemigo.setBounds(228, 69, 196, 14);
		contentPane.add(vidaEnemigo);

		cuadroMensajes = new JTextPane();
		cuadroMensajes.setEditable(false);
		cuadroMensajes.setText("Info Batalla:");
		cuadroMensajes.setBounds(0, 26, 424, 39);
		contentPane.add(cuadroMensajes);

		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(this);
		botonAtacar.setActionCommand("atacar");
		botonAtacar.setBounds(10, 213, 89, 47);
		contentPane.add(botonAtacar);

		JButton btnPiro = new JButton("Piro++");
		btnPiro.addActionListener(this);
		btnPiro.setActionCommand("piro");
		btnPiro.setBounds(118, 213, 89, 47);
		contentPane.add(btnPiro);

		JButton btnAqua = new JButton("Aqua++");
		btnAqua.addActionListener(this);
		btnAqua.setActionCommand("aqua");
		btnAqua.setBounds(228, 213, 89, 47);
		contentPane.add(btnAqua);

		JButton btnCura = new JButton("Cura++");
		btnCura.addActionListener(this);
		btnCura.setActionCommand("cura");
		btnCura.setBounds(335, 213, 89, 47);
		contentPane.add(btnCura);

		JLabel lblKikimora = new JLabel("");
		lblKikimora.setIcon(new ImageIcon(VentanaBatallaY.class.getResource("/img/kikimora.png")));
		lblKikimora.setBounds(228, 83, 192, 117);
		contentPane.add(lblKikimora);

		JLabel lblYeni = new JLabel("Yeni");
		lblYeni.setIcon(new ImageIcon(VentanaBatallaY.class.getResource("/img/yennefer.png")));
		lblYeni.setBounds(10, 108, 94, 94);
		contentPane.add(lblYeni);

		JLabel lblNewLabel = new JLabel("Ataque b\u00E1sico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 271, 89, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Magia (28-32)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(118, 271, 89, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Magia (15-25)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(228, 271, 89, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Recupera salud");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(327, 271, 107, 14);
		contentPane.add(lblNewLabel_3);
	}
	//Control de comportamiento al pulsar un boton.
	public void actionPerformed(ActionEvent arg0) {

		if (miMonstruo.getSalud()<=50&&miMonstruo.getSalud()>=35) {/* El monstruo intentara huir cuando su salud este entre estos valores, 
			si su salud esta por debajo se considera que ya esta moribundo e incapaz de huir lo sufientemente rapido*/
			if (miMonstruo.huir()==true) {
				cuadroMensajes.setText("Info Batalla: " + miMonstruo.getEspecie() + " logró huir. ");
				try {
					VentanaMonsHuida huir = new VentanaMonsHuida();
					huir.setVisible(true);
					this.dispose();
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		switch (arg0.getActionCommand()) {
		case "atacar":// Boton Ataque estandar 
			miYeni.pelear(1, miMonstruo);// implementa la opcion 1  del metodo pelear de la clase Yennefer
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Yennefer ha quitado: "+miYeni.getFuerza()+" puntos."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "piro"://boton ataque magico
			miYeni.pelear(2, miMonstruo);// implementa la opcion 2  del metodo pelear de la clase Yennefer
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Yennefer ha quitado: "+miYeni.getFuerza()+" puntos."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "aqua"://Boton ataque magico
			miYeni.pelear(3, miMonstruo);// implementa la opcion 3  del metodo pelear de la clase Yennefer
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Yennefer ha quitado: "+miYeni.getFuerza()+" puntos."+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "cura"://Boton curacion
			miYeni.pelear(4, miMonstruo);// implementa la opcion 4  del metodo pelear de la clase Yennefer
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Info Batalla: Yennefer se ha curado "+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		}

		if (miYeni.getSalud()<0) {//para que la vida no sea nunca un número negativo
			miYeni.setSalud(0);
		}

		if (miMonstruo.getSalud()<0) {//para que la vida no sea nunca un número negativo
			miMonstruo.setSalud(0);
		}



		if (miYeni.getSalud()<=0 && miMonstruo.getSalud()>0) { //solo muere el monstruo
			try {
				VentanaDerrota derrota = new VentanaDerrota();
				derrota.setVisible(true);
				this.dispose();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (miMonstruo.getSalud()<=0 && miYeni.getSalud()>0) { //solo muere el/la héroe/heroína
			try {
				VentanaVictoria victoria = new VentanaVictoria();
				victoria.setVisible(true);
				this.dispose();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (miMonstruo.getSalud()<=0 && miYeni.getSalud()<=0) { //mueren ambos
			try {
				VentanaDerrota derrota = new VentanaDerrota();
				derrota.setVisible(true);
				this.dispose();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		vidaTuya.setText("Yennefer: "+ miYeni.getSalud());// Actualiza la Salud de Yennefer en la interfaz grafica cada vez que peleamos
		vidaEnemigo.setText("Kikimora: "+ miMonstruo.getSalud());// Actualiza la Salud de Monstruo en la interfaz grafica cada vez que peleamos



	}

}
