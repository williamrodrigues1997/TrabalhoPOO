package dados;

import medicos.Medico;
import java.util.ArrayList;
import java.util.List;
import medicos.DadosAdicionaisPaciente;
import medicos.Prontuario;
import secretaria.Consulta;
import secretaria.Paciente;


/**
 *
 * Definição de variáveis estáticas para uso geral no sistema com objetivo de 
 * armazenar os dados em mémoria em coleções do tipo List.
 */
public class Dados {

    public static List<Paciente> listaPacientes = new ArrayList();
    public static List<Consulta> listaConsultas = new ArrayList();

    public static List<Medico> listaMedicos = new ArrayList();
    public static List<Prontuario> listaProntuarios = new ArrayList();
    public static List<DadosAdicionaisPaciente> listaAdicionaisPacientes = new ArrayList();

}
