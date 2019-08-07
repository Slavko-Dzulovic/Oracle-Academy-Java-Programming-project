package oracle.java.programming;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainProgramFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textProdNo;
	private JTextField textName;
	private JTextField textAudioSpec;
	private JTextField textResolution;
	private JTextField textRefreshRate;
	private JTextField textResponseTime;
	
	private ArrayList<Product> productArrayList=new ArrayList<Product>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainProgramFrame frame = new MainProgramFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainProgramFrame()
	{
		setTitle("Java Programming Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Oracle Production");
		lblTitle.setBounds(23, 11, 150, 14);
		contentPane.add(lblTitle);

		JLabel lblSelectItemType = new JLabel("Select the type of your item:");
		lblSelectItemType.setBounds(23, 70, 173, 14);
		contentPane.add(lblSelectItemType);

		JLabel lblAudioSpecification = new JLabel("Audio specification: ");
		lblAudioSpecification.setBounds(23, 198, 130, 14);
		contentPane.add(lblAudioSpecification);
		
		textAudioSpec = new JTextField();
		textAudioSpec.setBounds(163, 195, 86, 20);
		contentPane.add(textAudioSpec);
		textAudioSpec.setColumns(10);
		
		JLabel lblMediaType = new JLabel("Media type: ");
		lblMediaType.setBounds(23, 173, 77, 14);
		contentPane.add(lblMediaType);
		

		JLabel lblEnterProdNo = new JLabel("Enter the number of the selected product:");
		lblEnterProdNo.setBounds(23, 103, 241, 14);
		contentPane.add(lblEnterProdNo);

		textProdNo = new JTextField();
		textProdNo.setBounds(260, 100, 86, 20);
		contentPane.add(textProdNo);
		textProdNo.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(23, 132, 46, 14);
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setBounds(81, 129, 86, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblScreen = new JLabel("Screen");
		lblScreen.setBounds(23, 198, 46, 14);
		contentPane.add(lblScreen);
		
		JLabel lblReso = new JLabel("Resolution");
		lblReso.setBounds(23, 223, 77, 14);
		contentPane.add(lblReso);
		
		textResolution = new JTextField();
		textResolution.setBounds(163, 220, 86, 20);
		contentPane.add(textResolution);
		textResolution.setColumns(10);
		
		JLabel lblRefreshRate = new JLabel("Refresh rate:");
		lblRefreshRate.setBounds(23, 248, 77, 14);
		contentPane.add(lblRefreshRate);
		
		textRefreshRate = new JTextField();
		textRefreshRate.setBounds(163, 245, 86, 20);
		contentPane.add(textRefreshRate);
		textRefreshRate.setColumns(10);
		
		JLabel lblResponseTime = new JLabel("Response time: ");
		lblResponseTime.setBounds(23, 273, 97, 14);
		contentPane.add(lblResponseTime);
		
		textResponseTime = new JTextField();
		textResponseTime.setBounds(163, 270, 86, 20);
		contentPane.add(textResponseTime);
		textResponseTime.setColumns(10);
		
		JLabel lblMonitorType = new JLabel("Monitor type:");
		lblMonitorType.setBounds(23, 173, 77, 14);
		contentPane.add(lblMonitorType);
		
		JComboBox comboBoxMonitor = new JComboBox();
		comboBoxMonitor.setModel(new DefaultComboBoxModel(new String[] {"LCD", "LED"}));
		comboBoxMonitor.setBounds(163, 170, 97, 20);
		contentPane.add(comboBoxMonitor);
		
		JComboBox comboBoxAudio = new JComboBox();
		comboBoxAudio.setModel(new DefaultComboBoxModel(new String[] {"AU", "AM"}));
		comboBoxAudio.setBounds(163, 170, 97, 20);
		contentPane.add(comboBoxAudio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<select>", "Audio Player", "Movie Player"}));
		comboBox.setBounds(249, 67, 97, 20);
		contentPane.add(comboBox);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					int n=Integer.parseInt(textProdNo.getText().trim());
					
					if(comboBox.getSelectedItem().toString().equals("Audio Player"))
					{
						String name=textName.getText();
						String audioSpec=textAudioSpec.getText();
						for(int i=0;i<n;i++)
							productArrayList.add(new AudioPlayer(name, audioSpec));

						clearFields();
					}
					
					else if(comboBox.getSelectedItem().toString().equals("Movie Player"))
					{
						String name=textName.getText();
						String resolution=textResolution.getText();
						int refreshRate=Integer.parseInt(textRefreshRate.getText().trim());
						int responseTime=Integer.parseInt(textResponseTime.getText().trim());
						String monitorType=comboBoxMonitor.getSelectedItem().toString();
						
						if(monitorType.equals("LCD"))
							for(int i=0;i<n;i++)
								productArrayList.add(new MoviePlayer(name, 
																new Screen(resolution, refreshRate, responseTime), 
																MonitorType.LCD));
						
						else if(monitorType.equals("LED"))
							for(int i=0;i<n;i++)
								productArrayList.add(new MoviePlayer(name, 
																new Screen(resolution, refreshRate, responseTime), 
																MonitorType.LED));

						clearFields();
					}
				}
				catch (Exception e)
				{
					System.out.println("Illegal number format!");
				}
			}
		});
		btnAdd.setBounds(23, 318, 89, 23);
		contentPane.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 70, 297, 272);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnPrintProductList = new JButton("Print product list");
		btnPrintProductList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				textArea.setText(null);
				if(productArrayList.size()>0)
				{
					for (Product product : productArrayList)
					{
						textArea.append(product.toString()+"\n");
					}
				}
				else textArea.append("List of products is empty!");
			}
		});
		btnPrintProductList.setBounds(516, 364, 130, 23);
		contentPane.add(btnPrintProductList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(749, 70, 291, 271);
		contentPane.add(scrollPane_1);
		
		JTextArea textAreaStatistics = new JTextArea();
		scrollPane_1.setViewportView(textAreaStatistics);
		
		JButton btnPrintProductStatistics = new JButton("Print production statistics");
		btnPrintProductStatistics.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				textAreaStatistics.setText(null);
				ArrayList<String> aListNames=new ArrayList<String>();
				for(int i=0;i<productArrayList.size();i++)
				{
					aListNames.add(productArrayList.get(i).getName());
				}
				long numberOfDistinct=aListNames.stream().distinct().count();
				if(productArrayList.size()>0)
				{
					textAreaStatistics.append("Total number of Products created: "+Integer.toString(Product.getProductionNumber()));
					textAreaStatistics.append("\nNumber of distinct products: "+numberOfDistinct+"\n");
				}
				else textAreaStatistics.append("List of products is empty!");
			}
		});
		btnPrintProductStatistics.setBounds(791, 364, 186, 23);
		contentPane.add(btnPrintProductStatistics);
		
		JButton btnSortListAlphabetically = new JButton("Sort list alphabetically");
		btnSortListAlphabetically.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				textArea.setText(null);
				if(productArrayList.size()>0)
				{
					Collections.sort(productArrayList);
					for (Product product : productArrayList)
					{
						textArea.append(product.toString()+"\n");
					}
				}
				else textArea.append("List of products is empty!");
			}
		});
		btnSortListAlphabetically.setBounds(499, 398, 163, 23);
		contentPane.add(btnSortListAlphabetically);
		

		lblEnterProdNo.setVisible(false);
		textProdNo.setVisible(false);
		lblName.setVisible(false);
		textName.setVisible(false);
		btnAdd.setVisible(false);
		
		lblAudioSpecification.setVisible(false);
		textAudioSpec.setVisible(false);
		lblMediaType.setVisible(false);
		lblAudioSpecification.setVisible(false);
		comboBoxAudio.setVisible(false);
		
		lblMonitorType.setVisible(false);
		lblRefreshRate.setVisible(false);
		lblReso.setVisible(false);
		lblScreen.setVisible(false);
		lblResponseTime.setVisible(false);
		textRefreshRate.setVisible(false);
		textResolution.setVisible(false);
		textResponseTime.setVisible(false);
		comboBoxMonitor.setVisible(false);
		
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				String key=comboBox.getSelectedItem().toString();
				switch (key)
				{
					case "Audio Player":
						lblAudioSpecification.setVisible(true);
						textAudioSpec.setVisible(true);
						lblMediaType.setVisible(true);
						lblAudioSpecification.setVisible(true);
						comboBoxAudio.setVisible(true);
						
						lblMonitorType.setVisible(false);
						lblRefreshRate.setVisible(false);
						lblReso.setVisible(false);
						lblScreen.setVisible(false);
						lblResponseTime.setVisible(false);
						textRefreshRate.setVisible(false);
						textResolution.setVisible(false);
						textResponseTime.setVisible(false);
						comboBoxMonitor.setVisible(false);
						
						lblEnterProdNo.setVisible(true);
						textProdNo.setVisible(true);
						lblName.setVisible(true);
						textName.setVisible(true);
						btnAdd.setVisible(true);
						
						break;
	
					case "Movie Player":
						
						lblAudioSpecification.setVisible(false);
						textAudioSpec.setVisible(false);
						lblMediaType.setVisible(false);
						lblAudioSpecification.setVisible(false);
						comboBoxAudio.setVisible(false);
						
						lblMonitorType.setVisible(true);
						lblRefreshRate.setVisible(true);
						lblReso.setVisible(true);
						lblScreen.setVisible(true);
						lblResponseTime.setVisible(true);
						textRefreshRate.setVisible(true);
						textResolution.setVisible(true);
						textResponseTime.setVisible(true);
						comboBoxMonitor.setVisible(true);
						
						lblEnterProdNo.setVisible(true);
						textProdNo.setVisible(true);
						lblName.setVisible(true);
						textName.setVisible(true);
						btnAdd.setVisible(true);
						
						break;
						
					case "<select>":
						
						lblAudioSpecification.setVisible(false);
						textAudioSpec.setVisible(false);
						lblMediaType.setVisible(false);
						lblAudioSpecification.setVisible(false);
						comboBoxAudio.setVisible(false);

						lblMonitorType.setVisible(false);
						lblRefreshRate.setVisible(false);
						lblReso.setVisible(false);
						lblScreen.setVisible(false);
						lblResponseTime.setVisible(false);
						textRefreshRate.setVisible(false);
						textResolution.setVisible(false);
						textResponseTime.setVisible(false);
						comboBoxMonitor.setVisible(false);
						
						lblEnterProdNo.setVisible(false);
						textProdNo.setVisible(false);
						lblName.setVisible(false);
						textName.setVisible(false);
						btnAdd.setVisible(false);
				}
				
				
				
				
				
				
				
				
				/*
				if(comboBox.getSelectedItem().toString().equals("Audio Player"));
				{
					lblAudioSpecification.setVisible(true);
					textAudioSpec.setVisible(true);
					lblMediaType.setVisible(true);
					lblAudioSpecification.setVisible(true);
					comboBoxAudio.setVisible(true);
					
					lblMonitorType.setVisible(false);
					lblRefreshRate.setVisible(false);
					lblReso.setVisible(false);
					lblScreen.setVisible(false);
					lblResponseTime.setVisible(false);
					textRefreshRate.setVisible(false);
					textResolution.setVisible(false);
					textResponseTime.setVisible(false);
					comboBoxMonitor.setVisible(false);
				}
				
				if(comboBox.getSelectedItem().toString().equals("Movie Player"));
				{
					lblAudioSpecification.setVisible(false);
					textAudioSpec.setVisible(false);
					lblMediaType.setVisible(false);
					lblAudioSpecification.setVisible(false);
					comboBoxAudio.setVisible(false);
					
					lblMonitorType.setVisible(true);
					lblRefreshRate.setVisible(true);
					lblReso.setVisible(true);
					lblScreen.setVisible(true);
					lblResponseTime.setVisible(true);
					textRefreshRate.setVisible(true);
					textResolution.setVisible(true);
					textResponseTime.setVisible(true);
					comboBoxMonitor.setVisible(true);
				}
				*/
			}
		});
	}
	
	private void clearFields()
	{
		textName.setText(null);
//		textProdNo.setText(null);
		textAudioSpec.setText(null);
		textRefreshRate.setText(null);
		textResolution.setText(null);
		textResponseTime.setText(null);	
	}
}
