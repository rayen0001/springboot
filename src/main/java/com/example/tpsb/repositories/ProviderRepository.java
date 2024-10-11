package com.example.tpsb.repositories;


import com.example.tpsb.Models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider getProviderByName(String name);
    Provider getProviderByMatricule(String matricule);
    void deleteProviderByName(String name);
    void deleteProviderByMatricule(String matricule);
}
