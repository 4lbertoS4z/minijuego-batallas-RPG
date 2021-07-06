package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

@SuppressWarnings({ "serial", "unused" })
public class VentanaInicial extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSalir,btnOmitir;
	private JLabel lblNewLabel;

	public VentanaInicial() {
		//Valores de la ventana

		setResizable(false);
		setTitle("The  Witcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		sound();//Llamamos al metodo sound para que se empiece a reproducir la musica

		//Creamos los JLabel y Jbutton necesarios

		btnOmitir = new JButton("Jugar");
		btnOmitir.addActionListener(this);
		btnOmitir.setActionCommand("jugar");
		btnOmitir.setBounds(427, 306, 97, 23);
		contentPane.add(btnOmitir);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("salir");
		btnSalir.setBounds(10, 306, 89, 23);
		contentPane.add(btnSalir);

		lblNewLabel = new JLabel("logoJuego");
		lblNewLabel.setIcon(new ImageIcon(VentanaInicial.class.getResource("/img/the-witcher-netflix-810x400.jpg")));
		lblNewLabel.setBounds(10, 11, 514, 265);
		contentPane.add(lblNewLabel);



	}
	public void sound(){       
		try{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sound/ost.wav").getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();//iniciar música
			sonido.loop(Clip.LOOP_CONTINUOUSLY); //repetir siempre
		}catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("No se encuentra src/sound/ost.wav. Por favor, contacte con el servivio técnico.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand()=="salir") {
			System.exit(0);// cierra el programa
		}

		if (arg0.getActionCommand()=="jugar"){
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
