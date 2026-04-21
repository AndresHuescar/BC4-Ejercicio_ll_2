import java.sql.*;
import java.util.Scanner;

public class VueltaCiclistaMenu {

    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static String user = "RIBERA";
    static String password = "ribera";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n1.Insertar 2.Actualizar 3.Eliminar 0.Salir");
            op = sc.nextInt();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {

                if (op == 1) {

                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Nacionalidad: ");
                    String nac = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    System.out.print("Equipo: ");
                    int eq = sc.nextInt();

                    PreparedStatement check = conn.prepareStatement(
                            "SELECT 1 FROM EQUIPO WHERE ID_EQUIPO=?");
                    check.setInt(1, eq);

                    if (!check.executeQuery().next()) {
                        System.out.println("Equipo no existe");
                        continue;
                    }

                    PreparedStatement max = conn.prepareStatement(
                            "SELECT NVL(MAX(ID_CICLISTA),0)+1 FROM CICLISTA");
                    ResultSet r = max.executeQuery();
                    r.next();
                    int id = r.getInt(1);

                    PreparedStatement ps = conn.prepareStatement(
                            "INSERT INTO CICLISTA VALUES (?,?,?,?,?)");

                    ps.setInt(1, id);
                    ps.setString(2, nombre);
                    ps.setString(3, nac);
                    ps.setInt(4, edad);
                    ps.setInt(5, eq);

                    ps.executeUpdate();
                    System.out.println("Insertado");
                }

                if (op == 2) {

                    System.out.print("ID ciclista: ");
                    int id = sc.nextInt();

                    System.out.print("Edad nueva: ");
                    int edad = sc.nextInt();

                    System.out.print("Equipo nuevo: ");
                    int eq = sc.nextInt();

                    PreparedStatement ps = conn.prepareStatement(
                            "UPDATE CICLISTA SET EDAD=?, ID_EQUIPO=? WHERE ID_CICLISTA=?");

                    ps.setInt(1, edad);
                    ps.setInt(2, eq);
                    ps.setInt(3, id);

                    ps.executeUpdate();
                    System.out.println("Actualizado");
                }

                if (op == 3) {

                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    PreparedStatement del1 = conn.prepareStatement(
                            "DELETE FROM PARTICIPACION WHERE ID_CICLISTA=?");
                    del1.setInt(1, id);
                    del1.executeUpdate();

                    PreparedStatement del2 = conn.prepareStatement(
                            "DELETE FROM CICLISTA WHERE ID_CICLISTA=?");
                    del2.setInt(1, id);
                    del2.executeUpdate();

                    System.out.println("Eliminado");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (op != 0);
    }
}