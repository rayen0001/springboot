package com.example.tpsb.Services;

import com.example.tpsb.Models.Provider;

import java.util.List;
import java.util.Optional;

public interface ProviderService {

    List<Provider> getAllProviders();

    Optional<Provider> getProviderById(Long id);

    Optional<Provider> getProviderByName(String name);

    Optional<Provider> getProviderByMatricule(String matricule);

    Provider saveProvider(Provider provider);

    void deleteProviderById(Long id);

    void deleteProviderByName(String name);

    void deleteProviderByMatricule(String matricule);
}
