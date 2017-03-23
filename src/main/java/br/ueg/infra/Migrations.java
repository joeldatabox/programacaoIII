package br.ueg.infra;

import org.flywaydb.core.Flyway;

/**
 * Classe responsavel por encapsular o processo de migração do banco
 *
 * @author Joel Rodrigues Moreira
 */
public class Migrations {
    //define o nome padrão para armazenar as migrações executadas
    private static final String TABLE_VERSION = "__schema_version";
    //url de conexão com o banco
    private static final String URL = "jdbc:mysql://localhost:3306/programacaoIII?useUnicode=true&characterEncoding=utf8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //usuário do banco
    private static final String USER = "root";
    //senha do usuário
    private static final String PASSWD = "12root23@#";
    //local onde esta os scripts de migração
    private static final String LOCATION = "classpath:db/migration";

    public static void executeMigrations() {
        System.out.println("Iniciando a migração!");
        try {
            final Flyway flyway = new Flyway();
            flyway.setTable(TABLE_VERSION);
            flyway.setLocations(LOCATION);
            flyway.setDataSource(URL, USER, PASSWD);
            flyway.migrate();
            System.out.println("Migração finalizada!");
        } catch (Exception ex) {
            System.out.println("Erro ao executar o processo de migração!");
            ex.printStackTrace();
            //se deu problema ao migrar o banco devemos encerrar a aplicação imediatamente
            System.exit(1);
        }
    }
}
