package org.example;
import java.sql.Time;
import java.util.Date;
import domain.Client;
import domain.Cursa;
import domain.Rezervare;
import repo.ClientDBRepository;
import repo.ClientRepo;
import repo.CursaDBRepository;
import repo.RezervareDBRepository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Properties props=new Properties();
        try {
            props.load(new FileReader("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }
       // ClientRepo clientRepo= (ClientRepo) new ClientDBRepository(props);
        ClientDBRepository clientRepo=new ClientDBRepository(props);
        Client client=new Client("Diana","1234");

        //clientRepo.save(client);
        System.out.println("Toate clientii din db");
        System.out.println(client);

        System.out.println("Toate clientii din db dupa update");
        List<Client> clients=clientRepo.findAll();
        for(Client c:clients)
            System.out.println(c);

        CursaDBRepository cursaDBRepository=new CursaDBRepository(props);
        LocalDateTime date=LocalDateTime.of(2020,12,12,12,30);
        Time time=new Time(12,30,0);
        Date date1=new Date(2020,12,12);
        Cursa cursa=new Cursa("Cluj",date1,time);
        cursaDBRepository.save(cursa);
        System.out.println("Toate cursele din db");
        List<Cursa> curse=cursaDBRepository.findAll();
        for(Cursa c:curse)
            System.out.println(c);

        RezervareDBRepository rezervareDBRepository=new RezervareDBRepository(props);
        Rezervare rezervare=new Rezervare(3,client,cursa);
        Rezervare rezervare1=new Rezervare(4,client,cursa);
        rezervareDBRepository.save(rezervare);
        rezervareDBRepository.save(rezervare1);




    }
}