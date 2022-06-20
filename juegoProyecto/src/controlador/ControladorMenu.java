
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmAdministrador;
import vista.FrmMenu;

public class ControladorMenu implements ActionListener{

    FrmAdministrador vAdmin = new FrmAdministrador();
    FrmMenu vMnu = new FrmMenu();
    
    
    
    
    public ControladorMenu(FrmAdministrador vAdmin, FrmMenu vMnu) {
    this.vAdmin = vAdmin;
    this.vMnu = vMnu;
            
    vMnu.btnAdmin.addActionListener(this);
    vMnu.btnAvan.addActionListener(this);
    vMnu.btnInter.addActionListener(this);
    vMnu.btnPrin.addActionListener(this);
    
    
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == vMnu.btnAdmin){
        this.vAdmin.setVisible(true);
        vAdmin.setResizable(false);
        vAdmin.setLocationRelativeTo(vMnu);
    }
    
    }
    



}
