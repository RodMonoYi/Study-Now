package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Aplicacao;
import modelo.Estudante;
import monitorar.DAOEstudante;
import visao.Frame;
import visao.TelaCadastro;

public class ControllerTelaCadastro implements ActionListener {

	public TelaCadastro telaCadastro;
	
	public ControllerTelaCadastro(TelaCadastro cadastro) {
		telaCadastro = cadastro;
		Frame.controle=3;
		addEventos();
	}

	private void addEventos() {
		telaCadastro.getBtCadastrar().addActionListener(this);
	}
	
	public JPanel getTelaCadastro() {
		return telaCadastro;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaCadastro.getBtCadastrar()) {
			if (verificarCampos()) {
				Estudante aluno = new Estudante();
				if(addDadosEstudante(aluno)) {
					DAOEstudante entityEstudante = new DAOEstudante();
					if (entityEstudante.BuscarEstudante(aluno.getMatricula()) == null) {
						entityEstudante.SalvarEstudante(aluno);
						JOptionPane.showMessageDialog(telaCadastro, "Cadastrado com Sucesso!!", null, JOptionPane.INFORMATION_MESSAGE);
						Aplicacao.ReiniciarPanel();
					}
					else {
						JOptionPane.showMessageDialog(telaCadastro, "Já existe uma conta com esta matricula", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}

	private boolean verificarCampos() {
		if(telaCadastro.getTfNome().getText().trim().isEmpty() || telaCadastro.getTfMatricula().getText().trim().isEmpty()
		|| telaCadastro.getTfDataNasc().getText().trim().isEmpty() || String.valueOf(telaCadastro.getTfSenha().getPassword()).trim().isEmpty()
		|| String.valueOf(telaCadastro.getTfSenhaConfirmar().getPassword()).trim().isEmpty()) {
			telaCadastro.getAviso().setText("Por favor, preencha todos os campos!");
			return false;
		} else if(dataValida()==false) {
			telaCadastro.getAviso().setText("Por favor, use uma data válida!");
			return false;
		}else if(String.valueOf(telaCadastro.getTfSenha().getPassword()).trim().length() < 6 || String.valueOf(telaCadastro.getTfSenha().getPassword()).trim().length() > 10 ){
			telaCadastro.getAviso().setText("Sua senha deve ter de 6 à 10 caracteres");
			return false;
		} else if(String.valueOf(telaCadastro.getTfSenha().getPassword()).trim().compareTo(String.valueOf(telaCadastro.getTfSenhaConfirmar().getPassword()).trim())!=0) {
			telaCadastro.getAviso().setText("Senhas não compatíveis!");
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean dataValida() {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate.parse(telaCadastro.getTfDataNasc().getText(), formatter);  
	         return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      }   
	   }

	private boolean addDadosEstudante(Estudante aluno) {
		boolean flag=false;
		aluno.setNome(telaCadastro.getTfNome().getText());
		aluno.setMatricula(telaCadastro.getTfMatricula().getText());
		aluno.setSenha(String.valueOf(telaCadastro.getTfSenha().getPassword()));
		try {
			aluno.setDataNascimento(telaCadastro.getTfDataNasc().getText());
			flag=true;
		} catch (ParseException e) {
			flag=false;
			telaCadastro.getAviso().setText("Por favor, preencha todos os campos!");
		}
		return flag;
	}
	
	
}
