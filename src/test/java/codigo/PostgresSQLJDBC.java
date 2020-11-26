package codigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PostgresSQLJDBC {


    private Connection connection;
    private PreparedStatement stmt;
    String updateSQL = null;


    public PostgresSQLJDBC(String database){

        this.connection = new ConnectionFactory().getConnection(database);
    }

    public void closeConnection(){
        try {
            connection.close();
        }catch (SQLException s){}
    }

    public boolean setPerfil(String email1) {
        try {
            String updateSQL = "UPDATE public.usuario set idperfil = 1 where email = ?";
            // String stringSQL = "SELECT * FROM public.usuario where email = ?";
            stmt = this.connection.prepareStatement(updateSQL);
            stmt.setString(1, email1);
            stmt.execute();

            System.out.println("\nAtualizado perfil do usuario para Analista");

            stmt.close();
            //connection.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return false;
        }
    }

    public boolean setPerfilcliente(String email1) {
        try {
            String updateSQL = "UPDATE public.usuario set idperfil = 2 where email = ?";
            // String stringSQL = "SELECT * FROM public.usuario where email = ?";
            stmt = this.connection.prepareStatement(updateSQL);
            stmt.setString(1, email1);
            stmt.execute();
            System.out.println("\nAtualizado perfil do usuario para Cliente");
            stmt.close();
            //connection.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return false;
        }
    }



    public boolean setSenha (String senhas, String email) {
            try {

                updateSQL = "update public.usuario set senha = ? where email = ?";
                stmt = this.connection.prepareStatement(updateSQL);
                stmt.setString(1,senhas);
                stmt.setString(2,email);
                stmt.execute();
                stmt.close();

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("\nOperation done successfully");
            return true;
        }

    public boolean setAtivaco (String email) {
        try {

            updateSQL = "update public.usuario set ativo = true where email = ?";
            stmt = this.connection.prepareStatement(updateSQL);
                 stmt.setString(1,email);
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("\nOperation done successfully");
        return true;
    }




    public String buscaNome () {
        String nome = null;
        String selectSQL = "Select nome from public.usuario where id = (SELECT MAX(id) FROM public.usuario)";

        try{
            stmt = this.connection.prepareStatement(selectSQL);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                //usar apenas os campos que retornam no select
                String  email = rs.getString("nome");
                nome = rs.getString("nome");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("\nOperation done successfully");
        return nome;

    }


    public String buscaProtocolo () {
        String protocolo = null;
        String selectSQL = "SELECT ultimoprotocolo FROM public.protocolo;";

        try{
            stmt = this.connection.prepareStatement(selectSQL);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                //usar apenas os campos que retornam no select
               // String  email = rs.getString("nome");
                protocolo = rs.getString("ultimoprotocolo");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("\nOperation done successfully");
        return protocolo;

    }






    public String buscaContatos (){
        //busca o último e-mail cadastrado
        String contato = null;
        String selectSQL = "Select email from public.usuario where id = (SELECT MAX(id) FROM public.usuario)";
        try{
            stmt = this.connection.prepareStatement(selectSQL);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                //usar apenas os campos que retornam no select
                String  email = rs.getString("email");
                contato = rs.getString("email");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
                 System.err.println(e.getClass().getName() + ": " + e.getMessage());
                 System.exit(0);
        }
       // System.out.println("\nOperation done successfully");
        return contato;
    }

    public String limpaUsuario(){
        String selectSQL1 =

                "delete from public.restricao_acesso_solicitacao_usuario where id_usuario not in (SELECT id FROM PUBLIC.usuario WHERE email in ('morganajohann@gmail.com','morgana.johann@apisul.com.br','morgana.cliente@teste.com','leticia.dietrich@apisul.com.br','guilherme.mattarollo@apisul.com.br','leonardo.dorneles@apisul.com.br','emerson.depaula@apisul.com.br','hora.anderson@gmail.com','raiana.candido@apisul.com.br','anderson.hora@apisul.com.br','luiza.meirelles@apisul.com.br'));" +
                "delete from public.usuariogrupo WHERE id_usuario not in (SELECT id FROM PUBLIC.usuario WHERE email in ('morganajohann@gmail.com','morgana.johann@apisul.com.br','morgana.cliente@teste.com','leticia.dietrich@apisul.com.br','guilherme.mattarollo@apisul.com.br','leonardo.dorneles@apisul.com.br','emerson.depaula@apisul.com.br','hora.anderson@gmail.com','raiana.candido@apisul.com.br','anderson.hora@apisul.com.br','luiza.meirelles@apisul.com.br'));" +
                "delete from public.usuariotelefone WHERE idusuario not IN (SELECT id FROM PUBLIC.usuario WHERE email IN ('morganajohann@gmail.com','morgana.johann@apisul.com.br','morgana.cliente@teste.com','leticia.dietrich@apisul.com.br','guilherme.mattarollo@apisul.com.br','leonardo.dorneles@apisul.com.br','emerson.depaula@apisul.com.br','hora.anderson@gmail.com','raiana.candido@apisul.com.br','anderson.hora@apisul.com.br','luiza.meirelles@apisul.com.br'));" +
                "delete FROM PUBLIC.usuario WHERE email not IN ('servico.usuario','servico.transportadora','servico.tarifador','servico.questionario','servico.geo','servico.agendamento','morganajohann@gmail.com','morgana.johann@apisul.com.br','morgana.cliente@teste.com','leticia.dietrich@apisul.com.br','guilherme.mattarollo@apisul.com.br','leonardo.dorneles@apisul.com.br','emerson.depaula@apisul.com.br','hora.anderson@gmail.com','raiana.candido@apisul.com.br','anderson.hora@apisul.com.br','luiza.meirelles@apisul.com.br');";
        try {
            stmt = this.connection.prepareStatement(selectSQL1);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){
        }
        return null;
    }

    public String limpaUsuarioObr(){
        String selectSQL1 =
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'vazios@apisul.com');" +
                        "DELETE FROM usuario where email = 'vazios@apisul.com';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'leandro.brr@apisul.com.br');" +
                        "DELETE FROM usuario where email = 'leandro.brr@apisul.com.br';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'leandro.rr@apisul.com.br');" +
                        "DELETE FROM usuario where email = 'leandro.rr@apisul.com.br';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'valor@tst.com');" +
                        "DELETE FROM usuario where email = 'valor@tst.com';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'bloq@tst.com');" +
                        "DELETE FROM usuario where email = 'bloq@tst.com';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = '2s@tst.com');" +
                        "DELETE FROM usuario where email = '2s@tst.com';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'acesso@tst.com');" +
                        "DELETE FROM usuario where email = 'acesso@tst.com';" +
                        "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'zero@tst.com');" +
                        "DELETE FROM usuario where email = 'zero@tst.com';";
        try {
            stmt = this.connection.prepareStatement(selectSQL1);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){
        }
        return null;
    }

    public String limpaUserNovoLog(){
        String selectSQL1 =
                      //   "DELETE FROM usuariotelefone where idusuario = (select id from public.usuario where email = 'leandro.brum@apisul.com.br');" +
                       //  "DELETE FROM usuario where email = 'leandro.brum@apisul.com.br';";

        "delete from public.restricao_acesso_solicitacao_usuario where id_usuario in (SELECT id FROM PUBLIC.usuario WHERE senha = '$2a$10$LOUCcisC2UpueZHaW5AgcuVu9hRO3tLzl912yFNlDiNzqlAmaZuvO' and email not in ('leonardo.dorneles@apisul.com.br','morganajohann@gmail.com', 'morgana.cliente@teste.com','emerson.depaula@apisul.com.br','anderson.hora@apisul.com.br',raiana.candido@apisul.com.br','morgana.johann@apisul.com.br'));" +
        "delete from public.usuariogrupo WHERE id_usuario in (SELECT id FROM PUBLIC.usuario WHERE senha = '$2a$10$LOUCcisC2UpueZHaW5AgcuVu9hRO3tLzl912yFNlDiNzqlAmaZuvO' and email not in ('leonardo.dorneles@apisul.com.br','morganajohann@gmail.com','morgana.cliente@teste.com','emerson.depaula@apisul.com.br','anderson.hora@apisul.com.br',raiana.candido@apisul.com.br','morgana.johann@apisul.com.br'));" +
        "delete from public.usuariotelefone WHERE idusuario in (SELECT idusuario FROM PUBLIC.usuario WHERE senha = '$2a$10$LOUCcisC2UpueZHaW5AgcuVu9hRO3tLzl912yFNlDiNzqlAmaZuvO' and email not in ('leonardo.dorneles@apisul.com.br','morganajohann@gmail.com','morgana.cliente@teste.com','emerson.depaula@apisul.com.br','anderson.hora@apisul.com.br',raiana.candido@apisul.com.br','morgana.johann@apisul.com.br'));" +
        "delete FROM PUBLIC.usuario WHERE senha = '$2a$10$LOUCcisC2UpueZHaW5AgcuVu9hRO3tLzl912yFNlDiNzqlAmaZuvO' and email not in ('leonardo.dorneles@apisul.com.br','morganajohann@gmail.com', 'morgana.cliente@teste.com','emerson.depaula@apisul.com.br','anderson.hora@apisul.com.br',raiana.candido@apisul.com.br','morgana.johann@apisul.com.br');";




        try {
            stmt = this.connection.prepareStatement(selectSQL1);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){
        }
        return null;
    }
 //teste
    public String limpTransportadoraObr(){

        String selectSQL =

                        "delete from public.transportadora where cnpj ='21640678000109';" +
                        "delete from public.transportadora where cnpj ='95342412000116';" +
                        "delete from public.transportadora where cnpj ='73482287000107';" +
                        "delete from public.transportadora where cnpj ='55633739000122';" +
                        "delete from public.transportadora where cnpj ='14668288000181';" +
                        "delete from public.transportadora where cnpj ='14668288000181';" +
                        "delete from public.transportadora where cnpj ='10163013000135';" ;

        try {
            stmt = this.connection.prepareStatement(selectSQL);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){
        }
        return null;
    }



    public String limpaQuestionario(){

        String selectSQL1 =
                        "delete from public.kafka_receiver_log;" +
                        "delete from public.kafka_sender_log;" +
                        "delete from public.conjunto_arquivo;" +
                        "delete from public.conjunto_proposta_assinada;"  +
                        "delete from public.conjunto_declaracao_seguro;"  +
                        "delete from public.arquivo_questionario;" +
                        "delete from public.parecer_questionario;" +
                        "delete from public.questionarioinconsistencia;" +
                        "delete from public.propostaseguro;"+
                        "delete from public.questionario;"+
                        "delete from public.auditoria;" +
                        "delete from public.novosegurocontato;"+
                        "delete from public.novoseguro;"+
                        "delete from public.qar_transportadora;"+
                         "delete from public.segurosanterioressinistros;"+
                        "delete from public.segurosanteriores;"+
                        "delete from public.dadosoperacionaisrotas;"+
                        "delete from public.dadosoperacionaismercadorias;"+
                        "delete from public.dadosoperacionais;";
                      //  "delete from public.kafka_receiver_log;"+
                     //   "delete from public.kafka_sender_log;";

        try {
            stmt = this.connection.prepareStatement(selectSQL1);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){

            e.printStackTrace();

            // System.out.println(e.getStackTrace());
        }
        return null;
    }

    public String limpaTransportadora(){
        String selectSQL1 = "delete from public.enderecotransportadora;" +
                            "delete from public.transportadora;";
        try {
            stmt = this.connection.prepareStatement(selectSQL1);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){
        }
        return null;
    }

    public String limpaQuestAgendamento(){
        String selectSQL1 = "delete from public.questionarioagendamento;";
        try {
            stmt = this.connection.prepareStatement(selectSQL1);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.close();
            stmt.close();
        }catch (Exception e){
        }
        return null;
    }

    }


