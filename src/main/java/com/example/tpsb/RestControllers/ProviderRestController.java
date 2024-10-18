package com.example.tpsb.RestControllers;

import com.example.tpsb.Models.Provider;
import com.example.tpsb.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "/api")
@RestController
@RequestMapping("/providers")
public class ProviderRestController {

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providers = providerService.getAllProviders();
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        Optional<Provider> provider = providerService.getProviderById(id);
        return provider.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Provider> getProviderByName(@PathVariable String name) {
        Optional<Provider> provider = providerService.getProviderByName(name);
        return provider.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/matricule/{matricule}")
    public ResponseEntity<Provider> getProviderByMatricule(@PathVariable String matricule) {
        Optional<Provider> provider = providerService.getProviderByMatricule(matricule);
        return provider.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider newProvider = providerService.saveProvider(provider);
        return ResponseEntity.ok(newProvider);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProviderById(@PathVariable Long id) {
        providerService.deleteProviderById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteProviderByName(@PathVariable String name) {
        providerService.deleteProviderByName(name);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/matricule/{matricule}")
    public ResponseEntity<Void> deleteProviderByMatricule(@PathVariable String matricule) {
        providerService.deleteProviderByMatricule(matricule);
        return ResponseEntity.noContent().build();
    }
}
