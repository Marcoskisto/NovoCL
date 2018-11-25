package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesBasicas.*;
import lombok.*;

import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public static JDesktopPane desktopPane;
	
	@Getter @Setter
	public static CasaLeilao casa=new CasaLeilao();
	public static boolean logon=false;
	public static String loginCpf="";
	public static int idLeilao;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\andre\\Documents\\GitHub\\CasaLeilao\\CasaLeilao\\src\\iconLeilao.png"));
		setTitle("Leil\u00F5es System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 599);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmCadastrarUsuario = new JMenuItem("Cadastrar Usuario");
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastraUsuario novoCadastro= new CadastraUsuario();
				desktopPane.add(novoCadastro);
				novoCadastro.setVisible(true);
			}
		});
		mnUsuario.add(mntmCadastrarUsuario);
		
		JMenuItem mntmLogin = new JMenuItem("TelaLogin / Trocar Usu\u00E1rio");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin novoLogin = new TelaLogin();
				desktopPane.add(novoLogin);
				novoLogin.setVisible(true);
			}
		});
		mnUsuario.add(mntmLogin);
		
		JMenuItem mntmMeuPerfil = new JMenuItem("Meu Perfil");
		mntmMeuPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(logon) {
				MeuPerfil meuPerfil = new MeuPerfil();
				desktopPane.add(meuPerfil);
				meuPerfil.setVisible(true);
				}
			}
		});

		mntmMeuPerfil.setEnabled(true);
		mnUsuario.add(mntmMeuPerfil);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnUsuario.add(mntmSair);
		
		JMenu mnLeiloes = new JMenu("Leil\u00F5es");
		menuBar.add(mnLeiloes);
		
		JMenuItem mntmCadastrarLeilao = new JMenuItem("Cadastrar Leil\u00E3o");
		mntmCadastrarLeilao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarLeilao novoLeilao = new CadastrarLeilao();
				desktopPane.add(novoLeilao);
				novoLeilao.setVisible(true);
			}
		});
		mnLeiloes.add(mntmCadastrarLeilao);
		
		JMenuItem mntmGerenciarLeiloes = new JMenuItem("Gerenciar Leiloes");
		mntmGerenciarLeiloes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarLeiloes gerLeiloes = new GerenciarLeiloes();
				desktopPane.add(gerLeiloes);
				gerLeiloes.setVisible(true);
			}
		});
		mnLeiloes.add(mntmGerenciarLeiloes);
		
		JMenu mnLances = new JMenu("Lances");
		menuBar.add(mnLances);
		
		JMenuItem mntmFazerLance = new JMenuItem("Fazer Lance");
		mnLances.add(mntmFazerLance);
		
		JMenuItem mntmMeusLances = new JMenuItem("Meus Lances");
		mnLances.add(mntmMeusLances);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		desktopPane.setAlignmentY(Component.TOP_ALIGNMENT);
		desktopPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
