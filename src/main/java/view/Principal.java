package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMunicipio;
import controller.ControladorProvincia;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField tf_filtrar;
	private JTextField tf_NombreMunicipio;
	private JComboBox<Municipio> jcbSeleccionar;
	private JComboBox<Provincia> jcbProvinciaMunicipio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnFamosa;
	private JRadioButton rdbtnConocida;
	private JRadioButton rdbtnPocoConocida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		initialize();
		cargarProvinciaEnJComboBox();

	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		tf_filtrar = new JTextField();
		GridBagConstraints gbc_tf_filtrar = new GridBagConstraints();
		gbc_tf_filtrar.insets = new Insets(0, 0, 5, 5);
		gbc_tf_filtrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_filtrar.gridx = 0;
		gbc_tf_filtrar.gridy = 0;
		contentPane.add(tf_filtrar, gbc_tf_filtrar);
		tf_filtrar.setColumns(10);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarValoresMunicipioEnJComboBox();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 0;
		contentPane.add(btnFiltrar, gbc_btnFiltrar);

		jcbSeleccionar = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbSeleccionar = new GridBagConstraints();
		gbc_jcbSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSeleccionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSeleccionar.gridx = 0;
		gbc_jcbSeleccionar.gridy = 1;
		contentPane.add(jcbSeleccionar, gbc_jcbSeleccionar);

		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMunicipioEnJComboBox();
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 1;
		gbc_btnSeleccionar.gridy = 1;
		contentPane.add(btnSeleccionar, gbc_btnSeleccionar);

		JLabel lblMunicipio = new JLabel("Municipio Seleccionado:");
		GridBagConstraints gbc_lblMunicipio = new GridBagConstraints();
		gbc_lblMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_lblMunicipio.gridwidth = 2;
		gbc_lblMunicipio.gridx = 0;
		gbc_lblMunicipio.gridy = 2;
		contentPane.add(lblMunicipio, gbc_lblMunicipio);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNombreMunicipio = new JLabel("Nombre del municipio:");
		GridBagConstraints gbc_lblNombreMunicipio = new GridBagConstraints();
		gbc_lblNombreMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreMunicipio.anchor = GridBagConstraints.EAST;
		gbc_lblNombreMunicipio.gridx = 0;
		gbc_lblNombreMunicipio.gridy = 0;
		panel.add(lblNombreMunicipio, gbc_lblNombreMunicipio);

		tf_NombreMunicipio = new JTextField();
		GridBagConstraints gbc_tf_NombreMunicipio = new GridBagConstraints();
		gbc_tf_NombreMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_tf_NombreMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_NombreMunicipio.gridx = 1;
		gbc_tf_NombreMunicipio.gridy = 0;
		panel.add(tf_NombreMunicipio, gbc_tf_NombreMunicipio);
		tf_NombreMunicipio.setColumns(10);

		JLabel lblProvinciaMunicipio = new JLabel("Provincia del municipio:");
		GridBagConstraints gbc_lblProvinciaMunicipio = new GridBagConstraints();
		gbc_lblProvinciaMunicipio.anchor = GridBagConstraints.EAST;
		gbc_lblProvinciaMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvinciaMunicipio.gridx = 0;
		gbc_lblProvinciaMunicipio.gridy = 1;
		panel.add(lblProvinciaMunicipio, gbc_lblProvinciaMunicipio);

		jcbProvinciaMunicipio = new JComboBox<Provincia>();
		GridBagConstraints gbc_jcbProvinciaMunicipio = new GridBagConstraints();
		gbc_jcbProvinciaMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvinciaMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvinciaMunicipio.gridx = 1;
		gbc_jcbProvinciaMunicipio.gridy = 1;
		panel.add(jcbProvinciaMunicipio, gbc_jcbProvinciaMunicipio);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarMunicipio();
			}
		});

		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 2;
		panel.add(btnGuardar, gbc_btnGuardar);

	}

	/**
	 * Método que carga la lista de municipios según el filtro de búsqueda
	 */
	private void cargarValoresMunicipioEnJComboBox() {
		// Cargamos valores dentro del combobox
		List<Municipio> lista = ControladorMunicipio.filtrarMunicipio(this.tf_filtrar.getText());
		for (int i = 0; i < lista.size(); i++) {
			jcbSeleccionar.addItem(lista.get(i));
		}

	}

	/**
	 * 
	 * Método que selecciona el municipio mediante su codigo y recorre el combobox
	 * de provincias para Obtener la provincia del municipio
	 */
	private void seleccionarMunicipioEnJComboBox() {
		// Obtengo el muncipio, desde la lista del JComboBox
		Municipio m = (Municipio) this.jcbSeleccionar.getSelectedItem();

		this.tf_NombreMunicipio.setText(m.getNombre());

		// Recorro el combobox de las provincias y si su id coincide con la del id de la
		// provincia del municipio
		for (int i = 0; i < this.jcbProvinciaMunicipio.getItemCount(); i++) {
			if (this.jcbProvinciaMunicipio.getItemAt(i).getId() == m.getIdProvincia()) { // Si el id de la lista de
																							// provincias coincide con
																							// el id de la provincia del
																							// objeto municipio
				this.jcbProvinciaMunicipio.setSelectedIndex(i); // En el comboBox de Provincias selecciona el indice
																// encontrado
			}
		}

	}

	/**
	 * Método que carga la lista de provincias según el filtro de búsqueda
	 */
	private void cargarProvinciaEnJComboBox() {
		// Cargamos valores dentro del combobox
		List<Provincia> lista = ControladorProvincia.obtenerTodosLasProvincias();
		for (int i = 0; i < lista.size(); i++) {
			jcbProvinciaMunicipio.addItem(lista.get(i));
		}

	}

	/**
	 * Método que modifica el municipio seleccionado
	 */
	private void modificarMunicipio() {
		Municipio m = (Municipio) this.jcbSeleccionar.getSelectedItem();


		m.setNombre(this.tf_NombreMunicipio.getText());
		m.setIdProvincia(((Provincia) this.jcbProvinciaMunicipio.getSelectedItem()).getId());

		try {
			ControladorMunicipio.modificar(m);
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error, no ha podido modificarse");
			ex.printStackTrace();
		}
	}

	/**
	 * Método que devuelve el String de la opcion del JRadioButton
	 * 
	 * @return
	 */

}
