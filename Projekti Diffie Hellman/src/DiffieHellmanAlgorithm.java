
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;

import java.math.BigInteger;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;


import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DiffieHellmanAlgorithm extends JFrame {

	private JPanel contentPane;
	private JTextField txtN;
	private JTextField txtG;
	private JTextField txtA;
	private JTextField txtB;
	private boolean n;
	private boolean g;
	private JLabel lblg;
	private JLabel lbln;
	private boolean state = true;
	private JLabel lblCelesiA;
	private JLabel lblCelesiB;
	private JLabel lblB;
	private JLabel lblA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiffieHellmanAlgorithm frame = new DiffieHellmanAlgorithm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DiffieHellmanAlgorithm() {
		setResizable(false);
		setTitle("Diffie Hellman");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DiffieHellmanAlgorithm.class.getResource("/images/siguria4.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 699);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumriPrimN = new JLabel("Numri prim N:");
		lblNumriPrimN.setForeground(new Color(0, 0, 51));
		lblNumriPrimN.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumriPrimN.setBounds(32, 108, 145, 42);
		contentPane.add(lblNumriPrimN);
		
		JLabel lblNumriPrimG = new JLabel("Numri prim G:");
		lblNumriPrimG.setForeground(new Color(0, 0, 51));
		lblNumriPrimG.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumriPrimG.setBounds(386, 108, 145, 42);
		contentPane.add(lblNumriPrimG);
		
		txtN = new JTextField();
		txtN.setForeground(new Color(0, 0, 51));
		txtN.setFont(new Font("Arial", Font.BOLD, 16));
		txtN.setBorder(null);
		txtN.setOpaque(false);
		txtN.setBounds(66, 167, 267, 35);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		txtG = new JTextField();
		txtG.setForeground(new Color(0, 0, 51));
		txtG.setFont(new Font("Arial", Font.BOLD, 16));
		txtG.setOpaque(false);
		txtG.setBorder(null);
		txtG.setColumns(10);
		txtG.setBounds(420, 167, 267, 35);
		contentPane.add(txtG);
		
		JLabel lblNumriSekretA = new JLabel("\u00C7elesi privat A:");
		lblNumriSekretA.setForeground(new Color(0, 0, 51));
		lblNumriSekretA.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumriSekretA.setBounds(32, 255, 145, 42);
		contentPane.add(lblNumriSekretA);
		
		txtA = new JTextField();
		txtA.setForeground(new Color(0, 0, 51));
		txtA.setFont(new Font("Arial", Font.BOLD, 16));
		txtA.setBorder(null);
		txtA.setOpaque(false);
		txtA.setColumns(10);
		txtA.setBounds(66, 314, 267, 35);
		contentPane.add(txtA);
		
		txtB = new JTextField();
		txtB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					lbln.setText("");
					lblg.setText("");
					lblA.setText("");
					lblB.setText("");
					boolean valid = validimi();
					if(valid == false)
						JOptionPane.showMessageDialog(null, "Të dhënat nuk janë valide!");
					else
					{
						n = returnPrime(new BigInteger(txtN.getText()));
						g = returnPrime(new BigInteger(txtG.getText()));
						gjenerimi();
					}
				}
			}
		});
		txtB.setForeground(new Color(0, 0, 51));
		txtB.setFont(new Font("Arial", Font.BOLD, 16));
		txtB.setOpaque(false);
		txtB.setBorder(null);
		txtB.setColumns(10);
		txtB.setBounds(420, 314, 267, 35);
		contentPane.add(txtB);
		
		JLabel lblNumriSekretB = new JLabel("\u00C7elesi privat B:");
		lblNumriSekretB.setForeground(new Color(0, 0, 51));
		lblNumriSekretB.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumriSekretB.setBounds(386, 255, 145, 42);
		contentPane.add(lblNumriSekretB);
		
		JButton btnGjenero = new JButton("Gjenero");
		btnGjenero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					
					lbln.setText("");
					lblg.setText("");
					lblA.setText("");
					lblB.setText("");
					boolean valid = validimi();
					if(valid == false)
						JOptionPane.showMessageDialog(null, "Të dhënat nuk janë valide!");
					else
					{
						n = returnPrime(new BigInteger(txtN.getText()));
						g = returnPrime(new BigInteger(txtG.getText()));
						gjenerimi();
					}
				}
			}
		});
		btnGjenero.setForeground(Color.WHITE);
		btnGjenero.setBackground(new Color(51, 204, 255));
		btnGjenero.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/generate.png")));
		btnGjenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbln.setText("");
				lblg.setText("");
				lblA.setText("");
				lblB.setText("");
				boolean valid = validimi();
				if(valid == false)
					JOptionPane.showMessageDialog(null, "Të dhënat nuk janë valide!");
				else
				{
					n = returnPrime(new BigInteger(txtN.getText()));
					g = returnPrime(new BigInteger(txtG.getText()));
					gjenerimi();
				}
			}
		});
		btnGjenero.setFont(new Font("Arial", Font.BOLD, 16));
		btnGjenero.setBounds(143, 549, 217, 42);
		contentPane.add(btnGjenero);
		
		JButton btnPastro = new JButton("Pastro");
		btnPastro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					txtN.setText("");
					txtG.setText("");
					txtA.setText("");
					txtB.setText("");
					lblCelesiA.setText("");
					lblCelesiB.setText("");
					lbln.setText("");
					lblg.setText("");
					lblA.setText("");
					lblB.setText("");
				}
			}
		});
		btnPastro.setForeground(Color.WHITE);
		btnPastro.setBackground(new Color(51, 204, 255));
		btnPastro.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/erase.png")));
		btnPastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtN.setText("");
				txtG.setText("");
				txtA.setText("");
				txtB.setText("");
				lblCelesiA.setText("");
				lblCelesiB.setText("");
				lbln.setText("");
				lblg.setText("");
				lblA.setText("");
				lblB.setText("");
			}
		});
		btnPastro.setFont(new Font("Arial", Font.BOLD, 16));
		btnPastro.setBounds(386, 549, 217, 42);
		contentPane.add(btnPastro);
		
		lbln = new JLabel("");
		lbln.setForeground(Color.RED);
		lbln.setFont(new Font("Arial", Font.ITALIC, 13));
		lbln.setBounds(32, 198, 301, 16);
		contentPane.add(lbln);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 200, 301, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(386, 200, 301, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(32, 347, 301, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(386, 347, 301, 2);
		contentPane.add(separator_3);
		
		lblg = new JLabel("");
		lblg.setForeground(Color.RED);
		lblg.setFont(new Font("Arial", Font.ITALIC, 13));
		lblg.setBounds(386, 198, 301, 16);
		contentPane.add(lblg);
		
		JLabel lblelesiIGjeneruar = new JLabel("\u00C7elesi i gjeneruar nga A:");
		lblelesiIGjeneruar.setForeground(new Color(0, 0, 51));
		lblelesiIGjeneruar.setFont(new Font("Arial", Font.BOLD, 16));
		lblelesiIGjeneruar.setBounds(32, 398, 206, 42);
		contentPane.add(lblelesiIGjeneruar);
		
		lblCelesiA = new JLabel("");
		lblCelesiA.setForeground(new Color(0, 0, 51));
		lblCelesiA.setFont(new Font("Arial", Font.BOLD, 16));
		lblCelesiA.setBounds(308, 398, 379, 42);
		contentPane.add(lblCelesiA);
		
		JLabel lblelesiIGjeneruar_1 = new JLabel("\u00C7elesi i gjeneruar nga B:");
		lblelesiIGjeneruar_1.setForeground(new Color(0, 0, 51));
		lblelesiIGjeneruar_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblelesiIGjeneruar_1.setBounds(32, 471, 206, 42);
		contentPane.add(lblelesiIGjeneruar_1);
		
		lblCelesiB = new JLabel("");
		lblCelesiB.setForeground(new Color(0, 0, 51));
		lblCelesiB.setBackground(Color.WHITE);
		lblCelesiB.setFont(new Font("Arial", Font.BOLD, 16));
		lblCelesiB.setBounds(308, 471, 379, 42);
		contentPane.add(lblCelesiB);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.ITALIC, 10));
		label.setBounds(22, 268, 301, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 10));
		label_1.setBounds(434, 268, 301, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/keypass.png")));
		label_2.setBounds(32, 314, 33, 35);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/5.png")));
		label_3.setBounds(32, 167, 33, 35);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/7.png")));
		label_4.setBounds(386, 167, 33, 35);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/keypass.png")));
		label_5.setBounds(386, 314, 33, 35);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/key.png")));
		label_6.setBounds(250, 471, 46, 42);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/key.png")));
		label_7.setBounds(250, 398, 46, 42);
		contentPane.add(label_7);
		
		JLabel lblNewLabel = new JLabel("Diffie Hellman");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
		lblNewLabel.setBounds(158, 0, 459, 82);
		contentPane.add(lblNewLabel);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(DiffieHellmanAlgorithm.class.getResource("/images/siguria3.png")));
		label_10.setBounds(176, 0, 99, 82);
		contentPane.add(label_10);
		
		JLabel label_8 = new JLabel("");
		label_8.setBackground(new Color(51, 204, 255));
		label_8.setOpaque(true);
		label_8.setBounds(0, 0, 722, 82);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setBackground(new Color(51, 204, 255));
		label_9.setBounds(0, 600, 722, 64);
		contentPane.add(label_9);
		
		lblA = new JLabel("");
		lblA.setForeground(Color.RED);
		lblA.setFont(new Font("Arial", Font.ITALIC, 13));
		lblA.setBounds(32, 347, 301, 16);
		contentPane.add(lblA);
		
		lblB = new JLabel("");
		lblB.setForeground(Color.RED);
		lblB.setFont(new Font("Arial", Font.ITALIC, 13));
		lblB.setBounds(386, 347, 301, 16);
		contentPane.add(lblB);
		
		
	}
	public void gjenerimi()
	{
		try
		{
			if(n == false && g == false)
			{
				lbln.setText("Numri n nuk është prim!");
				lblg.setText("Numri g nuk është prim!");
				state = false;
			}
			else if(n == true && g == false)
			{
				lbln.setText("");
				lblg.setText("Numri g nuk është prim!");
				state = false;
			}
			else if(n == false && g == true)
			{
				lbln.setText("Numri n nuk është prim!");
				lblg.setText("");
				state = false;
			}
			else
			{
				lbln.setText("");
				lblg.setText("");
				state = true;
			}
			if(state)
			{
				try
				{
					BigInteger celesi1, celesi2;
					//Numri i pare prim
					BigInteger biG = new BigInteger(txtN.getText());
					//Numri i dyte prim
					BigInteger biP = new BigInteger(txtG.getText());
					//Numri sekret i A - celesi sekret i A
					BigInteger biA = new BigInteger(txtA.getText());
					//Numri sekret i B - celesi sekret i B
					BigInteger biB = new BigInteger(txtB.getText());
					
					// numriIdytePrim(biG)^(numriSekretiA(biA)) modulo (NumriIparePrim(biN))
					BigInteger numriIgjeneruarNgaA = biG.modPow(biA,biP);
					// numriIdytePrim(biG)^(numriSekretiB(biB)) modulo (NumriIparePrim(biN))
					BigInteger numriIgjeneruarNgaB = biG.modPow(biB, biP);
					
					//celesi sekret i gjeneruar nga A
					celesi1 = numriIgjeneruarNgaB.modPow(biA, biP);
					//celesi sekret i gjeneruar nga B
					celesi2 = numriIgjeneruarNgaA.modPow(biB, biP);
					lblCelesiA.setText(String.valueOf(celesi1));
					lblCelesiB.setText(String.valueOf(celesi2));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Keni gabime në formën tuaj!");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	public static boolean returnPrime(BigInteger number) {
		try
		{
		
		
		    
		    if (!number.isProbablePrime(5))
		        return false;
	
		    
		    BigInteger two = new BigInteger("2");
		    if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
		        return false;
	
		    
		    for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) 
		    { 
		        if (BigInteger.ZERO.equals(number.mod(i)))
		            return false;
		    }
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	    return true;
	}
	public boolean validimi()
	{
		int counter =0;
		String patterna = "^[1-9][0-9]*$";
		if(!Pattern.matches(patterna, txtN.getText()))
		{
			lbln.setText("Lejohen vetem numra të plotë!");
			counter++;
		}
		if(!Pattern.matches(patterna,txtG.getText()))
		{
			lblg.setText("Lejohen vetem numra të plotë!");
			counter++;
		}
		if(!Pattern.matches(patterna, txtA.getText()))
		{
			lblA.setText("Lejohen vetem numra të plotë!");
			counter++;
		}
		if(!Pattern.matches(patterna, txtB.getText()))
		{
			lblB.setText("Lejohen vetem numra të plotë!");
			counter++;
		}
		if(txtN.getText().equals(""))
		{
			lbln.setText("Ju lutem shkruani një numër prim!");
			counter++;
		}
		if(txtG.getText().equals(""))
		{
			lblg.setText("Ju lutem shkruani një numër prim!");
			counter++;
		}
		if(txtA.getText().equals(""))
		{
			lblA.setText("Ju lutem shkruani një numër të plotë!");
			counter++;
		}
		if(txtB.getText().equals(""))
		{
			lblB.setText("Ju lutem shkruani një numër të plotë!");
			counter++;
		}
		if(counter != 0)
			return false;
		
			
		return true;
	}
}
