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
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings({ "serial", "unused" })
public class VentanaBatallaJ extends JFrame implements ActionListener {

	private JPanel contentPane;

	Geralt miGeralt = new Geralt();
	Yennefer miYeni = new Yennefer();
	Jaskier miJaskier = new Jaskier();
	Monstruo miMonstruo = new Monstruo();
	private JLabel vidaTuya;
	private JLabel vidaEnemigo;
	private JTextPane cuadroMensajes;

	//Creacion JPanel
	public VentanaBatallaJ() {
		setResizable(false);
		setTitle("The Witcher");
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

		vidaTuya = new JLabel();
		vidaTuya.setText("Jaskier: "+ miJaskier.getSalud());
		vidaTuya.setBounds(10, 74, 147, 14);
		contentPane.add(vidaTuya);

		vidaEnemigo = new JLabel("Kikimora:"+miMonstruo.getSalud());
		vidaEnemigo.setBounds(220, 74, 192, 14);
		contentPane.add(vidaEnemigo);

		cuadroMensajes = new JTextPane();
		cuadroMensajes.setEditable(false);
		cuadroMensajes.setText("Info Batalla:");
		cuadroMensajes.setBounds(10, 25, 402, 39);
		contentPane.add(cuadroMensajes);

		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(this);
		botonAtacar.setActionCommand("atacar");
		botonAtacar.setBounds(10, 213, 89, 47);
		contentPane.add(botonAtacar);

		JButton botonCantar = new JButton("Cantar");
		botonCantar.addActionListener(this);
		botonCantar.setActionCommand("cantar");
		botonCantar.setBounds(171, 213, 89, 47);
		contentPane.add(botonCantar);

		JButton btnHuir = new JButton("Huir");
		btnHuir.addActionListener(this);
		btnHuir.setActionCommand("huir");
		btnHuir.setBounds(323, 213, 89, 47);
		contentPane.add(btnHuir);

		JLabel lblKikimora = new JLabel("");
		lblKikimora.setIcon(new ImageIcon(VentanaBatallaY.class.getResource("/img/kikimora.png")));
		lblKikimora.setBounds(220, 85, 192, 117);
		contentPane.add(lblKikimora);

		JLabel lblJaskier = new JLabel("Jaskier");
		lblJaskier.setIcon(new ImageIcon(VentanaBatallaJ.class.getResource("/img/jaskier.png")));
		lblJaskier.setBounds(10, 112, 89, 90);
		contentPane.add(lblJaskier);

		JLabel lblAtaqueBsico = new JLabel("Ataque b\u00E1sico");
		lblAtaqueBsico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaqueBsico.setBounds(10, 271, 89, 14);
		contentPane.add(lblAtaqueBsico);

		JLabel lblCalmaAlMonstruo = new JLabel("Calma al monstruo o...");
		lblCalmaAlMonstruo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalmaAlMonstruo.setBounds(142, 271, 147, 14);
		contentPane.add(lblCalmaAlMonstruo);

		JLabel lblNewLabel = new JLabel("Intentar escapar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(299, 271, 135, 14);
		contentPane.add(lblNewLabel);
	}
	//Control de comportamiento al pulsar un boton.
	public void actionPerformed(ActionEvent arg0) {

		if (miMonstruo.getSalud()<=50&&miMonstruo.getSalud()>=35) {/* El monstruo intentara huir cuando su salud este entre estos valores, 
			si su salud esta por debajo se considera que ya esta moribundo e incapaz de huir lo sufientemente rapido*/
			if (miMonstruo.huir()==true) {
				cuadroMensajes.setText(miMonstruo.getEspecie() + " logró huir. ");
				try {
					VentanaMonsHuida huirMons = new VentanaMonsHuida();
					huirMons.setVisible(true);
					this.dispose();//cerramos esta ventana al abrir la nueva ventana
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		switch (arg0.getActionCommand()) {
		case "atacar":// Boton Ataque estandar 
			miJaskier.pelear(1, miMonstruo);// implementa la opcion 1  del metodo pelear de la clase Yennefer
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			cuadroMensajes.setText("Jaskier ha quitado: "+miJaskier.getFuerza()+" puntos. "+ " \nKikimora: "+miMonstruo.getFuerza()+" puntos");
			break;
		case "cantar":// Boton cantar
			String frase=miJaskier.pelear(2, miMonstruo);// implementa la opcion 2  del metodo pelear de la clase Yennefer
			cuadroMensajes.setText("Jaskier canta la primera estupidez que se le ocurre. " + frase + "Kikimora: "+miMonstruo.getFuerza()+" puntos");
			miMonstruo.pelear(miGeralt, miYeni, miJaskier);
			break;
		case "huir"://Boton huida
			if(miJaskier.huir()==true) {//llama al metodo creado el Jaskier para huir que se creaba gracias a una interface en la clase personaje
				cuadroMensajes.setText("Jaskier logró huir. ");
				VentanaHuida huir = new VentanaHuida();
				huir.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}else {
				miMonstruo.pelear(miGeralt, miYeni, miJaskier);	
				cuadroMensajes.setText("Jaskier no logró huir. "+ "\nKikimora: "+miMonstruo.getFuerza()+" puntos");
			}
			break;
		}

		if (miJaskier.getSalud()<0) {//para que la vida no sea nunca un número negativo
			miJaskier.setSalud(0);
		}

		if (miMonstruo.getSalud()<0) {//para que la vida no sea nunca un número negativo
			miMonstruo.setSalud(0);
		}

		if (miJaskier.getSalud()<=0 && miMonstruo.getSalud()>0) { //solo muere el monstruo
			try {
				VentanaDerrota derrota = new VentanaDerrota();
				derrota.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (miMonstruo.getSalud()<=0 && miJaskier.getSalud()>0) { //solo muere el/la héroe/heroína
			try {
				VentanaVictoria victoria = new VentanaVictoria();
				victoria.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (miMonstruo.getSalud()<=0 && miJaskier.getSalud()<=0) { //mueren ambos
			try {
				VentanaDerrota derrota = new VentanaDerrota();
				derrota.setVisible(true);
				this.dispose();//cerramos esta ventana al abrir la nueva ventana
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		vidaTuya.setText("Jaskier: "+ miJaskier.getSalud());// Actualiza la Salud de Jaskier en la interfaz grafica cada vez que peleamos
		vidaEnemigo.setText("Kikimora: "+ miMonstruo.getSalud());// Actualiza la Salud de Monstruo en la interfaz grafica cada vez que peleamos

	}

}
