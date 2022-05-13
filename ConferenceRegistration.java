package javaapplication99;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.border.TitledBorder;

public class ConferenceRegistration extends JFrame{

   private JPanel registrationPanel;
   private JPanel registrationTypePanel;
   private JPanel workshopsPanel;
   private JPanel dinnerPanel;
   private JPanel buttonPanel;
   private JPanel leftPanel;
   private ButtonGroup bg;

   private JRadioButton generalRegistrationButton;
   private JRadioButton studentRegistrationButton;
  
   private JCheckBox dinnerCheckBox;
  
   private JButton calculateButton;
   private JButton exitButton;

   private JLabel registrationLabel;
   private JLabel registrationPanelLabel;
   private JLabel dinnerPanelLabel;
   private JLabel workshopLabel;
  
   private JList workshopList;
   private JScrollPane workshopListPane;
  

   private String[] workshops = {"Introduction to E-commerce", "The Future of the Web", "Advanced Java Programming", "Network Security"};
      
   private EventListener listener = new EventListener();
  
   private final int WINDOW_WIDTH = 1020;
   private final int WINDOW_HEIGHT = 500;
  
   private final double NETWORK_SECURITY_CLASS_COST = 395;
   private final double FUTURE_OF_WEB_CLASS_COST = 295;
   private final double ADVANCED_JAVA_CLASS_COST = 395;
   private final double E_COMMERCE_CLASS_COST = 295;
   private final double GENERAL_REGISTRATION_COST = 895;
   private final double STUDENT_REGISTRATION_COST = 495;
   private final double DINNER_COST = 30;
  
   public ConferenceRegistration() {
  
       setTitle("Conference Registration System");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
    
       buildRegistrationPanel();
       buildRegistrationTypePanel();
       buildworkshopsPanel();
       buildButtonPanel();
       pack(); 
       setVisible(true);
   }
 
   private void buildRegistrationPanel() { 
       registrationPanel = new JPanel();
      
       registrationLabel = new JLabel("Select Registration Options");
      
       registrationLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
      
       registrationPanel.add(registrationLabel);
      
       add(registrationPanel, BorderLayout.NORTH);         
   }

   private void buildworkshopsPanel() {
       workshopsPanel = new JPanel();
  
       setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
  
       workshopList = new JList(workshops);

       workshopList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
     
       workshopList.setVisibleRowCount(4);

       workshopListPane = new JScrollPane(workshopList);
    
       workshopsPanel.add(workshopListPane);

       TitledBorder border = new TitledBorder("Workshops");
       border.setTitleJustification(TitledBorder.LEFT);
       border.setTitlePosition(TitledBorder.TOP);
  
       workshopsPanel.setBorder(border);
       add(workshopsPanel, BorderLayout.EAST);
   }

   private void buildRegistrationTypePanel() {

       generalRegistrationButton = new JRadioButton("General Registration");
       studentRegistrationButton = new JRadioButton("Student Registration");

       registrationTypePanel = new JPanel();
       registrationTypePanel.setLayout(new GridLayout(1,2));
      
       bg = new ButtonGroup();
       bg.add(generalRegistrationButton);
       bg.add(studentRegistrationButton);
      
       generalRegistrationButton.setSelected(true);
      
       registrationTypePanel.add(generalRegistrationButton);
       registrationTypePanel.add(studentRegistrationButton);

       TitledBorder border = new TitledBorder("Registration Type");
       border.setTitleJustification(TitledBorder.LEFT);
       border.setTitlePosition(TitledBorder.TOP);
       registrationTypePanel.setBorder(border);
  
       dinnerCheckBox = new JCheckBox("Dinner and Keynote Speech");
       dinnerPanel = new JPanel();
       dinnerPanel.add(dinnerCheckBox);
 
       leftPanel = new JPanel();
       leftPanel.setLayout(new GridLayout(2, 1));
       leftPanel.add(registrationTypePanel);
       leftPanel.add(dinnerPanel);
       add(leftPanel, BorderLayout.WEST);    
   }

   private void buildButtonPanel() {
       calculateButton = new JButton("Calculate Charges");
       exitButton = new JButton("Exit");
      
       calculateButton.addActionListener(listener);
       exitButton.addActionListener(listener);
      
       buttonPanel = new JPanel();
       buttonPanel.add(calculateButton);
       buttonPanel.add(exitButton);
   
   add(buttonPanel, BorderLayout.SOUTH);
   }

   private class EventListener implements ActionListener {
      
           public void actionPerformed(ActionEvent e) {
  
               List selections = workshopList.getSelectedValuesList();
               double price = 0;
               String[] selectionList = (String[]) selections.toArray(new String[0]);
              
               for(int i =0; i<selectionList.length; i++) {
                   if(selectionList[i] == "Network Security") {
                       price += NETWORK_SECURITY_CLASS_COST;                      
                   }
                   if(selectionList[i] == "The Future of the Web") {
                       price +=FUTURE_OF_WEB_CLASS_COST;
                   }
                   if(selectionList[i] == "Advanced Java Programming") {
                       price +=ADVANCED_JAVA_CLASS_COST;                  
                   }
                   if(selectionList[i] == "Introduction to E-commerce") {
                       price +=E_COMMERCE_CLASS_COST;
                   }
               }
              
              
               if(generalRegistrationButton.isSelected()) {
                   price += GENERAL_REGISTRATION_COST;
                  
               }
               else if (studentRegistrationButton.isSelected()) {
                   price += STUDENT_REGISTRATION_COST;
               }
               
              
               if(dinnerCheckBox.isSelected()) {
                   price +=DINNER_COST;
                  
               }
              
               if(e.getActionCommand() == "Calculate Charges") {
 
                       System.out.println(price);  
                      
                       DecimalFormat df = new DecimalFormat("##.00");
                       JOptionPane.showMessageDialog(null, "Total charges: $" + df.format(price), "Message",                          
                           JOptionPane.INFORMATION_MESSAGE);
                   
                  
               }
           
               if(e.getActionCommand() == "Exit") {
                   System.exit(1);
                   System.out.println("exit");
               }
          
          
          
              
           }          
       }
}
  
