package gestionLocation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui {
	private JTextField nomAjou;
	private JTextField PrenText;
	private JTextField CniAjout;
	private JTextField IdSuppr;
	private JTextField nomModif;
	private JTextField nomPren;
	private JTextField cniModif;
	private JTextField IdModif;
	private JTextField cniRech;
	private JTextField marTexte;
	private JTextField modTexte;
	private JTextField annText;
	private JTextField Idsupp;
	private JTextField nouvmar;
	private JTextField nouvmod;
	private JTextField nouvAnn;
	private JTextField Idmodif;
	private JTextField marRecher;
	GestionLocationVehicule G;
    private static String user="root";
    private static String pass="";
    private static String url = "jdbc:mysql://localhost:3306/agencelocation";
    Connection myConnection;
    private JTable tabClient;
    private JTextField modRecher;
    private JTable table_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_8;
    private JTable table_3;
	/**
	 * @wbp.parser.entryPoint
	 */
	public Gui() {
		try {
			myConnection = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        try {
            G = new GestionLocationVehicule();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        try {
		JPanel principle = new JPanel();
		JFrame mFram = new JFrame();
		mFram.getContentPane().setBackground(new Color(240, 248, 255));
		mFram.setBackground(new Color(240, 248, 255));
		mFram.setVisible(true);
		mFram.setSize(930,500);
		mFram.setTitle("Yassine Moulat El Ali");
		mFram.setLocationRelativeTo(null);
		mFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFram.getContentPane().setLayout(null);
		//=================================================================
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 248, 255));
		tabbedPane.setBounds(0, 0, 857, 466);
		tabbedPane.setToolTipText("");
		mFram.getContentPane().add(tabbedPane);
		
		JPanel Location = new JPanel();
		Location.setBackground(new Color(240, 248, 255));
		tabbedPane.addTab("Location", null, Location, null);
		Location.setLayout(null);
		
		JPanel AjoPanel_1_1 = new JPanel();
		AjoPanel_1_1.setBounds(73, 11, 381, 206);
		AjoPanel_1_1.setLayout(null);
		AjoPanel_1_1.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Enregistrer", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		AjoPanel_1_1.setBackground(new Color(240, 248, 255));
		Location.add(AjoPanel_1_1);
		
		JLabel marqAjout_1 = new JLabel("Marque");
		marqAjout_1.setHorizontalAlignment(SwingConstants.CENTER);
		marqAjout_1.setBounds(31, 27, 110, 31);
		AjoPanel_1_1.add(marqAjout_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(151, 27, 177, 31);
		AjoPanel_1_1.add(textField);
		
		JLabel modAjout_1 = new JLabel("Model");
		modAjout_1.setHorizontalAlignment(SwingConstants.CENTER);
		modAjout_1.setBounds(31, 74, 110, 31);
		AjoPanel_1_1.add(modAjout_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 74, 177, 31);
		AjoPanel_1_1.add(textField_1);
		
		JLabel annAjout_1 = new JLabel("CNI");
		annAjout_1.setHorizontalAlignment(SwingConstants.CENTER);
		annAjout_1.setBounds(31, 116, 110, 31);
		AjoPanel_1_1.add(annAjout_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 116, 177, 31);
		AjoPanel_1_1.add(textField_2);
		
		JButton EnrButton = new JButton("Enregistrer");
		EnrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mar = textField.getText();
				String mod = textField_1.getText();
				String cni = textField_2.getText();
				try {
					G.EnregisterLocation(cni, mar, mod);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		EnrButton.setBackground(new Color(144, 238, 144));
		EnrButton.setBounds(134, 158, 110, 31);
		AjoPanel_1_1.add(EnrButton);
		
		JPanel ModPanel_1_1 = new JPanel();
		ModPanel_1_1.setBounds(464, 11, 378, 206);
		ModPanel_1_1.setLayout(null);
		ModPanel_1_1.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Cloturer", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ModPanel_1_1.setBackground(new Color(240, 248, 255));
		Location.add(ModPanel_1_1);
		
		JLabel KilomButton = new JLabel("Kilometrage");
		KilomButton.setHorizontalAlignment(SwingConstants.CENTER);
		KilomButton.setBounds(20, 65, 110, 31);
		ModPanel_1_1.add(KilomButton);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(158, 65, 176, 31);
		ModPanel_1_1.add(textField_5);
		
		JLabel EtatButton = new JLabel("Etat");
		EtatButton.setHorizontalAlignment(SwingConstants.CENTER);
		EtatButton.setBounds(20, 112, 110, 31);
		ModPanel_1_1.add(EtatButton);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(158, 112, 176, 31);
		ModPanel_1_1.add(textField_6);
		
		JButton ClotButton = new JButton("Cloturer");
		ClotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textField_8.getText();
				int ID = Integer.parseInt(temp);
				String tem2 = textField_5.getText();
				int kil = Integer.parseInt(tem2);
				String etat = textField_6.getText();
				try {
					G.CloturerLocation(ID, kil, etat);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_8.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		ClotButton.setBackground(new Color(250, 240, 230));
		ClotButton.setBounds(125, 154, 110, 31);
		ModPanel_1_1.add(ClotButton);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(158, 23, 176, 31);
		ModPanel_1_1.add(textField_8);
		
		JLabel IdClot = new JLabel("ID");
		IdClot.setHorizontalAlignment(SwingConstants.CENTER);
		IdClot.setBounds(20, 23, 110, 31);
		ModPanel_1_1.add(IdClot);
		
		table_3 = new JTable();
		table_3.setBounds(308, 228,534, 199);
		Location.add(table_3);
		
		JButton EnrButton_1 = new JButton("Visualiser");
		EnrButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Requette = "SELECT l.IDLocation, v.Marque AS vehicule, c.Nom AS clientNom, c.Prenom AS PrenomClient,l.KilometrageRetour,l.EtatVehicule "+
					    "FROM location l "+
					    			"JOIN vehicule v ON l.IDVehicule = v.IDVehicule "+
					    "JOIN client c ON l.IDClient = c.IDClient "+
					    			" WHERE l.DateRetour IS NULL OR l.DateRetour >= CURRENT_DATE";
				afficher(Requette,table_3);
			}
		});
		EnrButton_1.setBackground(new Color(216, 191, 216));
		EnrButton_1.setBounds(55, 304, 165, 52);
		Location.add(EnrButton_1);
		//=============================== partie Client ==============================================
		
		JPanel Client = new JPanel();
		Client.setBackground(new Color(240, 248, 255));
		tabbedPane.addTab("Client", null, Client, null);
		Client.setLayout(null);
		
		//-------------------------- 1)petit panel d'ajout --------------------------------------
		
		JPanel AjoPanel = new JPanel();
		AjoPanel.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Ajout", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		AjoPanel.setBackground(new Color(240, 248, 255));
		AjoPanel.setBounds(10, 11, 265, 206);
		Client.add(AjoPanel);
		AjoPanel.setLayout(null);
		
		JLabel nomAjout = new JLabel("Nom");
		nomAjout.setBounds(10, 27, 110, 31);
		AjoPanel.add(nomAjout);
		nomAjout.setHorizontalAlignment(SwingConstants.CENTER);
		
		nomAjou = new JTextField();
		nomAjou.setBounds(118, 27, 122, 31);
		AjoPanel.add(nomAjou);
		nomAjou.setColumns(10);
		
		JLabel prenAjout = new JLabel("Prenom");
		prenAjout.setBounds(10, 74, 110, 31);
		AjoPanel.add(prenAjout);
		prenAjout.setHorizontalAlignment(SwingConstants.CENTER);
		
		PrenText = new JTextField();
		PrenText.setBounds(118, 74, 122, 31);
		AjoPanel.add(PrenText);
		PrenText.setColumns(10);
		
		JLabel cniAjout = new JLabel("CNI");
		cniAjout.setBounds(10, 116, 110, 31);
		AjoPanel.add(cniAjout);
		cniAjout.setHorizontalAlignment(SwingConstants.CENTER);
		
		CniAjout = new JTextField();
		CniAjout.setBounds(118, 116, 122, 31);
		AjoPanel.add(CniAjout);
		CniAjout.setColumns(10);
		
		JButton AjoButton = new JButton("Ajouter");
		AjoButton.setBackground(new Color(102, 205, 170));
		AjoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String nom = nomAjou.getText();
		        String pren = PrenText.getText();
		        String cnI = CniAjout.getText();
		        // Appeler la méthode ajouterClient de la classe G avec les informations saisies		
					try {
						G.AjouterClient(new Client(getId("SELECT MAX(IDClient) AS maxID FROM client"),nom, pren,cnI));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nomAjou.setText("");
					PrenText.setText("");
					CniAjout.setText("");
			}
			
			
		});
		AjoButton.setBounds(90, 158, 89, 31);
		AjoPanel.add(AjoButton);
		
		
		JPanel SupPanel = new JPanel();
		SupPanel.setLayout(null);
		SupPanel.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Supprim", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		SupPanel.setBackground(new Color(240, 248, 255));
		SupPanel.setBounds(285, 11, 229, 116);
		Client.add(SupPanel);
		
		JLabel idSupprimer = new JLabel("ID");
		idSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		idSupprimer.setBounds(21, 27, 52, 31);
		SupPanel.add(idSupprimer);
		
		IdSuppr = new JTextField();
		IdSuppr.setColumns(10);
		IdSuppr.setBounds(83, 27, 122, 31);
		SupPanel.add(IdSuppr);
		
		JButton SupButton = new JButton("Supprimer");
		SupButton.setBackground(new Color(255, 182, 193));
		SupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String IDs = IdSuppr.getText();
				 int Ids = Integer.parseInt(IDs);
				 try {
					G.SupprimerClient(Ids);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 IdSuppr.setText("");
			}
		});
		SupButton.setBounds(70, 69, 99, 31);
		SupPanel.add(SupButton);
		
		//========= Panel modifier Client =====================
		JPanel ModPanel = new JPanel();
		ModPanel.setLayout(null);
		ModPanel.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Modifie", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ModPanel.setBackground(new Color(240, 248, 255));
		ModPanel.setBounds(524, 11, 265, 238);
		Client.add(ModPanel);
		//================= champ de siasie nom ==========================
		JLabel nomModifier = new JLabel("Nouveau Nom");
		nomModifier.setHorizontalAlignment(SwingConstants.CENTER);
		nomModifier.setBounds(10, 65, 110, 31);
		ModPanel.add(nomModifier);
		
		nomModif = new JTextField();
		nomModif.setColumns(10);
		nomModif.setBounds(118, 65, 122, 31);
		ModPanel.add(nomModif);
		
		//================= champ de siasie prenom ==========================
		JLabel prenModifier = new JLabel("Nouveau Prenom");
		prenModifier.setHorizontalAlignment(SwingConstants.CENTER);
		prenModifier.setBounds(10, 112, 110, 31);
		ModPanel.add(prenModifier);
		
		nomPren = new JTextField();
		nomPren.setColumns(10);
		nomPren.setBounds(118, 112, 122, 31);
		ModPanel.add(nomPren);
		
		//================= champ de siasie cni ==========================
		JLabel cniModifier = new JLabel("Nouveau CNI");
		cniModifier.setHorizontalAlignment(SwingConstants.CENTER);
		cniModifier.setBounds(10, 154, 110, 31);
		ModPanel.add(cniModifier);
		
		cniModif = new JTextField();
		cniModif.setColumns(10);
		cniModif.setBounds(118, 154, 122, 31);
		ModPanel.add(cniModif);
		
		//
		JButton modButton = new JButton("Modifier");
		modButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tem = IdModif.getText();
				int idm = Integer.parseInt(tem);
				String nouvnom = nomModifier.getText();
				String nouvpren = prenModifier.getText();
				String nouvcni = cniModifier.getText();
				try {
					G.ModifierClient(idm, new Client(idm, nouvnom, nouvpren, nouvcni));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				IdModif.setText("");
				nomModif.setText("");
				nomPren.setText("");
				cniModif.setText("");
			}
		});
		modButton.setBackground(new Color(135, 206, 250));
		modButton.setBounds(89, 196, 89, 31);
		ModPanel.add(modButton);
		
		IdModif = new JTextField();
		IdModif.setColumns(10);
		IdModif.setBounds(118, 23, 122, 31);
		ModPanel.add(IdModif);
		
		JLabel idModifier = new JLabel("ID");
		idModifier.setHorizontalAlignment(SwingConstants.CENTER);
		idModifier.setBounds(10, 23, 110, 31);
		ModPanel.add(idModifier);
		//======================= petit panel Rechercher =========================
		JPanel RechPanel = new JPanel();
		RechPanel.setLayout(null);
		RechPanel.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Recherche", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		RechPanel.setBackground(new Color(240, 248, 255));
		RechPanel.setBounds(285, 133, 229, 116);
		Client.add(RechPanel);
		
		//~~~~~~~~~~~~~~~~~~ champ de saisie CNI ~~~~~~~~~~~~~~~~~~
		
		JLabel lblCni = new JLabel("CNI");
		lblCni.setHorizontalAlignment(SwingConstants.CENTER);
		lblCni.setBounds(21, 27, 52, 31);
		RechPanel.add(lblCni);
		
		cniRech = new JTextField();
		cniRech.setColumns(10);
		cniRech.setBounds(83, 27, 122, 31);
		RechPanel.add(cniRech);
		
		//~~~~~~~~~~~~~~~~~~ button Rechecher ~~~~~~~~~~~~~~~~~~
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cniR = cniRech.getText();
				String requette = "SELECT * FROM Client WHERE CNI = "+"'"+cniR+"' ;";
				System.out.println(requette);
				rechercher(requette,tabClient);
				cniRech.setText("");
			}
		});
		btnRechercher.setBackground(new Color(192, 192, 192));
		btnRechercher.setBounds(70, 69, 101, 31);
		RechPanel.add(btnRechercher);
		
		//--------------------------- petit panel du tableau ------------------------------
		
		JPanel panel = new JPanel();
		panel.setBounds(238, 260, 551, 167);
		Client.add(panel);
		panel.setLayout(null);
		
		tabClient = new JTable();
		tabClient.setColumnSelectionAllowed(true);
		tabClient.setCellSelectionEnabled(true);
		tabClient.setBounds(0, 0, 551, 167);
		panel.add(tabClient);
		
		//~~~~~~~~~~~~~~~~~~ button afficher ~~~~~~~~~~~~~~~~~~
		
		JButton Affbutton = new JButton("Afficher");
		Affbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requette = "SELECT * FROM Client;";
				afficher(requette,tabClient);
			}
		});
		Affbutton.setBackground(new Color(255, 255, 240));
		Affbutton.setBounds(55, 322, 99, 32);
		Client.add(Affbutton);
		tabClient.setColumnSelectionAllowed(true);
		tabClient.setCellSelectionEnabled(true);
		
		//=============================== partie Vehicule ==============================================
		
		JPanel Vehicule = new JPanel();
		Vehicule.setBackground(new Color(240, 248, 255));
		tabbedPane.addTab("vehicule", null, Vehicule, null);
		Vehicule.setLayout(null);
		
		
		JPanel AjoPanel_1 = new JPanel();
		AjoPanel_1.setLayout(null);
		AjoPanel_1.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Ajout", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		AjoPanel_1.setBackground(new Color(240, 248, 255));
		AjoPanel_1.setBounds(10, 11, 265, 206);
		Vehicule.add(AjoPanel_1);
		
		JLabel marqAjout = new JLabel("Marque");
		marqAjout.setHorizontalAlignment(SwingConstants.CENTER);
		marqAjout.setBounds(10, 27, 110, 31);
		AjoPanel_1.add(marqAjout);
		
		marTexte = new JTextField();
		marTexte.setColumns(10);
		marTexte.setBounds(118, 27, 122, 31);
		AjoPanel_1.add(marTexte);
		
		JLabel modAjout = new JLabel("Model");
		modAjout.setHorizontalAlignment(SwingConstants.CENTER);
		modAjout.setBounds(10, 74, 110, 31);
		AjoPanel_1.add(modAjout);
		
		modTexte = new JTextField();
		modTexte.setColumns(10);
		modTexte.setBounds(118, 74, 122, 31);
		AjoPanel_1.add(modTexte);
		
		JLabel annAjout = new JLabel("Annee");
		annAjout.setHorizontalAlignment(SwingConstants.CENTER);
		annAjout.setBounds(10, 116, 110, 31);
		AjoPanel_1.add(annAjout);
		
		annText = new JTextField();
		annText.setColumns(10);
		annText.setBounds(118, 116, 122, 31);
		AjoPanel_1.add(annText);
		
		JButton AjoButton_1 = new JButton("Ajouter");
		AjoButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marque = marTexte.getText();
		        String modele = modTexte.getText();
		        String temp = annText.getText();
		        int annee = Integer.parseInt(temp);
		        // Appeler la méthode ajouterClient de la classe G avec les informations saisies		
					try {
						G.AjouterVehicule(new Vehicule(getId("SELECT MAX(IDVehicule) AS maxID FROM vehicule"),marque, modele,annee));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					marTexte.setText("");
					modTexte.setText("");
					annText.setText("");
				
			}
		});
		AjoButton_1.setBackground(new Color(144, 238, 144));
		AjoButton_1.setBounds(90, 158, 89, 31);
		AjoPanel_1.add(AjoButton_1);
		
		JPanel SupPanel_1 = new JPanel();
		SupPanel_1.setLayout(null);
		SupPanel_1.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Supprim", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		SupPanel_1.setBackground(new Color(240, 248, 255));
		SupPanel_1.setBounds(285, 11, 229, 116);
		Vehicule.add(SupPanel_1);
		
		JLabel idSupprimer_1 = new JLabel("ID");
		idSupprimer_1.setHorizontalAlignment(SwingConstants.CENTER);
		idSupprimer_1.setBounds(21, 27, 52, 31);
		SupPanel_1.add(idSupprimer_1);
		
		Idsupp = new JTextField();
		Idsupp.setColumns(10);
		Idsupp.setBounds(83, 27, 122, 31);
		SupPanel_1.add(Idsupp);
		
		JButton SupButton_1 = new JButton("Supprimer");
		SupButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDv = Idsupp.getText();
				 int Ids = Integer.parseInt(IDv);
				 try {
					G.SupprimerVehicule(Ids);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 Idsupp.setText("");
			}
		});
		SupButton_1.setBackground(new Color(255, 255, 255));
		SupButton_1.setBounds(70, 69, 102, 31);
		SupPanel_1.add(SupButton_1);
		
		JPanel ModPanel_1 = new JPanel();
		ModPanel_1.setLayout(null);
		ModPanel_1.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Modifie", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ModPanel_1.setBackground(new Color(240, 248, 255));
		ModPanel_1.setBounds(524, 11, 265, 238);
		Vehicule.add(ModPanel_1);
		
		JLabel marModifier = new JLabel("Nouvelle Marque");
		marModifier.setHorizontalAlignment(SwingConstants.CENTER);
		marModifier.setBounds(10, 65, 110, 31);
		ModPanel_1.add(marModifier);
		
		nouvmar = new JTextField();
		nouvmar.setColumns(10);
		nouvmar.setBounds(118, 65, 122, 31);
		ModPanel_1.add(nouvmar);
		
		JLabel modModifier_1 = new JLabel("Nouveau Modele");
		modModifier_1.setHorizontalAlignment(SwingConstants.CENTER);
		modModifier_1.setBounds(10, 112, 110, 31);
		ModPanel_1.add(modModifier_1);
		
		nouvmod = new JTextField();
		nouvmod.setColumns(10);
		nouvmod.setBounds(118, 112, 122, 31);
		ModPanel_1.add(nouvmod);
		
		JLabel cniModifier_1 = new JLabel("Nouvelle Annee");
		cniModifier_1.setHorizontalAlignment(SwingConstants.CENTER);
		cniModifier_1.setBounds(10, 154, 110, 31);
		ModPanel_1.add(cniModifier_1);
		
		nouvAnn = new JTextField();
		nouvAnn.setColumns(10);
		nouvAnn.setBounds(118, 154, 122, 31);
		ModPanel_1.add(nouvAnn);
		
		JButton modButton_1 = new JButton("Modifier");
		modButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = Idmodif.getText();
				int id = Integer.parseInt(temp);
				String mar = nouvmar.getText();
				String mod = nouvmod.getText();
				String t = nouvAnn.getText();
				int ann = Integer.parseInt(t);
				try {
					G.ModifierVehicule(id, new Vehicule(id, mar, mod, ann));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Idmodif.setText("");
				nouvmar.setText("");
				nouvmod.setText("");
				nouvAnn.setText("");
			}
		});
		modButton_1.setBackground(new Color(250, 240, 230));
		modButton_1.setBounds(89, 196, 89, 31);
		ModPanel_1.add(modButton_1);
		
		Idmodif = new JTextField();
		Idmodif.setColumns(10);
		Idmodif.setBounds(118, 23, 122, 31);
		ModPanel_1.add(Idmodif);
		
		JLabel idModifier_1 = new JLabel("ID");
		idModifier_1.setHorizontalAlignment(SwingConstants.CENTER);
		idModifier_1.setBounds(10, 23, 110, 31);
		ModPanel_1.add(idModifier_1);
		
		JPanel RechPanel_1 = new JPanel();
		RechPanel_1.setLayout(null);
		RechPanel_1.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 2, true), "Recherche", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		RechPanel_1.setBackground(new Color(240, 248, 255));
		RechPanel_1.setBounds(10, 239, 265, 161);
		Vehicule.add(RechPanel_1);
		
		JLabel lblCni_1 = new JLabel("Marque");
		lblCni_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCni_1.setBounds(21, 27, 52, 31);
		RechPanel_1.add(lblCni_1);
		
		marRecher = new JTextField();
		marRecher.setColumns(10);
		marRecher.setBounds(83, 27, 138, 31);
		RechPanel_1.add(marRecher);
		
		JButton btnRechercher_1 = new JButton("Rechercher");
		btnRechercher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marR = marRecher.getText();
				String modR = modRecher.getText();
				String requette = "SELECT * FROM vehicule WHERE Marque = '"+marR+"'" + " AND Modele = '"+modR+"' ;";
				System.out.println(requette);
				rechercher(requette,table_1);
				marRecher.setText("");
				modRecher.setText("");
			}
		});
		btnRechercher_1.setBackground(new Color(230, 230, 250));
		btnRechercher_1.setBounds(90, 119, 89, 31);
		RechPanel_1.add(btnRechercher_1);
		
		JLabel lblCni_1_1 = new JLabel("Model");
		lblCni_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCni_1_1.setBounds(21, 77, 52, 31);
		RechPanel_1.add(lblCni_1_1);
		
		modRecher = new JTextField();
		modRecher.setColumns(10);
		modRecher.setBounds(83, 77, 138, 31);
		RechPanel_1.add(modRecher);
		
		JButton affichVehicule = new JButton("Afficher");
		affichVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requette = "SELECT * FROM vehicule;";
				afficher(requette,table_1);
			}
		});
		affichVehicule.setBackground(new Color(245, 245, 220));
		affichVehicule.setBounds(309, 159, 187, 58);
		Vehicule.add(affichVehicule);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(307, 260, 482, 167);
		Vehicule.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(309, 260, 478, 163);
		Vehicule.add(table_1);
	} catch (Exception e) {

	}
	}
	
	int getId(String requette) {
	    int id = 0;
	    try (PreparedStatement pr = myConnection.prepareStatement(requette);
	         ResultSet res = pr.executeQuery()) {

	        if (res.next()) {
	            id = res.getInt("maxID") + 1;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return id;
	}

    public void rechercher(String requette,JTable tab) {
	    PreparedStatement pr;
	    ResultSet res;
	    int lig = 0;
	    int col = 0;
	    
			try {
				pr = myConnection.prepareStatement(requette);
				res = pr.executeQuery();
				java.sql.ResultSetMetaData metaData = res.getMetaData();
	            col = metaData.getColumnCount();
	            
	            String[] colone = new String[col];
	            for (int i = 0; i < col; i++) {
	                colone[i] = metaData.getColumnName(i + 1);
	            }
				res.last();
				lig = res.getRow();
				col = res.getMetaData().getColumnCount();
				res.beforeFirst();
				String lignD [][] = new String[lig][col];
		    	int r=0;
				while (res.next()) {
					for (int i = 0; i<col;i++) {
						lignD[r][i]=res.getString(i+1);
					}
					r++; 
				}
				DefaultTableModel model  = (DefaultTableModel) tab.getModel();
				model.setDataVector(lignD, colone);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    public void afficher(String requette,JTable tab) {
    	 try {
	        System.out.println(requette);
	        PreparedStatement pr = myConnection.prepareStatement(requette);
	        ResultSet res = pr.executeQuery();
            java.sql.ResultSetMetaData metaData = res.getMetaData();
            int col = metaData.getColumnCount();            
            String[] colone = new String[col];
            for (int i = 0; i < col; i++) {
                colone[i] = metaData.getColumnName(i + 1);
            }

            res.last();
            int lig = res.getRow();
            res.beforeFirst();

            String[][] donnee = new String[lig][col];
            int r = 0;

            while (res.next()) {
                for (int i = 0; i < col; i++) {
                    donnee[r][i] = res.getString(i + 1);
                }
                r++;
            }

            DefaultTableModel model = (DefaultTableModel) tab.getModel();
            model.setDataVector(donnee, colone);
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }


    

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public static void main(String[] args) {
		Gui G = new Gui();	
	}
}
