package com.example.tpsb.Services.Impl;

import com.example.tpsb.Models.Provider;
import com.example.tpsb.Services.ProviderService;
import com.example.tpsb.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Optional<Provider> getProviderById(Long id) {
        return providerRepository.findById(id);
    }

    @Override
    public Optional<Provider> getProviderByName(String name) {
        return Optional.ofNullable(providerRepository.getProviderByName(name));
    }

    // Retrieve provider by matricule
    @Override
    public Optional<Provider> getProviderByMatricule(String matricule) {
        return Optional.ofNullable(providerRepository.getProviderByMatricule(matricule));
    }

    // Save or update a provider
    @Override
    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    // Delete provider by ID
    @Override
    public void deleteProviderById(Long id) {
        providerRepository.deleteById(id);
    }

    // Delete provider by name
    @Override
    public void deleteProviderByName(String name) {
        providerRepository.deleteProviderByName(name);
    }

    // Delete provider by matricule
    @Override
    public void deleteProviderByMatricule(String matricule) {
        providerRepository.deleteProviderByMatricule(matricule);
    }
}
