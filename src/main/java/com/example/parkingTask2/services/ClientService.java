package com.example.parkingTask2.services;

import com.example.parkingTask2.dto.ClientDTO;
import com.example.parkingTask2.entities.Client;
import com.example.parkingTask2.entities.ClientKey;
import com.example.parkingTask2.entities.Parking;
import com.example.parkingTask2.entities.ParkingSlot;
import com.example.parkingTask2.repositories.ClientKeyRepository;
import com.example.parkingTask2.repositories.ParkingRepository;
import com.example.parkingTask2.repositories.ParkingSlotRepository;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parkingTask2.repositories.ClientRepository;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    private ClientRepository repository;
    private ParkingRepository parkingRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private ClientKeyRepository clientKeyRepository;

   @Autowired
    public ClientService(ClientRepository repository, ParkingRepository parkingRepository, ParkingSlotRepository parkingSlotRepository, ClientKeyRepository clientKeyRepository) {
        this.repository = repository;
        this.parkingRepository = parkingRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.clientKeyRepository = clientKeyRepository;
    }

    //    public void getParking(){
//        List<ParkingSlot> parking_slot = parkingSlotRepository.findAll();
//        for(int i=0;i<parking_slot.size();i++){
//            System.out.print(parking_slot.get(i).toString());
//        }
//    }

    public void clientSave(ClientDTO dto) throws JoseException, NoSuchAlgorithmException {
        Client client = mappingDtoToClient(dto);

        //Set slot to client
        List<ParkingSlot> parkingSlotList = parkingSlotRepository.findAll();
        for (ParkingSlot parkingSlot:parkingSlotList){
            if (parkingSlot.isFree() && (parkingSlot.getType().equals(dto.getCarType()))
                    && parkingSlot.getMainParking().equals(dto.getParking())) {
                client.setParkingSlot(parkingSlot.getSlotId());
                parkingSlot.setFree(false);
                parkingSlotRepository.save(parkingSlot);
                repository.save(client);

                setClientPublicKey(client);
                break;

            }
        }
    }

    private void setClientPublicKey(Client client) throws JoseException {
        RsaJsonWebKey jsonSignKey = RsaJwkGenerator.generateJwk(2048);
        //saving new client to the database with their public key
        ClientKey c = new ClientKey();
        c.setPublicKey(jsonSignKey.getPublicKey());
        c.setId(client.getId());
        clientKeyRepository.save(c);
    }

    @org.jetbrains.annotations.NotNull
    private Client mappingDtoToClient(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setCarType(dto.getCarType());
        client.setCcInfo(dto.getCcInfo());
        client.setParking(dto.getParking());
        client.setCarType(dto.getCarType());
        client.setArrivalTime(LocalTime.now());
        return client;
    }

    public double getPayment(int id) {
        Client c = repository.findById(id).orElse(null);
        String pId = Objects.requireNonNull(c).getParking();
        Parking park = parkingRepository.findByName(pId);
        double hours = Duration.between(LocalTime.now(),c.getArrivalTime()).toHours();

        return hours*park.getPricePerHour()+park.getFixedPrice();
    }

    public void deleteClient(int id){
        freeClientParkingSlot(id);
        //Delete the client
        repository.deleteById(id);
    }


    private void freeClientParkingSlot(int id) {
        Client cl = repository.findById(id).orElse(null);

        ParkingSlot clientSlot =
                parkingSlotRepository.findById(cl.getParkingSlot())
                        .orElse(null);


        clientSlot.setFree(true);
        parkingSlotRepository.save(clientSlot);
    }
}

