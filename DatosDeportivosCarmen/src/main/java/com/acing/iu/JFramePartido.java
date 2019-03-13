package com.acing.iu;

import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.acing.eventos.Evento;
import com.acing.eventos.Partido;
import com.esotericsoftware.tablelayout.Value;
import com.esotericsoftware.tablelayout.swing.Table;

public class JFramePartido extends JFrame{
	
	private JComboBox cb_VariosTipos;
	private JCheckBox ckb_ParaAlgo;
	private JTextField txt_input;
	
	Partido partido = new Partido();
	
	public JFramePartido(Partido partido) {
		super();
		this.partido = partido;
		initialize();
	}
	
	

	private void initialize() {
		setName("Partido");
        setLocale(new Locale("es", "ES"));
        setMinimumSize(new Dimension(500, 600));
        //Establece el tamaño
        setBounds(100, 100, 1100, 400);
        
        setTitle("Partido");
        
      //Para que termine la ejecucion al cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JLabel lbl_1 = new JLabel("Participantes");
        JLabel lbl_3 = new JLabel("Resultado");
        
        JComboBox<String> cb_String = new JComboBox<>(new String[]{ partido.getLocal().toString(), partido.getVisitante().toString()});
        JComboBox<String> cb_String2 = new JComboBox<>(new String[]{ partido.getResultado()});
		
       
        Table tabla = new Table();
        Value padding = new Value.FixedValue(5);
        tabla.top().left().pad(padding);
        tabla.defaults().pad(padding).left();
        tabla.columnDefaults(2).expandX();
        getContentPane().add(tabla);
        
        Value anchoCombos = new Value.FixedValue(200);
        
        tabla.addCell(lbl_1);
        tabla.addCell(cb_String).width(anchoCombos);
        tabla.row();
        tabla.addCell(lbl_3);
        tabla.addCell(cb_String2).width(anchoCombos); 
        
	}

}
