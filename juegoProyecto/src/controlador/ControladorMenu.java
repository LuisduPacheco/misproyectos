
//package controlador;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import vista.FrmAdministrador;
//import vista.FrmMenu;
//import vista.FrmPrincipiante;
//
//public class ControladorMenu implements ActionListener{
//
//    FrmAdministrador vAdmin = new FrmAdministrador();
//    FrmMenu vMnu = new FrmMenu();
//    FrmPrincipiante vPri = new FrmPrincipiante();
//    
//    
//    
//    
//    public ControladorMenu(FrmAdministrador vAdmin, FrmMenu vMnu, FrmPrincipiante vPri) {
//    this.vAdmin = vAdmin;
//    this.vMnu = vMnu;
//    this.vPri = vPri;
//            
//    vMnu.btnAdmin.addActionListener(this);
//    vMnu.btnAvan.addActionListener(this);
//    vMnu.btnInter.addActionListener(this);
//    vMnu.btnPrin.addActionListener(this);
//    
//    
//    }
//
//    
//    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//    if(e.getSource() == vMnu.btnAdmin){
//        this.vAdmin.setVisible(true);
//        vAdmin.setResizable(false);
//        vAdmin.setLocationRelativeTo(vMnu);
//    }
//    if(e.getSource() == vMnu.btnPrin){
//        this.vPri.setVisible(true);
//        vPri.setResizable(false);
//        vPri.setLocationRelativeTo(vMnu);
//    }
//    
//    }
//    
//
//
//
//}
