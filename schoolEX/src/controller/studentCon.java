package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentImp;
import model.student;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class studentCon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentCon frame = new studentCon();
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
	public studentCon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 600, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(208, 10, 99, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(25, 69, 46, 15);
		panel.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(71, 66, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("國文");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(215, 69, 46, 15);
		panel.add(lblNewLabel_2);
		
		chi = new JTextField();
		chi.setBounds(259, 66, 96, 21);
		panel.add(chi);
		chi.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("英文");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(409, 69, 46, 15);
		panel.add(lblNewLabel_3);
		
		eng = new JTextField();
		eng.setBounds(444, 66, 96, 21);
		panel.add(eng);
		eng.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 208, 378, 109);
		panel.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JButton addButton = new JButton("新增");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();
				int CHI = Integer.parseInt(chi.getText());
				int ENG = Integer.parseInt(eng.getText());				
				student s = new student(Name,CHI,ENG);			
				new studentImp().add(s);
			}
		});
		addButton.setFont(new Font("新細明體", Font.BOLD, 14));
		addButton.setBounds(58, 162, 87, 23);
		panel.add(addButton);
		
		JButton queryButton = new JButton("查詢string");
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(new studentImp().queryAll1());
			}
		});
		queryButton.setFont(new Font("新細明體", Font.BOLD, 14));
		queryButton.setBounds(167, 162, 99, 23);
		panel.add(queryButton);
		
		JButton btnNewButton = new JButton("查詢list");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<student> l=new studentImp().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					show=show+"id:"+o.getId()+
							"\t姓名:"+o.getName()+
							"\t國文:"+o.getChi()+
							"\t英文:"+o.getEng()+
							"\t總分:"+(o.getChi()+o.getEng())+"\n";
				}
				show=show+"\n總分="+sum+"\t平均="+(sum/i);
				
				
				output.setText(show);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(289, 162, 87, 23);
		panel.add(btnNewButton);
	}
}