package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Create_InsertOcena {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Tworzymy studenta
            System.out.println("Podaj imię studenta:");
            String imie = scanner.nextLine();

            System.out.println("Podaj nazwisko studenta:");
            String nazwisko = scanner.nextLine();

            System.out.println("Podaj rok rozpoczęcia studiów:");
            String rokStudiow = scanner.nextLine();
            int rok = Integer.parseInt(rokStudiow);


            Student uczen = Student.builder()
                    .imie(imie)
                    .nazwisko(nazwisko)
                    .rokRozpoczeciaStudiow(rok)
                    .build();

            // zapisujemy studenta
            session.persist(uczen);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }

}
